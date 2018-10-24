package com.hh.service;

import com.hh.model.Position;

import java.util.HashMap;
import java.util.List;

public interface PositionService {

    Integer addPosition(Position position);

    Integer delPosition(Position position);

    Integer updatePosition(Position position);

    Position queryPosition(Position position);

    List<Position> queryPositionList(Position position);

    List<Position> queryPositionLimit(HashMap<String, Object> hashMap);

}
