package com.example.nouritshlocal;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nouritshlocal.model.Community;

public class DetailsActivity extends AppCompatActivity {

    private String friendName;
    private Community community;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        // ---------------------------------------------------------------------------------------------------------------------------- //
        // declare variable in local you don't need to declare it as global member while you use it in same function which [ onCreate ]
        ImageView typeImageView = findViewById(R.id.type_image_view);
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descTextView);
        Button shareButton = findViewById(R.id.shareButton);
        // ---------------------------------------------------------------------------------------------------------------------------- //
        // don't use spaces in key when you passed params throw intents
        friendName = getIntent().getStringExtra(getString(R.string.frind_name_kay));
        community = (Community) getIntent().getSerializableExtra(getString(R.string.community_kay));
        typeImageView.setImageResource(community.getImageReference());

        titleTextView.setText(community.getName());
        descriptionTextView.setText(community.getDescription());

        shareButton.setText(String.format("%s %s", getString(R.string.share_with), friendName));

        // ---------------------------------------------------------------------------------------------------------------------------- //
        shareButton.setOnClickListener(view -> {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");

            String msg = String.format("%s: %s", friendName, community.getDescription());
            shareIntent.putExtra(Intent.EXTRA_TEXT, msg);

            startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
        });
        // ---------------------------------------------------------------------------------------------------------------------------- //

    }


}
