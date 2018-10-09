package com.example.uno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        email = findViewById(R.id.email);
        button = findViewById(R.id.buttonsecond);

        String text = getIntent().getStringExtra("nuovamail");
        email.setText(text);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentreturn = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentreturn);
            }
        });


    }
}
