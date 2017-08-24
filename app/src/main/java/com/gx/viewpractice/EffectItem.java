package com.gx.viewpractice;

/**
 * Created by gaoxuan on 2017/8/24.
 */

public class EffectItem {
    private String name;
    private int count;

    public EffectItem(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
