package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.EvaluationDAO;
import com.digital.dao.OrderInfoDAO;
import com.digital.pojo.Evaluation;
import com.digital.pojo.ForSearchOfRid;
import com.digital.service.EvaluationService;

@Service("EvaluationService")
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDAO evaluationDao;
	
	@Override
	public List<Evaluation> getEvaluationByRid(int rid) {
		return evaluationDao.getEvaluationByRid(rid);
	}

	@Override
	public void addEvaluation(Evaluation evaluation) {
		evaluationDao.addEvaluation(evaluation);
	}

	@Override
	public List<Evaluation> getAllEvaluation() {
		return evaluationDao.getAllEvaluation();
	}

	@Override
	public List<Evaluation> getEvaluationByEid(int eid) {
		return evaluationDao.getEvaluationByEid(eid);
	}

	@Override
	public List<Evaluation> getEvaluationByEidOfRid(ForSearchOfRid fe){
		return evaluationDao.getEvaluationByEidOfRid(fe);
	}

	@Override
	public void deleteEvaluation(int eid) {
		evaluationDao.deleteEvaluation(eid);
	}

	@Override
	public void updateEvaluation(Evaluation evaluation) {
		evaluationDao.updateEvaluation(evaluation);
	}

}
