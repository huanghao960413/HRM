package com.hh.dao;

import com.hh.model.RewardPunish;

import java.util.HashMap;
import java.util.List;

public interface RewardPunishDao {

    Integer addRewardPunish(RewardPunish rewardPunish);

    Integer updateRewardPunish(RewardPunish rewardPunish);

    Integer delRewardPunish(RewardPunish rewardPunish);

    RewardPunish queryRewardPunish(RewardPunish rewardPunish);

    List<RewardPunish> queryRewardPunishList(RewardPunish rewardPunish);

    List<RewardPunish> queryRewardPunishLimit(HashMap<String, Object> hashMap);

}
