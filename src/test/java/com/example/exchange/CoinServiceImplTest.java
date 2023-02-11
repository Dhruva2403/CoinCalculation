package com.example.exchange;

import com.exchangeBill.service.CoinService;
import com.exchangeBill.service.CoinServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CoinServiceImplTest {

    @Test
    public void test() {
        CoinService coinService = new CoinServiceImpl();
        Map<Double, Integer> result = coinService.getChange(10);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(result.get(0.25), 40);
    }

    @Test
    public void test2() {
        CoinService coinService = new CoinServiceImpl();
        Map<Double, Integer> result = coinService.getChange(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(result.get(0.25), 4);
    }

    @Test
    public void test3() {
        CoinService coinService = new CoinServiceImpl();
        Map<Double, Integer> result = coinService.getChange(5);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(result.get(0.25), 20);
    }

    @Test
    public void test4() {
        CoinService coinService = new CoinServiceImpl();
        Map<Double, Integer> result = coinService.getChange(100);
        Assertions.assertNull(result);
    }
}
