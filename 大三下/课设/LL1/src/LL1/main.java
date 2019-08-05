package LL1;

//#define N1 8//产生式的个数
//#define M1 6//终结符的个数（包括‘#’)
//#define A1 5//非终结符的个数

import java.util.*;
import java.lang.String;

public class main {

	public static void main(String[] args) {
		Variable v= new Variable();
		char left[]=	      { 'E',  'A',  'A',  'T',  'B',   'B',   'F',   'F'};//初态必须放在第一位
		String right[]=	      {"TA", "+TA", "0",  "FB", "*FB", "0",   "(E)", "i"};//0代表空[N1]
		String selectSet[]=   {"(i", "+",   ")#", "(i", "*" ,  "+)#", "(",   "i"};//[N1]
		String predictAnalyzeGraph[][]= {  {"-1", "i",  "+",   "*",   "(",   ")", "#"},//[A1+1][M1+1]
		/*N-2的意思是有2个重复的非终结符*/	       {"E",  "TA", "-1",  "-1",  "TA",  "-1", "-1"},
										   {"A",  "-1", "+TA", "-1",  "-1",  "0",  "0"},
										   {"T",  "FB", "-1",  "-1",  "FB",  "-1", "-1"},
										   {"B",  "-1", "0",   "*FB", "-1",  "0",  "0"},
										   {"F",  "i",  "-1",  "-1",  "(E)", "-1", "-1"} };
		
		RightLine rl[]= new RightLine[v.getN1()];
		for(int i=0; i< v.getN1(); i++){
			rl[i]= new RightLine();
			rl[i].setLeft(left[i]);
			rl[i].setRight(right[i]);
		}
		Analyze ana= new Analyze();
		ana.initialize(predictAnalyzeGraph, rl);
//		System.out.println("预测分析表：");
//		ana.printAnalyzeGraph();
		ana.analyze(left);
		ana.printReasonProcess();
	}

}
