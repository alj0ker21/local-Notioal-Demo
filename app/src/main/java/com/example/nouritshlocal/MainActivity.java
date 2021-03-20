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
    private ArrayList<Community> list = new ArrayList<>();


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText =  findViewById(R.id.nameEditText);

        // one of the big mistake in your code that's u use Recycler view type and assigned to TextView time :(
        RecyclerView typesListView = findViewById(R.id.typesListView);
        typesListView.setHasFixedSize(true);
        typesListView.setLayoutManager(new LinearLayoutManager(this));
        // -------------------------------------------------------------------------- //

        // You don't need to use variable to store any object you can pass it directly
        list.add(new Community(getString(R.string.eat)
                ,R.drawable.eat,getString(R.string.eat_description)));
        list.add(new Community(getString(R.string.cook)
                ,R.drawable.cook, getString(R.string.cook_description)));
        list.add(new Community(getString(R.string.grow)
                ,R.drawable.grow,getString(R.string.grow_description)));
        list.add(new Community(getString(R.string.Shop)
                ,R.drawable.shop,getString(R.string.shop_description)));
        list.add(new Community(getString(R.string.make)
                ,R.drawable.make,getString(R.string.make_description)));
        // -------------------------------------------------------------------------- //

        CommunityRecyclerViewAdapter communityRecyclerViewAdapter = new CommunityRecyclerViewAdapter(list, this);
        typesListView.setAdapter(communityRecyclerViewAdapter);
    }
    /** ------------------------------------------------------------------------------------------ */
    public void openDetails(Community community){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.frind_name_kay), nameEditText.getText().toString());
        intent.putExtra(getString(R.string.community_kay), community);
        startActivity(intent);
    }
    /** ------------------------------------------------------------------------------------------ */

}
