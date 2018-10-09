package com.example.uno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button buttoninvio;


    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        buttoninvio = findViewById(R.id.button);


        buttoninvio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailnuova = email.getText().toString();
                String passwordnuova = password.getText().toString();

                /*
                if (emailnuova.isEmpty() || !isValidEmail(emailnuova)){
                    Toast.makeText(MainActivity.this, "email sbagliata", Toast.LENGTH_SHORT).show();
                }else if (passwordnuova.isEmpty()|| passwordnuova.length() < 6){
                    Toast.makeText(MainActivity.this, "Password errata", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(MainActivity.this, "Inserito correttamente", Toast.LENGTH_SHORT).show();
                    */

                if (emailnuova.isEmpty() && passwordnuova.isEmpty()){
                    Toast.makeText(MainActivity.this, "Accesso Negato", Toast.LENGTH_SHORT).show();
                }else if (!isValidEmail(emailnuova)){
                    Toast.makeText(MainActivity.this, "Email errata e/o mancante", Toast.LENGTH_SHORT).show();
                }else if (passwordnuova.length()<6){
                    Toast.makeText(MainActivity.this, "Password errata e/o mancante", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Inserimento effettuato", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                    intent.putExtra("nuovamail",emailnuova);
                    startActivity(intent);


                }


            }
        });

    }



}
