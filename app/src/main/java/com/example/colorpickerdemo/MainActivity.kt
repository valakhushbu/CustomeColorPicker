package com.example.colorpickerdemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.colorpickerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ColorPickerViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedCustomView: View
    private var selectedColor: Int = Color.GRAY
    private var originalColor: Int = Color.BLACK

    private var colorSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //for latest android version to set top bar color as app bg color
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.customView1.setBackgroundColor(Color.GRAY)

        viewModel = ViewModelProvider(this)[ColorPickerViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupInitialColors()

        binding.customView1.setOnClickListener {
            setCustomView(binding.customView1, binding.sivFirstView)
        }

        binding.customView2.setOnClickListener {
            setCustomView(binding.customView2, binding.sivSecondView)
        }

        binding.customView3.setOnClickListener {
            setCustomView(binding.customView3, binding.sivThirdView)
        }

        binding.brightnessSeekBar.setOnSeekBarChangeListener(brightnessSeekBarChangeListener)

        observeViewModel()
    }

    //initial given color set [initial first set in viewmodel with static value]
    private fun setupInitialColors() {
        binding.sivFirstView.setBackgroundColor(ContextCompat.getColor(this, R.color.teal))
        binding.sivSecondView.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        binding.sivThirdView.setBackgroundColor(ContextCompat.getColor(this, R.color.orange))

        selectedCustomView = binding.sivFirstView
        updateSelectedCustomView()
    }

    //function for set view of three color view
    private fun setCustomView(selectedView: View, selectedImageView: View) {
        binding.customView1.setBackgroundColor(if (selectedView == binding.customView1) Color.GRAY else Color.BLACK)
        binding.customView2.setBackgroundColor(if (selectedView == binding.customView2) Color.GRAY else Color.BLACK)
        binding.customView3.setBackgroundColor(if (selectedView == binding.customView3) Color.GRAY else Color.BLACK)
        selectedCustomView = selectedImageView
        updateSelectedCustomView()
    }

    //seek bar for brightness
    private val brightnessSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            val percentage = "$progress%"
            binding.txtPercentage.text = percentage

            val seekBarWidth = seekBar.width - seekBar.paddingLeft - seekBar.paddingRight
            val thumbOffset = seekBar.thumbOffset
            val seekBarStart = seekBar.paddingLeft + thumbOffset
            val seekBarEnd = seekBarWidth - thumbOffset - seekBar.paddingRight
            val newX = (progress * (seekBarEnd - seekBarStart)) / seekBar.max + seekBarStart

            val layoutParams = binding.txtPercentage.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.horizontalBias = newX.toFloat() / seekBarWidth
            binding.txtPercentage.layoutParams = layoutParams

            selectedCustomView.let {
                updateColorBasedOnBrightness(originalColor, progress)
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }

    private fun observeViewModel() {
        //set brightness color and update  from observer
        viewModel.selectedColor.observe(this) { color ->
            selectedCustomView.setBackgroundColor(color)
            updateColorBasedOnBrightness(color, viewModel.brightness.value ?: 100)
        }

        viewModel.brightness.observe(this) { brightness ->
            viewModel.selectedColor.value?.let { color ->
                updateColorBasedOnBrightness(color, brightness)
            }
        }
    }

    //function to update all three color from color picker [with condition for separate selection or not]
    private fun updateSelectedCustomView() {
        if (!colorSelected) {
            binding.colorPickerView.setOnColorSelectedListener(object : ColorPickerView.OnColorSelectedListener {
                override fun onColorSelected(color: Int, colorCode: String) {
                    Log.d("CheckColorCode", "Selected color code: $colorCode")
                    selectedColor = color
                    viewModel.setSelectedColor(color)
                    originalColor = color
                    colorSelected = true
                }
            })
        } else {
            selectedCustomView = when (selectedCustomView) {
                binding.sivFirstView -> binding.sivFirstView
                binding.sivSecondView -> binding.sivSecondView
                binding.sivThirdView -> binding.sivThirdView
                else -> binding.sivFirstView
            }
        }
    }

    //for brightness update
    private fun updateColorBasedOnBrightness(color: Int, brightnessProgress: Int) {
        val brightness = brightnessProgress / 100f
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)

        val adjustedColor = if (brightness == 0f) {
            Color.BLACK
        } else {
            hsv[2] = brightness
            Color.HSVToColor(hsv)
        }
        selectedCustomView.setBackgroundColor(adjustedColor)
    }
}
