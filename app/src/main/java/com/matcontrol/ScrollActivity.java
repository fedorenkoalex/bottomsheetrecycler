package com.matcontrol;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.matcontrol.control.BottomSheetBehavior;
import com.matcontrol.control.BottomSheetBehaviorRecyclerManager;

public class ScrollActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehavior;
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

        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheetView);

        mBottomSheetBehavior.setPeekHeight(150);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
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
