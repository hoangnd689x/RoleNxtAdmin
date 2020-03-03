package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Position;

@Service
@Transactional
public interface PositionService {
	
	 List<Position> getAllPosition();
}
