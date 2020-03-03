package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.PositionDetails;

/**
 * @author YOG1HC
 *
 */
@Service
@Transactional
public interface PositionDetailsService {
	
	 List<PositionDetails> getAllPositionDetails();
}
