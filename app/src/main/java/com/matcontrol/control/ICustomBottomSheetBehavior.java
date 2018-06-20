package com.matcontrol.control;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;

import java.util.List;

public interface ICustomBottomSheetBehavior<V extends View> {
    void setNestedScrollingChildRefList(List<View> nestedScrollingChildRefList);
    boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection);
}
