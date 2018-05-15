package com.kitestart.reposapp.Network;

import com.kitestart.reposapp.Model.Repos;
import com.kitestart.reposapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposService{

    IReposService service;





    public ReposService(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(IReposService.class);

        Call<List<Repos>> allRepos = service.listRepos();

        allRepos.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                if(response.isSuccessful()){


                    //response.body();


                }
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {

            }
        });

    }



}
