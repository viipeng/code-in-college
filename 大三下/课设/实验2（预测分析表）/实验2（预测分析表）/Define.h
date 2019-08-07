#include <iostream>
#include <string>
#define N 5		//ָ���Ƿ��ս���ĸ���
using namespace std;

class RightLine{

public:
		void initialize(char s1, string s2){
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
	//�Ƴ��մ��ķ��ս����,1�����пմ���0����û�пմ�
	void setNounGraph(){
		for(int i=0; i<N; i++){
			if(isNoun(i)){
				nounGraph[i]= 1;
			}
			else{
				nounGraph[i]= 0;
			}
		}
/*		cout<<"������:"<<" ";
		for(int j=0; j<N; j++){
			cout<<nounGraph[j]<<" ";
		}
		cout<<endl;*/
	}
	void calculateFirstSet(){
		for(int i=0; i<N; i++){
			cout<<"����"<<left[i]<<"��first���Ĺ��̣�"<<endl;
			circleFirstSet(i);
			cout<<endl;
		}
	}
	//���left��������iΪ�±�ķ��ս����first����
	void circleFirstSet(int i){
		static int repeatTime[10]= {0,0,0,0,0,0,0,0,0,0};
		repeatTime[i]++;
		if(repeatTime[i] == 1){
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
	}
	//�����Ǽ���first���ϵĵ�1��2��3��4��5��,�Ӳ���ʽ�ĵ�i1λ��ʼ���㣬����j1λ����,i1��j1������Чֵ
	void circleFirstSet1(int i, int i1, int j1){
		//����д���Ǽ���first���ϵĵ�1��
		if(isVT(left[i])){
			if(!isExist(firstSet[i], left[i])){
				firstSet[i]+= left[i];
				cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
			}
		}
		//����д���Ǽ���first���ϵĵ�2��
		else if(isVN(left[i]) && isVT(right[i][i1])){
			if(!isExist(firstSet[i], right[i][i1])){
				firstSet[i]+= right[i][i1];
				cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
			}
		}
		//����д���Ǽ���first���ϵĵ�3,4,5��
		else if(isVN(left[i])){
			//����д���Ǽ���first���ϵĵ�3��
			if(isVN(right[i][i1])){
				int j= locateVN(right[i][i1]);
				circleFirstSet(j);
				string str= deleteNoun(firstSet[j]);
				for(int l=0; l< str.length(); l++){
					if(!isExist(firstSet[i], str[l])){
						firstSet[i]+= str[l];
						cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
					}
				}
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
						if(!isExist(firstSet[i], str[l])){
							firstSet[i]+= str[l];
							cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
						}
					}
				}
				int last= locateVN(right[i][j1]);
				circleFirstSet(last);//���first[last]��ʱ��û�б����㣬�ͻ��������Ҫ��һ��
				string str1= firstSet[last];
				for(int l=0; l< str1.length(); l++){
					if(!isExist(firstSet[i], str1[l])){
						firstSet[i]+= str1[l];
						cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
					}
				}
				//����㣬������һ�����ս�����Ƴ��մ�
				if(nounGraph[last] == 1)
					if(!isExist(firstSet[i], '0')){
						firstSet[i]+= '0';
					}
			}
		}
	}
	void printFristSet(){
		for(int i=0; i< N; i++){
			cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
		}
		cout<<endl;
	}
			
