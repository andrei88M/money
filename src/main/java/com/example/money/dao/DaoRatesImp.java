package com.example.money.dao;

import com.example.money.model.CurAbbreviation;
import com.example.money.model.Rates;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Component
public class DaoRatesImp implements DaoRates {
    @Override
    public String getStrFile(CurAbbreviation curAbbreviation) {
        String urlString = "";
        try {
            URL url = new URL("https://www.nbrb.by/api/exrates/rates/" + curAbbreviation + "?parammode=2");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            } else {
                System.out.println("Пожалуйста, введите HTTP URL.");
                return "";
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String current;

            while ((current = in.readLine()) != null) {
                urlString += current;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlString;
    }


    @Override
    public Rates getRates(String StrFile) {
        Gson gson = new Gson();
        Rates rates = gson.fromJson(StrFile, Rates.class);
        return rates;
    }
}
