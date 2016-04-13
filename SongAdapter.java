package com.sindhujasirigireddy.musicplayer20;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sindhuja.sirigireddy on 4/13/2016.
 */
public class SongAdapter extends ArrayAdapter<Song>  {
    private Activity context;
    private ArrayList<Song> input;
    public SongAdapter(Activity context, ArrayList<Song> songslist)
    {
        super(context,0,songslist);
        this.context=context;
        this.input=songslist;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final Song song = input.get(position);
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_each_song, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.songNameTV);
        TextView artists = (TextView) rowView.findViewById(R.id.artists);
        TextView duration = (TextView) rowView.findViewById(R.id.Duration);

        if(song != null) {
            txtTitle.setText(song.getName());
            artists.setText(song.getArtist());
            duration.setText(song.getDuration());
        }

       /* final ImageButton playButton=(ImageButton)rowView.findViewById(R.id.playIB);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!song.getIsPlaying()) {
                    Toast.makeText(getContext(), song.getSongName() + " is playing", Toast.LENGTH_SHORT).show();
                    playButton.setImageResource(R.mipmap.pause);
                    song.setIsPlaying(true);
                }
                else
                {
                    playButton.setImageResource(R.mipmap.play);
                    song.setIsPlaying(false);
                }
            }

        });
        final ImageButton favButton=(ImageButton)rowView.findViewById(R.id.AddToFavIB);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!song.getIsAddedToFav()) {
                    Toast.makeText(getContext(), song.getSongName() + " is added to favourites", Toast.LENGTH_SHORT).show();
                    favButton.setImageResource(R.mipmap.like_filled);
                    song.setIsAddedToFav(true);
                }
                else {
                    Toast.makeText(getContext(), song.getSongName() + " is removed from favourites", Toast.LENGTH_SHORT).show();
                    favButton.setImageResource(R.mipmap.like);
                    song.setIsAddedToFav(false);
                }
            }
        });*/
        return rowView;
    }
}
