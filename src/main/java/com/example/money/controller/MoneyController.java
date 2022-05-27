package com.example.money.controller;

import com.example.money.model.CurAbbreviation;
import com.example.money.model.Rates;
import com.example.money.service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/money")
public class MoneyController {

    private RatesService ratesService;

    @Autowired
    public MoneyController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping
    public String money() {
        return "/rates";
    }

    @GetMapping("/rates")
    public String rates(@RequestParam("select") CurAbbreviation select, Model model) {
        Rates rates = ratesService.getRates(select);
        model.addAttribute("rates", rates);
        return "/rates";
    }
}
