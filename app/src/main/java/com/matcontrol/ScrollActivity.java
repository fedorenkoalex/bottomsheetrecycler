package com.matcontrol;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.matcontrol.control.BottomSheetBehaviorRecyclerManager;
import com.matcontrol.control.BottomSheetBehavior_v27;

public class ScrollActivity extends AppCompatActivity {

    private BottomSheetBehavior_v27 mBottomSheetBehavior;
    private View mBottomSheetView;

    private CoordinatorLayout mParent;

    private ScrollView mScrollLeft;
    private ScrollView mScrollRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        mParent = (CoordinatorLayout) findViewById(R.id.parent_container);
        mParent.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        mBottomSheetView = findViewById(R.id.main_bottomsheet);


        mScrollLeft = (ScrollView) findViewById(R.id.scroll_left);
        mScrollRight = (ScrollView) findViewById(R.id.scroll_right);

        mBottomSheetBehavior = BottomSheetBehavior_v27.from(mBottomSheetView);

        mBottomSheetBehavior.setPeekHeight(150);
        mBottomSheetBehavior.setState(BottomSheetBehavior_v27.STATE_COLLAPSED);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior_v27.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior_v27.STATE_COLLAPSED) {
                    //  mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });


        //helper to rule scrolls
        BottomSheetBehaviorRecyclerManager manager = new BottomSheetBehaviorRecyclerManager(mParent, mBottomSheetBehavior, mBottomSheetView);
        manager.addControl(mScrollLeft);
        manager.addControl(mScrollRight);
        manager.create();

    }
}
