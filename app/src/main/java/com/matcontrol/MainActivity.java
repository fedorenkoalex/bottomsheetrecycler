package com.matcontrol;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.matcontrol.control.BottomSheetBehaviorRecyclerManager;
import com.matcontrol.control.BottomSheetBehavior_v25;
import com.matcontrol.control.BottomSheetBehavior_v27;
import com.matcontrol.control.BottomSheetDialog_v25;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mRecyclerBtn;
    private Button mScrollBtn;
    private Button mRecyclerDialogBtn;

    private CoordinatorLayout mParent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mParent = (CoordinatorLayout) findViewById(R.id.parent_container);
        mParent.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        mRecyclerBtn = (Button) findViewById(R.id.recyclerView_btn);
        mScrollBtn = (Button) findViewById(R.id.scrollView_btn);
        mRecyclerDialogBtn = (Button) findViewById(R.id.recyclerDialog_btn);

        mRecyclerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RecyclerActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        mScrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ScrollActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        mRecyclerDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i = new Intent(MainActivity.this, RecyclerDialogActivity.class);
                MainActivity.this.startActivity(i);*/

                /*BottomSheetDialogv2 bottomSheetDialog = new BottomSheetDialogv2(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
                bottomSheetDialog.setContentView(view1);
                bottomSheetDialog.show();*/

                createDialogBtmSheet();
            }
        });
    }


    private void createDialogBtmSheet() {
        BottomSheetDialog_v25 bottomSheetDialog = new BottomSheetDialog_v25(MainActivity.this);
        View dialogSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

        bottomSheetDialog.setContentView(dialogSheetView);
        bottomSheetDialog.show();

        RecyclerView mBottomSheetRecyclerLeft = (RecyclerView) dialogSheetView.findViewById(R.id.btm_recyclerview_left);
        LinearLayoutManager mLayoutManagerLeft = new LinearLayoutManager(this);
        mBottomSheetRecyclerLeft.setLayoutManager(mLayoutManagerLeft);

        RecyclerView mBottomSheetRecyclerRight = (RecyclerView) dialogSheetView.findViewById(R.id.btm_recyclerview_right);
        LinearLayoutManager mLayoutManagerRight = new LinearLayoutManager(this);
        mBottomSheetRecyclerRight.setLayoutManager(mLayoutManagerRight);

        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.getBehavior().setPeekHeight(150);
        bottomSheetDialog.getBehavior().setState(BottomSheetBehavior_v27.STATE_COLLAPSED);


        RecyclerAdapter mAdapterLeft = new RecyclerAdapter();
        mBottomSheetRecyclerLeft.setAdapter(mAdapterLeft);
        mAdapterLeft.setOnClickInterface(new RecyclerAdapter.OnClickInterface() {
            @Override
            public void onClick(TempModel tempModel) {
                Toast.makeText(MainActivity.this, "Clicked ".concat(tempModel.getName()), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerAdapter mAdapterRight = new RecyclerAdapter();
        mBottomSheetRecyclerRight.setAdapter(mAdapterRight);
        mAdapterRight.setOnClickInterface(new RecyclerAdapter.OnClickInterface() {
            @Override
            public void onClick(TempModel tempModel) {
                Toast.makeText(MainActivity.this, "Clicked ".concat(tempModel.getName()), Toast.LENGTH_SHORT).show();
            }
        });

        List<TempModel> modelsLeft = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            modelsLeft.add(new TempModel(i + " left"));
        }
        List<TempModel> modelsRight = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            modelsRight.add(new TempModel(i + " right"));
        }


        mAdapterLeft.update(modelsLeft);
        mAdapterRight.update(modelsRight);

        //helper to rule scrolls
        BottomSheetBehaviorRecyclerManager manager = new BottomSheetBehaviorRecyclerManager(mParent, bottomSheetDialog.getBehavior(), bottomSheetDialog.getBottomSheetView());
        manager.addControl(mBottomSheetRecyclerLeft);
        manager.addControl(mBottomSheetRecyclerRight);
        manager.create();
    }
}
