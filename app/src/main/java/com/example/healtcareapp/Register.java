package com.example.healtcareapp;

import android.content.Intent;
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

public class Register extends AppCompatActivity {

    EditText edUsername, edemail, edPassword, edConfirmPassword;
    Button btn2;
    TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editUsername);
        edemail = findViewById(R.id.emailAddress);
        edPassword= findViewById(R.id.editPassword);
        edConfirmPassword = findViewById(R.id.editConfirmPassword);
        btn2 = findViewById(R.id.registerbtn);
        txt2= findViewById(R.id.login);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =  edUsername.getText().toString();
                String email =  edemail.getText().toString();
                String password =  edPassword.getText().toString();
                String confirmPassword =  edConfirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "heathYOU", null,1);

                if(username.length() == 0 || email.length() ==00 || password.length() == 0 || confirmPassword.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please complete the details", Toast.LENGTH_SHORT ).show();
                }
                else{
                    if(password.compareTo(confirmPassword)==0){
                        if(isValid(password)) {
                            db.register(username,email,password,confirmPassword);

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must be 8 charaters", Toast.LENGTH_SHORT ).show();

                        }
                        Toast.makeText(getApplicationContext(), "Both passwords didn't match", Toast.LENGTH_SHORT ).show();


                    }
                }
            }
        });

    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isLetter(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;


        }
    }
}