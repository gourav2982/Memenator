package com.example.memenator;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    String currenturl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMeme();

    }
    private void loadMeme(){

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);


        String url = "https://meme-api.com/gimme";
        MySingleton mySingleton = new MySingleton(imageView,progressBar,url,this);
    }

    public void nextMeme(View view) {
        loadMeme();


    }

    public void shareMeme(View view) {
        currenturl = MySingleton.currenturl;

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT,"Hey,check this meme out \n"+currenturl);
        Intent chooser = Intent.createChooser(i,"Share this meme to your friend");
        startActivity(chooser);
    }
}