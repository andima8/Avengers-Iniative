package com.example.avengersinitiative;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.avengersinitiative.List.Avengers;
import com.example.avengersinitiative.List.DataAvengers;
import com.example.avengersinitiative.List.ListAvengersAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvAvengers;
    private ArrayList<Avengers> list = new ArrayList<>();
    public static final String name = "name";
    public static final String bio = "bio";
    public static final String photo = "photo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rvAvengers = findViewById(R.id.rv_avengers);
        rvAvengers.setHasFixedSize(true);
        list.addAll(DataAvengers.getListData());
        showRecyclerList();

    }

    private void setSupportActionBar(Toolbar toolBarAtas2) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {
        //int setMode = menu.getItemId();
        setMode(menu.getItemId());
        return super.onOptionsItemSelected(menu);
    }
    private void showRecyclerList() {
        rvAvengers.setLayoutManager(new LinearLayoutManager(this));
        final ListAvengersAdapter listAvengersAdapter = new ListAvengersAdapter(list);
        rvAvengers.setAdapter(listAvengersAdapter);
        listAvengersAdapter.setOnItemClickCallback(new ListAvengersAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Avengers data) {
                showSelectedHero(data);
            }
        });
    }


    private void setMode (int selectedMode){
        if (selectedMode == R.id.about) {
            // do something here
            Intent a = new Intent(this, AboutActivity.class);
            startActivity(a);
        }
    }

    private void showSelectedHero(Avengers hero) {
        Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
          Intent i = new Intent(MainActivity.this, DetailActivity.class);
          i.putExtra(DetailActivity.extra_supername, hero.getName());
          i.putExtra(DetailActivity.extra_bio, hero.getBio());
          i.putExtra(DetailActivity.extra_realname, hero.getRealname());
          i.putExtra(DetailActivity.extra_photo, hero.getPhoto());
          startActivity(i);
    }
}
