package com.example.shivamkumar1.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
//import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivamkumar1.R;
import com.example.shivamkumar1.adapter.AllEventAdapter;
import com.example.shivamkumar1.adapter.RecommendedAdapter;
import com.example.shivamkumar1.adapter.SuggestedEventAdapter;
import com.example.shivamkumar1.model.AllEvent;
import com.example.shivamkumar1.model.Purchase;
import com.example.shivamkumar1.model.EventDetail;
import com.example.shivamkumar1.model.Example;
import com.example.shivamkumar1.model.ExamplePurchase;
import com.example.shivamkumar1.model.PurchaseDetail;
import com.example.shivamkumar1.rest.ApiClient;
import com.example.shivamkumar1.rest.ApiInterface;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = ThirdActivity.class.getSimpleName();

    @BindView(R.id.backBtn)
    ImageView backBtn;
    @BindView(R.id.linerlayoutScroll)
    LinearLayout linerlayoutScroll;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.imgbackdrop)
    ImageView imgbackdrop;
    @BindView(R.id.isparented)
    TextView isparented;
    @BindView(R.id.sports)
    TextView sports;
    @BindView(R.id.eventName)
    TextView eventName;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.totalprize)
    TextView totalprize;
    @BindView(R.id.ticket)
    TextView ticket;
    @BindView(R.id.btnLike)
    ImageButton btnLike;
    @BindView(R.id.ticketsold_maxticket)
    TextView ticketsold_maxticket;
    @BindView(R.id.tag1)
    TextView tag1;
   /* @BindView(R.id.tag2)
    TextView tag2;
    @BindView(R.id.tag3)
    TextView tag3;*/
    @BindView(R.id.text_about)
    TextView text_about;
    @BindView(R.id.price_iam_in)
    Button price_iam_in;
    @BindView(R.id.text_venuinfo)
    TextView text_venuinfo;
    @BindView(R.id.text_eventcreatedby)
    TextView text_eventcreatedby;
    @BindView(R.id.text_location)
    TextView text_location;
    @BindView(R.id.redirectGoogleMap)
    TextView redirectGoogleMap;
    @BindView(R.id.text_contactEmail)
    TextView text_contactEmail;
    @BindView(R.id.text_contactPhoneNo)
    TextView text_contactPhoneNo;
    @BindView(R.id.text_teaminfo)
    TextView text_teaminfo;



    String ValID;
    String Valimgbackdrop;
    String Valisparented;
    String Valsports;
    String ValeventName;
    String Valdate;
    String Valprice;
    String Valtotalprize;
    int ValticketsSold;
    int ValmaxTickets;
    String ValbtnLike;
    String Valticketsold_maxticket;
    String Valtag1;
    String Valtext_about;
    String Valtext_venuinfo;
    String Valtext_eventcreatedby;
    String Valtext_location;
    String Valtext_contactEmail;
    String Valtext_contactPhoneNo;
    String Valtext_teaminfo;
    String ValPaymentMethodType;





    int position ;
    int bookinfIDNO ;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;
    String call_number="19916810200";

    List<AllEvent> suggestedEvent =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);
        ButterKnife.bind(this);
        Intent getVal1 = getIntent();
        position = getVal1.getIntExtra("position",0);
        ValID=getVal1.getStringExtra("ValID");
        Valimgbackdrop=getVal1.getStringExtra("Valimgbackdrop");
        Valisparented=getVal1.getStringExtra("Valisparented");
        Valsports=getVal1.getStringExtra("Valsports");
        ValeventName =getVal1.getStringExtra("ValeventName");
        Valdate = getVal1.getStringExtra("Valdate");
        Valprice = String.valueOf(getVal1.getFloatExtra("Valprice",0));
        Valtotalprize = String.valueOf(getVal1.getIntExtra("Valtotalprize",0));
        ValticketsSold = getVal1.getIntExtra("ValticketsSold",0);
        ValmaxTickets = getVal1.getIntExtra("ValmaxTickets",0);
        Valtag1 = getVal1.getStringExtra("Valtag1");
        Valtext_about = getVal1.getStringExtra("Valtext_about");
        Valtext_venuinfo = getVal1.getStringExtra("Valtext_venuinfo");
        Valtext_eventcreatedby = getVal1.getStringExtra("Valtext_eventcreatedby");
        Valtext_location = getVal1.getStringExtra("Valtext_location");
        Valtext_teaminfo = getVal1.getStringExtra("Valtext_teaminfo");
        SetSuggestedRecyclerView();
        setDataToView();


        setSupportActionBar(toolbar);


        initCollapsingToolbar();
        onRadioButtonClicked();


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLike.setImageResource(R.drawable.heart_icon);
                btnLike.setImageResource(R.drawable. heart_icon);
            }
        });

       price_iam_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPurchaseDailog();
            }
        });


        text_contactEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email="contact@techalcahmey.co";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "your subject goes here...");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello, Have a good day :-).  Thank you");
                startActivity(emailIntent);
            }
        });

        text_contactPhoneNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {

                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:"+Uri.encode(call_number.trim())));
                        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(callIntent);
                    }  catch(ActivityNotFoundException ex)
                    {
                        try
                        {
                            Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(call_number));
                            startActivity(unrestrictedIntent);
                        }
                        catch(ActivityNotFoundException innerEx)
                        {
                            Toast.makeText(ThirdActivity.this, "Please install a phone application", Toast.LENGTH_LONG).show();
                        }
                    }


            }
        });


        redirectGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean chk = DeviceUtil.isNetworkAvailable(ThirdActivity.this, null);
                if(chk){

                    String address= Valtext_location ;
                     Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + address + "");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);mapIntent.setPackage("com.google.android.apps.maps");

                            try
                            {
                                startActivity(mapIntent);
                            }
                            catch(ActivityNotFoundException ex)
                            {
                                try
                                {
                                    Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                    startActivity(unrestrictedIntent);
                                }
                                catch(ActivityNotFoundException innerEx)
                                {
                                    Toast.makeText(ThirdActivity.this,"Pleas install google map",Toast.LENGTH_SHORT).show();
                                }
                            }


                } else {

                    AlertDialog alertDialog = new AlertDialog.Builder(ThirdActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("No Internet Connection")
                            .setMessage("Pleas check your phone internet connection")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what should happen when negative button is clicked
                                    Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                }
                            })
                            .show();
                }
            }
        });



    }




    public void setDataToView(){


        Picasso.get().load(String.valueOf(Valimgbackdrop)).into(imgbackdrop);


        if(Boolean.valueOf(Valisparented).equals(true)){
            isparented.setText("Partnered");
        }else {
            isparented.setText("Not Partnered");
        }

        sports.setText(Valsports);

        eventName.setText(ValeventName);

        date.setText(Valdate);
        Valprice = "£"+String.valueOf(Valprice);
        price.setText(String.valueOf(Valprice));

        totalprize.setText(Valtotalprize);


        Valticketsold_maxticket = " "+ValticketsSold+"/"+ValmaxTickets+" attending";
        SpannableString content = new SpannableString(Valticketsold_maxticket);
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        ticketsold_maxticket.setText(content);


       String str = Valtag1.replaceAll("[^a-zA-Z0-9]", "#");
        str = str.replaceAll("##", "#");
        str = str.replaceAll("##", " # ");



        tag1.setText(str.substring(0, str.length() - 1));

        text_about.setText(Valtext_about);

        text_venuinfo.setText(Valtext_venuinfo);

        text_eventcreatedby.setText("  "+Valtext_eventcreatedby);

        text_location.setText("  "+Valtext_location);

        text_teaminfo.setText(Valtext_teaminfo);

    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    /*collapsingToolbar.setTitle(getString(R.string.app_name));*/
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }






    private void showPurchaseDailog() {


        final BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(ThirdActivity.this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.purchase_dialog, (LinearLayout)findViewById(R.id.bottom_sheet_container));

        TextView eventName = (TextView) bottomSheetView.findViewById(R.id.eventName);
        TextView date = (TextView) bottomSheetView.findViewById(R.id.date);
        TextView location = (TextView) bottomSheetView.findViewById(R.id.location);
        TextView price = (TextView) bottomSheetView.findViewById(R.id.price);
        eventName.setText(ValeventName);
        date.setText(Valdate);
        location.setText(Valtext_location);
        price.setText(Valprice);


        bottomSheetView.findViewById(R.id.radio0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValPaymentMethodType="visa";
            }
        });

        bottomSheetView.findViewById(R.id.radio01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValPaymentMethodType="mastercard";
            }
        });

        bottomSheetView.findViewById(R.id.radio02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValPaymentMethodType="paypal";
            }
        });

        bottomSheetView.findViewById(R.id.button_paynow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(String.valueOf(ValPaymentMethodType).isEmpty() || ValPaymentMethodType == null){
                    bottomSheetDialog1.dismiss();
                    Toast.makeText(ThirdActivity.this, "Please select Payment Type", Toast.LENGTH_SHORT).show();

                }else {

                    bottomSheetDialog1.dismiss();
                    {
                        boolean chk = DeviceUtil.isNetworkAvailable(ThirdActivity.this, null);
                        if(chk){
                            Toast.makeText(ThirdActivity.this, "Purchase....", Toast.LENGTH_SHORT).show();
                            sendPurchasePostAPIRequest();
                        } else {

                            AlertDialog alertDialog = new AlertDialog.Builder(ThirdActivity.this)
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .setTitle("No Internet Connection")
                                    .setMessage("Pleas check your phone internet connection")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            finish();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            //set what should happen when negative button is clicked
                                            Toast.makeText(getApplicationContext(),"Nothing Happened",Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .show();
                        }
                    }

                }

            }
        });
        bottomSheetDialog1.setContentView(bottomSheetView);
        bottomSheetDialog1.show();


        bottomSheetView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog1.dismiss();
                return;
            }
        });

        bottomSheetView.findViewById(R.id.backBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog1.dismiss();
                return;
            }
        });



    }



  public void onRadioButtonClicked() {
        LayoutInflater inflater = getLayoutInflater();
        View purchase_dialog = inflater.inflate(R.layout.purchase_dialog, null);

        RadioButton radio0 = (RadioButton) purchase_dialog.findViewById(R.id.radio0);
        RadioButton radio01 = (RadioButton) purchase_dialog.findViewById(R.id.radio01);
        RadioButton radio02 = (RadioButton) purchase_dialog.findViewById(R.id.radio02);
        RadioGroup radioGroup = (RadioGroup) purchase_dialog.findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio0) {
                    ValPaymentMethodType="visa";
                } else if(checkedId == R.id.radio01) {
                    ValPaymentMethodType="mastercard";
                } else if(checkedId == R.id.radio02){
                    ValPaymentMethodType="paypal";
                }
            }

        });



    }




    public void ShowThankYouDialog(){
        final BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(ThirdActivity.this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.thankyou_dialog, (LinearLayout)findViewById(R.id.bottom_sheet_container));
       TextView bookinfID= (TextView) bottomSheetView.findViewById(R.id.bookinfID);
        bookinfID.setText(String.valueOf(bookinfIDNO));
        bottomSheetView.findViewById(R.id.button_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Close....", Toast.LENGTH_SHORT).show();
                bottomSheetDialog2.dismiss();

                Intent intent=new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bottomSheetDialog2.setContentView(bottomSheetView);
        bottomSheetDialog2.show();


        bottomSheetView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog2.dismiss();
                return;
            }
        });



    }




 public void sendPurchasePostAPIRequest(){

     ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

     ExamplePurchase example = new ExamplePurchase();
     PurchaseDetail purchase = new PurchaseDetail(Valdate, Valprice, ValPaymentMethodType, ValID);
    // PurchaseDetail purchase = new PurchaseDetail("2/13/2021 16:00:00", "120", "visa", "3");
     List<PurchaseDetail> purchases= new ArrayList<>();
     purchases.add(purchase);
     example.setPurchase(purchases);


            Call<Example> call = apiService.sendPurchaseDetail( example);
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    int statusCode = response.code();
                    if(statusCode==200) {
                       // Toast.makeText(ThirdActivity.this,"Status:"+ statusCode + "Success",Toast.LENGTH_SHORT).show();
                        bookinfIDNO =  response.body().getPurchase().getId();
                        ShowThankYouDialog();

                    }else {
                        Toast.makeText(ThirdActivity.this,"Error occurred...",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(i);
        finish();
    }

    public void SetSuggestedRecyclerView(){


      boolean  chk = DeviceUtil.isNetworkAvailable(ThirdActivity.this, null);
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
                       /* List<AllEvent> suggestedEvent = new ArrayList<>();

                        for(int i=0;i<=allEvent.size();i++){
                        if(allEvent.get(i).getSport().equals(Valsports)) {
                            suggestedEvent.addAll(allEvent);
                        }
                        }
                        suggestedrecyclerView.setAdapter(new SuggestedEventAdapter(ThirdActivity.this,suggestedEvent, R.layout.allevent_cartview, getApplicationContext(),Valsports));
*/
                        serDataToRecyclerView(allEvent);
                        DeviceUtil.hideLoading();

                    }else {
                        Toast.makeText(ThirdActivity.this,"Error occured..",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Log.e(TAG, t.toString());
                }
            });


        } else {

            AlertDialog alertDialog = new AlertDialog.Builder(ThirdActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("No Internet Connection")
                    .setMessage("Pleas check your phone internet connection")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intMain=new Intent(ThirdActivity.this, MainActivity.class);
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

    public void serDataToRecyclerView(List<AllEvent> allEvent){
        RecyclerView suggestedrecyclerView = (RecyclerView) findViewById(R.id.suggestedEvent);

        LinearLayoutManager HorizontalLayout1 = new LinearLayoutManager(ThirdActivity.this, LinearLayoutManager.HORIZONTAL, false);
        suggestedrecyclerView.setLayoutManager(HorizontalLayout1);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(suggestedrecyclerView);
        suggestedrecyclerView.addItemDecoration(new LinePagerIndicatorDecoration());


        for(int i=0;i<allEvent.size();i++){
            if(allEvent.get(i).getSport().equals(Valsports) && suggestedEvent.size()< 5) {
               suggestedEvent.add(allEvent.get(i));
            }

        }
        suggestedrecyclerView.setAdapter(new SuggestedEventAdapter(ThirdActivity.this,suggestedEvent, R.layout.allevent_cartview, getApplicationContext(),Valsports));


    }


}
