package com.example.aa.search;

import android.content.Intent;
import android.os.Bundle;
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
    public void registerListener() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SearchActivity.this, RecyclerViewActivity.class);
                Bundle b = new Bundle();
                b.putString("searchvalue", input.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    public void findViews() {
        setContentView(R.layout.act_search);
        search = (Button) findViewById(R.id.search);
        input = (EditText) findViewById(R.id.input);

    }
}
