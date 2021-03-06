package com.hippo.ehviewer.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.hippo.conaco.Conaco;
import com.hippo.conaco.Unikery;

public class LoadImageView extends ImageView implements Unikery {

    private int mTaskId = Unikery.INVAILD_ID;

    public LoadImageView(Context context) {
        super(context);
    }

    public LoadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoadImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setBitmap(Bitmap bitmap, Conaco.Source source) {
        if (source != Conaco.Source.MEMORY) {
            Drawable[] layers = new Drawable[2];
            layers[0] = new ColorDrawable(Color.TRANSPARENT);
            layers[1] = new BitmapDrawable(getContext().getResources(), bitmap);
            TransitionDrawable transitionDrawable = new TransitionDrawable(layers);
            setImageDrawable(transitionDrawable);
            transitionDrawable.startTransition(300);
        } else {
            setImageBitmap(bitmap);
        }
    }

    @Override
    public void setDrawable(Drawable drawable) {
        setImageDrawable(drawable);
    }

    @Override
    public void setTaskId(int id) {
        mTaskId = id;
    }

    @Override
    public int getTaskId() {
        return mTaskId;
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onCancel() {

    }
}
