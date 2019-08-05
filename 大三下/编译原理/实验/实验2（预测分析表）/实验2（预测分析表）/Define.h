#include <iostream>
#include <string>
#define N 5		//ָ���Ƿ��ս���ĸ���
using namespace std;

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
class PredictAnalyzeGraph{

public:
	void setNounGraph(){//�Ƴ��մ��ķ��ս����,1�����пմ���0����û�пմ�
		for(int i=0; i<N; i++){		
			if(isNoun(i)){
				nounGraph[i]= 1;
			}
			else{
				nounGraph[i]= 0;
			}
		}
		cout<<"������:"<<" ";
		for(int j=0; j<N; j++){
			cout<<nounGraph[j]<<" ";
		}
		cout<<endl;
	}
	void calculateFirstSet(){
		for(int i=0; i<N; i++){
			circleFirstSet(i);
		}
	}
	//���left��������iΪ�±�ķ��ս����first����
	void circleFirstSet(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//û�С�|��
			circleFirstSet1(i, 0, right[i].length()-1);
		}
		else{//��'|'
			circleFirstSet1(i, 0, j-1);
			int j1;
			while(1){
				j1= selectOr(right[i], j+1);
				if(j1 == -1){//�����һ������ʽ
					circleFirstSet1(i, j+1, right[i].length()-1);
					break;
				}
				else{
					circleFirstSet1(i, j+1, j1-1);
					j= j1;
				}
			}	
		}
	}
	//�����Ǽ���first���ϵĵ�2��3��4��5��,�Ӳ���ʽ�ĵ�i1λ��ʼ���㣬����j1λ����
	void circleFirstSet1(int i, int i1, int j1){
//		cout<<"begin="<<i1<<" "<<"end="<<j1<<endl;
		//�����Ǽ���first���ϵĵ�1��
		if(isVT(left[i])){
			if(!isExist(firstSet[i], left[i]))
				firstSet[i]+= left[i];
		}
		//����д���Ǽ���first���ϵĵ�2��
		else if(isVN(left[i]) && isVT(right[i][i1])){
			if(!isExist(firstSet[i], right[i][i1]))
				firstSet[i]+= right[i][i1];
		}
		//����д���Ǽ���first���ϵĵ�3,4,5��
		else if(isVN(left[i])){
			//����д���Ǽ���first���ϵĵ�3��
			if(isVN(right[i][i1])){
				int j= locateVN(right[i][i1]);
				circleFirstSet(j);
				string str= deleteNoun(firstSet[j]);
				for(int l=0; l< str.length(); l++){
					if(!isExist(firstSet[i], str[l]))
						firstSet[i]+= str[l];
				}
//				cout<<"��3��"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][i1]="<<right[i][i1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
			}
			//����д���Ǽ���first���ϵĵ�4��
			int n=0;
			for(int k=i1; k< j1; k++){
				if(!isVN(right[i][k])){//�ж��Ƿ��Ƿ��ս��
					n= 1;
				}
				int a1= locateVN(right[i][k]);
				if(nounGraph[a1] == 0){//�Լ��ܷ��Ƶ����մ�
					n= 1;
				}
			}
			if(n == 0){
				for(int k=i1; k< j1; k++){
					int location= locateVN(right[i][k]);
					string str= deleteNoun(firstSet[location]);						
					for(int l=0; l<str.length(); l++){
						if(!isExist(firstSet[i], str[l]))
							firstSet[i]+= str[l];
					}
				}
//				cout<<"��41��"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][i1]="<<right[i][i1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
				int last= locateVN(right[i][j1]);
				circleFirstSet(last);//���first[last]��ʱ��û�б����㣬�ͻ��������Ҫ��һ��
				string str1= firstSet[last];
				for(int l=0; l< str1.length(); l++){
					if(!isExist(firstSet[i], str1[l]))
						firstSet[i]+= str1[l];
				}
//				cout<<"��42��"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][j1]="<<right[i][j1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
				//����㣬������һ�����ս�����Ƴ��մ�
				if(nounGraph[last] == 1)
					if(!isExist(firstSet[i], '0')){
						cout<<'0'<<endl;
						firstSet[i]+= '0';
					}
//				cout<<"��5��"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][j1]="<<right[i][j1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
			}
		}
	}
	void printFristSet(){
		for(int i=0; i< N; i++){
			cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
		}
	}
			
	//����follow����
	void calculateFollowSet(){

	}
	//����select����
	void calculateSelectSet(){

	}
	//�ж��Ƿ����Ƶ����մ�
	bool isNoun(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//û�С�|��
			if(test(i, 0, right[i].length()-1)){
				return true;
			}
			else{
				return false;
			}	
		}
		else{//�С�|��
			if(test(i, 0, j-1)){
				return true;
			}
			while(1){
				int j1= selectOr(right[i], j+1);
				if(j1 == -1){
					if(test(i, j+1, right[i].length()-1)){
						return true;
					}
					else{
						return false;
					}
					break;
				}
				else{//���ǡ�|����������һ������ʽ
					if(test(i, j+1, j1-1)){
						return true;
					}
					j= j1;
				}
			}
		}
	}	

	//�ж�ָ�������ַ���֮�����޿մ���û�С�|����
	bool test(int i, int begin, int end){
		//ֻ��һ���ַ�
		if(end- begin == 0){//���ַ�Ϊ�մ�
			if(right[i][begin] == '0'){
				return true;
			}
			else if(isVN(right[i][begin])){//���ַ�Ϊ���ս��
				int location= locateVN(right[i][begin]);
				if(isNoun(location))
					return true;
				else 
					return false;
			}
			else{
				return false;
			}
		}
		else{
			for(int k=begin; k<=end; k++){//�������һ���ս������һ�������Ƴ��մ�
				if(isVT(right[i][k])){		
					if(right[i][k] != '0')
						return false;
				}
			}
			int sign= 0;
			for(int k=begin; k<=end; k++){
				int location= locateVN(right[i][k]);
				if(!isNoun(location)){ //nounGraph[location] == 0 || 
					sign= 1;
				}
			}
			if(sign == 1){
				return false;
			}
			else{
				return true;
			}
		}
	}
	//�жϸ��ַ��Ƿ��Ѿ�������first������
	bool isExist(string str, char c){
		string::size_type a;
		a= str.find_first_of(c, 0);
		if(a != str.npos)//�ҵ���
			return true;
		else 
			return false;
	}
	//���ĳ���ַ����еĿմ��������ı�ԭ�ַ���
	string deleteNoun(string str){
		string::size_type a;
		int b=1;
		while(b){
		a= str.find_first_of('0', 0);
		if(a != str.npos)
			str.erase(a,1);
		else
			b=0;
		}
		return str;
	}
	//�ҳ��÷��ս����left�ַ������λ�õ��±�
	int locateVN(char c){
		for(int i=0; i<N; i++){
			if(c == left[i])
				return i;
		}	
		return -1;
	}
	//����'|'�������ַ����е�λ�õ��±�,��i���濪ʼ����
	int selectOr(string str, int i){
		int n;
		n= str.find('|', 0+i);
		//���´�������ȷ���Ƿ��Ѿ��ַ���|����������һ������ʽ
		if(i!= 0 && n == -1)
			return -1;
		//���ַ�����û�С�|���ַ�
		if(n == -1)
			return 0;
		return n;
	}
	//��ʼ����Ա����
	void setPredictAnalyzeGraph(char c[], string s[]){
		for(int i=0; i<N; i++){
			left[i]= c[i];
			right[i]= s[i];
			vn+= left[i];//�����ս������
		}
		//�����ս�����ϣ���0��Ҳ���ս��������#������
		for(int i=0; i<N; i++){
			for(int j=0; j<right[i].length(); j++){
				char c= right[i][j];
				if(!isVN(c) && c!= '|'){
					string::size_type a;
					a= vt.find_first_of(c, 0);
					if(a == vt.npos)
						vt+= c;
				}
			}
		}
	}
	//�ж��Ƿ��Ƿ��ս��
	bool isVN(char c){
/*		cout<<"���ս������"<<endl;
		for(int i=0; i<N; i++){
			cout<<vn[i]<<" ";
		}*/
		for(int i=0; i< vn.length(); i++){
			if(vn[i] == c)
				return true;
		}
		return false;
	}
	//�ж��Ƿ����ս��
	bool isVT(char c){
/*		cout<<"�ս������";
		for(int i=0; i< vt.length(); i++){
			cout<<vt[i]<<" ";
		}
		cout<<endl;*/
		for(int j=0; j< vt.length(); j++){
			if(c == vt[j])
				return true;
		}
		return false;
	}

private:
	string vt;//�ս�����ϣ�Сд
	string vn;//���ս������,��д
	char left[N];
	string right[N];
	int nounGraph[N];//�մ��ķ��ս����
	string firstSet[N];
	string followSet[N];
	string selectSet[100];
};