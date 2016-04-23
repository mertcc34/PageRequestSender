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
                URL yahoo = new URL("http://cevaptu.com/soru/zenmate-vpn-guvenli-mi/");
                URLConnection yc = yahoo.openConnection();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                yc.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null)
                    //   System.out.println(inputLine);
                    in.close();


            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
            i++;
        }
    }
}