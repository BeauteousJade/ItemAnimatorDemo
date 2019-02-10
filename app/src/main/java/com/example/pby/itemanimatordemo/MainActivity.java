package com.example.pby.itemanimatordemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private List<Bean> mDataList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        mAdapter = new RecyclerViewAdapter(mDataList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new CustomItemAnimator());
        mRecyclerView.getItemAnimator().setChangeDuration(10000);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            Bean bean = new Bean();
            bean.setContent("position = " + i);
            bean.setColor(Color.parseColor(ColorUtils.generateRandomColor()));
            mDataList.add(bean);
        }
    }

    @OnClick(R.id.add)
    public void onAdd(View view) {
        mDataList.add(0, new Bean("add data", Color.parseColor(ColorUtils.generateRandomColor())));
        mAdapter.notifyItemInserted(0);
        mRecyclerView.scrollToPosition(0);
    }

    @OnClick(R.id.remove)
    public void onRemove(View view) {
        mDataList.remove(0);
        mAdapter.notifyItemRemoved(0);
    }

    @OnClick(R.id.change)
    public void onChanged(View view) {
        mDataList.get(0).setContent("change data");
        mAdapter.notifyItemChanged(0);
    }
}
