package com.kitestart.reposapp.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.kitestart.reposapp.Model.Repos;
import com.kitestart.reposapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ReposAdapter extends ArrayAdapter<Repos> {


    Context context;
    ArrayList<Repos> allRepos;

    public ReposAdapter(Context context, ArrayList<Repos> allRepos) {

        super(context, 0, allRepos);

        this.context = context;
        this.allRepos = allRepos;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View itemView = convertView;

        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.repos_item, parent, false);
        }


        Repos repo = allRepos.get(position);

        TextView name = itemView.findViewById(R.id.nameTxt);
        TextView desc = itemView.findViewById(R.id.descTxt);

        name.setText(repo.getName());
        desc.setText(repo.getDescription());


        return itemView;
    }
}
