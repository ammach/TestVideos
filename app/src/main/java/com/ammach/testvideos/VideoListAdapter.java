package com.ammach.testvideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by ammach on 8/31/2016.
 */
public class VideoListAdapter extends BaseAdapter{



    String[] videoUrls   = {"http://clips.vorwaerts-gmbh.de/VfE_html5.mp4","http://cp.dmbshare.net:8000/live/paul/paul/7305.ts"};
    String[] videoThumbs = {"http://www.therealmadridfan.com/wp-content/uploads/madridista.jpg","http://www.marruecosprofundo.com/images/sl7.jpg"};
    String[] videoTitles = {"hala madrid", "viva maruecos"};

    Context context;

    public VideoListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return videoThumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.item_videoview, null);
            JCVideoPlayerStandard  jcVideoPlayer = (JCVideoPlayerStandard) convertView.findViewById(R.id.videoplayer);



        boolean setUp = jcVideoPlayer.setUp(videoUrls[position], JCVideoPlayer.SCREEN_LAYOUT_LIST,videoTitles[position]);
        if (setUp) {
            Picasso.with(context).load(videoThumbs[position]).into(jcVideoPlayer.thumbImageView);
        }
        return convertView;
    }


}
