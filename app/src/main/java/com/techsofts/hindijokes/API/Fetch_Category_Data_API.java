package com.techsofts.hindijokes.API;

import com.techsofts.hindijokes.Model.Model_category_view;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Fetch_Category_Data_API
{

  @POST("fetch_category_data.php")
  @FormUrlEncoded
  Call<List<Model_category_view>> getData(@Field("category") String category);


}
