#include <iostream>
#define N 100
using namespace std;

void MergeSort(int *a, int left, int right);
void Merge(int *a, int *b, int left, int mid, int right);
void Copy(int *a, int *b, int left, int right);

int main()
{
    int a[]={4,56,91,8,12,2};//
    int left= 0, right= 5;
    for(int i= left; i<= right; i++){
        cout << a[i] <<" ";
    }
    cout<<endl;
    MergeSort(a, left, right);
    for(int i= left; i<= right; i++){
        cout << a[i] <<" ";
    }
    cout<<endl;
    return 0;
}

void MergeSort(int *a, int left, int right){
    int mid;
    if(left< right){
        mid= (left+ right)/2;
        MergeSort(a, left, mid);//��midֵ��ߵ�ֵ����
        MergeSort(a, mid+1, right);//��midֵ�ұߵ�ֵ����
        int b[N]= {0};
        Merge(a, b, left, mid, right);//�ϲ�midֵ���ߵ�ֵ������,��a���ź������ֵ���뵽b��
        Copy(a, b, left, right);//��b���ź������Ԫ�ط��ظ�a
    }
}
void Merge(int *a, int *b, int left, int mid, int right){
    int i,j,k= 0;
    i= left;
    j= mid+1;
    while(i<= mid && j<= right){//�������������кϲ���һ����������
        if(a[i]< a[j]) b[k++]= a[i++];
        else b[k++]= a[j++];
    }
    while(i<= mid){
        b[k++]= a[i++];
    }
    while(j<= right){
        b[k++]= a[j++];
    }
}
void Copy(int *a, int *b, int left, int right){
    int j= 0;
    for(int i= left; i<= right; i++){
        a[i]= b[j++];//��ʱb�ӵ�һ��Ԫ�ؿ�ʼ������ֵ��Ҳ����b[0],b[1],,,
    }
}
