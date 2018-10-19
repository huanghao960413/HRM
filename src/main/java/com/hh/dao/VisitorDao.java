package com.hh.dao;

import com.hh.model.Visitor;

public interface VisitorDao {

    Integer addVisitor(Visitor visitor);

    Integer updateVisitor(Visitor visitor);

    Visitor queryVisitor(Visitor visitor);

}
