package com.example.svenu.svenuitendaalpset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class FillInWords extends AppCompatActivity {

    EditText editText = (EditText)findViewById(R.id.editText);
    Story story;
    TextView wordtype = (TextView)findViewById(R.id.wordtype);
    TextView counter = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_words);

        Intent intent = getIntent();
        String receivedStory = intent.getStringExtra("storyname");

        String[] stories = {"madlib0_simple.txt",
                "madlib1_tarzan.txt",
                "madlib2_university.txt",
                "madlib3_clothes.txt",
                "madlib4_dance.txt"};

        // laad het juiste verhaal dmv cases
        InputStream storyfile;
        switch (receivedStory){
            case "Simple":
            try {
                storyfile = getAssets().open(stories[0]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            break;
            case "Tarzan":
            try {
                storyfile = getAssets().open(stories[1]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            break;
            case "University":
            try {
                storyfile = getAssets().open(stories[2]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            break;
            case "Clothes":
            try {
                storyfile = getAssets().open(stories[3]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            break;
            case "Dance":
            try {
                storyfile = getAssets().open(stories[4]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            break;
            case "Random":;
            try {
                Random r = new Random();
                int i = r.nextInt(5);
                storyfile = getAssets().open(stories[i]);
                story = new Story(storyfile);
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void load_page() {
        int n = story.getPlaceholderRemainingCount();
        String counterText = n + " word(s) left";
        counter.setText(counterText);

        String placeholderText = story.getNextPlaceholder();
        editText.setHint(placeholderText);

        String wordtypeText = "please type a/an " + placeholderText;
        wordtype.setText(wordtypeText);
    }

    public void submitWord(Button ok) {
        

        load_page();
    }
}
