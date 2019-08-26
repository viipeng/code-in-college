#include"iostream"
#define N 6
using namespace std;

    int array[][2]={
                {50, 55},//A1
                {55, 15},//A2
                {15, 25},//A3
                {25, 40},//A4
                {40, 60},//A5
                {60, 25}//A6
                        };
    int a= 1, b= N;
    int p[N+1];
    int s[N+1][N+1];
    int m[N+1][N+1];//N+1是因为在矩阵连乘的各种算法中会出现像m[][N],s[][N]之类的数组元素
void output(int arr[][N+1]){
    for(int i=1; i<N; i++){
        for(int j=1; j<N+1; j++)
            cout<<arr[i][j]<<" ";
        cout<<endl;
    }
}
void arr_p(){
    p[0]= array[0][0];
    for(int i=0; i<N; i++)
        p[i+1]= array[i][1];
}
