package com.hh.service.impl;

import com.hh.dao.TrainDao;
import com.hh.dao.TrainRecordDao;
import com.hh.model.Train;
import com.hh.model.TrainRecord;
import com.hh.service.TrainService;
import com.hh.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TrainRecordDao trainRecordDao;

    public Integer addTrain(Train train) {
        if (train == null) {
            return 0;
        }
        if (DateUtil.differentDays(DateUtil.getDate(), train.getT_start_time()) < 0) {
            return -1;
        }
        if (DateUtil.differentDays(train.getT_start_time(), train.getT_over_time()) < 0) {
            return -2;
        }
        return trainDao.addTrain(train);
    }

    public Integer delTrain(Train train) {
        if (train == null) {
            return 0;
        }
        TrainRecord queryTrainRecord = new TrainRecord();
        queryTrainRecord.setT_id(train.getT_id());
        List<TrainRecord> trainRecordList = trainRecordDao.queryTrainRecordList(queryTrainRecord);
        if (trainRecordList.size() != 0) {
            return -1;
        }
        return trainDao.delTrain(train);
    }

    public Integer updateTrain(Train train) {
        if (train == null) {
            return 0;
        }
        TrainRecord queryTrainRecord = new TrainRecord();
        queryTrainRecord.setT_id(train.getT_id());
        List<TrainRecord> trainRecordList = trainRecordDao.queryTrainRecordList(queryTrainRecord);
        if (trainRecordList.size() != 0) {
            return -1;
        }
        return trainDao.updateTrain(train);
    }

    public Train queryTrain(Train train) {
        if (train == null) {
            return null;
        }
        return trainDao.queryTrain(train);
    }

    public List<Train> queryTrainList(Train train) {
        if (train == null) {
            return null;
        }
        return trainDao.queryTrainList(train);
    }

    public List<Train> queryTrainLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return trainDao.queryTrainLimit(hashMap);
    }

}
