package me.dkzwm.widget.srl.sample.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import org.xwalk.core.XWalkView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dkzwm on 2017/9/25.
 *
 * @author dkzwm
 */

public class CompatXWalkView extends XWalkView {
    private List<OnScrollChangeListener> mScrollChangeListeners;

    public CompatXWalkView(Context context) {
        super(context);
    }

    public CompatXWalkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatXWalkView(Context context, Activity activity) {
        super(context, activity);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        notifyScrollChanged(l, t, oldl, oldt);
    }

    private void notifyScrollChanged(int l, int t, int oldl, int oldt) {
        if (mScrollChangeListeners != null) {
            for (OnScrollChangeListener listener : mScrollChangeListeners) {
                listener.onScrollChange(l, t, oldl, oldt);
            }
        }
    }

    public void addOnScrollChangeListeners(@NonNull OnScrollChangeListener listener) {
        if (mScrollChangeListeners == null)
            mScrollChangeListeners = new ArrayList<>();
        mScrollChangeListeners.add(listener);
    }

    public void removeOnScrollChangeListeners(@NonNull OnScrollChangeListener listener) {
        if (mScrollChangeListeners == null)
            return;
        mScrollChangeListeners.remove(listener);
    }

    public interface OnScrollChangeListener {
        void onScrollChange(int var2, int var3, int var4, int var5);
    }
}
