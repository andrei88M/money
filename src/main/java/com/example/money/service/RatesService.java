package com.example.money.service;

import com.example.money.model.CurAbbreviation;
import com.example.money.model.Rates;
import org.springframework.stereotype.Service;

public interface RatesService {
    Rates getRates(CurAbbreviation curAbbreviation);
}
