package com.plc_2.siemens;

/**
 * Created by Sveticov on 24.06.2016.
 */
public class ConvertToIEEE754 {
   int var1;
    long var9;
    String var7;
    float var5;
    public  float IntToReal(int var11){
       this.var1=var11;
        this.var5=0f;
      this.var7="";

            var7=Integer.toBinaryString(var1);
            var9=Long.parseLong(var7,2);
            var1=(int)var9;

            var5=Float.intBitsToFloat(var1);

            return var5;
    }
}
