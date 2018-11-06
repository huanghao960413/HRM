package com.hh.service.impl;

import com.hh.dao.PositionDao;
import com.hh.dao.StaffDao;
import com.hh.model.Position;
import com.hh.model.Staff;
import com.hh.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private StaffDao staffDao;

    public Integer addPosition(Position position) {
        if (position == null) {
            return 0;
        }
        if (positionDao.queryPosition(position) != null) {
            return -1;
        }
        return positionDao.addPosition(position);
    }

    public Integer delPosition(Position position) {
        if (position == null) {
            return 0;
        }
        Staff queryStaff = new Staff();
        queryStaff.setP_id(position.getP_id());
        List<Staff> staffList = staffDao.queryStaffList(queryStaff);
        for (Staff s : staffList) {
            if (s.getS_state() != -1) {
                return -1;
            }
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
