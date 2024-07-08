package com.example.healtcareapp;

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
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edusername = findViewById(R.id.email);
        edpassword = findViewById(R.id.password);
        btn = findViewById(R.id.loginbtn);
        txt = findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
            }
        });
    }
}