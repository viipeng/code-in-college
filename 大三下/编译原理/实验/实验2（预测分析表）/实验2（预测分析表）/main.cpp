#include <iostream>
#include <string>
#include "Define.h"
#include "Founction.h"
//#define N 5
using namespace std;
/*
	char left[10]=	 {'E',	'A',	 'T',	'B',	 'F'};//初态必须放在第一位
	string right[10]={"TA", "+TA|0", "FB",  "*FB|0", "i|(E)"};//0代表空*/
/*
	char left[10]=	 {'S',		'A',	'B',	'C',	'D'};//初态必须放在第一位
	string right[10]={"AB|bC",  "b|0",  "aD|0", "AD|b", "aS|c"};//0代表空*/
/*
	char left[10]=	 {'S',		'A',	'B',};//初态必须放在第一位
	string right[10]={"B|b",   "b|0",  "a"};//0代表空*/
int main(){
	RightLine rl[N];
	//改变left数组时需要看一看在头文件中常量N是否发生了变化
	char left[10]=	 {'S',		'A',	'B',	'C',	'D'};//初态必须放在第一位
	string right[10]={"AB|bC",  "b|0",  "aD|0", "AD|b", "aS|c"};//0代表空
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
		cout<<"找到了"<<endl;
	}
	else{
		cout<<"没找到"<<endl;
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
		cout<<"没找到"<<endl;
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