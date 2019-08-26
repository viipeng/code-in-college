#include <iostream>

using namespace std;
void swap(int &a, int  &b);
void perm(int  list[], int k, int m);

int main(){
	int list[]= {2,6,4};
	int k= 0, m= 2;
	perm(list, k, m);
	return 0;
}

void perm(int list[], int k, int m){
	if(k == m){
		for(int i= 0; i<= m; i++){
			cout<<list[i]<<" ";//打印排列后的数组
		}
		cout<<endl;
	}
	else{
		for(int i= k; i<= m; i++){
			swap(list[k], list[i]);//将第i个元素与该问题中第一个元素交换
			perm(list, k+1, m);//求解规模为n-1的子问题
			swap(list[k], list[i]);//从后往前依次把元素换回原位，实现不同顺序的排列
		}
	}
}

void swap(int &a, int &b){
	int t= 0;
	t= a;
	a= b;
	b= t;
}

