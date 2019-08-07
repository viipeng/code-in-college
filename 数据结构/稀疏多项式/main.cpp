#include <iostream>
#include "Function.h"
using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main() {
	Polynomial PA, PB;
	int m=0, n=0;
	cout<<"输入第一个多项式的系数的个数：";
	cin>>m;
	cout<<"输入多项式的系数和指数：";
	CreatePolyn(PA, m);
	cout<<"输入第二个多项式的系数的个数：";
	cin>>n;
	cout<<"输入多项式的系数和指数：";
	CreatePolyn(PB, n);
	AddPolyn(PA, PB);
	Output(PA);
//	cout<<endl;
//	system("pause");
	return 0;
}
