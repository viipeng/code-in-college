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
			cout<<list[i]<<" ";//��ӡ���к������
		}
		cout<<endl;
	}
	else{
		for(int i= k; i<= m; i++){
			swap(list[k], list[i]);//����i��Ԫ����������е�һ��Ԫ�ؽ���
			perm(list, k+1, m);//����ģΪn-1��������
			swap(list[k], list[i]);//�Ӻ���ǰ���ΰ�Ԫ�ػ���ԭλ��ʵ�ֲ�ͬ˳�������
		}
	}
}

void swap(int &a, int &b){
	int t= 0;
	t= a;
	a= b;
	b= t;
}

