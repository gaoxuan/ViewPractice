package com.gx.viewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_main)
    ListView lvMain;

    private List<EffectItem> effectList;
    private SimpleItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        setListeners();
    }

    private void initData() {
        effectList = new ArrayList<>();
        effectList.add(new EffectItem("View练习", 4));
        adapter = new SimpleItemAdapter(this, effectList);
        lvMain.setAdapter(adapter);
    }

    private void setListeners() {
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startFragment(position);
            }
        });
    }

    private void startFragment(int position) {

    }
}
