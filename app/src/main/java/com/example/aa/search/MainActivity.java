package com.example.aa.search;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {

    private Button login;
    private EditText username;
    private EditText password;

    @Override
    public void registerListener() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void findViews() {
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.btn);
        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
    }

}