	//����follow����
	void calculateFollowSet(){
		for(int i=0; i<N; i++){
			cout<<"����"<<left[i]<<"��follow���Ĺ��̣�"<<endl;
			//����д���Ǽ���follow���ϵĵ�1��
			if(left[i] == left[0]){
				if(!isExist(followSet[i], '#')){
					followSet[i]+= '#';
					cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
				}
			}
			circleFollowSet(i);
			cout<<endl;
		}
	}
	//���left��������iΪ�±�ķ��ս����follow����
	void circleFollowSet(int i){
		static int repeatTime[10]= {0,0,0,0,0,0,0,0,0,0};
		repeatTime[i]++;
		if(repeatTime[i] == 1){
			int num= 0;
			while(num< N){
				int j= selectOr(right[num], 0);
				if(j == 0){//û�С�|��
					circleFollowSet1(i, num, 0, right[num].length()-1);
				}
				else{//��'|'
					circleFollowSet1(i, num, 0, j-1);
					int j1;
					while(1){
						j1= selectOr(right[num], j+1);
						if(j1 == -1){//�����һ������ʽ
							circleFollowSet1(i, num, j+1, right[num].length()-1);
							break;
						}
						else{
							circleFollowSet1(i, num, j+1, j1-1);
							j=j1;
						}
					}
				}
				num++;
			}
		}
	}
	//�����Ǽ���follow���ϵĵ�2��3��,�Ӳ���ʽ�ĵ�i1λ��ʼ���㣬����j1λ����,i1��j1������Чֵ
	void circleFollowSet1(int i, int ii, int i1, int j1){
		//left[i]ָ����Ҫ������ĸ����ս����follow����iiָ���ǵڼ�������ʽ���Ҳ�
		int sign= -1;
		for(int j= i1; j<= j1; j++){
			if(right[ii][j] == left[i])//�ж��ڲ���ʽ�Ҳ���������Ӧ�ķ��ս��
				sign= j;
		}
		if(sign != -1){
			//����д���Ǽ���follow���ϵĵ�2,3��
			if(sign< j1){
				if(isVT(right[ii][sign+1])){
					followSet[i]+= right[ii][sign+1];
					cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
				}
				else if(isVN(right[ii][sign+1])){
					int isnu= 0;
					int location= locateVN(right[ii][sign+1]);
					for(int k=0; k< firstSet[location].length(); k++){
						if(firstSet[location][k] == '0')
							isnu= 1;
					}
					//��2��
					string str= deleteNoun(firstSet[location]);
					for(int l=0; l< str.length(); l++){
						if(!isExist(followSet[i], str[l])){
							followSet[i]+= str[l];
							cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
						}
					}
					if(isnu == 1){//��3���һ���֣�����ķ��ս����first�����пմ�
						int location1= locateVN(left[ii]);
						circleFollowSet(location1);
						for(int l=0; l< followSet[location1].length(); l++){
							if(!isExist(followSet[i], followSet[location1][l])){
								followSet[i]+= followSet[location1][l];
								cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
							}
						}
					}
				}
			}
			else if(sign == j1){//��3�����һ���֣�����û������Ԫ��
				int location1= locateVN(left[ii]);
				circleFollowSet(location1);
				for(int l=0; l< followSet[location1].length(); l++){
					if(!isExist(followSet[i], followSet[location1][l])){
						followSet[i]+= followSet[location1][l];
						cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
					}
				}
			}
		}
	}
	void printFollowSet(){
		for(int i=0; i< N; i++){
			cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
		}
	}

	//����select����
	void calculateSelectSet(){

	}
	//�ж��Ƿ����Ƶ����մ�
	bool isNoun(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//û�С�|��
			if(testNoun(i, 0, right[i].length()-1)){
				return true;
			}
			else{
				return false;
			}	
		}
		else{//�С�|��
			if(testNoun(i, 0, j-1)){
				return true;
			}
			while(1){
				int j1= selectOr(right[i], j+1);
				if(j1 == -1){
					if(testNoun(i, j+1, right[i].length()-1)){
						return true;
					}
					else{
						return false;
					}
					break;
				}
				else{//���ǡ�|����������һ������ʽ
					if(testNoun(i, j+1, j1-1)){
						return true;
					}
					j= j1;
				}
			}
		}
	}
	//���ָ��first����follow��������
	void print(string str){
		cout<<str<<endl;
	}
	//�ж�ָ���±�֮����ַ��������޿մ���û�С�|�������з���true,û�з���false
	bool testNoun(int i, int begin, int end){
		//ֻ��һ���ַ�
		if(end- begin == 0){//���ַ���ֻ��һ���ַ�
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
			//�ַ�����ȫ�Ƿ��ս��
			int sign= 0;
			for(int k=begin; k<=end; k++){
				int location= locateVN(right[i][k]);
				if(!isNoun(location)){ 
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
	//�жϸ��ַ�c�Ƿ��Ѿ�������str�ַ����У����ڷ���true�������ڷ���false
	bool isExist(string str, char c){
		string::size_type a;
		a= str.find_first_of(c, 0);
		if(a != str.npos)//�ҵ���
			return true;
		else 
			return false;
	}
	//����ַ���str�еĿմ���Ҳ����0���������ı�ԭ�ַ���
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
			vn+= left[i];//������ս������
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
	char left[N];//����ʽ��
	string right[N];//����ʽ�Ҳ�
	int nounGraph[N];//�մ��ķ��ս����
	string firstSet[N];
	string followSet[N];
//	string selectSet[100];
};