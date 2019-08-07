#include <iostream>
#include <stack>
#include <string>
using namespace std;
#define N1 8//����ʽ�ĸ���
#define M1 6//�ս���ĸ�����������#��)
#define A1 5//���ս���ĸ���
class RightLine{

public:
		void set(char s1, string s2){
			left= s1;
			right= s2;
		}
		string getright(){
			string str= right;
			return str;
		}
		char getleft(){
			char c= left;
			return c;
		}
		void printRightLine(){
			cout<<left<<"->"<<right<<endl;
		}
		
private:
		char left;
		string right;
};
class Analyze{

public:
	void set(string str[A1+1][M1+1], RightLine r[N1]){
		for(int i=0; i<= A1; i++)
			for(int j=0; j<= M1; j++)
				predictAnalyzeGraph[i][j]+= str[i][j];
		for(int i=0; i< N1; i++)
			rl[i]= r[i];	
	}
	void printAnalyzeGraph(){
		for(int i=0; i<= A1; i++){
			for(int j=0; j<= M1; j++){
				if(predictAnalyzeGraph[i][j]!= "-1")
					cout<<predictAnalyzeGraph[i][j];
				cout<<"\t";
			}
			cout<<endl;
		}
	}
	void analyze(char left[]){
		char X,a;
		string input;
		inputStack.push('#');
		analyzeStack.push('#');
		cout<<"�����ַ����� ";
		cin>>input;
		cout<<"����ջ\t"<<"ʣ�മ\t"<<"����ʽ\t"<<endl;
		for(int i= input.length()-1; i>= 0; i--){
//			cout<<input[i];
			inputStack.push(input[i]);
		}
		analyzeStack.push(left[0]);
		int num =0;
		while(1){//�����˶�����һ��������Ҫ�ı�a
			a= inputStack.top();
			X= analyzeStack.top();
//			cout<<"a="<<a<<" ";
//			cout<<"X="<<X<<endl;
			if(X == '0'){
				analyzeStack.pop();
				//???????????????????????????????????
				X=analyzeStack.top();
			}
//			cout<<"X1="<<X<<endl;
			if(isVT(X)){
				if(X == a){
					string add;
					add+= a;
					add+= "ƥ��";
					frame[num][2]+= add;
					cout<<a<<"ƥ��\t"<<endl;//----------------------------------
					inputStack.pop();
					analyzeStack.pop();
					continue;
				}
				else{
					cout<<"����1"<<endl;//----------------------------------
					break;
				}
			}
			else{
				if(X == '#'){
					if(X == a){
						string add;
						add+= "����";
						frame[num][2]+= add;
						cout<<"����"<<endl;//----------------------------------
						break;
					}
					else{
						cout<<"����2"<<endl;//----------------------------------
						break;
					}
				}
				else{
					if(testAnalyzeStack(a, X)){
						int i1, j1;
						for(int i=1; i<= A1; i++){//��
							int b1= predictAnalyzeGraph[i][0].find(X, 0);
							if(b1 != predictAnalyzeGraph[i][0].npos){
								for(int j=1; j<= M1; j++){//��
									int b2= predictAnalyzeGraph[0][j].find(a, 0);
									if(b2 != predictAnalyzeGraph[0][j].npos){
										i1= i;
										j1= j;
									}
								}
							}
						}
						antiPush(i1, j1);
						string add;
						add+= predictAnalyzeGraph[i1][0];
						add+= "->";
						add+= predictAnalyzeGraph[i1][j1];
						frame[num][2]+= add;
						cout<<predictAnalyzeGraph[i1][0]<<"->"<<predictAnalyzeGraph[i1][j1]<<"\t"<<endl;//----------------------------------
						continue;
					}
					else{
						cout<<"����3"<<endl;//----------------------------------
						break;
					}
				}
			}
			num++;	
		}
		
	}
	void printFrame(){
		int a=0, i=0;
		do{
			cout<<frame[i][0]<<"\t";
			cout<<frame[i][1]<<"\t";
			cout<<frame[i][2]<<"\t"<<endl;
			int a= frame[i][0].find('#', 0);
			if(a!= frame[i][0].npos){
				a=1;
			}
			i++;
		}while(a!= 1);
	}
	//�����Ƿ��ǲ���ʽ
	bool testAnalyzeStack(char a, char X){
//		cout<<"a="<<a<<endl;
		for(int i=1; i<= A1; i++){//��
			int b1= predictAnalyzeGraph[i][0].find(X, 0);
			if(b1 != predictAnalyzeGraph[i][0].npos){
				for(int j=1; j<= M1; j++){//��
					int b2= predictAnalyzeGraph[0][j].find(a, 0);
					if(b2 != predictAnalyzeGraph[0][j].npos){
						return true;
					}
				}
			}
		}
		return false;
	}
	//������ջ
	void antiPush(int i, int j){
		analyzeStack.pop();
		for(int k= predictAnalyzeGraph[i][j].length()-1; k>= 0; k--){
			analyzeStack.push(predictAnalyzeGraph[i][j][k]);
		}
	}
	//�ж��Ƿ����ս��
	bool isVT(char c){
//		cout<<"X2="<<c<<endl;
		for(int i=1; i<M1; i++){
			int a= predictAnalyzeGraph[0][i].find(c, 0);
//				cout<<"X3="<<a<<endl;
			if(a!= predictAnalyzeGraph[0][i].npos){
				return true;
			}
		}
		return false;
	}

private:
	stack <char> inputStack;
	stack <char> analyzeStack;
	string predictAnalyzeGraph[A1+1][M1+1];
	RightLine rl[N1];
	string frame[100][3];
};