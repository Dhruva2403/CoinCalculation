package com.exchangeBill.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ChangeConfig {

    @Bean
    @Qualifier("bills")
    public Set<Integer> getBills() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(10);
        set.add(20);
        set.add(50);
        set.add(100);
        return set;
    }

    @Bean
    @Qualifier("coins")
    public Set<Double> getCoins() {
        Set<Double> set = new HashSet<>();
        set.add(0.01);
        set.add(0.05);
        set.add(0.10);
        set.add(0.25);
        return set;
    }

}
