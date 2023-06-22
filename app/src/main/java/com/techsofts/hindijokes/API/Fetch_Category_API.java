package com.techsofts.hindijokes.API;

import com.techsofts.hindijokes.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Fetch_Category_API
{
  @GET("fetch_Category.php")
  Call<List<Model>> getmodels();
}
