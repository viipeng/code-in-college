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
    cout<<"���������̴�С��";
    cin>>n;
    int t=1;
    Backtrack(t);
    cout <<"�ܺ�Ϊ��"<< sum<< endl;
    return 0;
}
void Backtrack(int t){
    while(t>0){
        x[t]++;//������һ�У�������ͬһ��
        while(x[t]<= n && !(Place(t)))
            x[t]++;
        if(x[t]<= n){
            if(t== n){//�Ѿ����������һ�У�����Ҫ�󣬿������
                sum++;
                for(int k=1; k<=n; k++)
                    cout<<x[k]<<" ";
                cout<<endl;
            }
            else{
                t++;//������һ�У�
                x[t]= 0;//x[t]�п�������һ�ε�ֵ�������Ҫ��0
            }
        }
        else{//��x[t]>nʱ���Ѿ��������˵�ǰ�������������һλ�������Ҫ����
            t--;//������һ��
        }
    }
}
bool Place(int t){
    int i;
    for(i=1;i<t;i++)
        if((abs(t-i) == abs(x[i]- x[t])) || (x[i] == x[t]))//ͬһ�кʹ���б�����ϵ�ֵʱ�ͷ�
        return false;
    return true;
}
