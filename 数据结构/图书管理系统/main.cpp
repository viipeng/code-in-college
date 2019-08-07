#include <iostream>
#include "BookManagement.h"
using namespace std;

int main(){
	SqList L;
	InitSqList(L);
	CreateSqList(L);
	Output(L);
	SortSqList(L);
	Output(L);
//	system("pause");
	return 0;
}
//修改的操作
//	Output(L);
//	cout<<endl;
//	string str1= "kn";
//	int price= 100;
//	SqListChange_price(L, str1, price); 

//删除的操作
//	Output(L);
//	string str= "mz";
//	SqListDelete(L, str);
//	cout<<endl; 

//插入的操作 
//	Output(L);
//	cout<<endl;
//	SqList L1;
//	InitSqList(L1);
//	CreateSqList(L1);
//	SqListInsert(L, 3, L1);

//查询的操作 
//	int i= LocateElem(L, 2);
//	cout<<i<<endl;
//	cout<<L.ISBN[i-1]<<" "<<L.name[i-1]<<" "<<L.price[i-1]<<" "<<endl; 
