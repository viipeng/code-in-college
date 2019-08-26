#include <iostream>
#include <cmath>
#define NUM 20

using namespace std;
void Backtrack(int t);
bool Place(int t);

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
    int i;
    if(t>n){
        sum++;
        for(i=1;i<=n;i++)
            cout<<x[i]<<" ";
        cout<<endl;
    }
    else{
        for(i=1;i<=n;i++){
            x[t]= i;
            if(Place(t))
                Backtrack(t+1);
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
