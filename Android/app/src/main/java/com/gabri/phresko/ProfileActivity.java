package com.gabri.phresko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.gabri.phresko.activity.ImageViewActivity;
import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    ListView favorites_listview;
    ImageButton home_imagebutton;
    FavAdapter adapter;
    List<Favorites> favelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        home_imagebutton=(ImageButton)findViewById(R.id.home_imageButton);
        home_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        favorites_listview=(ListView)findViewById(R.id.favorite_listview);
        load_fave();
        favorites_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.setToPrefString(Constants.KEY_TAG,favelist.get(position).getTagname(),ProfileActivity.this);
                Intent intent=new Intent(ProfileActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void load_fave(){


        favelist=new ArrayList<Favorites>();


        Favorites favorites=new Favorites();
        favorites.setTagname("SPORTS");
        favelist.add(favorites);
        Favorites favorites1=new Favorites();
        favorites1.setTagname("POLITICS");
        favelist.add(favorites1);
        Favorites favorites2=new Favorites();
        favorites2.setTagname("SAVAGERY");
        favelist.add(favorites2);



        adapter = new FavAdapter(this, favelist);
        favorites_listview.setAdapter(adapter);



    }
}
