package ga.astech.mbaya.adapter;

/**
 * Created by julian on 6/8/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ga.astech.mbaya.R;
import ga.astech.mbaya.fragments.DetailsItem;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private ArrayList<DetailsItem> details;

    public MyAdapter(ArrayList<DetailsItem> items) {
        details = items;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public Holder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(  R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final  DetailsItem fp = details.get(position);
        holder.textView.setText(fp.getTextView());
        holder.imageView.setImageResource(fp.getImageView());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}