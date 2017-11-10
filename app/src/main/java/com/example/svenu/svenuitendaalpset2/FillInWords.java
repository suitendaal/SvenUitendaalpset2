package com.example.svenu.svenuitendaalpset2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class FillInWords extends AppCompatActivity {

    EditText editText;
    TextView wordtype;
    TextView counter;
    Story story;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in_words);

        editText = findViewById(R.id.editText);
        wordtype = findViewById(R.id.wordtype);
        counter = findViewById(R.id.counter);

        Intent intent = getIntent();
        String receivedStory = intent.getStringExtra("storyname");

        String[] stories = {"simple.txt",
                "tarzan.txt",
                "university.txt",
                "clothes.txt",
                "dance.txt"};

        // laad het juiste verhaal dmv cases
        InputStream storyfile;
        switch (receivedStory){
            case "Simple":
            try {
                storyfile = getAssets().open(stories[0]);
                story = new Story(storyfile);
                title = stories[0].replace(".txt","");
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
                title = stories[1].replace(".txt","");
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
                title = stories[2].replace(".txt","");
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
                title = stories[3].replace(".txt","");
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
                title = stories[4].replace(".txt","");
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
                title = stories[i].replace(".txt","");
                load_page();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }

    @Override
    public void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        story = (Story)inState.getSerializable("story");
        load_page();
    }

    public void load_page() {
        int n = story.getPlaceholderRemainingCount();
        String counterText = n + " word(s) left";
        counter.setText(counterText);

        String placeholderText = story.getNextPlaceholder();
        editText.setHint(placeholderText);

        String wordtypeText = "please type a/an " + placeholderText;
        wordtype.setText(wordtypeText);

        if (n == 1) {
            Button b = findViewById(R.id.ok);
            b.setText("Make story");
        }
    }

    public void submitWord(View view) {
        String new_word = editText.getText().toString();
        if (!new_word.equals("")) {
            story.fillInPlaceholder(new_word);
            editText.setText("");
        }
        else {
            // https://developer.android.com/guide/topics/ui/notifiers/toasts.html
            Context context = getApplicationContext();
            CharSequence text = "No word filled in";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        if (story.isFilledIn()) {
            show_story();
        }

        load_page();
    }

    public void show_story() {
        Intent intent = new Intent(this, ShowStory.class);
        String storyString = story.toString();
        intent.putExtra("story", storyString);
        intent.putExtra("title", title);
        startActivity(intent);
        finish();
    }
}
