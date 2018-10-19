package com.hh.service;

import com.hh.model.Visitor;

public interface VisitorService {

    Integer addVisitor(Visitor visitor);

    Integer updateVisitor(Visitor visitor);

    Visitor queryVisitor(Visitor visitor);

}
