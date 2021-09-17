package com.multicampus.androidjava202109.multichat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.enterBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String server = ((TextView)findViewById(R.id.server)).getText().toString();
                String nickname = ((TextView)findViewById(R.id.nickname)).getText().toString();

                // ChatActivity 호출
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                intent.putExtra("server", server);
                intent.putExtra("nickname", nickname);

                startActivity(intent);
            }
        });
    }
}