package com.gx.viewpractice.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gaoxuan on 2017/8/25.
 */

public class ViewFragmentFactory extends Fragment {
    private static final String PARAMS_TYPE = "type";

    public static final String TYPE_BASIC = "type_basic";
    public static final String TYPE_PAINT = "type_paint";
    public static final String TYPE_TEXT = "type_text";
    public static final String TYPE_CANVAS = "type_canvas";
    public static final String TYPE_ORDER = "type_order";

    private String type;

    public static ViewFragmentFactory getInstance(String type) {
        ViewFragmentFactory fragment = new ViewFragmentFactory();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString(PARAMS_TYPE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (type) {
            case TYPE_BASIC:
                view = new Session1(getActivity());
                break;
            case TYPE_PAINT:
                view = new Session2(getActivity());
                break;
            case TYPE_TEXT:
                view = new Session3(getActivity());
                break;
            case TYPE_CANVAS:
                view = new Session4(getActivity());
                break;
            case TYPE_ORDER:
                view = new Session5(getActivity());
                break;
        }
        return view;
    }
}
