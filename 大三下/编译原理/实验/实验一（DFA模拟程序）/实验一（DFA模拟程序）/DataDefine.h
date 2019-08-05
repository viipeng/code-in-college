#include<iostream>
#include<string>
#define N 4
//#include "function.h"
using namespace std;

class RightLine{
	
	char left;
	string right;
	char nrouteA,nrouteB;
	char nextA,nextB;

	public:
		void set(char c, string str){
			left= c;
			right= str;
			nrouteA= right[0];
			nrouteB= right[3];
			nextA= right[1];
			nextB= right[4];
		}
		string getright(){
			string str= right;
			return str;
		}
		char getleft(){
			char c= left;
			return c;
		}
/*		void printRightLine(){
			cout<<left<<"->"<<right<<endl;
		}
		void printRoute(){
			cout<<nrouteA<<nextA<<" "<<nrouteB<<nextB<<endl;
		}*/
};
class SituationGraph{

	RightLine rl[N];
	char end[N];

	public:
		void set(RightLine r[], char ch[]){
			for(int i=0; i<N; i++){
				rl[i]= r[i];
			}
			for(int j=0; j<N; j++){
				end[j]= ch[j];
			}
		}
/*		void print(){
			for(int j=0; j<N; j++){
				rl[j].printRightLine();
			}
		}*/
		//�ж��ַ����Ƿ����ڸ�����
		bool query(string str){
			int i=0;//�ַ����������㵽��λ��
			int sign= 0;//��������ʱ��״̬������λ��
			int length= str.length();
//			cout<<length<<endl;
			while(i<= length){//����string�ĳ����ж�
				if(rl[sign].getright()[0] == str[i]){
					sign = find(rl[sign].getright()[1]);
				}
				else if(rl[sign].getright()[3] == str[i]){
					sign = find(rl[sign].getright()[4]);
				}
				i++;
			}
			if(isEnd(rl[sign].getleft()))
				return true;
			else 
				return false;
		}
		//�ҵ���һ��״̬
		int find(char c){
			for(int i=0; i<N; i++){
				if(c == rl[i].getleft())
					return i;
			}
			return -1;
		}
		bool isEnd(char c){
			int i=0;
			while(i<N){
				if(c == end[i])
					return true;
				i++;
			}
			return false;
		}
};