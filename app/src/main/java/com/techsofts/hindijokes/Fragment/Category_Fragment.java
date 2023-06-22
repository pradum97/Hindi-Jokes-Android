package com.techsofts.hindijokes.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.techsofts.hindijokes.API.Fetch_Category_API;
import com.techsofts.hindijokes.Adapter.Category_Adapter;
import com.techsofts.hindijokes.Adapter.Home_Adapter;
import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Category_Fragment extends Fragment {
    View view ;
    RecyclerView recyclerView;
    String url="https://android.api.techsofts.in/Jokes_App/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_category, container, false);

        recyclerView =view. findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Fetch_Category_API api=retrofit.create(Fetch_Category_API.class);

        Call<List<Model>> call=api.getmodels();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data=response.body();

                Category_Adapter adapter = new Category_Adapter(data,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Model>> call, @NonNull Throwable t) {

                Toast.makeText(getActivity(), "error "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}