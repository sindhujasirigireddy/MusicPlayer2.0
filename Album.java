package com.sindhujasirigireddy.musicplayer20;

import java.util.ArrayList;

/**
 * Created by sindhuja.sirigireddy on 4/13/2016.
 */
public class Album {
    String Name;
    int No_Of_Songs;
    ArrayList<Song> albumSongs=new ArrayList<Song>();
    Album()
    {

    }

    public int getNo_Of_Songs() {
        return No_Of_Songs;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNo_Of_Songs(int no_Of_Songs) {
        No_Of_Songs = no_Of_Songs;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(ArrayList<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }
}
