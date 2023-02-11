package com.exchangeBill.model;

import java.util.Map;

public class CoinResponse {

    private Map<Double, Integer> changeCoin;
    private String error;

    public Map<Double, Integer> getChangeCoin() {
        return changeCoin;
    }

    public void setChangeCoin(Map<Double, Integer> changeCoin) {
        this.changeCoin = changeCoin;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
