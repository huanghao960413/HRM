package com.hh.service.impl;

import com.hh.dao.RewardPunishDao;
import com.hh.model.RewardPunish;
import com.hh.service.RewardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RewardPunishServiceImpl implements RewardPunishService {
    @Autowired
    private RewardPunishDao rewardPunishDao;

    public Integer addRewardPunish(RewardPunish rewardPunish) {
        if (rewardPunish == null) {
            return 0;
        }
        return rewardPunishDao.addRewardPunish(rewardPunish);
    }

    public Integer updateRewardPunish(RewardPunish rewardPunish) {
        if (rewardPunish == null) {
            return 0;
        }
        return rewardPunishDao.updateRewardPunish(rewardPunish);
    }

    public Integer delRewardPunish(RewardPunish rewardPunish) {
        if (rewardPunish == null) {
            return 0;
        }
        return rewardPunishDao.delRewardPunish(rewardPunish);
    }

    public RewardPunish queryRewardPunish(RewardPunish rewardPunish) {
        if (rewardPunish == null) {
            return null;
        }
        return rewardPunishDao.queryRewardPunish(rewardPunish);
    }

    public List<RewardPunish> queryRewardPunishList(RewardPunish rewardPunish) {
        if (rewardPunish == null) {
            return null;
        }
        return rewardPunishDao.queryRewardPunishList(rewardPunish);
    }

    public List<RewardPunish> queryRewardPunishLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return rewardPunishDao.queryRewardPunishLimit(hashMap);
    }
}
