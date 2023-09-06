package com.example.fitapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    static Context context;
    static ArrayList<String> uexercise;
    static ArrayList<String>  usets;
    static ArrayList<String>  ureps;
    static ArrayList<String>  uweight;
    LayoutInflater layoutInflater;

    public MyAdapter(Context context, ArrayList<String>  uexercise, ArrayList<String>  usets, ArrayList<String>  ureps, ArrayList<String>  uweight){
        this.context = context;
        this.uexercise = uexercise;
        this.usets = usets;
        this.ureps = ureps;
        this.uweight = uweight;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.workout_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.exercises.setText(String.valueOf(uexercise.get(position)));
        holder.setss.setText(String.valueOf(usets.get(position)));
        holder.repss.setText(String.valueOf(ureps.get(position)));
        holder.weights.setText(String.valueOf(uweight.get(position)));

    }

    @Override
    public int getItemCount() {
        return uexercise.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView exercises, setss, repss, weights;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            exercises = itemView.findViewById(R.id.exercise_tv);
            setss = itemView.findViewById(R.id.sets_tv);
            repss = itemView.findViewById(R.id.reps_tv);
            weights = itemView.findViewById(R.id.weight_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Edit_exercise.class);
                    intent.putExtra("exercises", uexercise.get(getAdapterPosition()));
                    intent.putExtra("sets", usets.get(getAdapterPosition()));
                    intent.putExtra("reps", ureps.get(getAdapterPosition()));
                    intent.putExtra("weight", uweight.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
