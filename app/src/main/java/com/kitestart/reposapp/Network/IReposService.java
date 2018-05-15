package com.kitestart.reposapp.Network;


import com.kitestart.reposapp.Model.Repos;
import com.kitestart.reposapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IReposService {


    @GET("/repositories?since=364")
    Call<List<Repos>> listRepos();




}
