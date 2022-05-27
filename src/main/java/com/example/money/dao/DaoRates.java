package com.example.money.dao;

import com.example.money.model.CurAbbreviation;
import com.example.money.model.Rates;


public interface DaoRates {

    String getStrFile(CurAbbreviation curAbbreviation);

    Rates getRates(String StrFile);
}
