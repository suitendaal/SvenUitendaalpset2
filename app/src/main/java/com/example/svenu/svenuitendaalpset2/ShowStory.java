package com.example.svenu.svenuitendaalpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_story);

        Intent intent = getIntent();
        String storytext = intent.getStringExtra("story");
        String titletext = intent.getStringExtra("title");

        TextView story = (TextView)findViewById(R.id.story);
        TextView title = (TextView)findViewById(R.id.title) ;
        title.setText(titletext);
        story.setText(storytext);
    }

    public void chooseNew(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
