package com.exchangeBill.service;

import java.util.Map;

public interface CoinService {

    Map<Double, Integer> getChange(int billAmount);

    boolean isValidBillAmount(int billAmount);
}
