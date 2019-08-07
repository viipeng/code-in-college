#include "SqListFunction.h"
#include<iostream>
using namespace std;

int main(){
	int n1[10]= {7,6,3,11};
	int n2[10]= {2,6,3};
	SqList LA, LB;
	InitSqList(LA);
	InitSqList(LB);
	CreateSqList(LA, n1);
	CreateSqList(LB, n2);
	MergeSqList(LA, LB);
	SortSqList_inc(LA);
	OutputSqList(LA);
	cout<<endl;
	system("pause");
	return 0;
}


