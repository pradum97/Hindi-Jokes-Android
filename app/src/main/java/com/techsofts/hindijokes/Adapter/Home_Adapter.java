package com.techsofts.hindijokes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.R;

import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.myviewholder> {

    List<Model> data;

    public Home_Adapter(List<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_design,null);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myviewholder holder, int position) {

        int id = data.get(position).getID();
        String title = data.get(position).getTITLE();

        holder.textView.setText(""+id+"   "+title);
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
