package com.sindhujasirigireddy.musicplayer20;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    static ArrayList<Song> songList;
    static ArrayList<Album> albumList=new ArrayList<Album>();
    static ListView albumListView;
   /* static ArrayList<Album> albumList;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

       /*albumList=ListOfAlbums();*/

        ArrayList<Song> songsFile = new ArrayList<Song>();
        File[] files = Environment.getExternalStorageDirectory().listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                songsFile.addAll(findSongs(singleFile));
            } else {
                if (singleFile.getName().endsWith(".mp3")) {
                    Song song = new Song();
                    MediaMetadataRetriever m = new MediaMetadataRetriever();
                    m.setDataSource(singleFile.getPath());
                    song.setArtist(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
                    song.setName(singleFile.getName());
                    song.setAlbum(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
                    song.setId(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS));
                    song.setDuration(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
                    song.setPath(singleFile.getPath());
                    songsFile.add(song);
                }
            }
        }

        Album album;
        ArrayList<String> albumNames=new ArrayList<String>();
        for (int i = 0; i < songsFile.size(); i++) {
           if (songsFile.get(i).getAlbum()!=null&&songsFile.get(i).getAlbum().length()>0) {

                album = new Album();
                album.setName(songsFile.get(i).getAlbum());
                int count = 0;
                for (Song s : songsFile) {
                    if(s.getAlbum()!=null&&s.getAlbum().length()>0)
                    {
                        if (s.getAlbum().hashCode() == songsFile.get(i).getAlbum().hashCode()) {
                            album.getAlbumSongs().add(s);
                            album.setNo_Of_Songs(album.getNo_Of_Songs() + 1);
                            count++;
                        }
                    }
                }
                album.setNo_Of_Songs(count);

                if (!albumNames.contains(album.getName())) {
                    albumNames.add(album.getName());
                    albumList.add(album);
                }
            }
        }

        AlbumAdaptor albumAdapter = new AlbumAdaptor(AlbumActivity.this, albumList);

        albumListView = (ListView) findViewById(R.id.AlbumLV);
        albumListView.setAdapter(albumAdapter);
        albumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedAlbum = albumList.get(position).getName();
                Util.album = albumList.get(position);
                Toast.makeText(getApplicationContext(), selectedAlbum + " " + "selected.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SongActivity.class);
                startActivity(intent);
            }
        });
    }


   /* private static ArrayList<Album> ListOfAlbums() {
        songList = findSongs(Environment.getExternalStorageDirectory());
        Album album;
        for (int i = 0; i < songList.size(); i++) {

            MediaMetadataRetriever m = new MediaMetadataRetriever();
            if (!albumNames.contains(songList.get(i).getAlbum())) {
                int n = Integer.parseInt(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS));
                album = new Album();
                album.setName(songList.get(i).getName());
                album.setNo_Of_Songs(n);
                albumNames.add(album);
            }
        }
        return albumNames;
    }*/

    private static ArrayList<Song> findSongs(File root)
    {
        ArrayList<Song> songsFile = new ArrayList<Song>();
        File[] files = root.listFiles();
        for (File singleFile : files)
        {
            if (singleFile.isDirectory() && !singleFile.isHidden())
            {
                songsFile.addAll(findSongs(singleFile));
            } else {
                if (singleFile.getName().endsWith(".mp3"))
                {
                    Song song=new Song();
                    MediaMetadataRetriever m = new MediaMetadataRetriever();
                    m.setDataSource(singleFile.getPath());
                    song.setArtist(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
                    song.setName(singleFile.getName());
                    song.setAlbum(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
                    song.setId(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS));
                    song.setDuration(m.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
                    song.setPath(singleFile.getPath());
                    songsFile.add(song);
                }
            }
        }
        return songsFile;
    }
}
