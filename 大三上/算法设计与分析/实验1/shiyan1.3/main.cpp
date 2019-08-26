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
        MergeSort(a, left, mid);//将mid值左边的值排序
        MergeSort(a, mid+1, right);//将mid值右边的值排序
        int b[N]= {0};
        Merge(a, b, left, mid, right);//合并mid值两边的值并排序,把a中排好了序的值输入到b中
        Copy(a, b, left, right);//将b中排好了序的元素返回给a
    }
}
void Merge(int *a, int *b, int left, int mid, int right){
    int i,j,k= 0;
    i= left;
    j= mid+1;
    while(i<= mid && j<= right){//把两个有序序列合并成一个有序序列
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
        a[i]= b[j++];//此时b从第一个元素开始就有了值，也就是b[0],b[1],,,
    }
}
