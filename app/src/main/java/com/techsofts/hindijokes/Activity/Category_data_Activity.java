package com.techsofts.hindijokes.Activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techsofts.hindijokes.Adapter.Category_Data_Adapter;
import com.techsofts.hindijokes.Adapter.Home_Adapter;
import com.techsofts.hindijokes.Controller;
import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.Model.Model_category_view;
import com.techsofts.hindijokes.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Category_data_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_data);
        tv = findViewById(R.id.tv);

        String name = getIntent().getStringExtra("name");

        recyclerView = findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);

        processlogin(name.replaceAll(" ", ""));
    }
    private void processlogin(String name) {

        Call<List<Model_category_view>> call = Controller
                .getInstance()
                .getapi()
                .getData(name);

        call.enqueue(new Callback<List<Model_category_view>>() {
            @Override
            public void onResponse(Call<List<Model_category_view>> call, Response<List<Model_category_view>> response) {

                try {

                    List<Model_category_view> data = response.body();
                    Category_Data_Adapter adapter = new Category_Data_Adapter(data, Category_data_Activity.this);
                    recyclerView.setAdapter(adapter);

                } catch (Exception e) {
                    Toast.makeText(Category_data_Activity.this, "Error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onFailure(Call<List<Model_category_view>> call, Throwable t) {

                Toast.makeText(Category_data_Activity.this, "error! " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}