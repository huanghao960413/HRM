package com.hh.dao;

import com.hh.model.Train;

import java.util.HashMap;
import java.util.List;

public interface TrainDao {

    Integer addTrain(Train train);

    Integer delTrain(Train train);

    Integer updateTrain(Train train);

    Train queryTrain(Train train);

    List<Train> queryTrainList(Train train);

    List<Train> queryTrainLimit(HashMap<String, Object> hashMap);

}
