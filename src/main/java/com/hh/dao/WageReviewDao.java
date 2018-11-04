package com.hh.dao;

import com.hh.model.WageReview;

public interface WageReviewDao {

    Integer addWageReview(WageReview wageReview);

    Integer updateWageReview(WageReview wageReview);

    WageReview queryWageReview(WageReview wageReview);

}
