package com.kitestart.reposapp.Controller;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kitestart.reposapp.Model.Repos;
import com.kitestart.reposapp.Network.IReposService;
import com.kitestart.reposapp.Network.ReposService;
import com.kitestart.reposapp.R;
import com.kitestart.reposapp.View.ReposAdapter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView reposList;
    static ArrayList<Repos> allRepos = new ArrayList();
    ReposAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reposList = findViewById(R.id.reposList);

        getAllRepos();


        reposList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(MainActivity.allRepos.get(position).getHtml_url()));
                startActivity(browserIntent);

            }
        });



    }
    void getAllRepos(){


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IReposService service = retrofit.create(IReposService.class);

        Call<List<Repos>> allRepos = service.listRepos();

        allRepos.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                if(response.isSuccessful()){

                    MainActivity.allRepos = (ArrayList<Repos>) response.body();

                    System.out.println(MainActivity.allRepos.get(0).getName());

                    adapter = new ReposAdapter(getApplicationContext(), MainActivity.allRepos);
                    adapter.notifyDataSetChanged();
                    reposList.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {

            }
        });




    }

}


