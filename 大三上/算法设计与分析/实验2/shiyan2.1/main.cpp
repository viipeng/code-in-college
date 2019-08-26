#include <iostream>
#include "variable.h"
#define N 6

using namespace std;
int MatrixChain_Recursion(int i, int j);
void Traceback(int i, int j);

int main()
{
    arr_p();
    int u= MatrixChain_Recursion(a, b);
    cout <<"最优值为:"<<u<< endl;
    cout <<"最优解为:";
    Traceback(a, b);
    return 0;
}
int MatrixChain_Recursion(int i, int j){//递归算法
    if(i== j) return 0;
    int u= MatrixChain_Recursion(i, i)+ MatrixChain_Recursion(i+1, j)+ p[i-1]* p[i]* p[j];
    s[i][j]= i;
    for(int k= i+1; k<j; k++){
        int t= MatrixChain_Recursion(i, k)+ MatrixChain_Recursion(k+1, j)+ p[i-1]* p[k]* p[j];
        if(t< u) {
            u= t;
            s[i][j]= k;
        }
    }
    return u;
}
void Traceback(int i, int j){
    if(i== j) cout<<"Ai";
    else{
        cout<<"(";
        Traceback(i, s[i][j]);
        Traceback(s[i][j]+1, j);
        cout<<")";
    }
}

