#include <iostream>
#include <string>
#include "Define.h"
#include "Founction.h"
//#define N 5
using namespace std;
/*
	char left[10]=	 {'E',	'A',	 'T',	'B',	 'F'};//��̬������ڵ�һλ
	string right[10]={"TA", "+TA|0", "FB",  "*FB|0", "i|(E)"};//0�����*/
/*
	char left[10]=	 {'S',		'A',	'B',	'C',	'D'};//��̬������ڵ�һλ
	string right[10]={"AB|bC",  "b|0",  "aD|0", "AD|b", "aS|c"};//0�����*/
/*
	char left[10]=	 {'S',		'A',	'B',};//��̬������ڵ�һλ
	string right[10]={"B|b",   "b|0",  "a"};//0�����*/
int main(){
	RightLine rl[N];
	//�ı�left����ʱ��Ҫ��һ����ͷ�ļ��г���N�Ƿ����˱仯
	char left[10]=	 {'S',		'A',	'B',	'C',	'D'};//��̬������ڵ�һλ
	string right[10]={"AB|bC",  "b|0",  "aD|0", "AD|b", "aS|c"};//0�����
	for(int i=0; i<N; i++){
		rl[i].set(left[i], right[i]);
		rl[i].printRightLine();
	}
	cout<<endl;
	PredictAnalyzeGraph pag;
	pag.setPredictAnalyzeGraph(left, right);
	pag.setNounGraph();
	pag.calculateFirstSet();
	pag.printFristSet();
/*	string str="0ad";
	if(str[0] == '0'){
		cout<<"YES"<<endl;
	}*/
/*	string str= "0";
	string::size_type a;
	a= str.find_first_of('0', 0);
	if(a != str.npos){
		cout<<"�ҵ���"<<endl;
	}
	else{
		cout<<"û�ҵ�"<<endl;
	}*/
/*	string str= "adaf";
	string::size_type a;
	a= str.find_first_of('a', 0);
	cout<<str<<endl;
	if(a != str.npos)
		str.erase(a,1);
	cout<<str<<endl;*/
/*	string str="ads|dda";
	int n=0;
	n= str.find('|', 4);
	if(n == -1)
		cout<<"û�ҵ�"<<endl;
	else
		cout<<n<<endl;*/
/*	char a= '#';
	cout<<"a="<<a<<endl;
	if(pag.isVT(a)){
		cout<<"YES!"<<endl;
	}
	else{
		cout<<"NO!"<<endl;
	}*/
	system("pause");
	return 0;
}