package com.gx.viewpractice.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gx.viewpractice.R;
import com.gx.viewpractice.SimpleFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gaoxuan on 2017/8/25.
 */

public class ViewActivity extends AppCompatActivity {

    @BindView(R.id.tv_view_basic)
    TextView tvViewBasic;
    @BindView(R.id.tv_view_paint)
    TextView tvViewPaint;
    @BindView(R.id.tv_view_text)
    TextView tvViewText;
    @BindView(R.id.tv_view_canvas)
    TextView tvViewCanvas;
    @BindView(R.id.tv_view_order)
    TextView tvViewOrder;
    @BindView(R.id.vp_view)
    ViewPager vpView;

    private SimpleFragmentAdapter adapter;
    private List<Fragment> fragmentList;
    private ViewFragmentFactory bascFragment;
    private ViewFragmentFactory paintFragment;
    private ViewFragmentFactory textFragment;
    private ViewFragmentFactory canvasFragment;
    private ViewFragmentFactory orderFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);

        initData();
        setListeners();
    }

    private void setListeners() {
        vpView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeSelectItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeSelectItem(int position) {
        switch (position) {
            case 0:
                tvViewBasic.setTextColor(getResources().getColor(R.color.colorAccent));
                tvViewPaint.setTextColor(getResources().getColor(R.color.grey));
                tvViewText.setTextColor(getResources().getColor(R.color.grey));
                tvViewCanvas.setTextColor(getResources().getColor(R.color.grey));
                tvViewOrder.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 1:
                tvViewBasic.setTextColor(getResources().getColor(R.color.grey));
                tvViewPaint.setTextColor(getResources().getColor(R.color.colorAccent));
                tvViewText.setTextColor(getResources().getColor(R.color.grey));
                tvViewCanvas.setTextColor(getResources().getColor(R.color.grey));
                tvViewOrder.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 2:
                tvViewBasic.setTextColor(getResources().getColor(R.color.grey));
                tvViewPaint.setTextColor(getResources().getColor(R.color.grey));
                tvViewText.setTextColor(getResources().getColor(R.color.colorAccent));
                tvViewCanvas.setTextColor(getResources().getColor(R.color.grey));
                tvViewOrder.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 3:
                tvViewBasic.setTextColor(getResources().getColor(R.color.grey));
                tvViewPaint.setTextColor(getResources().getColor(R.color.grey));
                tvViewText.setTextColor(getResources().getColor(R.color.grey));
                tvViewCanvas.setTextColor(getResources().getColor(R.color.colorAccent));
                tvViewOrder.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 4:
                tvViewBasic.setTextColor(getResources().getColor(R.color.grey));
                tvViewPaint.setTextColor(getResources().getColor(R.color.grey));
                tvViewText.setTextColor(getResources().getColor(R.color.grey));
                tvViewCanvas.setTextColor(getResources().getColor(R.color.grey));
                tvViewOrder.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        bascFragment = ViewFragmentFactory.getInstance(ViewFragmentFactory.TYPE_BASIC);
        paintFragment = ViewFragmentFactory.getInstance(ViewFragmentFactory.TYPE_PAINT);
        textFragment = ViewFragmentFactory.getInstance(ViewFragmentFactory.TYPE_TEXT);
        canvasFragment = ViewFragmentFactory.getInstance(ViewFragmentFactory.TYPE_CANVAS);
        orderFragment = ViewFragmentFactory.getInstance(ViewFragmentFactory.TYPE_ORDER);
        fragmentList.add(bascFragment);
        fragmentList.add(paintFragment);
        fragmentList.add(textFragment);
        fragmentList.add(canvasFragment);
        fragmentList.add(orderFragment);

        adapter = new SimpleFragmentAdapter(getSupportFragmentManager(), fragmentList);
        vpView.setAdapter(adapter);
    }

    @OnClick({R.id.tv_view_basic, R.id.tv_view_paint, R.id.tv_view_text, R.id.tv_view_canvas, R.id.tv_view_order})
    public void onClick(View view) {
        int position = 0;
        switch (view.getId()) {
            case R.id.tv_view_basic:
                position = 0;
                break;
            case R.id.tv_view_paint:
                position = 1;
                break;
            case R.id.tv_view_text:
                position = 2;
                break;
            case R.id.tv_view_canvas:
                position = 3;
                break;
            case R.id.tv_view_order:
                position = 4;
                break;
        }
        vpView.setCurrentItem(position);
        changeSelectItem(position);
    }
}
