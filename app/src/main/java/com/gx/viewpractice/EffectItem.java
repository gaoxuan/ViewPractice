package com.gx.viewpractice;

/**
 * Created by gaoxuan on 2017/8/24.
 */

public class EffectItem {
    private String name;
    private int count;
    private Class cls;

    public EffectItem(String name, int count, Class cls) {
        this.name = name;
        this.count = count;
        this.cls = cls;
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

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }
}
