package com.conversor.models;

import java.util.ArrayList;
import java.util.List;

public class UserHistory {
    private List<CurrencyPairConversion> userConversionList = new ArrayList<>();

    public void setUserHistoryList(CurrencyPairConversion currencyPairConversion) {
        this.userConversionList.add(currencyPairConversion);
    }

    public List<CurrencyPairConversion> getUserConversionList() {
        return userConversionList;
    }
}
