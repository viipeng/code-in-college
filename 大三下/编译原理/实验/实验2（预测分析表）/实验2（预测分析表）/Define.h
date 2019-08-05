#include <iostream>
#include <string>
#define N 5		//指的是非终结符的个数
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
	void setNounGraph(){//推出空串的非终结符表,1代表有空串，0代表没有空串
		for(int i=0; i<N; i++){		
			if(isNoun(i)){
				nounGraph[i]= 1;
			}
			else{
				nounGraph[i]= 0;
			}
		}
		cout<<"空序列:"<<" ";
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
	//求出left数组中以i为下标的非终结符的first集合
	void circleFirstSet(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//没有‘|’
			circleFirstSet1(i, 0, right[i].length()-1);
		}
		else{//有'|'
			circleFirstSet1(i, 0, j-1);
			int j1;
			while(1){
				j1= selectOr(right[i], j+1);
				if(j1 == -1){//是最后一个产生式
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
	//以下是计算first集合的第2、3、4、5点,从产生式的第i1位开始计算，到第j1位结束
	void circleFirstSet1(int i, int i1, int j1){
//		cout<<"begin="<<i1<<" "<<"end="<<j1<<endl;
		//以下是计算first集合的第1点
		if(isVT(left[i])){
			if(!isExist(firstSet[i], left[i]))
				firstSet[i]+= left[i];
		}
		//下面写的是计算first集合的第2点
		else if(isVN(left[i]) && isVT(right[i][i1])){
			if(!isExist(firstSet[i], right[i][i1]))
				firstSet[i]+= right[i][i1];
		}
		//下面写的是计算first集合的第3,4,5点
		else if(isVN(left[i])){
			//下面写的是计算first集合的第3点
			if(isVN(right[i][i1])){
				int j= locateVN(right[i][i1]);
				circleFirstSet(j);
				string str= deleteNoun(firstSet[j]);
				for(int l=0; l< str.length(); l++){
					if(!isExist(firstSet[i], str[l]))
						firstSet[i]+= str[l];
				}
//				cout<<"第3步"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][i1]="<<right[i][i1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
			}
			//下面写的是计算first集合的第4点
			int n=0;
			for(int k=i1; k< j1; k++){
				if(!isVN(right[i][k])){//判断是否都是非终结符
					n= 1;
				}
				int a1= locateVN(right[i][k]);
				if(nounGraph[a1] == 0){//以及能否推导出空串
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
//				cout<<"第41步"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][i1]="<<right[i][i1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
				int last= locateVN(right[i][j1]);
				circleFirstSet(last);//如果first[last]此时还没有被计算，就会出错，故需要这一步
				string str1= firstSet[last];
				for(int l=0; l< str1.length(); l++){
					if(!isExist(firstSet[i], str1[l]))
						firstSet[i]+= str1[l];
				}
//				cout<<"第42步"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][j1]="<<right[i][j1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
				//第五点，如果最后一个非终结符能推出空串
				if(nounGraph[last] == 1)
					if(!isExist(firstSet[i], '0')){
						cout<<'0'<<endl;
						firstSet[i]+= '0';
					}
//				cout<<"第5步"<<" "<<"left[i]="<<left[i]<<" "<<"right[i][j1]="<<right[i][j1]<<" "<<"firstSet[i]="<<firstSet[i]<<endl;
			}
		}
	}
	void printFristSet(){
		for(int i=0; i< N; i++){
			cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
		}
	}
			
	//计算follow集合
	void calculateFollowSet(){

	}
	//计算select集合
	void calculateSelectSet(){

	}
	//判断是否能推导出空串
	bool isNoun(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//没有‘|’
			if(test(i, 0, right[i].length()-1)){
				return true;
			}
			else{
				return false;
			}	
		}
		else{//有‘|’
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
				else{//不是‘|’后面的最后一个产生式
					if(test(i, j+1, j1-1)){
						return true;
					}
					j= j1;
				}
			}
		}
	}	

	//判断指定间距的字符串之间有无空串（没有‘|’）
	bool test(int i, int begin, int end){
		//只有一个字符
		if(end- begin == 0){//该字符为空串
			if(right[i][begin] == '0'){
				return true;
			}
			else if(isVN(right[i][begin])){//该字符为非终结符
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
			for(int k=begin; k<=end; k++){//如果存在一个终结符，则一定不能推出空串
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
	//判断该字符是否已经存在于first集合中
	bool isExist(string str, char c){
		string::size_type a;
		a= str.find_first_of(c, 0);
		if(a != str.npos)//找到了
			return true;
		else 
			return false;
	}
	//祛除某个字符串中的空串，但不改变原字符串
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
	//找出该非终结符在left字符数组的位置的下标
	int locateVN(char c){
		for(int i=0; i<N; i++){
			if(c == left[i])
				return i;
		}	
		return -1;
	}
	//返回'|'符号在字符串中的位置的下标,从i后面开始计算
	int selectOr(string str, int i){
		int n;
		n= str.find('|', 0+i);
		//以下代码用来确定是否已经字符‘|’后面的最后一个产生式
		if(i!= 0 && n == -1)
			return -1;
		//该字符串中没有’|‘字符
		if(n == -1)
			return 0;
		return n;
	}
	//初始化成员变量
	void setPredictAnalyzeGraph(char c[], string s[]){
		for(int i=0; i<N; i++){
			left[i]= c[i];
			right[i]= s[i];
			vn+= left[i];//构造终结符集合
		}
		//构造终结符集合，‘0’也是终结符，但‘#’不是
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
	//判断是否是非终结符
	bool isVN(char c){
/*		cout<<"非终结符集："<<endl;
		for(int i=0; i<N; i++){
			cout<<vn[i]<<" ";
		}*/
		for(int i=0; i< vn.length(); i++){
			if(vn[i] == c)
				return true;
		}
		return false;
	}
	//判断是否是终结符
	bool isVT(char c){
/*		cout<<"终结符集：";
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
	string vt;//终结符集合，小写
	string vn;//非终结符集合,大写
	char left[N];
	string right[N];
	int nounGraph[N];//空串的非终结符表
	string firstSet[N];
	string followSet[N];
	string selectSet[100];
};