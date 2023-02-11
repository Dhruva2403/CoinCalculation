package com.exchangeBill.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoinServiceImpl implements CoinService {

    public static final int[] AVAILABLE_BILLS = {1, 2, 5, 10, 20, 50, 100};
    public static final double[] AVAILABLE_COINS = {0.01, 0.05, 0.10, 0.25};
    private static final int INTIAL_COIN_COUNT = 100;
    private static Map<Double, Integer> coinCountMap = new HashMap<>();

    static {
        for (double coin : AVAILABLE_COINS) {
            coinCountMap.put(coin, INTIAL_COIN_COUNT);
        }
    }

    @Override
    public Map<Double, Integer> getChange(int billAmount) {
        // TODO Auto-generated method stub
        Map<Double, Integer> newMap = makeChange(billAmount);
        // Deduct the change from the available coin count
        if (newMap != null) {
            for (Map.Entry<Double, Integer> entry : newMap.entrySet()) {
                double coin = entry.getKey();
                int coinCount = entry.getValue();
                coinCountMap.put(coin, coinCountMap.get(coin) - coinCount);
            }
        }
        return newMap;
        // return "Success: Change for bill amount " + bill + " is " + changeMap;
    }

    private Map<Double, Integer> makeChange(int bill) {
        Map<Double, Integer> changeMap = new HashMap<>();
        double remainingAmount = bill;
        for (int i = AVAILABLE_COINS.length - 1; i >= 0; i--) {
            double coin = AVAILABLE_COINS[i];
            int coinCount = (int) (remainingAmount / coin);
            if (coinCount > coinCountMap.get(coin)) {
                coinCount = coinCountMap.get(coin);
            }
            if (coinCount > 0) {
                changeMap.put(coin, coinCount);
                remainingAmount -= coinCount * coin;
            }
        }
        if (remainingAmount > 0) {
            return null;
        }
        return changeMap;
    }

    @Override
    public boolean isValidBillAmount(int billAmount) {
        // TODO Auto-generated method stub
        boolean billAvailable = false;
        for (int availableBill : AVAILABLE_BILLS) {
            if (availableBill == billAmount) {
                billAvailable = true;
                break;
            }
        }
        return billAvailable;
    }

}
