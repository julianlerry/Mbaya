package ga.astech.mbaya.adapter;

/**
 * Created by julian on 6/8/17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ga.astech.mbaya.R;
import ga.astech.mbaya.activities.DetailsActivity;
import ga.astech.mbaya.fragments.DetailsItem;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private ArrayList<DetailsItem> details;
    Context ctx;

    public MyAdapter(ArrayList<DetailsItem> items, Context ctx) {
        details = items;
        this.ctx = ctx;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new Holder(view, ctx, details);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final  DetailsItem fp = details.get(position);
        holder.imageView.setImageResource(fp.getImageView());
        holder.textView.setText(fp.getTextView());
        holder.costView.setText(fp.getCostView());
        holder.descripView.setText(fp.getDescriptionView());
        holder.cityView.setText(fp.getCityView());
        holder.dateView.setText(fp.getDateView());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }


    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public TextView costView;
        public TextView descripView;
        public TextView cityView;
        public TextView dateView;

        ArrayList<DetailsItem> details = new ArrayList<DetailsItem>();
        Context ctx;

        public Holder(View itemView, Context ctx, ArrayList<DetailsItem> details) {
            super(itemView);
            this.details = details;
            this.ctx = ctx;

            itemView.setOnClickListener(this);
            imageView = (ImageView) itemView.findViewById(  R.id.imageView);
            textView = (TextView) itemView.findViewById( R.id.textView);
            costView = (TextView) itemView.findViewById( R.id.costView);
            descripView = (TextView) itemView.findViewById( R.id.descriptionView);
            cityView = (TextView) itemView.findViewById( R.id.cityView);
            dateView = (TextView) itemView.findViewById( R.id.dateView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            DetailsItem detailsItem = this.details.get(position);
            Intent intent = new Intent(this.ctx, DetailsActivity.class);
            intent.putExtra(" imageView", detailsItem.getImageView());
            intent.putExtra(" textView", detailsItem.getTextView());
            intent.putExtra(" costView", detailsItem.getCostView());
            intent.putExtra(" descriptionView", detailsItem.getDescriptionView());
            intent.putExtra(" cityView", detailsItem.getCityView());
            intent.putExtra(" dateView", detailsItem.getDateView());
            this.ctx.startActivity(intent);

        }
    }
}