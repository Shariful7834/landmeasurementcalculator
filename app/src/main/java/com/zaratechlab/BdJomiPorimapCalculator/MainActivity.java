package com.zaratechlab.BdJomiPorimapCalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.zaratechlab.landmeasurementcalculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText ET1, ET2, ET3, ET4,edit;;
    private Button msMS,clear;
    private TextView ketroTV, hundredTV, kataTV,akorTV,kaniTV,clearTV;
    public static ArrayList<String> num = new ArrayList<String>();
    double sum, res;
    private boolean isDone=false;
    private InterstitialAd mInterstitialAd;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET1=findViewById(R.id.dorgoBtn1);
        ET2 = findViewById(R.id.dorgoBtn2);
        ET3 = findViewById(R.id.prostoBtn1);
        ET4 = findViewById(R.id.prostoBtn2);
        msMS = findViewById(R.id.measurmentBtn);
        ketroTV = findViewById(R.id.showKetrofol);
        hundredTV = findViewById(R.id.showSotangsho);
        kataTV = findViewById(R.id.showKata);
        akorTV=findViewById(R.id.showAkor);
        kaniTV=findViewById(R.id.showKani);
        clear=findViewById(R.id.measurmentBtn2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-6964300942601218~6737577284");






        mInterstitialAd = new InterstitialAd(this);

       mInterstitialAd.setAdUnitId("ca-app-pub-6964300942601218/2028176087");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
            }
        });



        msMS =  (Button)findViewById(R.id.measurmentBtn);
        clear=(Button)findViewById(R.id.measurmentBtn2);

        msMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked, call the calucate method.
                calculate();
            }

        });


    }


    public void calculate(){
        //get entered texts from the edittexts,and convert to integers.
        Double value1 = Double.parseDouble(ET1.getText().toString());
        Double value2 = Double.parseDouble(ET2.getText().toString());
        //  Double value3 = Double.parseDouble(mEditText3.getText().toString());
        //do the calculation
        Double value3=Double.parseDouble(ET3.getText().toString());
        Double value4=Double.parseDouble(ET4.getText().toString());
        Double calculatedValue = (value2+value1)/2 * (value3+value4)/2;
        Double area=(calculatedValue/435.60);
        Double kota=(calculatedValue/721.46);
        Double akor=(calculatedValue/43560);
        Double kani=(calculatedValue/17280);

        ketroTV.setText(calculatedValue.toString());
        hundredTV.setText(area.toString());
        kataTV.setText(kota.toString());
        akorTV.setText(akor.toString());
        kaniTV.setText(kani.toString());


        //set the value to the textview, to display on screen.

    }

    public void clearText(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

        ET4.setText(null);
        ET1.setText(null);
        ET3.setText(null);
        ET2.setText(null);
        ketroTV.setText(null);
        hundredTV.setText(null);
        kaniTV.setText(null);
        kataTV.setText(null);
        akorTV.setText(null);

    }




}



//ca-app-pub-6964300942601218~6737577284 app ID
/*
Complete the instructions in the Google Mobile Ads SDK guide using this app ID:
        জমির হিসাব ক্যালকুলেটর,Land Measurement and Survey Calculatorca-app-pub-6964300942601218~6737577284
        Follow the banner implementation guide to integrate the SDK. You'll specify ad type, size, and placement when you integrate the code using this ad unit ID:
        Banner_Adsca-app-pub-6964300942601218/6681736960
        Review the AdMob policies to ensure your implementation complies.





        Follow these instructions:
Complete the instructions in the Google Mobile Ads SDK guide using this app ID:
জমির হিসাব ক্যালকুলেটর,Land Measurement and Survey Calculatorca-app-pub-6964300942601218~6737577284
Follow the interstitial implementation guide to integrate the SDK. You'll specify ad type and placement when you integrate the code using this ad unit ID:
Interstial_adsca-app-pub-6964300942601218/2028176087
Review the AdMob policies to ensure your implementation complies.


*/
