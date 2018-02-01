package com.example.ranokf.asynctask;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ranokf on 16.01.18.
 */

class ConnectOracle {


    //        //        To set up a connection to a database, the code is this:
////        Connection con = DriverManager.getConnection( host, username, password );
//
//        //ORACLE
//        //oracle.jdbc.driver.OracleDriver
//        //jdbc:oracle:thin:@hostname:port Number:databaseName
//
//
//


    static void main() {

        String host = "jdbc:oracle:thin:@ebs-dev.localdomain:1541:DEV";
        String uName = "apps";
        String uPass= " apps ";

//        String host = "jdbc:oracle:thin:@192.168.19.138:2022:DEV";
//        String uName = "artem";
//        String uPass= " BQfgrbBCABdU7tN";


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
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ebs-dev.localdomain:1541:DEV","apps","apps");
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Log.d(LOG_TAG, "--- CONNECTION TEST after get connection ---" + debugSting);


//step3 create the statement object
            Statement stmt=con.createStatement();

            Log.d(LOG_TAG, "--- CONNECTION TEST after create statement ---" + debugSting);

//step4 execute query
            ResultSet rs = stmt.executeQuery("select name from pa_projects_all where segment1 = 'Ф900976У'");
            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            //System.out.println(rs.getString(1));

            debugSting = rs.getString(1);

            System.out.println(debugSting);


            Log.d(LOG_TAG, "--- CONNECTION TEST inside (execute query) ---" + debugSting);


//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);
            Log.d(LOG_TAG, "--- CONNECTION TEST inside catch ---" + e);
        }

        Log.d(LOG_TAG, "--- CONNECTION TEST after catch ---" + debugSting);

    }

}
