package com.digital.service;

import java.util.List;

import com.digital.pojo.Evaluation;
import com.digital.pojo.ForSearchOfRid;

public interface EvaluationService {

	public List<Evaluation> getEvaluationByRid(int rid);

	public void addEvaluation(Evaluation evaluation);

	public List<Evaluation> getAllEvaluation();

	public List<Evaluation> getEvaluationByEid(int eid);

	public List<Evaluation> getEvaluationByEidOfRid(ForSearchOfRid fe);

	public void deleteEvaluation(int eid);

	public void updateEvaluation(Evaluation evaluation);

}
