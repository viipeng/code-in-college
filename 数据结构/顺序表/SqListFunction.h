#include<iostream>
#include<math.h>
using namespace std;

#define MAXSIZE 100
#define ERROR 0

//顺序表的定义 
typedef struct{
	int *elem;
	int length;
}SqList;

//顺序表的初始化
int InitSqList(SqList &L){
	L.elem= new int[MAXSIZE];
	if(!L.elem)
		return(ERROR);
	L.length= 0;
	return 1;
} 

//创建顺序表数据 
void CreateSqList(SqList &L, int n[]){
	int i=0;
	while(n[i]){
		L.elem[i]= n[i];
		++L.length;
		i++;
	}
} 

//顺序表的长度
int SqListLength(SqList L){
	return L.length;
}

//顺序表的取值
int GetElem(SqList L, int i, int &e){
	if(i<1 || i>L.length) return ERROR;
	e= L.elem[i-1];
	return 1;
} 

//顺序表的查找
int LocateElem(SqList L, int e){
	int i;
	for(i=0; i<L.length; i++)
		if(L.elem[i]== e) return i+1;
	return ERROR;
}

//顺序表的插入
int SqListInsert(SqList &L, int i, int e){
	if((i<1) || (i>L.length+1)) return ERROR;
	if(L.length== MAXSIZE) return ERROR;
	int j;
	for(j=L.length-1; j>=i-1; j--)
		L.elem[j+1]= L.elem[j];
	L.elem[i-1]= e;
	++L.length;
	return 1;
} 

//顺序表的删除
int SqListDelete(SqList &L, int i){
	if((i<1) || (i>L.length)) return ERROR;
	int j;
	for(j=i; j<=L.length-1; j++)
	L.elem[j-1]= L.elem[j];
	--L.length;
	return 1;
} 

//合并两个顺序表(没有排序） 
void MergeSqList(SqList &LA, SqList LB){
	int m= SqListLength(LA);
	int n= SqListLength(LB);
	int i,e;
	for(i=1; i<=n; i++){
		GetElem(LB,i,e);
		if(!LocateElem(LA,e))
			SqListInsert(LA,++m,e);
	}
}

//输出顺序表数据 
void OutputSqList(SqList L){
	for(int i=0; i<L.length; i++){
		cout<<L.elem[i];
		if(i!= L.length-1)
			cout<<" ";
	}
}

//给顺序表排序（从小到大） 
void SortSqList_inc(SqList &L){
	int temp= 0;
	for(int i=0; i<L.length-1; i++)
		for(int j=i+1; j<L.length; j++)
			if(L.elem[i]> L.elem[j]){
				temp= L.elem[i];
				L.elem[i]= L.elem[j];
				L.elem[j]= temp;
			}
}

//给顺序表排序（从大到小） 
void SortSqList_dec(SqList &L){
	int temp= 0;
	for(int i=0; i<L.length-1; i++)
		for(int j=i+1; j<L.length; j++)
			if(L.elem[i]< L.elem[j]){
				temp= L.elem[i];
				L.elem[i]= L.elem[j];
				L.elem[j]= temp;
			}
}

