package com.example.shivamkumar1.activity;


import static android.view.MotionEvent.ACTION_SCROLL;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivamkumar1.R;
import com.example.shivamkumar1.adapter.AllEventAdapter;
import com.example.shivamkumar1.adapter.RecommendedAdapter;
import com.example.shivamkumar1.model.AllEvent;
import com.example.shivamkumar1.model.EventDetail;
import com.example.shivamkumar1.model.Example;
import com.example.shivamkumar1.rest.ApiClient;
import com.example.shivamkumar1.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity implements AllEventAdapter.OnClickListener {

    private static final String TAG = SecondActivity.class.getSimpleName();


    boolean chk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysecond_event);
        ButterKnife.bind(this);

        DeviceUtil.showLoading("Loading...",SecondActivity.this);


        final RecyclerView recyclerViewAllEvent = (RecyclerView) findViewById(R.id.AllEvent);
        LinearLayoutManager HorizontalLayout2 = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewAllEvent.setLayoutManager(HorizontalLayout2);






         chk = DeviceUtil.isNetworkAvailable(SecondActivity.this, null);
        if(chk){

                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

                Call<Example> call = apiService.getallEvents();
                call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        int statusCode = response.code();
                        if(statusCode==200) {
                          //  Toast.makeText(SecondActivity.this,"Status:"+ statusCode + "Success",Toast.LENGTH_SHORT).show();
                            List<AllEvent> allEvent = response.body().getAllEvents();

                            setDataToRecommendedViw(allEvent);
                             recyclerViewAllEvent.setAdapter(new AllEventAdapter(SecondActivity.this,allEvent, R.layout.allevent_cartview, getApplicationContext()));

                            DeviceUtil.hideLoading();

                        }else {
                            Toast.makeText(SecondActivity.this,"Error occured..",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.e(TAG, t.toString());
                    }
                });


        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(SecondActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("No Internet Connection")
                    .setMessage("Pleas check your phone internet connection")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intMain=new Intent(SecondActivity.this, MainActivity.class);
                            startActivity(intMain);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }



    }

    public void setDataToRecommendedViw(List<AllEvent> allEvent){

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecommendedEvent);
        LinearLayoutManager HorizontalLayout1 = new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout1);
        // add pager behavior
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new LinePagerIndicatorDecoration());

        List<AllEvent> recommendedEvent = new ArrayList<>();
        for(int i=0;i<allEvent.size();i++){
            if(allEvent.get(i).isIsRecommended() ) {
                recommendedEvent.add(allEvent.get(i));
            }
        }
        recyclerView.setAdapter(new RecommendedAdapter(recommendedEvent, R.layout.recommendedevent_cartview, getApplicationContext()));


    }

    @Override
    public void onItemClick(View v, int position) {

        if(chk){
            DeviceUtil.showLoading("Loading...",SecondActivity.this);
            getDataFromAPI(position);

        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(SecondActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("No Internet Connection")
                    .setMessage("Pleas check your phone internet connection")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intMain=new Intent(SecondActivity.this, MainActivity.class);
                            startActivity(intMain);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }

    }

    public void getDataFromAPI(int position){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiService.getEventDetail();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                int statusCode = response.code();
                if(statusCode==200) {
                    //Toast.makeText(SecondActivity.this,"Status:"+ statusCode + "Success",Toast.LENGTH_SHORT).show();
                    List<EventDetail> eventDetails = response.body().getEventDetails();

                    passIntentDat(eventDetails,position);

                }else {
                    Toast.makeText(SecondActivity.this,"Error occurred...",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }

    public void passIntentDat(List<EventDetail> eventDetails,int position){

        Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("ValID", String.valueOf(eventDetails.get(position).getId()));
        intent.putExtra("Valimgbackdrop", eventDetails.get(position).getMainImage());
        intent.putExtra("Valisparented",eventDetails.get(position).getIsPartnered() );
        intent.putExtra("Valsports",eventDetails.get(position).getSport() );
        intent.putExtra("ValeventName",eventDetails.get(position).getName() );
        intent.putExtra("Valdate",eventDetails.get(position).getDateTime() );
        intent.putExtra("Valprice",eventDetails.get(position).getPrice() );
        intent.putExtra("Valtotalprize",eventDetails.get(position).getTotalPrize() );
        intent.putExtra("ValticketsSold",eventDetails.get(position).getTicketsSold() );
        intent.putExtra("ValmaxTickets",eventDetails.get(position).getMaxTickets() );
        intent.putExtra("Valtag1",eventDetails.get(position).getTags() );
        intent.putExtra("Valtext_about",eventDetails.get(position).getDescription() );
        intent.putExtra("Valtext_venuinfo",eventDetails.get(position).getVenueInformation() );
        intent.putExtra("Valtext_eventcreatedby",eventDetails.get(position).getEventCreator() );
        intent.putExtra("Valtext_location",eventDetails.get(position).getLocation() );
        intent.putExtra("Valtext_teaminfo",eventDetails.get(position).getTeamInformation() );
        startActivity(intent);
        finish();

    }
}
