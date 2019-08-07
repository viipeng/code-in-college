#include <iostream>
using namespace std;

#define MAXSIZE 100
#define ERROR 0


//单链表的定义
typedef struct LNode{
	int data;
	struct LNode *next;
}LNode,*LinkList;

//单链表的初始化
void InitLinkList(LinkList &L){
	L= new LNode;
	L->next= NULL;
} 

//创建单链表数据 
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

//单链表的取值
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

//单链表的查找
LNode *LocateElem(LinkList L, int e){ //查找成功后会返回  e 值所在的指针（地址），e 为单链表内的某个值 
	LinkList p= L->next;			  //如果插入失败，程序会出现.exe文件停止运行的错误 
	while(p && p->data!=e)
	p= p->next;
	return p;
} 

//单链表的插入
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

//单链表的删除
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

//合并两个单链表 （已经排序了，前提是输入的数据必须是已经排好了序的） 
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

//输出单链表 
void OutputLinkList(LinkList L){
	LinkList p= L->next;
	while(p){
		cout<<p->data;
		if(p->next)
			cout<<" ";
		p= p->next;
	}
}

//给单链表排序（从小到大） 
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




