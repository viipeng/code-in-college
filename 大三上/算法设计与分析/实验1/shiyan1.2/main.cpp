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
        hanoi(A, C, B, n-1);//��n-1����С��Բ�̴�A�ƶ���C
        move(A, B, n);//��A��ʣ������Բ���ƶ���B
        hanoi(C, B, A, n-1);//��C��n-1��Բ���ƶ���B
    }
//    return time;
}
int move(char A, char B, int n){
    static int time= 0;//�����ƶ��Ĵ���
    time++;
    return time;
}
