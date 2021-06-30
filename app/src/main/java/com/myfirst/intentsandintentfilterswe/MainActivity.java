package com.myfirst.intentsandintentfilterswe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String eMailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private EditText mETEmail;
    private EditText mEtUser;
    private EditText mEtPass;
    private Button mBtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtLog.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmailValid() && isPasswordValid() && isUserValid()){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("username",mEtUser.getText().toString());
                    startActivity(intent);
                }
            }
        }));
    }

    private void initViews() {
        mEtUser = findViewById(R.id.etUser);
        mETEmail = findViewById(R.id.etEmail);
        mEtPass = findViewById(R.id.etPass);
        mBtLog = findViewById(R.id.btLog);

    }
    private boolean isEmailValid() {
        if (mETEmail.getText().toString().length() >= 1 && mETEmail.getText().toString().matches(eMailValidation))
            return true;
        else {
            mETEmail.setError("Email Invalid");
            return false;
        }
    }
    private boolean isPasswordValid(){
        if(mEtPass.getText().toString().trim().length() >= 6)
            return true;
        else{
            mEtPass.setError("Password is less than 6 characters");
        }
            return false;
    }
    private boolean isUserValid(){
        if(mEtPass.getText().toString().trim().length() >= 4)
            return true;
        else{
            mEtUser.setError("Username is less than 4 characters");
        }
            return false;
    }
}