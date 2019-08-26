#include <iostream>
#include "variable.h"

using namespace std;
void Traceback(int i, int j);
void MemoizedMatrixChain(int n);
int LookupChain(int i, int j);

int main()
{
    arr_p();
    MemoizedMatrixChain(N);
    int u= LookupChain(1,N);
    cout << "最优值为：" <<u<< endl;
    cout << "最优解为：" <<endl;
    Traceback(1,N);
    return 0;
}
void MemoizedMatrixChain(int n){//备忘录方法
    for(int i=1; i<=n; i++)
        for(int j=1; j<=n; j++){
            m[i][j]= 0;
        }
}
int LookupChain(int i, int j){
    if(m[i][j]> 0) return m[i][j];
    if(i== j) return 0;
    int u= LookupChain(i,i)+ LookupChain(i+1,j)+ p[i-1]* p[i]* p[j];
    s[i][j]= i;
    for(int k= i+1; k<j; k++){
        int t= LookupChain(i,k)+ LookupChain(k+1,j)+ p[i-1]* p[k]* p[j];
        if(t<u){
            u=t;
            s[i][j]= k;
        }
    }
    m[i][j]= u;
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
