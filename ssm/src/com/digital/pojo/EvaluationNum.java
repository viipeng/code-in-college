package com.digital.pojo;

import java.util.List;

public class EvaluationNum {

	private List<Evaluation> evaluationList;
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
	private int sum;//总评价数
	private float rstar;//更新餐馆星级
	
	public EvaluationNum(){
		this.setOne(0);
		this.setTwo(0);
		this.setThree(0);
		this.setFour(0);
		this.setFive(0);
		this.setRstar(0);
	}

	public List<Evaluation> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<Evaluation> evaluationList) {
		this.evaluationList = evaluationList;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public float getRstar() {
		return rstar;
	}

	public void setRstar(float rstar) {
		this.rstar = rstar;
	}

	@Override
	public String toString() {
		return "EvaluationNum [evaluationList=" + evaluationList + ", one="
				+ one + ", two=" + two + ", three=" + three + ", four=" + four
				+ ", five=" + five + ", sum=" + sum + ", rstar=" + rstar + "]";
	}
		
}
