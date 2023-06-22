package com.techsofts.hindijokes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsofts.hindijokes.Activity.Category_data_Activity;
import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.R;

import java.util.List;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.myviewholder> {

    List<Model> data;
    Context ctx;

    public Category_Adapter(List<Model> data, Context ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_category,null);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myviewholder holder, int position) {

        int id = data.get(position).getID();
        String title = data.get(position).getTITLE();

        holder.textView.setText(title);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.getContext().startActivity(new Intent(v.getContext(), Category_data_Activity.class)
                .putExtra("name",title));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView textView;

        public myviewholder(@NonNull  View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
