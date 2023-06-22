package com.techsofts.hindijokes.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsofts.hindijokes.Activity.Category_data_Activity;
import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.Model.Model_category_view;
import com.techsofts.hindijokes.R;

import java.util.List;

public class Category_Data_Adapter extends RecyclerView.Adapter<Category_Data_Adapter.myviewholder> {

            List<Model_category_view> data;
            Context ctx;

    public Category_Data_Adapter(List<Model_category_view> data, Context ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_category_data,null);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myviewholder holder, int position) {
        StringBuffer stringBuffer = new StringBuffer();

        int id = data.get(position).getID();
        String title = data.get(position).getTITLE();

        int length = title.length();
        int given_lenght = 200;

        if (length > given_lenght){
            String str = title.substring(0,given_lenght).concat(". . .");

            String text = "<font color=#000>"+str+"</font> <font color=#B22222>Click Here To See More</font>";

            holder.textView.setText(Html.fromHtml(text));

        }else {

            holder.textView.setText(title);
        }



        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* v.getContext().startActivity(new Intent(v.getContext(), Category_data_Activity.class)
                .putExtra("name",title));*/
            }
        });
    }

    @Override
    public int getItemCount() {
        
        int size = 0;
        try {
            size = data.size();
        }catch (Exception e){

            System.out.println("Size error : "+e.getMessage());
        }
        
        return size;
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView textView;

        public myviewholder(@NonNull  View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
        }
    }
}
