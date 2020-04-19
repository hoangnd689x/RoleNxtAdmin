package com.orgchart.orgchart.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.orgchart.orgchart.model.Competency;

/**
 * @author YOG1HC
 *
 */
@Transactional
public interface CompetencyService {
	
	 List<Competency> GetAllCompetencies();
	 
	 List<Competency> GetAllPureCompetencies();
	 
	 List<Competency> GetCompetenciesByDomainId(long id);
	 
	 Competency GetCompById(long id);
	 
	 boolean DeleteComp(long id);
	 
	 boolean UpdateComp(Competency compUpdate);
	 
	 public boolean AddComp(Competency compUpdate);
}
