package com.example.avengersinitiative;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {

    public static String extra_supername = "name";
    public static String extra_bio = "bio";
    public static String extra_photo = "photo";
    public static String extra_realname = "realname";
    private  TextView nama;
    private  TextView bio2;
    private  ImageView photo2;
    private  TextView realnama;
    private Context context = DetailActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String name = getIntent().getStringExtra(extra_supername);
        String bio = getIntent().getStringExtra(extra_bio);
        String realname = getIntent().getStringExtra(extra_realname);
        String photo = getIntent().getStringExtra(extra_photo);

        nama = (TextView) findViewById(R.id.super_name);
        nama.setText(name);
        bio2 = (TextView) findViewById(R.id.bio);
        bio2.setText(bio);
        realnama = (TextView) findViewById(R.id.real_name);
        realnama.setText(realname);
        photo2 = (ImageView) findViewById(R.id.photo);
        Glide.with(context).load(getIntent().getStringExtra("photo"))
                .into(photo2);

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}


