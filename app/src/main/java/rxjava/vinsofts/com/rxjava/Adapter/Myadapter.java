package rxjava.vinsofts.com.rxjava.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import rxjava.vinsofts.com.rxjava.R;
import rxjava.vinsofts.com.rxjava.model.Collection;
import rxjava.vinsofts.com.rxjava.model.Track;


public class Myadapter extends RecyclerView.Adapter<Myadapter.MyHolder> {
    private Context context;
    private List<Collection> songList;


    public Myadapter(Context context, List<Collection> songList) {
        this.context = context;
        this.songList = songList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Collection collection = songList.get(i);
        myHolder.tv_score.setText(String.valueOf(collection.getScore()));
        Track track = collection.getTrack();
        Glide.with(context).load(track.getArtworkUrl()).into(myHolder.iv_item);
    }

    @Override
    public int getItemCount() {
        if (songList == null) {
            return 0;
        }
        return songList.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_score;
        ImageView iv_item;
        MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_score = itemView.findViewById(R.id.tv_score);
            iv_item = itemView.findViewById(R.id.iv_item);
        }
    }
}
