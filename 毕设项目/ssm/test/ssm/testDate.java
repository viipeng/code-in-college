package ssm;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.digital.pojo.OrderInfo;

public class testDate {

	@Test
	public void testDate1(){
		Date date= new Date();
		System.out.println(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		try {
			Date timeDate= format.parse(time);
			System.out.println(time);
//			System.out.println(date);
			System.out.println(timeDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDate2(){
		long currentTimeMillis= System.currentTimeMillis();
		Date date= new Date(currentTimeMillis);
		Time time= new Time(currentTimeMillis);
		String datetime= date.toString() +" "+ time.toString();
		System.out.println(date);
		System.out.println(time);
		System.out.println(datetime);
	}
	
	@Test
	public void testDate3() throws ParseException{
		Date date= new Date();
		SimpleDateFormat sp= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date= sp.parse(sp.format(date));
		System.out.println(date);
	}
	
	@Test
	public void testDate4(){
		String evaluation="2";
		int evaluation1= Integer.valueOf(evaluation).intValue();
		System.out.println(evaluation);
		if(evaluation1==2)
			System.out.println(evaluation1);
	}

	@Test
	public void testDate5() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这里的时间格式任意
		int year=2019, month=4, day=3;
		Date begin = format.parse("2019-04-03 00:00:00"); 
		Date end = format.parse("2019-04-05 00:00:00"); 
		Date now = format.parse(year+"-"+month+"-"+day+" 00:00:00");
		if(isBetweenTwoDate(now, begin, end)){
			System.out.println("在"); 
		}
		else{
			System.out.println("不在"); 
		}
	}
	
	public boolean isBetweenTwoDate(Date date, Date startDate, Date endDate) { 
		if(date.equals(startDate))
			return true;
		else
			return startDate.before(date) && endDate.after(date); 
	}
	
	@Test
	public void getYear() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		System.out.println("今年是"+year+"年");
	}
	
	@Test
	public void getToday() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String day = String.valueOf(date.get(Calendar.DATE));
		System.out.println("今天是"+year+"年"+month+"月"+day+"号");
	}

	@Test
	public void getTodayOnHMS() throws ParseException {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String today = String.valueOf(date.get(Calendar.DATE));
		String tomorrow = String.valueOf(date.get(Calendar.DATE)+1);//明天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = format.parse(year+"-"+month+"-"+today+" 00:00:00");
		Date end = format.parse(year+"-"+month+"-"+tomorrow+" 00:00:00");
		Date now = date.getTime();
//		Date now = format.parse(year+"-"+month+"-"+today+" 09:00:00");
		if(isBetweenTwoDate(now, begin, end)){
			System.out.println("在"); 
		}
		else{
			System.out.println("不在"); 
		}
		System.out.println("今天是"+year+"年"+month+"月"+today+"号");
		System.out.println(begin);
		System.out.println(end);
		System.out.println(now);
	}

	@Test
	public void convertToday() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		String month = String.valueOf(date.get(Calendar.MONTH)+1);
		String day = String.valueOf(date.get(Calendar.DATE));
		System.out.println("今天是"+year+"年"+month+"月"+day+"号");
	}

}
