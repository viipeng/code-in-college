#include <iostream>
#include "LinkListFunction.h"
using namespace std;


int main(){
	int arr1[10]= {3,5,9,11};
	int arr2[10]= {2,6,8,1,11,21,20};
	LinkList LA, LB, LC;
	InitLinkList(LA);
	InitLinkList(LB);
	InitLinkList(LC);
	CreateLinkList(LA, arr1);
	CreateLinkList(LB, arr2);
	MergeLinkList_L(LA, LB, LC);
	SortLinkList(LC);
	OutputLinkList(LC);
	cout<<endl;
	system("pause");
	return 0;
}


