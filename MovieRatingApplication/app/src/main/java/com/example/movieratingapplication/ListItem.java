package com.example.movieratingapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListItem extends AppCompatActivity {

    TextView movie_name;
    TextView movie_year;
    TextView movie_description;
    TextView movie_length;
    TextView movie_rating;
    TextView movie_actors;
    TextView movie_director;

    Button save_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_details);

        movie_name = findViewById(R.id.movie_name);
        movie_year = findViewById(R.id.movie_year);
        movie_length = findViewById(R.id.movie_length);
        movie_description = findViewById(R.id.movie_description);
        save_button = findViewById(R.id.save_button);
        movie_rating = findViewById(R.id.movie_rating);
        movie_actors = findViewById(R.id.movie_actors);
        movie_director = findViewById(R.id.movie_director);

        Context context = getApplicationContext();

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                Toast.makeText(context, "Thank you for your evaluation of " + bundle.getString("name"), Toast.LENGTH_SHORT).show();
            }
        });

        Bundle bundle = getIntent().getExtras();

        movie_name.setText(bundle.getString("name"));
        movie_year.setText(bundle.getString("year"));
        movie_length.setText(bundle.getString("length"));
        movie_description.setText(bundle.getString("description"));
        movie_rating.setText(bundle.getString("rating"));
        movie_actors.setText(bundle.getString("actors"));
        movie_director.setText(bundle.getString("director"));
    }
}
