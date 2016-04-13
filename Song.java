package com.sindhujasirigireddy.musicplayer20;

/**
 * Created by sindhuja.sirigireddy on 4/12/2016.
 */
public class Song {
    private String id;
    private String name;
    private String artist,album,path;
    String duration;

    public Song(String songID, String songTitle, String songArtist) {
        id=songID;
        name =songTitle;
        artist=songArtist;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDuration() {
       int convDuration=Integer.parseInt(duration)/1000;

       /*  String time=(convDuration/60000)+":"+String.valueOf(convDuration%60000).substring(0,2);
        return time;*/
        long s = convDuration % 60;
        long m = (convDuration / 60) % 60;
        long h = (convDuration / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Song(){

    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }


}
