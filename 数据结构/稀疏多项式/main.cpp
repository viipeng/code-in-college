#include <iostream>
#include "Function.h"
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	Polynomial PA, PB;
	int m=0, n=0;
	cout<<"�����һ������ʽ��ϵ���ĸ�����";
	cin>>m;
	cout<<"�������ʽ��ϵ����ָ����";
	CreatePolyn(PA, m);
	cout<<"����ڶ�������ʽ��ϵ���ĸ�����";
	cin>>n;
	cout<<"�������ʽ��ϵ����ָ����";
	CreatePolyn(PB, n);
	AddPolyn(PA, PB);
	Output(PA);
//	cout<<endl;
//	system("pause");
	return 0;
}
