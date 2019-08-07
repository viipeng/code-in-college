#include<iostream>
#include<string>
#include "DataDefine.h"
#define N 4
using namespace std;

int main(){
	char left[10]={'S','U','V','Q'};//��̬������ڵ�һλ
	string right[10]={"aU|bV","bV|aQ","aU|bQ","aQ|bQ"};
	char end[N]={'Q'};//��̬�ļ���
	RightLine rl[N];
	for(int i=0; i<N; i++){
		rl[i].set(left[i], right[i]);
	}
	SituationGraph sg;
	sg.set(rl, end);
//	sg.print();
/*	for(int j=0; j<N; j++){
		rl[j].printRightLine();
		rl[j].printRoute();
	}*/
	string strIn;
	cout<<"���룺";
	cin>>strIn;
	bool a= sg.query(strIn);
	if(a) 
		cout<<"YES!"<<endl;
	else 
		cout<<"NO!"<<endl;

	system("pause");
	return 0;
};
