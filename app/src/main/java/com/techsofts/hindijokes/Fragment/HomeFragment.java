package com.techsofts.hindijokes.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techsofts.hindijokes.API.Fetch_API;
import com.techsofts.hindijokes.Adapter.Home_Adapter;
import com.techsofts.hindijokes.Model.Model;
import com.techsofts.hindijokes.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    String url="https://android.api.techsofts.in/Jokes_App/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView =view. findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Fetch_API api=retrofit.create(Fetch_API.class);

        Call<List<Model>> call=api.getmodels();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                List<Model> data=response.body();

                Home_Adapter adapter = new Home_Adapter(data);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

        return view;
    }
}