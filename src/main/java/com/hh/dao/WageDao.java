package com.hh.dao;

import com.hh.model.Wage;

public interface WageDao {

    Integer addWage(Wage wage);

    Wage queryWage(Wage wage);

    Integer updateWage(Wage wage);

}
