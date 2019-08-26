#include <iostream>
#include <cmath>
#define NUM 20
using namespace std;

bool Place(int t);
void Backtrack(int t);

int n;
int x[NUM];
int sum;

int main()
{
    sum= 0;
    cout<<"请输入棋盘大小：";
    cin>>n;
    int t=1;
    Backtrack(t);
    cout <<"总和为："<< sum<< endl;
    return 0;
}
void Backtrack(int t){
    while(t>0){
        x[t]++;//跳到下一列，但仍在同一行
        while(x[t]<= n && !(Place(t)))
            x[t]++;
        if(x[t]<= n){
            if(t== n){//已经到达了最后一行，符合要求，可以输出
                sum++;
                for(int k=1; k<=n; k++)
                    cout<<x[k]<<" ";
                cout<<endl;
            }
            else{
                t++;//调到下一行，
                x[t]= 0;//x[t]中可能有上一次的值，因此需要置0
            }
        }
        else{//当x[t]>n时，已经遍历到了当前所在行数的最后一位，因此需要回溯
            t--;//返回上一行
        }
    }
}
bool Place(int t){
    int i;
    for(i=1;i<t;i++)
        if((abs(t-i) == abs(x[i]- x[t])) || (x[i] == x[t]))//同一列和处在斜角线上的值时就否定
        return false;
    return true;
}
