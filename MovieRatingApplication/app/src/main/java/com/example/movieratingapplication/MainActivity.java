package com.example.movieratingapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity<JasonArrayRequest> extends AppCompatActivity {

    private JasonArrayRequest request;
    private RequestQueue requestQueue;
    private ArrayList<Movie> movieList;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<Movie>();

        listview = findViewById(R.id.listView);

        requestQueue = Volley.newRequestQueue(this);

        //String urlObj = "https://run.mocky.io/v3/458cc99d-ad1c-43f8-9b0b-1c8310ac3c7c";
        String urlArray = "https://run.mocky.io/v3/7e12bc62-f35b-4b89-a915-c0eaeb359557";

        String url = "http://127.0.0.1:3000/movies";

        try{
            Thread.sleep(2000);
        }catch(Exception e){

        }
        JsonArrayRequest jr = new JsonArrayRequest(Request.Method.GET, urlArray, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                parseJSON(response);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jr);
    }

    private void parseJSON(JSONArray response) {
        try {
            //JSONArray jsonArray = response.getJSONArray("movie");

            for (int i = 0; i < response.length(); i++) {

                JSONObject mv = response.getJSONObject(i);

                Movie movie = new Movie();

                movie.setName(mv.getString("name"));
                movie.setYear(mv.getString("year"));
                movie.setLength(mv.getString("length"));
                movie.setDirector(mv.getString("director"));
                movie.setRating(mv.getString("rating"));
                movie.setDescription(mv.getString("description"));
                movie.setActors(mv.getString("actors"));

                movieList.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MovieAdapter adapter = new MovieAdapter(MainActivity.this, (ArrayList<Movie>) movieList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movie movie = (Movie) parent.getItemAtPosition(position);

                Bundle bundle = new Bundle();

                bundle.putString("name", movie.getName());
                bundle.putString("year", movie.getYear());
                bundle.putString("length", movie.getLength());
                bundle.putString("director", movie.getDirector());
                bundle.putString("actors", movie.getActors());
                bundle.putString("rating", movie.getRating());
                bundle.putString("description", movie.getDescription());

                Intent intent = new Intent(MainActivity.this, ListItem.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}