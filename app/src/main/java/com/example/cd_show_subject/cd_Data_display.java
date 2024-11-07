package com.example.cd_show_subject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cd_Data_display extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cd_data_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Show_Data), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            Button Show= findViewById(R.id.Show_Button);
            Button backbtn = findViewById(R.id.backbutton);
            TextView txt = findViewById(R.id.textView);

//            getIntent().getStringExtra("CD");
            Intent intent = getIntent();



                Show.setOnClickListener(v1 -> {
                    if(txt.getText()!=null && txt.getText().toString().isEmpty()){
                        txt.setText(intent.getStringExtra("CD"));
                    }
                });
            backbtn.setOnClickListener(view -> {
                finish();
            });

            return insets;
        });
    }
}