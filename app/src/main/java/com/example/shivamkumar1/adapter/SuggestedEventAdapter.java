package com.example.shivamkumar1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivamkumar1.R;
import com.example.shivamkumar1.activity.SecondActivity;
import com.example.shivamkumar1.activity.ThirdActivity;
import com.example.shivamkumar1.model.AllEvent;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;


public class SuggestedEventAdapter extends RecyclerView.Adapter<SuggestedEventAdapter.SuggestedEventViewHolder> {

    String ViewType;
    private OnClickListener clickListener;
    private List<AllEvent> allEvent;
    private int rowLayout;
    private Context context;
    private String spotrs;


    public static class SuggestedEventViewHolder extends RecyclerView.ViewHolder {

        TextView add_event;
        ImageView img;
        TextView isparented;
        TextView sports;
        TextView eventName;
        TextView date;
        TextView price;
        TextView totalprize;
        ImageView like;
        TextView timeleft;
        TextView ticketsold_maxticket;
        TextView location;
        CardView cardView;


        public SuggestedEventViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);




            add_event = (TextView) v.findViewById(R.id.add_event);
            img = (ImageView) v.findViewById(R.id.img);
            isparented = (TextView) v.findViewById(R.id.isparented);
            sports  = (TextView) v.findViewById(R.id.sports);
            eventName = (TextView) v.findViewById(R.id.eventName);
            date = (TextView) v.findViewById(R.id.date);
            price = (TextView) v.findViewById(R.id.price);
            totalprize = (TextView) v.findViewById(R.id.totalprize);
            like  = (ImageView) v.findViewById(R.id.like);
            timeleft = (TextView) v.findViewById(R.id.timeleft);
            ticketsold_maxticket = (TextView) v.findViewById(R.id.ticketsold_maxticket);
            location = (TextView) v.findViewById(R.id.location);
            cardView = (CardView) v.findViewById(R.id.cardView);
        }
    }

    public SuggestedEventAdapter(ThirdActivity thirdActivity, List<AllEvent> allEvent, int rowLayout, Context context,String spotrs) {
        this.allEvent = allEvent;
        this.rowLayout = rowLayout;
        this.context = context;
        this.spotrs = spotrs;
    }

    @Override
    public SuggestedEventAdapter.SuggestedEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SuggestedEventAdapter.SuggestedEventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SuggestedEventAdapter.SuggestedEventViewHolder holder, @SuppressLint("RecyclerView") final int position) {


            Picasso.get().load(allEvent.get(position).getMainImage()).into(holder.img);
            if (allEvent.get(position).isIsPartnered()) {
                holder.isparented.setText("Partnered");
            } else {
                holder.isparented.setText("Not Partnered");
            }

            holder.sports.setText(allEvent.get(position).getSport());
            holder.eventName.setText(allEvent.get(position).getName());
            holder.date.setText(allEvent.get(position).getDateTime());
            holder.price.setText("£" + (int) allEvent.get(position).getPrice());
            holder.totalprize.setText(" Total Prize:" + String.valueOf(allEvent.get(position).getTotalPrize()));
            holder.timeleft.setText(" Time left to book:" + allEvent.get(position).getPrice());

            SpannableString content = new SpannableString(" " + allEvent.get(position).getTicketsSold() + "/" + allEvent.get(position).getMaxTickets() + " attending total");
            content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
            holder.ticketsold_maxticket.setText(content);

            holder.location.setText(" " + allEvent.get(position).getLocation());

            holder.add_event.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return allEvent.size();
    }

    public void setViewType(String viewType) {
        ViewType = viewType;
    }



    public interface OnClickListener {
        /**
         * On item click.
         *
         * @param position the position
         */
        void onItemClick(View v,int position);
    }

    public OnClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
