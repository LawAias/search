package com.example.aa.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by aa on 2016/3/31.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViews();
        registerListener();
    }

    /**
     * 注册事件
     */
    public abstract void registerListener();

    /**
     * 关联控件
     */
    public abstract void findViews();
}
