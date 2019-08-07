#include<iostream>
using namespace std;

typedef struct PNode{
	float coef;
	int expn;
	struct PNode *next;
}PNode, *Polynomial;


//输入数据
void CreatePolyn(Polynomial &P, int n){
	P= new PNode;
	P->next= NULL;
	for(int i=1; i<=n; i++){
		Polynomial s= new PNode;
		cin>>s->coef>>s->expn;
		Polynomial pre= P;
		Polynomial q= P->next;
		while(q && q->expn< s->expn){
			pre= q;
			q= q->next;
		}
		s->next= q;
		pre->next= s;
	}
} 

//加法运算
void AddPolyn(Polynomial &Pa, Polynomial &Pb){
	Polynomial p1= Pa->next;
	Polynomial p2= Pb->next;
	Polynomial p3= Pa;
	Polynomial r;
	while(p1 && p2){
		if(p1->expn == p2->expn){
			float sum= p1->coef+ p2->coef;
			if(sum!= 0){
				p1->coef= sum;
				p3->next= p1;
				p3= p1;
				p1= p1->next;
				r= p2;
				p2= p2->next;
				delete r;
			}
			else{
				r= p1; p1= p1->next; delete r;
				r= p2; p2= p2->next; delete r;
			}
		}
		else if(p1->expn< p2->expn){
			p3->next= p1;
			p3= p1;
			p1= p1->next;
		}
		else{
			p3->next= p2;
			p3= p2;
			p2= p2->next;
		}
	}
	p3->next= p1?p1:p2;
	delete Pb;
}

//输出单链表 
void Output(Polynomial L){
	Polynomial p= L->next;
	while(p){
		cout<<p->coef<<" "<<p->expn;
		if(p->next)
			cout<<endl;
		p= p->next;
	}
}
