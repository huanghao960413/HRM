package com.hh.service.impl;

import com.hh.dao.VisitorDao;
import com.hh.model.Visitor;
import com.hh.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorDao visitorDao;

    public Integer addVisitor(Visitor visitor) {
        if (visitor == null) {
            return 0;
        }
        return visitorDao.addVisitor(visitor);
    }

    public Integer updateVisitor(Visitor visitor) {
        if (visitor == null) {
            return 0;
        }
        return visitorDao.updateVisitor(visitor);
    }

    public Visitor queryVisitor(Visitor visitor) {
        if (visitor == null) {
            return null;
        }
        return visitorDao.queryVisitor(visitor);
    }

}
