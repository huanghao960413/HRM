package com.hh.service.impl;

import com.hh.dao.TrainRecordDao;
import com.hh.model.TrainRecord;
import com.hh.service.TrainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TrainRecordServiceImpl implements TrainRecordService {
    @Autowired
    private TrainRecordDao trainRecordDao;

    public Integer addTrainRecord(TrainRecord trainRecord) {
        if (trainRecord == null) {
            return 0;
        }
        return trainRecordDao.addTrainRecord(trainRecord);
    }

    public Integer delTrainRecord(TrainRecord trainRecord) {
        if (trainRecord == null) {
            return 0;
        }
        return trainRecordDao.delTrainRecord(trainRecord);
    }

    public Integer updateTrainRecord(TrainRecord trainRecord) {
        if (trainRecord == null) {
            return 0;
        }
        return trainRecordDao.updateTrainRecord(trainRecord);
    }

    public TrainRecord queryTrainRecord(TrainRecord trainRecord) {
        if (trainRecord == null) {
            return null;
        }
        return trainRecordDao.queryTrainRecord(trainRecord);
    }

    public List<TrainRecord> queryTrainRecordList(TrainRecord trainRecord) {
        if (trainRecord == null) {
            return null;
        }
        return trainRecordDao.queryTrainRecordList(trainRecord);
    }

    public List<TrainRecord> queryTrainRecordLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return trainRecordDao.queryTrainRecordLimit(hashMap);
    }
}
