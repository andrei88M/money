package com.example.money.service;

import com.example.money.dao.DaoRates;
import com.example.money.dao.DaoRatesImp;
import com.example.money.model.CurAbbreviation;
import com.example.money.model.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatesServiceImp implements RatesService {

    @Autowired
    private DaoRates daoRates;

    @Override
    public Rates getRates(CurAbbreviation curAbbreviation) {
        Rates rates;
        String strFile;
        strFile = daoRates.getStrFile(curAbbreviation);
        rates = daoRates.getRates(strFile);
        return rates;
    }
}
