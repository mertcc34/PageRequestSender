package com.cevaptu;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        while(i<20) {
            try {
                String str ="http://cevaptu.com/soru/antalya-expo-2016-fuari-hakkinda-ne-dusunuyorsunuz-sizce-yuksek-meblaga-gore-gerekli-bir-yatirim-miydi/";
                

                URL url = new URL(str);
                URLConnection mc = url.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                mc.getInputStream()));
                String inputLine;

              //  while ((inputLine = in.readLine()) != null) {
                    //   System.out.println(inputLine);
             //   }
                System.out.println("Request number : " + (i+1));

                in.close();


            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            i++;
        }
    }
}