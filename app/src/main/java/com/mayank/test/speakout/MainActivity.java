package com.mayank.test.speakout;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener
{

    private TextToSpeech mTextToSpeech1;
    private TextToSpeech mTextToSpeech2;
    private TextToSpeech mTextToSpeech3;
    private boolean isSetupDone;

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextToSpeech1 = new TextToSpeech(this, this);
        mTextToSpeech2 = new TextToSpeech(this, this);
        mTextToSpeech3 = new TextToSpeech(this, this);

        img1 = (ImageView) findViewById(R.id.img_view1);
        img2 = (ImageView) findViewById(R.id.img_view2);
        img3 = (ImageView) findViewById(R.id.img_view3);
        img4 = (ImageView) findViewById(R.id.img_view4);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
    }

    @Override
    public void onInit(int status)
    {
        if(status == TextToSpeech.SUCCESS)
        {

            int result1 = mTextToSpeech1.setLanguage(Locale.US);
            int result2 = mTextToSpeech2.setLanguage(Locale.FRENCH);
            int result3 = mTextToSpeech3.setLanguage(Locale.CHINESE);

            if((result1 == TextToSpeech.LANG_MISSING_DATA || result1 == TextToSpeech.LANG_NOT_SUPPORTED) &&
                    (result2 == TextToSpeech.LANG_MISSING_DATA || result2 == TextToSpeech.LANG_NOT_SUPPORTED) &&
                    (result3 == TextToSpeech.LANG_MISSING_DATA || result3 == TextToSpeech.LANG_NOT_SUPPORTED))
            {
                Log.e("TTS", "This Language is not supported");
                isSetupDone = false;
            }
            else
            {
                isSetupDone = true;
            }
        }
        else
        {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.img_view1:
                speakOut1("Elephant in French");
                speakOut2("Elephant");
                break;

            case R.id.img_view2:
                speakOut1("Tiger in chinese");
                speakOut3("Tiger");
                break;

            case R.id.img_view3:
                speakOut1("Peocock in French");
                speakOut2("Peocock");
                break;

            case R.id.img_view4:
                speakOut1("Lion in chinese");
                speakOut3("Lion");
                break;
        }
    }

    private void speakOut1(String textToConvert)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            mTextToSpeech1.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null, "animal text request1");
        }
        else
        {
            mTextToSpeech1.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void speakOut2(String textToConvert)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            mTextToSpeech2.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null, "animal text request2");
        }
        else
        {
            mTextToSpeech2.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void speakOut3(String textToConvert)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            mTextToSpeech3.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null, "animal text request3");
        }
        else
        {
            mTextToSpeech3.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
