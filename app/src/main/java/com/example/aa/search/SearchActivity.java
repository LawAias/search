package com.example.aa.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by aa on 2016/3/31.
 */
public class SearchActivity extends BaseActivity {

    private Button search;
    private EditText input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_search);
        findViews();

    }

    @Override
    public void registerListener() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchActivity.this,RecyclerViewActivity.class);
            }
        });
    }

    public void findViews() {
        search = (Button) findViewById(R.id.search);
        input = (EditText) findViewById(R.id.input);

    }
}
