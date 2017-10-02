package com.matcontrol;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.matcontrol.control.BottomSheetBehaviorRecyclerManager;
import com.matcontrol.control.BottomSheetBehaviorv2;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    private BottomSheetBehaviorv2 mBottomSheetBehavior;
    private View mBottomSheetView;

    private CoordinatorLayout mParent;


    private RecyclerView mBottomSheetRecyclerRight;
    private LinearLayoutManager mLayoutManagerRight;
    private RecyclerAdapter mAdapterRight;

    private RecyclerView mBottomSheetRecyclerLeft;
    private LinearLayoutManager mLayoutManagerLeft;
    private RecyclerAdapter mAdapterLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mParent = (CoordinatorLayout) findViewById(R.id.parent_container);
        mParent.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        mBottomSheetView = findViewById(R.id.main_bottomsheet);


        mBottomSheetRecyclerLeft = (RecyclerView) findViewById(R.id.btm_recyclerview_left);
        mLayoutManagerLeft = new LinearLayoutManager(this);
        mBottomSheetRecyclerLeft.setLayoutManager(mLayoutManagerLeft);

        mBottomSheetRecyclerRight = (RecyclerView) findViewById(R.id.btm_recyclerview_right);
        mLayoutManagerRight = new LinearLayoutManager(this);
        mBottomSheetRecyclerRight.setLayoutManager(mLayoutManagerRight);


        mBottomSheetBehavior = BottomSheetBehaviorv2.from(mBottomSheetView);

        mBottomSheetBehavior.setPeekHeight(150);
        mBottomSheetBehavior.setState(BottomSheetBehaviorv2.STATE_COLLAPSED);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehaviorv2.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehaviorv2.STATE_COLLAPSED) {
                    //  mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        mAdapterLeft = new RecyclerAdapter();
        mAdapterLeft.setOnClickInterface(new RecyclerAdapter.OnClickInterface() {
            @Override
            public void onClick(TempModel tempModel) {
                Toast.makeText(RecyclerActivity.this, "Clicked Left ".concat(tempModel.getName()), Toast.LENGTH_SHORT).show();
            }
        });
        mBottomSheetRecyclerLeft.setAdapter(mAdapterLeft);

        mAdapterRight = new RecyclerAdapter();
        mAdapterRight.setOnClickInterface(new RecyclerAdapter.OnClickInterface() {
            @Override
            public void onClick(TempModel tempModel) {
                Toast.makeText(RecyclerActivity.this, "Clicked Right ".concat(tempModel.getName()), Toast.LENGTH_SHORT).show();
            }
        });
        mBottomSheetRecyclerRight.setAdapter(mAdapterRight);

        List<TempModel> models = new ArrayList<>();
        models.add(new TempModel("a"));
        models.add(new TempModel("b"));
        models.add(new TempModel("c"));
        models.add(new TempModel("d"));
        models.add(new TempModel("f"));
        models.add(new TempModel("e"));
        models.add(new TempModel("k"));
        models.add(new TempModel("l"));
        models.add(new TempModel("a"));
        models.add(new TempModel("b"));
        models.add(new TempModel("c"));
        models.add(new TempModel("d"));
        models.add(new TempModel("f"));
        models.add(new TempModel("e"));
        models.add(new TempModel("k"));
        models.add(new TempModel("l"));
        models.add(new TempModel("a"));
        models.add(new TempModel("b"));
        models.add(new TempModel("c"));
        models.add(new TempModel("d"));
        models.add(new TempModel("f"));
        models.add(new TempModel("e"));
        models.add(new TempModel("k"));
        models.add(new TempModel("l"));

        mAdapterRight.update(models);
        mAdapterLeft.update(models);

        //helper to rule scrolls
        BottomSheetBehaviorRecyclerManager manager = new BottomSheetBehaviorRecyclerManager(mParent, mBottomSheetBehavior, mBottomSheetView);
        manager.addControl(mBottomSheetRecyclerLeft);
        manager.addControl(mBottomSheetRecyclerRight);
        manager.create();

    }
}
