package com.sindhujasirigireddy.musicplayer20;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sindhuja.sirigireddy on 4/13/2016.
 */
public class AlbumAdaptor extends ArrayAdapter<Album> {
    private Activity context;
    private List<Album> albumList;

   public AlbumAdaptor(Activity context, List<Album> albumlist)
{
    super(context,0,albumlist);
    this.context=context;
    this.albumList=albumlist;
}

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Album album = albumList.get(position);
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_each_album, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.album_nameTV);
        TextView SongsCount = (TextView) rowView.findViewById(R.id.No_Of_SongsTV);
        if(album != null) {
            txtTitle.setText(album.getName());
            SongsCount.setText("songs:"+""+album.getNo_Of_Songs()+"");
        }
        return rowView;
    }
}
