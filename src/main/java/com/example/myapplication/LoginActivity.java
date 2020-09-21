package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.utils.ShareUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        initViews();
        loadData();
    }

    private void loadData() {
        String userName = ShareUtils.getInstance(this).getString(ShareUtils.KEY_USER_NAME);
        String password = ShareUtils.getInstance(this).getString(ShareUtils.KEY_PASSWORD);
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }

    private void initViews() {
        edtPassword = findViewById(R.id.edt_content);
        edtUserName = findViewById(R.id.edt_user_name);
        btnSave = findViewById(R.id.btn_login);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        ShareUtils.getInstance(this).putString(ShareUtils.KEY_USER_NAME, userName);
        ShareUtils.getInstance(this).putString(ShareUtils.KEY_PASSWORD, password);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}