package com.hh.service.impl;

import com.hh.dao.PositionDao;
import com.hh.model.Position;
import com.hh.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    public Integer addPosition(Position position) {
        if (position == null) {
            return 0;
        }
        return positionDao.addPosition(position);
    }

    public Integer delPosition(Position position) {
        if (position == null) {
            return 0;
        }
        return positionDao.delPosition(position);
    }

    public Integer updatePosition(Position position) {
        if (position == null) {
            return 0;
        }
        return positionDao.updatePosition(position);
    }

    public Position queryPosition(Position position) {
        if (position == null) {
            return null;
        }
        return positionDao.queryPosition(position);
    }

    public List<Position> queryPositionList(Position position) {
        if (position == null) {
            return null;
        }
        return positionDao.queryPositionList(position);
    }

    public List<Position> queryPositionLimit(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        return positionDao.queryPositionLimit(hashMap);
    }

}
