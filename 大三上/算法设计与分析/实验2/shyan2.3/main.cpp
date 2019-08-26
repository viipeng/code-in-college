#include <iostream>
#include "variable.h"

using namespace std;
void Traceback(int i, int j);
void MatrixChain_DP(int *p, int n);

int main()
{
    arr_p();
    MatrixChain_DP(p, N);
    cout <<"最优值为:"<<m[1][N]<< endl;
    cout <<"最优解为:";
    Traceback(a, b);
    return 0;
}
void MatrixChain_DP(int *p, int n){//动态规划算法
    for(int i=1; i<= n; i++) m[i][i]= 0;
    for(int r=2; r<= n; r++)
    for(int i=1; i<= n-r+1; i++){
        int j= i+r-1;
        m[i][j]= m[i+1][j]+ p[i-1]* p[i]* p[j];
        s[i][j]= i;
        for(int k= i+1; k<j; k++){
            int t= m[i][k]+ m[k+1][j]+ p[i-1]* p[k]* p[j];
            if(t< m[i][j]){
                m[i][j]= t;
                s[i][j]= k;
            }
        }
    }
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
