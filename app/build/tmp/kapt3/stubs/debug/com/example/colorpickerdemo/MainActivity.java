package com.example.colorpickerdemo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/colorpickerdemo/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/colorpickerdemo/databinding/ActivityMainBinding;", "brightnessSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "colorSelected", "", "originalColor", "", "selectedColor", "selectedCustomView", "Landroid/view/View;", "viewModel", "Lcom/example/colorpickerdemo/ColorPickerViewModel;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCustomView", "selectedView", "selectedImageView", "setupInitialColors", "updateColorBasedOnBrightness", "color", "brightnessProgress", "updateSelectedCustomView", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.colorpickerdemo.ColorPickerViewModel viewModel;
    private com.example.colorpickerdemo.databinding.ActivityMainBinding binding;
    private android.view.View selectedCustomView;
    private int selectedColor = android.graphics.Color.GRAY;
    private int originalColor = android.graphics.Color.BLACK;
    private boolean colorSelected = false;
    @org.jetbrains.annotations.NotNull
    private final android.widget.SeekBar.OnSeekBarChangeListener brightnessSeekBarChangeListener = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupInitialColors() {
    }
    
    private final void setCustomView(android.view.View selectedView, android.view.View selectedImageView) {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateSelectedCustomView() {
    }
    
    private final void updateColorBasedOnBrightness(int color, int brightnessProgress) {
    }
}