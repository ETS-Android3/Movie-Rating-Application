package com.example.movieratingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public RecyclerViewAdapter(Context context, List<Movie> movies) {
        this.context = context;
        movieList = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.movie_name.setText(movieList.get(position).getName());
        holder.movie_year.setText(movieList.get(position).getYear());
        holder.movie_length.setText(movieList.get(position).getLength());
        holder.movie_director.setText(movieList.get(position).getDirector());
        holder.movie_rating.setText(movieList.get(position).getRating());
        
        holder.constraintLayout.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView movie_name;
        TextView movie_year;
        TextView movie_length;
        TextView movie_director;
        TextView movie_rating;

        ConstraintLayout constraintLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            movie_name = itemView.findViewById(R.id.movie_name);
            movie_year = itemView.findViewById(R.id.movie_year);
            movie_length = itemView.findViewById(R.id.movie_length);
            movie_director = itemView.findViewById(R.id.movie_director);
            movie_rating = itemView.findViewById(R.id.movie_rating);
            constraintLayout = itemView.findViewById(R.id.main_layout);

        }
    }
}*/

class MovieAdapter extends ArrayAdapter<Movie>{

    private Context context;
    private ArrayList<Movie> movieList;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        super(context, R.layout.list_item, movieList);
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Movie getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh ;
        LayoutInflater appInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null){

            vh = new ViewHolder();
            view = appInflater.inflate(R.layout.list_item,parent, false);

            vh.name = (TextView) view.findViewById(R.id.movie_name);
            vh.year = (TextView) view.findViewById(R.id.movie_year);
            vh.length = (TextView) view.findViewById(R.id.movie_length);
            vh.director = (TextView) view.findViewById(R.id.movie_director);
            vh.rating = (TextView) view.findViewById(R.id.movie_rating);
            vh.actors = (TextView) view.findViewById(R.id.movie_actors);

            view.setTag(vh);
        }
        else{
            vh = (ViewHolder) view.getTag();
        }

        Movie nm = movieList.get(position);

        vh.name.setText(nm.getName());
        vh.year.setText(nm.getYear());
        vh.length.setText(nm.getLength());
        vh.director.setText("Director: " + nm.getDirector());
        vh.rating.setText(nm.getRating());
        vh.actors.setText("Featuring: " + nm.getActors());

        return view;
    }

    class  ViewHolder{
        TextView name;
        TextView year;
        TextView length;
        TextView director;
        TextView rating;
        TextView actors;
    }
}