package com.digital.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.FoodInfoDAO;
import com.digital.dao.OrderInfoDAO;
import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.OrderInfo;
import com.digital.service.OrderInfoService;

@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService{

	@Autowired
	private OrderInfoDAO orderInfoDao;
	@Autowired
	private FoodInfoDAO foodInfoDao;

	@Override
	public int getOid() {
		return orderInfoDao.getOid();
	}
	@Override
	public void ordering(OrderInfo oi) {
		orderInfoDao.ordering(oi);
	}

	@Override
	public List<OrderInfo> getOrderInfoByUid(int uid) {
		return orderInfoDao.getOrderInfoByUid(uid);
	}

	@Override
	public List<OrderInfo> getEOrderByUid(int uid) {
		return orderInfoDao.getEOrderByUid(uid);
	}

	@Override
	public List<OrderInfo> getSOrderByUid(int uid) {
		return orderInfoDao.getSOrderByUid(uid);
	}

	@Override
	public List<OrderInfo> getPOrderByUid(int uid) {
		return orderInfoDao.getPOrderByUid(uid);
	}

	@Override
	public List<OrderInfo> getROrderByUid1(int uid) {
		return orderInfoDao.getROrderByUid1(uid);
	}

	@Override
	public List<OrderInfo> getROrderByUid2(int uid) {
		return orderInfoDao.getROrderByUid2(uid);
	}

	@Override
	public List<OrderInfo> getOrderInfoByRid(int rid) {
		return orderInfoDao.getOrderInfoByRid(rid);
	}

	@Override
	public List<OrderInfo> getEOrderByRid(int rid) {
		return orderInfoDao.getEOrderByRid(rid);
	}

	@Override
	public List<OrderInfo> getSOrderByRid(int rid){
		return orderInfoDao.getSOrderByRid(rid);
	}

	@Override
	public List<OrderInfo> getPOrderByRid(int rid){
		return orderInfoDao.getPOrderByRid(rid);
	}

	@Override
	public List<OrderInfo> getROrderByRid1(int rid){
		return orderInfoDao.getROrderByRid1(rid);
	}

	@Override
	public List<OrderInfo> getROrderByRid2(int rid){
		return orderInfoDao.getROrderByRid2(rid);
	}

	@Override
	public void inVisibleOrder(int oid) {
		orderInfoDao.inVisibleOrder(oid);
	}

	@Override
	public void isSent(int oid) {
		orderInfoDao.isSent(oid);
	}

	@Override
	public void havePaid(int oid) {
		orderInfoDao.havePaid(oid);
	}

	@Override
	public void haveRefund(int oid) {
		orderInfoDao.haveRefund(oid);
	}

	@Override
	public void evaluate(int oid) {
		orderInfoDao.evaluate(oid);
	}

	/*@Override
	public void addOrder(int uid, int fid) {
		Date date= new Date();
		String time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		OrderInfo oi= new OrderInfo();
		int mid= foodInfoDao.getMidByFid(fid);
		int rid= meauInfoAddDao.getRidByMid(mid);
		int did= delivererInfoDao.getDidByRid(rid);
		oi.setOstate("途中");
		oi.setOdate(time);
		oi.setUid(uid);
		oi.setDid(did);
		oi.setRid(rid);
		oi.setMid(mid);
		oi.setFid(fid);
		orderInfoDao.addOrder(oi);
	}*/

	/*@Override
	public void updateOrder(int oid, int evaluation) {
		OrderInfo oi= new OrderInfo();
		oi.setOid(oid);
		oi.setOstate("送达");
		oi.setOevaluation(evaluation);
		int fid= orderInfoDao.getFidByOid(oid);
//		updateScoreAndFevaluation(fid, evaluation);
		orderInfoDao.updateOrder(oi);
	}*/
	
	/*public void updateScoreAndFevaluation(int fid, int oevaluation){
		FoodInfo fi= new FoodInfo();
		int fevaluation= foodInfoDao.getFevaluationByFid(fid);
		int score= foodInfoDao.getScoreByFid(fid);
		if(oevaluation== 0 || oevaluation== fevaluation){
			//用户没有评价，不用理会
		}
		else if(oevaluation<= 5){
			if(oevaluation< fevaluation){
				score-= fevaluation-oevaluation;
			}
			else if(oevaluation> fevaluation){
				score+= oevaluation-fevaluation;
			}
		}
		else{//当评价大于5时，按5计算
			if(fevaluation== 5){
				
			}
			else if(fevaluation< 5){
				score+= 5-fevaluation;
			}
		}
		//经过上面的选择判断，score不可能超过15，fevaluation=5星的标准就是score=15
		if(score== 15){
			fevaluation= 5;
		}
		else if(score>= 10){
			fevaluation= 4;
		}
		else if(score>= 6){
			fevaluation= 3;
		}
		else if(score>= 3){
			fevaluation= 2;
		}
		else{
			fevaluation= 1;
		}
		fi.setFid(fid);
		fi.setScore(score);
		fi.setFevaluation(fevaluation);
		foodInfoDao.updateScoreAndFevaluation(fi);
	}*/
	
	@Override
	public List<OrderInfo> getOrderInfoByoid(int oid) {
		return orderInfoDao.getOrderInfoByoid(oid);
	}

	@Override
	public List<OrderInfo> getOrderInfoByoidOfRid(ForSearchOfRid fe) {
		return orderInfoDao.getOrderInfoByoidOfRid(fe);
	}

	@Override
	public List<OrderInfo> getOrderInfo() {
		return orderInfoDao.getOrderInfo();
	}

	@Override
	public void addOrderInfo(OrderInfo oi) {
		orderInfoDao.addOrderInfo(oi);
	}

	@Override
	public void deleteOrderInfo(int oid) {
		orderInfoDao.deleteOrderInfo(oid);
	}

	@Override
	public void updateOrderInfo(OrderInfo oi) {
		orderInfoDao.updateOrderInfo(oi);
	}
	
	@Override
	public void addOrder(int uid, int fid) {
		
	}
	
	@Override
	public void updateOrder(int oid, int evaluation) {
		
	}

	@Override
	public void appealRefund(int oid) {
		orderInfoDao.appealRefund(oid);
	}

	@Override
	public void cancelRefund(int oid) {
		orderInfoDao.cancelRefund(oid);
	}

	@Override
	public void permitRefund(int oid) {
		orderInfoDao.permitRefund(oid);
	}

	@Override
	public void refuseRefund(int oid) {
		orderInfoDao.refuseRefund(oid);
	}
	
}
