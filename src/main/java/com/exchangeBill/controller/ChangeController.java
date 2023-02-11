package com.exchangeBill.controller;

import com.exchangeBill.model.CoinResponse;
import com.exchangeBill.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/billAmount")
public class ChangeController {

    @Autowired
    private CoinService coinService;

    @RequestMapping(value = "/getChange", method = {RequestMethod.POST, RequestMethod.GET})
    public CoinResponse getChange(@RequestParam("billAmount") int billAmount) throws Exception {
        String error = "";
        Map<Double, Integer> changeCoins = new HashMap<Double, Integer>();
        CoinResponse coinResponse = new CoinResponse();
        boolean isValidBillAmount = (coinService.isValidBillAmount(billAmount));
        if (!isValidBillAmount) {
            error = "Error: Invalid bill amount. ";
        } else {
            changeCoins = coinService.getChange(billAmount);
            if (changeCoins == null) {
                error = "Error: Not enough coins to make change for bill amount: " + billAmount;
            } else {
                error = "";
            }
        }
        coinResponse.setChangeCoin(changeCoins);
        coinResponse.setError(error);
        return coinResponse;
    }
}
