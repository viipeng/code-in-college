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
    cout<<"数组：";
    for(int i= 0; i< N; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    MergeSort(arr, N);
    cout<<"排好了序的数组：";
    for(int i= 0; i< N; i++)
        cout<<arr[i]<<" ";
    cout<<endl;
    return 0;
}
void MergeSort(int *arr, int n){//自然合并排序,归并两个序列
    while(1){
        int arr1[n+1]= {1};//存储分组的序号,该数组第一个元素指向arr数组的第一个元素
        int i= 0;
        Sort(arr, n, arr1);
        if(arr1[i+1]== n){
            break;
        }
        while(1){
        int arr2[n]= {0};//临时存储数据
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
                //-1+1是因为arr1[i]这个位置的值已经被上一个Merge函数调用了，所以需要+1
            }
            i= i+2;
        }
    }
}
void Sort(int arr[], int n, int *arr1){//arr1是数组，用来装分界点的序号,序号是从1开始的，不是从0开始的
    int i= 0, j= 1;//arr1数组的第一个元素（j=0)留作1，表示第一个值
    while(i< n-1){
        if(i+1== n-1 && arr[i]<= arr[i+1]){//最后一个元素比前一个值大
            arr1[j]= i+2;
        }
        else if(i+1== n-1 && arr[i]> arr[i+1]){//最后一个元素比前一个值小
            arr1[j++]= i+1;
            arr1[j]= i+2;
        }
        else if(arr[i]<= arr[i+1]){}
        else{
            arr1[j++]= i+1;//加1是为了区分第一个元素和0，避免混淆
        }
        i++;
    }
}
void Merge(int *arr, int *arr2, int left, int mid, int right){//合并两个序列
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
