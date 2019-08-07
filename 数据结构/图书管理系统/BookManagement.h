#include <iostream>
#include <string>
using namespace std;

#define MAXSIZE 100
#define ERROR 0

typedef struct{
	string *ISBN;
	string *name;
	int *price;
	int length;
}SqList;

//˳���ĳ�ʼ��
int InitSqList(SqList &L){
	L.ISBN= new string[MAXSIZE];
	L.name= new string[MAXSIZE];
	L.price= new int[MAXSIZE];
	if(!L.ISBN || !L.name || !L.price)
		return(ERROR);
	L.length= 0;
	return 1;
} 

//����˳������� 
void CreateSqList(SqList &L){
	int i=0, n=0;
	cout<<"����ͼ��������";
	cin>>n;
	cout<<"����ͼ����Ϣ��"<<endl;
	while(n) {
		cin>>L.ISBN[i]>>L.name[i]>>L.price[i];
		++L.length;
		i++;
		n--;
	}
}

//˳���ĳ���
int SqListLength(SqList L){
	return L.length;
}

//˳���Ĳ���
int LocateElem(SqList L, string ISBN){
	int i;
	for(i=0; i<L.length; i++)
		if(L.ISBN[i] == ISBN) return i+1;
	return ERROR;
}

//˳���Ĳ���
int SqListInsert(SqList &L, int i, SqList L1 ){
	if((i<1) || (i>L.length+1)) return ERROR;
	if(L.length== MAXSIZE) return ERROR;
	int j;
	for(j=L.length-1; j>=i-1; j--){
		L.ISBN[j+1]= L.ISBN[j];
		L.name[j+1]= L.name[j];
		L.price[j+1]= L.price[j];
	}
	L.ISBN[i-1]= L1.ISBN[0];
	L.name[i-1]= L1.name[0];
	L.price[i-1]= L1.price[0];
	++L.length;
	return 1;
} 

//˳����ɾ��
int SqListDelete(SqList &L, string ISBN){
	int j;
	int i= LocateElem(L, ISBN);
	for(j=i; j<=L.length-1; j++){
		L.ISBN[j-1]= L.ISBN[j];
		L.name[j-1]= L.name[j];
		L.price[j-1]= L.price[j];
	}
	--L.length;
	return 1;
} 

//ͼ����ϢISBN���޸�
int SqListChange_ISBN(SqList &L, string ISBN, string ISBN_1){
	int i= LocateElem(L, ISBN);
	L.ISBN[i-1]= ISBN_1;
	return 1; 
}

//ͼ����Ϣ�������޸�
int SqListChange_name(SqList &L, string ISBN, string name_1){
	int i= LocateElem(L, ISBN);
	L.name[i-1]= name_1;
	return 1; 
}

//ͼ����Ϣ�۸���޸�
int SqListChange_price(SqList &L, string ISBN, int price_1){
	int i= LocateElem(L, ISBN);
	L.price[i-1]= price_1;
	return 1; 
}

//���˳������� 
void Output(SqList L){
	cout<<"ͼ��������鼮��Ϣ��----------------------"<<endl; 
	for(int i=0; i<L.length; i++){
		cout<< L.ISBN[i]<<" "<< L.name[i]<<" "<< L.price[i];
//		if(i!= L.length-1)
			cout<<endl;
	}
	cout<<endl;
}

//��˳������򣨴�С����,��ͼ��ļ۸����򣺣� 
void SortSqList(SqList &L){
	string I_temp;
	string n_temp;
	int p_temp;
	for(int i=0; i<L.length-1; i++)
		for(int j=i+1; j<L.length; j++)
			if(L.price[i]> L.price[j]){
				
				I_temp= L.ISBN[i];
				L.ISBN[i]= L.ISBN[j];
				L.ISBN[j]= I_temp;
				
				n_temp= L.name[i];
				L.name[i]= L.name[j];
				L.name[j]= n_temp;
				
				p_temp= L.price[i];
				L.price[i]= L.price[j];
				L.price[j]= p_temp;
			}
}
