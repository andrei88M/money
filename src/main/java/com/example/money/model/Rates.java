package com.example.money.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Rates {

    @SerializedName("Date")
    private String date;

    @SerializedName("Cur_Abbreviation")
    private String curAbbreviation;

    @SerializedName("Cur_Scale")
    private int curScale;

    @SerializedName("Cur_Name")
    private String curName;

    @SerializedName("Cur_OfficialRate")
    private String curOfficialRate;


}
