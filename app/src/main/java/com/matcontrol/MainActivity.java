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

import com.matcontrol.control.BottomSheetBehaviorRecyclerManager;
import com.matcontrol.control.BottomSheetBehaviorv2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mRecyclerBtn;
    private Button mScrollBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerBtn = (Button) findViewById(R.id.recyclerView_btn);
        mScrollBtn = (Button) findViewById(R.id.scrollView_btn);
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

    }
}
