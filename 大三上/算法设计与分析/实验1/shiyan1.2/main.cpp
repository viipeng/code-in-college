#include <iostream>

using namespace std;
void hanoi(char A, char B, char C, int n);
int move(char A, char B, int n);

int main()
{
    char A= 'a', B= 'b', C= 'c';
    int n= 4, time= 0;
    hanoi(A, B, C, n);
    time= move(A, B, n)- 1;
    cout<<time;
    return 0;
}

void hanoi(char A, char B, char C, int n){
//    int time= 0;
    if(n> 0){
        hanoi(A, C, B, n-1);//将n-1个较小的圆盘从A移动到C
        move(A, B, n);//将A上剩余的最大圆盘移动到B
        hanoi(C, B, A, n-1);//将C上n-1个圆盘移动到B
    }
//    return time;
}
int move(char A, char B, int n){
    static int time= 0;//计算移动的次数
    time++;
    return time;
}
