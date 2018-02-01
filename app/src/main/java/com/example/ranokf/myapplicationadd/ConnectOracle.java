package com.example.ranokf.myapplicationadd;


import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ranokf on 15.01.18.
 */

public class ConnectOracle {

    public static void main() {

        final String LOG_TAG = "myLogs";

        String debugSting = "";

        //Toast.makeText(this, debugSting, Toast.LENGTH_LONG).show();


        Log.d(LOG_TAG, "--- CONNECTION TEST before try ---" + debugSting);

        try{
//step1 load the driver class
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            Log.d(LOG_TAG, "--- CONNECTION TEST after load driver ---" + debugSting);

//step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@ebs-dev.localdomain:1541:DEV","apps","apps");

            Log.d(LOG_TAG, "--- CONNECTION TEST after get connection ---" + debugSting);


////step3 create the statement object
//            Statement stmt=con.createStatement();
//
//            Log.d(LOG_TAG, "--- CONNECTION TEST after create statement ---" + debugSting);
//
////step4 execute query
//            ResultSet rs=stmt.executeQuery("select description from pa_projects_all where segment1 = 'Ф900976У';");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//
//            Log.d(LOG_TAG, "--- CONNECTION TEST inside (execute query) ---" + debugSting);


//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);
            Log.d(LOG_TAG, "--- CONNECTION TEST inside catch ---" + e);
        }

        Log.d(LOG_TAG, "--- CONNECTION TEST after catch ---" + debugSting);

    }


}
