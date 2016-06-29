package com.plc_2.siemens;

import autocc.S7Connector.S7_PLC_Connection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sveticov on 23.06.2016.
 */
public class PLC_2 {
    public void startPLC_2(){
        S7_PLC_Connection plc_connection=new S7_PLC_Connection("172.20.2.1",0,2);
        ConvertToIEEE754 convertToIEEE754=new ConvertToIEEE754();
        List<String> adressData=new ArrayList<String>();
        adressData.add("DB25.DBD0");
        adressData.add("DB25.DBD4");
        adressData.add("DB25.DBD12");
        adressData.add("DB25.DBD192");
        adressData.add("DB25.DBD48");
       // adressData.add("MD1156");

        for (int i = 0; i <10 ; i++) {
            int varSD,count=1;
            for(String address:adressData) {
                varSD = plc_connection.readInteger(address);
                System.out.println("+-------------------------------------|");
                System.out.println("|  var"+count+": ["+address+"] " + convertToIEEE754.IntToReal(varSD)+" ");
               // System.out.println("+-----------------------+");
                count++;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println("+-------------------------------------|");

//
       plc_connection.close();

    }


}
