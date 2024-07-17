package com.example.healtcareapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Login extends AppCompatActivity {
    EditText edusername, edpassword;
    Button btn1;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edusername = findViewById(R.id.username);
        edpassword = findViewById(R.id.password);
        btn1 = findViewById(R.id.loginbtn);
        txt1 = findViewById(R.id.register);

        btn1 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edusername.getText().toString();
                String password = edpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"healtYOU",null, 1);
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Complete the details or register yourself", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.login(username,password)==1){
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(Login.this,Home.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid username or password" , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
}