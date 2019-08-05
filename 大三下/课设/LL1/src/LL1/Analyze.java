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
		System.out.print("�����ַ����� ");
		input= sc.nextLine();
		System.out.println("�ܿؽ����");
		System.out.println("����ջ\tʣ�മ\t����ʽ\t");
		char []t= input.toCharArray();
		for(int i= input.length()-1; i>= 0; i--){
			inputStack.push(t[i]);
		}
		analyzeStack.push(left[0]);
		int num= -1;
		while(true){//�����˶�����һ��������Ҫ�ı�a
			//�������ջ�������
			String str1= new String();
			do{
				str1+= analyzeStack.pop();
			}while(!analyzeStack.isEmpty());
			for(int i= str1.length()-1; i>= 0; i--)
				System.out.print(str1.charAt(i));
			System.out.print("\t");
			for(int i= str1.length()-1; i>= 0; i--)
				analyzeStack.push(str1.charAt(i));
			
			//�������ջ�������
			String str2= new String();
			do{
				str2+= inputStack.pop();
			}while(!inputStack.isEmpty());
			for(int i=0; i< str2.length(); i++)
				System.out.print(str2.charAt(i));
			System.out.print("\t");
			for(int i= str2.length()-1; i>= 0; i--)
				inputStack.push(str2.charAt(i));
			
			num++;//ÿ��ѭ��num��Ҫ��1��numָ����ѭ�����ܴ�����Ҳ���ܿس��������
			a= (char)inputStack.peek();//a�Ƿ���ջ��ջ��Ԫ��
			X= (char)analyzeStack.peek();//X�Ƿ���ջ��ջ��Ԫ��
			if(isVT(X)){
				if(X == a){
					System.out.println(a + "ƥ��\t");
					inputStack.pop();
					analyzeStack.pop();
					continue;
				}
				else{
					System.out.println("����1");
					break;
				}
			}
			else{
				if(X == '#'){
					if(X == a){
						System.out.println("����");
						break;
					}
					else{
						System.out.println("����2");
						break;
					}
				}
				else{
					if(testAnalyzeStack(a, X)){
						int i1= 0, j1= 0;
						for(int i=1; i<= v.getA1(); i++){//��
							int b1= predictAnalyzeGraph[i][0].indexOf(X);
							if(b1 != -1){
								for(int j=1; j<= v.getM1(); j++){//��
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
						System.out.println("����3");
						break;
					}
				}
			}
		}
		
	}
	//��reasonProcess�ַ����������
	public void addReasonProcess(String add){
		int sign= find(reasonProcess);
		if(sign!= 0){
			int i= findVN(add.charAt(0));//��Ӧ���ս����λ��
			int k= find(reasonProcess);//�ַ�>��λ�õĺ�һλ
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
		else{//�����ʱ�ַ���reasonProcess��ֻ�п�ʼ����
			for(int i=1; i< add.length(); i++){
				reasonProcess+= add.charAt(i);
			}
		}
	}
	//����reasonProcess,�Ӻ���ǰ�ҳ������һ������Ҫ��ķ��ս��,�����ظ÷��ս����λ��
	public int findVN(char vn){
		int end= find(reasonProcess);
		for(int i= reasonProcess.length()-1; i>= end; i--){
			if(reasonProcess.charAt(i)== vn){
				return i;
			}
		}
		return -1;
	}
	//����reasonProcess,�Ӻ���ǰ�ҳ������һ������>������,������->����ĵ�һ���ַ���λ��
	public int find(String str){
		for(int j= str.length()-1; j>= 0; j--){
			if(str.charAt(j)== '>'){
				return j+1;
			}
		}
		return 0;//��ʼ���ŵ�λ��
	}
	//��ӡ�Ƶ�����
	public void printReasonProcess(){
		System.out.print("�Ƶ����̣�");
		System.out.println(reasonProcess);
	}
	//��ӡԤ�������
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
	//�����Ƿ��ǲ���ʽ
	//����M[X,a]�Ƿ���Ԥ���������
	public boolean testAnalyzeStack(char a, char X){
		for(int i=1; i<= v.getA1(); i++){//��
			int b1= predictAnalyzeGraph[i][0].indexOf(X, 0);
			if(b1 != -1){
				for(int j=1; j<= v.getM1(); j++){//��
					int b2= predictAnalyzeGraph[0][j].indexOf(a, 0);
					if(b2 != -1){
						return true;
					}
				}
			}
		}
		return false;
	}
	//������ջ
	//��ƥ��ɹ��Ĳ���ʽ�Ҳ�ѹ�����ջ�У�����Ҫ����
	public void antiPush(int i, int j){
		analyzeStack.pop();
		//������ջ��ջ��Ԫ���Ƶ��մ�ʱ�����ðѿմ�ѹ�����ջ
		if(!predictAnalyzeGraph[i][j].equals("0")){
			for(int k= predictAnalyzeGraph[i][j].length()-1; k>= 0; k--){
				analyzeStack.push(predictAnalyzeGraph[i][j].charAt(k));
			}
		}
	}	
	//�Ƿ����ս��
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
