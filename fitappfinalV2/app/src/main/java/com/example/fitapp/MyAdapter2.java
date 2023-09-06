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

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    static Context context;
    static ArrayList<String> umealName;
    static ArrayList<String>  umealType;
    static ArrayList<String>  ucalories;
    static ArrayList<String>  uprotein;
    static ArrayList<String>  ucarbs;
    static ArrayList<String>  ufats;
    LayoutInflater layoutInflater;

    public MyAdapter2(Context context, ArrayList<String>  umealName, ArrayList<String>  umealType, ArrayList<String>  ucalories, ArrayList<String>  uprotein, ArrayList<String>  ucarbs, ArrayList<String>  ufats){
        this.context = context;
        this.umealName = umealName;
        this.umealType = umealType;
        this.ucalories = ucalories;
        this.uprotein = uprotein;
        this.ucarbs = ucarbs;
        this.ufats = ufats;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.calorie_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mealNames.setText(String.valueOf(umealName.get(position)));
        holder.mealTypes.setText(String.valueOf(umealType.get(position)));
        holder.caloriess.setText(String.valueOf(ucalories.get(position)));
        holder.proteins.setText(String.valueOf(uprotein.get(position)));
        holder.carbss.setText(String.valueOf(ucarbs.get(position)));
        holder.fatss.setText(String.valueOf(ufats.get(position)));
    }

    @Override
    public int getItemCount() {
        return umealName.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mealNames, mealTypes, caloriess, proteins, carbss, fatss;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mealNames = itemView.findViewById(R.id.mealtype_tv);
            mealTypes = itemView.findViewById(R.id.mealname_tv);
            caloriess = itemView.findViewById(R.id.calories_tv);
            proteins = itemView.findViewById(R.id.protein_tv);
            carbss = itemView.findViewById(R.id.carbs_tv);
            fatss = itemView.findViewById(R.id.fats_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Edit_meal.class);
                    intent.putExtra("mealnames", umealName.get(getAdapterPosition()));
                    intent.putExtra("mealtypes", umealType.get(getAdapterPosition()));
                    intent.putExtra("caloriess", ucalories.get(getAdapterPosition()));
                    intent.putExtra("proteins", uprotein. get(getAdapterPosition()));
                    intent.putExtra("carbss", ucarbs.get(getAdapterPosition()));
                    intent.putExtra("fatss", ufats.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
