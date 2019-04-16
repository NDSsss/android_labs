package com.example.androidlabs;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvLabel;
    EditText etLogin;
    EditText etPassword;
    Button btnSignIn;
    Button btnSignUp;

    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persons = new ArrayList<>();
        Person person = new Person();
        person.setLogin("test");
        person.setPassword("test");
        tvLabel = findViewById(R.id.tv_label);
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_sing_in);
        btnSignUp = findViewById(R.id.btn_sing_up);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
    }

    private void signIn(){
        for(Person person: persons){
            if(person.getLogin().equalsIgnoreCase(etLogin.getText().toString())
                    && person.getPassword().equalsIgnoreCase(etPassword.getText().toString())){
                tvLabel.setText("Вошли");
                return;
            }
        }
        tvLabel.setText("Не зарегестрирован");
    }

    private void openRegistration(){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 1){
            if(resultCode == 2){
                Person person = (Person) data.getParcelableExtra("person");
                persons.add(person);
                etLogin.setText(person.getLogin());
                etPassword.setText(person.getPassword());
            }
        }
    }
}
