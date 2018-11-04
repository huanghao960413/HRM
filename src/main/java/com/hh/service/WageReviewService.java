package com.hh.service;

import com.hh.model.WageReview;

public interface WageReviewService {

    Integer addWageReview(WageReview wageReview);

    WageReview queryWageReview(WageReview wageReview);

}
