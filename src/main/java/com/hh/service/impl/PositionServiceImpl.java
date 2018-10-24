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
        return null;
    }

    public Integer delPosition(Position position) {
        return null;
    }

    public Integer updatePosition(Position position) {
        return null;
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
        return null;
    }

}
