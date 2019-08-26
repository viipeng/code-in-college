#include <iostream>
#define N 5
using namespace std;

void test();
void Merge(int *a, int *b, int left, int mid, int right);
void MergeSort(int *arr, int n);
void Sort(int arr[], int n, int *arr1);
void Copy(int *a, int *b, int left, int right);

int main(){
    int arr[N]= {25,62,92,17,6};
    cout<<"���飺";
    for(int i= 0; i< N; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    MergeSort(arr, N);
    cout<<"�ź���������飺";
    for(int i= 0; i< N; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    return 0;
}
void MergeSort(int *arr, int n){//��Ȼ�ϲ�����,�鲢��������
    while(1){
        int arr1[n+1]= {1};//�洢��������,�������һ��Ԫ��ָ��arr����ĵ�һ��Ԫ��
        int i= 0;
        Sort(arr, n, arr1);
        if(arr1[i+1]== n){
            break;
        }
        while(1){
        int arr2[n]= {0};//��ʱ�洢����
            if(arr1[i+1]== 0){
                break;
            }
            if(arr1[i+2]!= 0){
                Merge(arr, arr2, arr1[i]-1, arr1[i+1]-1, arr1[i+2]-1);
                Copy(arr, arr2, arr1[i]-1, arr1[i+2]-1);
            }
            else{
                Merge(arr, arr2, arr1[i]-1+1, (arr1[i]+1+arr1[i+1]-2)/2, arr1[i+1]-1);
                Copy(arr, arr2, arr1[i]-1+1, arr1[i+1]-1);
                //-1+1����Ϊarr1[i]���λ�õ�ֵ�Ѿ�����һ��Merge���������ˣ�������Ҫ+1
            }
            i= i+2;
        }
    }
}
void Sort(int arr[], int n, int *arr1){//arr1�����飬����װ�ֽ������,����Ǵ�1��ʼ�ģ����Ǵ�0��ʼ��
    int i= 0, j= 1;//arr1����ĵ�һ��Ԫ�أ�j=0)����1����ʾ��һ��ֵ
    while(i< n-1){
        if(i+1== n-1 && arr[i]<= arr[i+1]){//���һ��Ԫ�ر�ǰһ��ֵ��
            arr1[j]= i+2;
        }
        else if(i+1== n-1 && arr[i]> arr[i+1]){//���һ��Ԫ�ر�ǰһ��ֵС
            arr1[j++]= i+1;
            arr1[j]= i+2;
        }
        else if(arr[i]<= arr[i+1]){}
        else{
            arr1[j++]= i+1;//��1��Ϊ�����ֵ�һ��Ԫ�غ�0���������
        }
        i++;
    }
}
void Merge(int *arr, int *arr2, int left, int mid, int right){//�ϲ���������
    int i,j,k= 0;
    i= left;
    j= mid+1;
    while(i<= mid && j<= right){
        if(arr[i]< arr[j]) arr2[k++]= arr[i++];
        else arr2[k++]= arr[j++];
    }
    while(i<= mid){
        arr2[k++]= arr[i++];
    }
    while(j<= right){
        arr2[k++]= arr[j++];
    }
}
void Copy(int *arr, int arr2[], int left, int right){
    int j= 0;
    for(int i= left; i<= right; i++){
        arr[i]= arr2[j++];
    }
}
