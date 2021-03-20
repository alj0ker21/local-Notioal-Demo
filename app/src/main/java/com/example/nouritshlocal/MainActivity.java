package com.example.nouritshlocal;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nouritshlocal.adapter.CommunityRecyclerViewAdapter;
import com.example.nouritshlocal.model.Community;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView typesListView;
    private CommunityRecyclerViewAdapter communityRecyclerViewAdapter;
    private ArrayList<Community> list = new ArrayList<>();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText =  findViewById(R.id.nameEditText);

        typesListView = findViewById(R.id.titleTextView);
        typesListView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        typesListView.setLayoutManager(linearLayoutManager);


        Community community1 = new Community(getString(R.string.eat)
                ,R.drawable.eat,getString(R.string.eat_description));
        Community community2 = new Community(getString(R.string.cook)
                ,R.drawable.cook, getString(R.string.cook_description));
        Community community3 = new Community(getString(R.string.grow)
                ,R.drawable.grow,getString(R.string.grow_description));
        Community community4 = new Community(getString(R.string.Shop)
                ,R.drawable.shop,getString(R.string.shop_description));
        Community community5 = new Community(getString(R.string.make)
                ,R.drawable.make,getString(R.string.make_description));

        list.add(community1);
        list.add(community2);
        list.add(community3);
        list.add(community4);
        list.add(community5);

        communityRecyclerViewAdapter = new CommunityRecyclerViewAdapter(list, this);
        typesListView.setAdapter(communityRecyclerViewAdapter);
    } // onCreate

    public void openDetails(Community community){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.frind_name_kay), nameEditText.getText().toString());
        intent.putExtra(getString(R.string.community_kay), community);
        startActivity(intent);
    } // openDetails
}
