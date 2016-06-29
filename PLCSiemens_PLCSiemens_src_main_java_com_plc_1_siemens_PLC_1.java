package com.plc_1.siemens;

import io.rudin.s7connector.impl.S7Connector;
import io.rudin.s7connector.impl.S7TCPConnection;
import io.rudin.s7connector.impl.nodave.DaveArea;

import java.io.IOException;

/**
 * Created by Sveticov on 23.06.2016.
 */
public class PLC_1 {

    public void startPlc(){
        S7Connector connector= new S7TCPConnection("172.20.2.1",0,2);
        byte[] bytes=connector.read(DaveArea.DB,25,212,0);
        System.out.println(bytes.toString());
       // S7Type.REAL

        bytes[0]=0x00;
//connector.write(DaveArea.DB,25,252,bytes);
        try {

            connector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

