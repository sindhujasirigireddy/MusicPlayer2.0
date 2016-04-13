package com.sindhujasirigireddy.musicplayer20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by sindhuja.sirigireddy on 4/13/2016.
 */
public class SongActivity extends AppCompatActivity {
    ListView SongListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        Album album= Util.album;
        SongAdapter songAdapter=new SongAdapter(SongActivity.this,album.getAlbumSongs());
        setTitle(album.getName());

        SongListView=(ListView) findViewById(R.id.SongLV);
        SongListView.setAdapter(songAdapter);
    }
}
