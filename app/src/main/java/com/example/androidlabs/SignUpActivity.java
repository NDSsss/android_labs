package com.example.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    EditText etLogin;
    EditText etPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        etLogin = findViewById(R.id.et_sign_up_login);
        etPassword = findViewById(R.id.et_sign_up_password);
        btnSignUp = findViewById(R.id.btn_sign_up_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register(){
        Person person = new Person();
        person.setLogin(etLogin.getText().toString());
        person.setPassword(etPassword.getText().toString());
        Intent data = new Intent();
        data.putExtra("person", person);
        setResult(2, data);
        finish();
    }
}
