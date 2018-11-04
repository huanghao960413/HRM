package com.hh.service;

import com.hh.model.Wage;

public interface WageService {

    Integer addWage(Wage wage);

    Integer updateWage(Wage wage);

    Wage queryWage(Wage wage);

    Wage settlementWage(Wage wage);

}
