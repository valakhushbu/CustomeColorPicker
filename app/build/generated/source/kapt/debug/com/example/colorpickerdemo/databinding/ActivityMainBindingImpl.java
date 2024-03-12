package com.example.colorpickerdemo.databinding;
import com.example.colorpickerdemo.R;
import com.example.colorpickerdemo.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.mainColorPicker, 1);
        sViewsWithIds.put(R.id.colorPickerView, 2);
        sViewsWithIds.put(R.id.mainCustomView, 3);
        sViewsWithIds.put(R.id.customView1, 4);
        sViewsWithIds.put(R.id.sivFirstView, 5);
        sViewsWithIds.put(R.id.customView2, 6);
        sViewsWithIds.put(R.id.sivSecondView, 7);
        sViewsWithIds.put(R.id.customView3, 8);
        sViewsWithIds.put(R.id.sivThirdView, 9);
        sViewsWithIds.put(R.id.txtBrightness, 10);
        sViewsWithIds.put(R.id.brightnessSeekBar, 11);
        sViewsWithIds.put(R.id.txtPercentage, 12);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.SeekBar) bindings[11]
            , (com.example.colorpickerdemo.ColorPickerView) bindings[2]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.LinearLayout) bindings[1]
            , (android.widget.LinearLayout) bindings[3]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[5]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[7]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[12]
            );
        this.main.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.colorpickerdemo.ColorPickerViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.colorpickerdemo.ColorPickerViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}