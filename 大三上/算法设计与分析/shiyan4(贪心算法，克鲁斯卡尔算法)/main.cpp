#include <iostream>
#define MAXN 11
#define MAXM 20
using namespace std;

struct edge
{
    int u,v,w;
}/*edge,*/edges[MAXM];//不能在这里加一个edge，这是语法规定的
int parent[MAXN];
int n,m;//n为顶点个数，m为边的数量
int i,j;//用作循环变量

void UFset()
{
    for(i=1; i<=n; i++)
        parent[i]= -1;
}
int Find(int x)
{
    int s;
    for(s=x; parent[s]>= 0; s=parent[s])
        while(s!= x)
        {
            int tmp= parent[x];
            parent[x]= s;
            x= tmp;
        }
    return s;
}
void Union(int R1, int R2)
{
    int r1= Find(R1), r2= Find(R2);
    int tmp= parent[r1]+ parent[r2];
    if(parent[r1]> parent[r2])
    {
        parent[r1]= r2;
        parent[r2]= tmp;
    }
    else
    {
        parent[r2]= r1;
        parent[r1]= tmp;
    }
}
void Kruskal()
{
    int sumweight= 0;
    int num= 0;
    int u,v;
    UFset();
    for(i=0; i<m; i++)
    {
        u= edges[i].u;
        v= edges[i].v;
        if( Find(u)!= Find(v) )
        {
//            printf("%d %d %d\n", u,v,edges[i].w);
            cout<<u<<" "<<v<<" "<<edges[i].w<<endl;
            sumweight += edges[i].w;
            num++;
            Union(u, v);
        }
        if(num >= n-1) break;
    }
    cout<<"weight of MST is "<<sumweight<<"!"<<endl;;
}
void sort(edge *arr, int m)//这个地方用指针作为形参，可以直接当数组用，
//但是指针类型!!!!!!!!!!!必须是edge，不能是edges!!!!!!!!!!!!
{
    int temp= 0;
    for(i=0; i< m-1; i++)
        for(j= i+1; j<m; j++)
            if(arr[i].w> arr[j].w)
            {
                temp= arr[i].u;
                arr[i].u= arr[j].u;
                arr[j].u= temp;

                temp= arr[i].v;
                arr[i].v= arr[j].v;
                arr[j].v= temp;

                temp= arr[i].w;
                arr[i].w= arr[j].w;
                arr[j].w= temp;
            }
}

int main()
{
    int u,v,w;
    int i;
    cin>>n>>m;
    for(i=0; i<m; i++)
    {
        cin>>u>>v>>w;
        edges[i].u= u;
        edges[i].v= v;
        edges[i].w= w;
    }
    sort(edges, m);
    cout<<endl;
    Kruskal();
    return 0;
}
