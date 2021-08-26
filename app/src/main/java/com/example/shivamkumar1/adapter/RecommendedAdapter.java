package com.example.shivamkumar1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivamkumar1.R;
import com.example.shivamkumar1.model.AllEvent;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder> {

    private List<AllEvent> allEvent;
    private int rowLayout;
    private Context context;


    public static class RecommendedViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView eventName;
        ImageView profile_image;
        TextView ticket;
        TextView friends;
        TextView price;
        CardView profile_image_view;


        public RecommendedViewHolder(View v) {
            super(v);


            date = (TextView) v.findViewById(R.id.date);
            eventName = (TextView) v.findViewById(R.id.eventName);
            profile_image = (ImageView) v.findViewById(R.id.profile_image);
            ticket = (TextView) v.findViewById(R.id.ticket);
            friends = (TextView) v.findViewById(R.id.friends);
            price = (TextView) v.findViewById(R.id.price);
            profile_image_view = (CardView) v.findViewById(R.id.profile_image_view);
        }
    }

    public RecommendedAdapter(List<AllEvent> allEvent, int rowLayout, Context context) {
        this.allEvent = allEvent;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecommendedViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new RecommendedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecommendedViewHolder holder, final int position) {


            Picasso.get().load(allEvent.get(position).getMainImage()).into(holder.profile_image);
            holder.date.setText(allEvent.get(position).getDateTime());
            holder.eventName.setText(allEvent.get(position).getName());
            holder.ticket.setText(allEvent.get(position).getTicketsSold() + "/" + allEvent.get(position).getMaxTickets());
            holder.friends.setText("+" + String.valueOf(allEvent.get(position).getFriendsAttending()) + " friends");
            holder.price.setText("£" + (int) allEvent.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return allEvent.size();
    }
}