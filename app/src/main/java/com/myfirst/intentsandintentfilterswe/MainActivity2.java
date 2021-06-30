package com.myfirst.intentsandintentfilterswe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTvView = findViewById(R.id.tvShow);
        Intent intent = getIntent();
        String user = intent.getStringExtra("username");
        mTvView.setText(user);
    }
}