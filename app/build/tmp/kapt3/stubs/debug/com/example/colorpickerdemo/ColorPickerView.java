package com.example.colorpickerdemo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001:B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012H\u0014J(\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0014J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u000e\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020\bJ\b\u00109\u001a\u00020(H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006;"}, d2 = {"Lcom/example/colorpickerdemo/ColorPickerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorSelectedListener", "Lcom/example/colorpickerdemo/ColorPickerView$OnColorSelectedListener;", "getColorSelectedListener", "()Lcom/example/colorpickerdemo/ColorPickerView$OnColorSelectedListener;", "setColorSelectedListener", "(Lcom/example/colorpickerdemo/ColorPickerView$OnColorSelectedListener;)V", "colorWheelPaint", "Landroid/graphics/Paint;", "colorWheelShader", "Landroid/graphics/SweepGradient;", "selectedColor", "", "getSelectedColor", "()I", "setSelectedColor", "(I)V", "touchCircleCenter", "Landroid/graphics/PointF;", "getTouchCircleCenter", "()Landroid/graphics/PointF;", "setTouchCircleCenter", "(Landroid/graphics/PointF;)V", "touchCirclePaint", "touchCircleRadius", "", "wheelCenter", "getWheelCenter", "wheelRadius", "getWheelRadius", "()F", "setWheelRadius", "(F)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setOnColorSelectedListener", "listener", "setupColorWheelShader", "OnColorSelectedListener", "app_debug"})
public final class ColorPickerView extends android.view.View {
    @org.jetbrains.annotations.Nullable
    private com.example.colorpickerdemo.ColorPickerView.OnColorSelectedListener colorSelectedListener;
    private float wheelRadius = 400.0F;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.PointF wheelCenter = null;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint colorWheelPaint = null;
    private android.graphics.SweepGradient colorWheelShader;
    private final float touchCircleRadius = 45.0F;
    @org.jetbrains.annotations.NotNull
    private final android.graphics.Paint touchCirclePaint = null;
    @org.jetbrains.annotations.NotNull
    private android.graphics.PointF touchCircleCenter;
    private int selectedColor;
    
    public ColorPickerView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.colorpickerdemo.ColorPickerView.OnColorSelectedListener getColorSelectedListener() {
        return null;
    }
    
    public final void setColorSelectedListener(@org.jetbrains.annotations.Nullable
    com.example.colorpickerdemo.ColorPickerView.OnColorSelectedListener p0) {
    }
    
    public final float getWheelRadius() {
        return 0.0F;
    }
    
    public final void setWheelRadius(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.PointF getWheelCenter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.graphics.PointF getTouchCircleCenter() {
        return null;
    }
    
    public final void setTouchCircleCenter(@org.jetbrains.annotations.NotNull
    android.graphics.PointF p0) {
    }
    
    public final int getSelectedColor() {
        return 0;
    }
    
    public final void setSelectedColor(int p0) {
    }
    
    private final void setupColorWheelShader() {
    }
    
    @java.lang.Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull
    android.view.MotionEvent event) {
        return false;
    }
    
    public final void setOnColorSelectedListener(@org.jetbrains.annotations.NotNull
    com.example.colorpickerdemo.ColorPickerView.OnColorSelectedListener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/colorpickerdemo/ColorPickerView$OnColorSelectedListener;", "", "onColorSelected", "", "color", "", "colorCode", "", "app_debug"})
    public static abstract interface OnColorSelectedListener {
        
        public abstract void onColorSelected(int color, @org.jetbrains.annotations.NotNull
        java.lang.String colorCode);
    }
}