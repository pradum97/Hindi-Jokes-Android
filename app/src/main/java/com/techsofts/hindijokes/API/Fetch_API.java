package com.techsofts.hindijokes.API;

import com.techsofts.hindijokes.Model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Fetch_API
{
  @GET("get_Details.php")
  Call<List<Model>> getmodels();
}
