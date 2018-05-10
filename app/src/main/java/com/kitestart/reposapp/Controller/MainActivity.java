package com.kitestart.reposapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitestart.reposapp.Model.Repos;
import com.kitestart.reposapp.R;
import com.kitestart.reposapp.View.ReposAdapter;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView reposList;
    ArrayList<Repos> allRepos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reposList = findViewById(R.id.reposList);

        getAllRepos();

        ReposAdapter adapter = new ReposAdapter(this, allRepos);
        reposList.setAdapter(adapter);

    }


    void getAllRepos(){


        Repos repo1 = new Repos("PokemonApp","Cool app oweuhdwn", "http://pokemon.com");
        Repos repo2 = new Repos("NarutoApp","Cool naruto app oweuhdwn", "http://pokemon.com");
        Repos repo3 = new Repos("MarioApp","Cool app mario oweuhdwn", "http://pokemon.com");

        allRepos.add(repo1);
        allRepos.add(repo2);
        allRepos.add(repo3);



    }

}
