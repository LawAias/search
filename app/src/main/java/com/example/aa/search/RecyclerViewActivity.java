package com.example.aa.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

/**
 * Created by aa on 2016/3/31.
 */
public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void registerListener() {

    }

    @Override
    public void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
