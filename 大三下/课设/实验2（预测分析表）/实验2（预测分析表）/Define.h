#include <iostream>
#include <string>
#define N 5		//指的是非终结符的个数
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
	//推出空串的非终结符表,1代表有空串，0代表没有空串
	void setNounGraph(){
		for(int i=0; i<N; i++){
			if(isNoun(i)){
				nounGraph[i]= 1;
			}
			else{
				nounGraph[i]= 0;
			}
		}
/*		cout<<"空序列:"<<" ";
		for(int j=0; j<N; j++){
			cout<<nounGraph[j]<<" ";
		}
		cout<<endl;*/
	}
	void calculateFirstSet(){
		for(int i=0; i<N; i++){
			cout<<"计算"<<left[i]<<"的first集的过程："<<endl;
			circleFirstSet(i);
			cout<<endl;
		}
	}
	//求出left数组中以i为下标的非终结符的first集合
	void circleFirstSet(int i){
		static int repeatTime[10]= {0,0,0,0,0,0,0,0,0,0};
		repeatTime[i]++;
		if(repeatTime[i] == 1){
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
	}
	//以下是计算first集合的第1、2、3、4、5点,从产生式的第i1位开始计算，到第j1位结束,i1和j1都是有效值
	void circleFirstSet1(int i, int i1, int j1){
		//下面写的是计算first集合的第1点
		if(isVT(left[i])){
			if(!isExist(firstSet[i], left[i])){
				firstSet[i]+= left[i];
				cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
			}
		}
		//下面写的是计算first集合的第2点
		else if(isVN(left[i]) && isVT(right[i][i1])){
			if(!isExist(firstSet[i], right[i][i1])){
				firstSet[i]+= right[i][i1];
				cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
			}
		}
		//下面写的是计算first集合的第3,4,5点
		else if(isVN(left[i])){
			//下面写的是计算first集合的第3点
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
						if(!isExist(firstSet[i], str[l])){
							firstSet[i]+= str[l];
							cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
						}
					}
				}
				int last= locateVN(right[i][j1]);
				circleFirstSet(last);//如果first[last]此时还没有被计算，就会出错，故需要这一步
				string str1= firstSet[last];
				for(int l=0; l< str1.length(); l++){
					if(!isExist(firstSet[i], str1[l])){
						firstSet[i]+= str1[l];
						cout<<"FIRST("<<left[i]<<")"<<"="<<firstSet[i]<<endl;
					}
				}
				//第五点，如果最后一个非终结符能推出空串
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
			
	//计算follow集合
	void calculateFollowSet(){
		for(int i=0; i<N; i++){
			cout<<"计算"<<left[i]<<"的follow集的过程："<<endl;
			//下面写的是计算follow集合的第1点
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
	//求出left数组中以i为下标的非终结符的follow集合
	void circleFollowSet(int i){
		static int repeatTime[10]= {0,0,0,0,0,0,0,0,0,0};
		repeatTime[i]++;
		if(repeatTime[i] == 1){
			int num= 0;
			while(num< N){
				int j= selectOr(right[num], 0);
				if(j == 0){//没有‘|’
					circleFollowSet1(i, num, 0, right[num].length()-1);
				}
				else{//有'|'
					circleFollowSet1(i, num, 0, j-1);
					int j1;
					while(1){
						j1= selectOr(right[num], j+1);
						if(j1 == -1){//是最后一个产生式
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
	//以下是计算follow集合的第2、3点,从产生式的第i1位开始计算，到第j1位结束,i1和j1都是有效值
	void circleFollowSet1(int i, int ii, int i1, int j1){
		//left[i]指的是要计算的哪个非终结符的follow集，ii指的是第几个产生式的右部
		int sign= -1;
		for(int j= i1; j<= j1; j++){
			if(right[ii][j] == left[i])//判断在产生式右部中有无相应的非终结符
				sign= j;
		}
		if(sign != -1){
			//下面写的是计算follow集合的第2,3点
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
					//第2点
					string str= deleteNoun(firstSet[location]);
					for(int l=0; l< str.length(); l++){
						if(!isExist(followSet[i], str[l])){
							followSet[i]+= str[l];
							cout<<"FOLLOW("<<left[i]<<")"<<"="<<followSet[i]<<endl;
						}
					}
					if(isnu == 1){//第3点的一部分，后面的非终结符的first集中有空串
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
			else if(sign == j1){//第3点的另一部分，后面没有其他元素
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

	//计算select集合
	void calculateSelectSet(){

	}
	//判断是否能推导出空串
	bool isNoun(int i){
		int j= selectOr(right[i], 0);
		if(j == 0){//没有‘|’
			if(testNoun(i, 0, right[i].length()-1)){
				return true;
			}
			else{
				return false;
			}	
		}
		else{//有‘|’
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
				else{//不是‘|’后面的最后一个产生式
					if(testNoun(i, j+1, j1-1)){
						return true;
					}
					j= j1;
				}
			}
		}
	}
	//输出指定first集或follow集的内容
	void print(string str){
		cout<<str<<endl;
	}
	//判断指定下标之间的字符串中有无空串（没有‘|’），有返回true,没有返回false
	bool testNoun(int i, int begin, int end){
		//只有一个字符
		if(end- begin == 0){//该字符串只有一个字符
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
			//字符串中全是非终结符
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
	//判断该字符c是否已经存在于str字符串中，存在返回true，不存在返回false
	bool isExist(string str, char c){
		string::size_type a;
		a= str.find_first_of(c, 0);
		if(a != str.npos)//找到了
			return true;
		else 
			return false;
	}
	//祛除字符串str中的空串（也就是0），但不改变原字符串
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
			vn+= left[i];//构造非终结符集合
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
	char left[N];//产生式左部
	string right[N];//产生式右部
	int nounGraph[N];//空串的非终结符表
	string firstSet[N];
	string followSet[N];
//	string selectSet[100];
};