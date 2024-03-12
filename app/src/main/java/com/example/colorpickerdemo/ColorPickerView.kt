package com.example.colorpickerdemo

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat
import kotlin.math.*

class ColorPickerView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    //listener for color selection
    interface OnColorSelectedListener {
        fun onColorSelected(color: Int, colorCode: String)
    }

    var colorSelectedListener: OnColorSelectedListener? = null

    //dynamically set color picker size
    var wheelRadius = 400f
    val wheelCenter = PointF(0f, 0f)
    private val colorWheelPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var colorWheelShader: SweepGradient

    //initial value set for touch listner
    private val touchCircleRadius = 45f
    private val touchCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    var touchCircleCenter = PointF(0f, 0f)

    var  selectedColor = ContextCompat.getColor(context, R.color.teal)

    init {
        // Calculate wheelRadius dynamically based on screen size
        val screenSize = Point()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(screenSize)
        val smallerDimension = min(screenSize.x, screenSize.y)
        wheelRadius = (smallerDimension / 2 * 0.8).toFloat() // Adjust multiplier as needed
        setupColorWheelShader()
    }

    private fun setupColorWheelShader() {
        val rainbowColors = intArrayOf(
            Color.RED, Color.MAGENTA, Color.BLUE,
            Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED
        )
        val rainbowPositions = floatArrayOf(0f, 1f / 6, 2f / 6, 3f / 6, 4f / 6, 5f / 6, 1f)

        val colorShader = SweepGradient(
            wheelCenter.x, wheelCenter.y, rainbowColors, rainbowPositions
        )

        val whiteAlpha = intArrayOf(255, 180)
        val whitePositions = floatArrayOf(0f, wheelRadius / (wheelRadius * 4))

        val whiteShader = RadialGradient(
            wheelCenter.x, wheelCenter.y, wheelRadius / 4,
            Color.WHITE, Color.TRANSPARENT, Shader.TileMode.CLAMP
        )

        val composeShader = ComposeShader(colorShader, whiteShader, PorterDuff.Mode.SCREEN)

        colorWheelPaint.shader = composeShader
        colorWheelPaint.style = Paint.Style.FILL
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = (wheelRadius * 2).toInt()
        val desiredHeight = (wheelRadius * 2).toInt()
        setMeasuredDimension(desiredWidth, desiredHeight)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        wheelCenter.set(w / 2f, h / 2f)
        // Set the touch circle center position based on the given color code
        val hsv = FloatArray(3)
        Color.colorToHSV(selectedColor, hsv)
        val hueAngle = hsv[0] * Math.PI.toFloat() * 2 / 360
        val x = wheelCenter.x + (wheelRadius * hsv[1] * cos(hueAngle))
        val y = wheelCenter.y - (wheelRadius * hsv[1] * sin(hueAngle))
        touchCircleCenter.set(x, y)
        setupColorWheelShader()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(wheelCenter.x, wheelCenter.y, wheelRadius, colorWheelPaint)

        val selectedColorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = selectedColor
            style = Paint.Style.FILL
        }
        canvas.drawCircle(touchCircleCenter.x, touchCircleCenter.y, touchCircleRadius, selectedColorPaint)

        canvas.drawCircle(touchCircleCenter.x, touchCircleCenter.y, touchCircleRadius, touchCirclePaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                val distanceX = event.x - wheelCenter.x
                val distanceY = event.y - wheelCenter.y
                val distanceToCenter = hypot(distanceX, distanceY)

                val scaleFactor = if (distanceToCenter > wheelRadius) {
                    wheelRadius / distanceToCenter.toFloat()
                } else {
                    1f
                }

                touchCircleCenter.x = wheelCenter.x + distanceX * scaleFactor
                touchCircleCenter.y = wheelCenter.y + distanceY * scaleFactor

                var angle = Math.toDegrees(atan2(-distanceY.toDouble(), distanceX.toDouble()))
                if (angle < 0) {
                    angle += 360
                }

                val hue = angle / 360f

                val saturation = min(1f, distanceToCenter / wheelRadius)
                val value = 1f

                selectedColor = Color.HSVToColor(floatArrayOf((hue * 360f).toFloat(), saturation, value))

                // Notify color selection
                colorSelectedListener?.onColorSelected(selectedColor, Integer.toHexString(selectedColor))

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val elevation = 16f
                    val translationZ = 8f

                    touchCirclePaint.setShadowLayer(elevation, 0f, 0f, Color.BLACK)
                    this.elevation = elevation
                    this.translationZ = translationZ
                }

                invalidate()
            }
        }
        return true
    }

    fun setOnColorSelectedListener(listener: OnColorSelectedListener) {
        this.colorSelectedListener = listener
    }
}
