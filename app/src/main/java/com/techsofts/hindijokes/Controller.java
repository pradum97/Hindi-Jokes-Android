package com.techsofts.hindijokes;

import com.techsofts.hindijokes.API.Fetch_Category_Data_API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller
{
   private static final String url="https://android.api.techsofts.in/Jokes_App/";
   private static Controller clienobject;
   private static Retrofit retrofit;

     Controller()
     {
         retrofit=new Retrofit.Builder()
                      .baseUrl(url)
                      .addConverterFactory(GsonConverterFactory.create())
                      .build();
     }

     public static synchronized Controller getInstance()
     {
          if(clienobject==null)
              clienobject=new Controller();
          return  clienobject;
     }

     public Fetch_Category_Data_API getapi()
     {
         return retrofit.create(Fetch_Category_Data_API.class);
     }
}
