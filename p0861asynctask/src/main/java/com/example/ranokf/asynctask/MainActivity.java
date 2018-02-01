package com.example.ranokf.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ranokf.*;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    MyTask mt;
    TextView tvInfo;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvInfo = findViewById(R.id.tvInfo);

        textViewResult = findViewById(R.id.textViewResult);
    }

    public void onclick(View v) {
        mt = new MyTask();
        mt.execute();

    }


    // IN, INTERMEDIATE, OUT params
    class MyTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Begin");
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                TimeUnit.SECONDS.sleep(2);

                ConnectOracle.main();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            tvInfo.setText("End");

            //textViewResult.setText(result);
        }
    }

}
