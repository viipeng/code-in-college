#include <iostream>
using namespace std;

#define MAXSIZE 100
#define ERROR 0


//������Ķ���
typedef struct LNode{
	int data;
	struct LNode *next;
}LNode,*LinkList;

//������ĳ�ʼ��
void InitLinkList(LinkList &L){
	L= new LNode;
	L->next= NULL;
} 

//�������������� 
void CreateLinkList(LinkList &L, int n[]){
	L= new LNode;
	L->next= NULL;
	LinkList r=L;
	int i=0;
	while(n[i]){
		LinkList p= new LNode;
		p->data= n[i];
		p->next= NULL;
		r->next= p;
		r=p;
		i++;
	}
}

//�������ȡֵ
int GetElem(LinkList L, int i, int &e){
	LinkList p= L->next;
	int j=1;
	while(p && j<i){
		p= p->next;
		++j;
	}
	if(!p || j>i) return ERROR;
	e= p->data;
	return 1;
} 

//������Ĳ���
LNode *LocateElem(LinkList L, int e){ //���ҳɹ���᷵��  e ֵ���ڵ�ָ�루��ַ����e Ϊ�������ڵ�ĳ��ֵ 
	LinkList p= L->next;			  //�������ʧ�ܣ���������.exe�ļ�ֹͣ���еĴ��� 
	while(p && p->data!=e)
	p= p->next;
	return p;
} 

//������Ĳ���
int LinkListInsert(LinkList &L, int i, int e){ 
	LinkList p= L;
	int j=0;
	while(p && (j<i-1)){
		p= p->next;
		++j;
	}
	if(!p || j>i-1) return ERROR;
	LinkList s= new LNode;
	s->data= e;
	s->next= p->next;
	p->next= s;
	return 1;
}

//�������ɾ��
int LinkListDelete(LinkList &L, int i){
	LinkList p= L;
	int j= 0;
	while((p->next) && (j<i-1)){
		p= p->next;
		++j;
	}
	if(!(p->next) || (j>i-1)) return ERROR;
	LinkList q= p->next;
	p->next= q->next;
	delete q;
	return 1;
} 

//�ϲ����������� ���Ѿ������ˣ�ǰ������������ݱ������Ѿ��ź�����ģ� 
void MergeLinkList_L(LinkList &LA, LinkList &LB, LinkList &LC){
	LinkList pa= LA->next;
	LinkList pb= LB->next;
	LC= LA;
	LinkList pc= LC;
	while(pa && pb){
		if(pa->data<= pb->data){
			pc->next= pa;
			pc= pa;
			pa= pa->next;
		}
		else{
			pc->next= pb;
			pc= pb;
			pb= pb->next;
		}
	}
	pc->next= pa?pa:pb;
	delete LB;
}

//��������� 
void OutputLinkList(LinkList L){
	LinkList p= L->next;
	while(p){
		cout<<p->data;
		if(p->next)
			cout<<" ";
		p= p->next;
	}
}

//�����������򣨴�С���� 
void SortLinkList(LinkList &L){
	LinkList s= L->next;
	while(s){
		LinkList p= s->next;
		while(p){
				int temp= 0;
			if(p->data< s->data){
				temp= p->data;
				p->data= s->data;
				s->data= temp;
			}
			p= p->next;
		}
		s= s->next;
	}
}




