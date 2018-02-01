package com.example.ranokf.myapplicationadd;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class MainActivity extends AppCompatActivity {


    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        setContentView(R.layout.activity_tabbed);

        LinearLayout l = new LinearLayout(this);
        l.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        l.setOrientation(LinearLayout.VERTICAL);



        setContentView(l);




        // barcode data
//        String barcode_data = "123456";
        String barcode_data = "9789667484552";
//        String barcode_data = "WAT?!";

        // barcode image
        Bitmap bitmap = null;
        ImageView iv = new ImageView(this);

        try {

            bitmap = encodeAsBitmap(barcode_data, BarcodeFormat.EAN_13, 600, 300);
//            bitmap = encodeAsBitmap(barcode_data, BarcodeFormat.QR_CODE, 600, 300);
            iv.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }


        l.addView(iv);

//        //barcode text
//        TextView tv = new TextView(this);
//        tv.setGravity(Gravity.CENTER_HORIZONTAL);
//        tv.setText(barcode_data);
//
//        l.addView(tv);

    }



    /**************************************************************
     * getting from com.google.zxing.client.android.encode.QRCodeEncoder
     *
     * See the sites below
     * http://code.google.com/p/zxing/
     * http://code.google.com/p/zxing/source/browse/trunk/android/src/com/google/zxing/client/android/encode/EncodeActivity.java
     * http://code.google.com/p/zxing/source/browse/trunk/android/src/com/google/zxing/client/android/encode/QRCodeEncoder.java
     */

    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;

    Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int img_width, int img_height) throws WriterException {
        String contentsToEncode = contents;
        if (contentsToEncode == null) {
            return null;
        }
        Map<EncodeHintType, Object> hints = null;
        String encoding = guessAppropriateEncoding(contentsToEncode);
        if (encoding != null) {
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, encoding);
        }
        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result;
        try {
            result = writer.encode(contentsToEncode, format, img_width, img_height, hints);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

    private static String guessAppropriateEncoding(CharSequence contents) {
        // Very crude at the moment
        for (int i = 0; i < contents.length(); i++) {
            if (contents.charAt(i) > 0xFF) {
                return "UTF-8";
            }
        }
        return null;
    }




    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity: onResume()");

//        makeConnection();

//        ConnectOracle.main();

    }


//    private void makeConnection(){
//        //        To set up a connection to a database, the code is this:
////        Connection con = DriverManager.getConnection( host, username, password );
//
//        //ORACLE
//        //oracle.jdbc.driver.OracleDriver
//        //jdbc:oracle:thin:@hostname:port Number:databaseName
//
//
//
//        String host = "jdbc:oracle:thin:@192.168.19.112:1541:DEV";
//        String uName = "apps";
//        String uPass= " apps ";
//
//        Log.d(LOG_TAG, "--- CONNECTION TEST before ---");
//
//        try {
//            Connection connection = DriverManager.getConnection(host, uName, uPass);
//
//            String debugSting = connection.getClientInfo().toString();
//
//
//
//            //Toast.makeText(this, debugSting, Toast.LENGTH_LONG).show();
//
//            Log.d(LOG_TAG, "--- CONNECTION TEST inside ---" + debugSting);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        Log.d(LOG_TAG, "--- CONNECTION TEST after ---");
//    }

}
