package LL1;

import java.util.*;
import java.lang.String;


public class Analyze {

	private	Stack inputStack;
	private Stack analyzeStack;
	private String predictAnalyzeGraph[][];//[A1+1][M1+1]
	private RightLine rl[];//[N1]
	private String reasonProcess;
	Variable v;

	public void initialize(String str[][], RightLine r[]){
		v= new Variable();
		reasonProcess= new String();
		predictAnalyzeGraph= new String[v.getA1()+1][v.getM1()+1];
		rl= new RightLine[v.getN1()];
		inputStack= new Stack();
		analyzeStack= new Stack();
		for(int i=0; i< v.getN1(); i++){
			rl[i]= new RightLine();
		}
		for(int i=0; i<= v.getA1(); i++)
			for(int j=0; j<= v.getM1(); j++){
				predictAnalyzeGraph[i][j]= new String();
				predictAnalyzeGraph[i][j]+= str[i][j];
			}
		for(int i=0; i< v.getN1(); i++)
			rl[i]= r[i];
	}
	
	public void analyze(char left[]){
		reasonProcess+= left[0];
		char X,a;
		String input;
		inputStack.push('#');
		analyzeStack.push('#');
		Scanner sc= new Scanner(System.in);
		System.out.print("输入字符串： ");
		input= sc.nextLine();
		System.out.println("总控结果：");
		System.out.println("分析栈\t剩余串\t产生式\t");
		char []t= input.toCharArray();
		for(int i= input.length()-1; i>= 0; i--){
			inputStack.push(t[i]);
		}
		analyzeStack.push(left[0]);
		int num= -1;
		while(true){//别忘了读入下一个符号需要改变a
			//输出分析栈里的数据
			String str1= new String();
			do{
				str1+= analyzeStack.pop();
			}while(!analyzeStack.isEmpty());
			for(int i= str1.length()-1; i>= 0; i--)
				System.out.print(str1.charAt(i));
			System.out.print("\t");
			for(int i= str1.length()-1; i>= 0; i--)
				analyzeStack.push(str1.charAt(i));
			
			//输出输入栈里的数据
			String str2= new String();
			do{
				str2+= inputStack.pop();
			}while(!inputStack.isEmpty());
			for(int i=0; i< str2.length(); i++)
				System.out.print(str2.charAt(i));
			System.out.print("\t");
			for(int i= str2.length()-1; i>= 0; i--)
				inputStack.push(str2.charAt(i));
			
			num++;//每次循环num都要加1，num指的是循环的总次数，也是总控程序的行数
			a= (char)inputStack.peek();//a是符号栈的栈顶元素
			X= (char)analyzeStack.peek();//X是分析栈的栈顶元素
			if(isVT(X)){
				if(X == a){
					System.out.println(a + "匹配\t");
					inputStack.pop();
					analyzeStack.pop();
					continue;
				}
				else{
					System.out.println("出错1");
					break;
				}
			}
			else{
				if(X == '#'){
					if(X == a){
						System.out.println("接受");
						break;
					}
					else{
						System.out.println("出错2");
						break;
					}
				}
				else{
					if(testAnalyzeStack(a, X)){
						int i1= 0, j1= 0;
						for(int i=1; i<= v.getA1(); i++){//行
							int b1= predictAnalyzeGraph[i][0].indexOf(X);
							if(b1 != -1){
								for(int j=1; j<= v.getM1(); j++){//列
									int b2= predictAnalyzeGraph[0][j].indexOf(a);
									if(b2 != -1){
										i1= i;
										j1= j;
									}
								}
							}
						}
						antiPush(i1, j1);
						String add= new String();
						add+= predictAnalyzeGraph[i1][0];
						add+= "->";
						add+= predictAnalyzeGraph[i1][j1];
						addReasonProcess(add);
						System.out.println(predictAnalyzeGraph[i1][0] + "->" 
						+ predictAnalyzeGraph[i1][j1] + "\t");
						continue;
					}
					else{
						System.out.println("出错3");
						break;
					}
				}
			}
		}
		
	}
	//给reasonProcess字符串添加数据
	public void addReasonProcess(String add){
		int sign= find(reasonProcess);
		if(sign!= 0){
			int i= findVN(add.charAt(0));//相应非终结符的位置
			int k= find(reasonProcess);//字符>的位置的后一位
			String tempf= new String();
			String templ= new String();
			for(int j=k; j< reasonProcess.length(); j++){
				if(j<i){
					tempf+= reasonProcess.charAt(j);
				}
				if(j>i){
					templ+= reasonProcess.charAt(j);
				}
			}
			reasonProcess+= "->";
			if(!tempf.isEmpty()){
				reasonProcess+= tempf;
			}
			if(add.charAt(3)!= '0'){
				for(int j=3; j<add.length(); j++){
					reasonProcess+= add.charAt(j);
				}
			}
			if(!templ.isEmpty()){
				reasonProcess+= templ;
			}
		}
		else{//如果此时字符串reasonProcess中只有开始符号
			for(int i=1; i< add.length(); i++){
				reasonProcess+= add.charAt(i);
			}
		}
	}
	//查找reasonProcess,从后往前找出最近的一个符合要求的非终结符,并返回该非终结符的位置
	public int findVN(char vn){
		int end= find(reasonProcess);
		for(int i= reasonProcess.length()-1; i>= end; i--){
			if(reasonProcess.charAt(i)== vn){
				return i;
			}
		}
		return -1;
	}
	//查找reasonProcess,从后往前找出最近的一个“—>”符号,并返回->后面的第一次字符的位置
	public int find(String str){
		for(int j= str.length()-1; j>= 0; j--){
			if(str.charAt(j)== '>'){
				return j+1;
			}
		}
		return 0;//开始符号的位置
	}
	//打印推导过程
	public void printReasonProcess(){
		System.out.print("推导过程：");
		System.out.println(reasonProcess);
	}
	//打印预测分析表
	public void printAnalyzeGraph(){
		for(int i=0; i<= v.getA1(); i++){
			for(int j=0; j<= v.getM1(); j++){
				if(!predictAnalyzeGraph[i][j].equals("-1"))
					System.out.print(predictAnalyzeGraph[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	//测试是否是产生式
	//测试M[X,a]是否在预测分析表中
	public boolean testAnalyzeStack(char a, char X){
		for(int i=1; i<= v.getA1(); i++){//行
			int b1= predictAnalyzeGraph[i][0].indexOf(X, 0);
			if(b1 != -1){
				for(int j=1; j<= v.getM1(); j++){//列
					int b2= predictAnalyzeGraph[0][j].indexOf(a, 0);
					if(b2 != -1){
						return true;
					}
				}
			}
		}
		return false;
	}
	//逆序入栈
	//把匹配成功的产生式右部压入分析栈中，不过要逆序
	public void antiPush(int i, int j){
		analyzeStack.pop();
		//当分析栈的栈顶元素推到空串时，不用把空串压入分析栈
		if(!predictAnalyzeGraph[i][j].equals("0")){
			for(int k= predictAnalyzeGraph[i][j].length()-1; k>= 0; k--){
				analyzeStack.push(predictAnalyzeGraph[i][j].charAt(k));
			}
		}
	}	
	//是否是终结符
	public boolean isVT(char c){
		for(int i=1; i< v.getM1(); i++){
			int a= predictAnalyzeGraph[0][i].indexOf(c);
			if(a!= -1){
				return true;
			}
		}
		return false;
	}

	public Stack getInputStack() {
		return inputStack;
	}
	public void setInputStack(Stack inputStack) {
		this.inputStack = inputStack;
	}
	public Stack getAnalyzeStack() {
		return analyzeStack;
	}
	public void setAnalyzeStack(Stack analyzeStack) {
		this.analyzeStack = analyzeStack;
	}	
	public String[][] getPredictAnalyzeGraph() {
		return predictAnalyzeGraph;
	}
	public void setPredictAnalyzeGraph(String[][] predictAnalyzeGraph) {
		this.predictAnalyzeGraph = predictAnalyzeGraph;
	}
	public RightLine[] getRl() {
		return rl;
	}
	public void setRl(RightLine[] rl) {
		this.rl = rl;
	}
}
