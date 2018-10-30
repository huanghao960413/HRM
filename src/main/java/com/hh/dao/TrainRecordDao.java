package com.hh.dao;

import com.hh.model.TrainRecord;

import java.util.HashMap;
import java.util.List;

public interface TrainRecordDao {

    Integer addTrainRecord(TrainRecord trainRecord);

    Integer delTrainRecord(TrainRecord trainRecord);

    Integer updateTrainRecord(TrainRecord trainRecord);

    TrainRecord queryTrainRecord(TrainRecord trainRecord);

    List<TrainRecord> queryTrainRecordList(TrainRecord trainRecord);

    List<TrainRecord> queryTrainRecordLimit(HashMap<String, Object> hashMap);

}
