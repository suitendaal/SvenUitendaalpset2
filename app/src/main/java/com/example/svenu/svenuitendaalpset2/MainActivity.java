package com.example.svenu.svenuitendaalpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        Button b = (Button)view;
        String storyname = b.getText().toString();
        Intent intent = new Intent(this, FillInWords.class);
        intent.putExtra("storyname", storyname);
        startActivity(intent);
    }
}
