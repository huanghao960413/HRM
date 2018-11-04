package com.hh.service.impl;

import com.hh.dao.RewardPunishDao;
import com.hh.dao.WageDao;
import com.hh.dao.WageReviewDao;
import com.hh.model.RewardPunish;
import com.hh.model.Wage;
import com.hh.model.WageReview;
import com.hh.service.WageReviewService;
import com.hh.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WageReviewServiceImpl implements WageReviewService {
    @Autowired
    private WageReviewDao wageReviewDao;
    @Autowired
    private WageDao wageDao;

    public Integer addWageReview(WageReview wageReview) {
        if (wageReview == null) {
            return 0;
        }
        Wage wage = wageDao.queryWage(new Wage(wageReview.getW_id()));
        wage.setW_state(1);
        if (wageDao.updateWage(wage) <= 0) {
            return 0;
        }
        return wageReviewDao.addWageReview(wageReview);
    }

    public WageReview queryWageReview(WageReview wageReview) {
        if (wageReview == null) {
            return null;
        }
        return wageReviewDao.queryWageReview(wageReview);
    }
}
