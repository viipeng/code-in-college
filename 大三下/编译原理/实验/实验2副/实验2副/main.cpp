// ʵ��2��ֻ��û��first...��.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include <iostream>
#include "Define.h"
#include <string>
//#define N1 8//����ʽ�ĸ���
//#define M1 6//�ս���ĸ�����������#��)
//#define A1 5//���ս���ĸ���
using namespace std;


int main(){
	char left[N1]=	      { 'E',  'A',  'A',  'T',  'B',   'B',   'F',   'F'};//��̬������ڵ�һλ
	string right[N1]=	  {"TA", "+TA", "0",  "FB", "*FB", "0",   "(E)", "i"};//0�����
	string selectSet[N1]= {"(i", "+",   ")#", "(i", "*" ,  "+)#", "(",   "i"};
	string predictAnalyzeGraph[A1+1][M1+1]={  {"-1", "i",  "+",   "*",   "(",   ")", "#"},
	/*N-2����˼����2���ظ��ķ��ս��*/	   {"E",   "TA", "-1",  "-1",  "TA",  "-1", "-1"},
										   {"A",   "-1", "+TA", "-1",  "-1",  "0",  "0"},
										   {"T",   "FB", "-1",  "-1",  "FB",  "-1", "-1"},
										   {"B",   "-1", "0",   "*FB", "-1",  "0",  "0"},
										   {"F",   "i",  "-1",  "-1",  "(E)", "-1", "-1"} };
	RightLine rl[N1];
	for(int i=0; i< N1; i++){
		rl[i].set(left[i], right[i]);
		rl[i].printRightLine();
	}
	Analyze ana;
	ana.set(predictAnalyzeGraph, rl);
	ana.printAnalyzeGraph();
	ana.analyze(left);
/*	for(int i=1; i<=M1; i++){
			int a= predictAnalyzeGraph[0][i].find('+', 0);
			cout<<"X3="<<a<<endl;
			if(a!= predictAnalyzeGraph[0][i].npos){
				cout<<"YES"<<endl;
			}
			else{
				cout<<"NO"<<endl;
			}
		}*/
/*	char c= 'a';
	if(c == 'a')
		cout<<"YES"<<endl;
	else
		cout<<"NO"<<endl;*/
	system("pause");
	return 0;
}

