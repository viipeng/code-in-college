//操作系统    实验三
//两级文件目录     文件系统设计实验
//当把一个文件打开再删除后，就无法把其他的文件打开了，陷入了死循环，不想弄了
#include<stdio.h>
#include<string.h>
#define N 100
typedef struct ufd{
	char filename[20];
	int power;
	int length;
}UFD[N],ufd;
typedef struct mfd{
	char username[20];
	ufd *strNext;
}MFD,mfd ;
/*typedef struct AFD{
	char filename[20];
	char power[4];
	int length;
	int location;
}AFD;*/
//数据初始化
//   UFD初始化
 UFD UFD1={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD2={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD3={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",011,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD4={{"file1",101,30},{"file2",111,20},{"file3",110,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 //  MFD初始化
  mfd MFDUser[4]={{"user1",UFD1},{"user2",UFD2},{"user3",UFD3},{"user4",UFD4}};
  //AFD初始化
  int afd= -1;
//部分标记字符
  int k=-1;//记录用户位置
// int *read;
// int *write;
//新建文件
void createFile()
{
    int i;
	int flag=1,kx;   //flag:判断该用户文件数是否已满   kx:空闲标志位
	for(i=0;i<10;i++)
	{
		if((MFDUser[k].strNext+i)->length==-1)
		{
			kx=i;
			flag=0;
			break;
		}
	}
	if(flag)
	{
		printf("用户可创建文件已满\n");
	}
	else
	{
		struct ufd t=*(MFDUser[k].strNext+kx);
		char name[100];
		int pow;
		int length;
		//getchar();
		while(1)
		{
			printf("输入文件名：");
			int flagname=0;
			scanf("%s",&name);
			flagname= queryFile(name);
			if(flagname!= -1)
			{
                printf("%s\n", &name);
				printf("文件名一致，错误！\n");
				continue;
			}
			break;
		}
		printf("输入3位保护码（操作顺序：读，写，执行）（0为不可，1为可）（例:110,可读可写不可执行）:\n") ;
		scanf("%3d",&pow);
		printf("输入文件长度：");
		scanf("%d",&length);
		strcpy(t.filename, name);
		t.power= pow;
		t.length=length;
		*(MFDUser[k].strNext+kx)=t;
		printf("创建成功！\n");
//		int i=0;
//		for(i=0;i<10;i++)
//		{
//			if((MFDUser[k].strNext+i)->length!=-1)
//			printf("%s %s %d\n",(MFDUser[k].strNext+i)->filename,(MFDUser[k].strNext+i)->power,(MFDUser[k].strNext+i)->length);
//		}
    }
    menu();
}
//删除文件
void deleteFile()
{
	printf("输入要删除的文件名：");
	int flagment= 0;
	char name[3];
	scanf("%s", &name);
	if(afd!= -1 && strcmp((MFDUser[k].strNext+afd)->filename, name)== 0)
    {
        flagment= afd;
        afd= -1;//删除的文件如果已经被打开，那么也会被删除，afd也会被清空
    }
    else
        flagment= queryFile(name);
//	flagname= queryFile(name);
//    printf("被删除的值在 %d 位,afd= %d\n", flagment, afd);
	if(flagment== -1)
        printf("该文件不存在！\n");
    else{
        strcpy((MFDUser[k].strNext+flagment)->filename, "file");
        ((MFDUser[k].strNext+flagment)->power)= 000;
        ((MFDUser[k].strNext+flagment)->length)= -1;
        printf("删除成功！\n");
    }
    menu();
}
//读文件
void readFile()
{
	printf("输入要阅读的文件的文件名：");
	char s[10];
	int flagment;
//	int power1[3];
	scanf("%s", s);
	if(afd!= -1 && strcmp(((MFDUser[k].strNext+ afd)->filename), s)== 0)
    {
//        changeString((MFDUser[k].strNext+ afd)->power, power1);
//        printf("权限为%s\n", (MFDUser[k].strNext+ afd)->power);
//        printf("权限为%d%d%d\n", power1[0], power1[1], power1[2]);
//        strcmp(((MFDUser[k].strNext+ afd)->power), "100")==1 || strcmp(((MFDUser[k].strNext+ afd)->power), "101")==1 ||
//           strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 || strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//        int n=1;
//        isPower(n), ((MFDUser[k].strNext+flagment)->power)
        //拥有读的权限
        if( (((MFDUser[k].strNext+ afd)->power)/100)== 1)
            printf("%s %d %d\n", (MFDUser[k].strNext+ afd)->filename,
                   (MFDUser[k].strNext+ afd)->power, (MFDUser[k].strNext+ afd)->length);
        else
            printf("该文件不允许被阅读！\n");
    }
    else
    {
        flagment= queryFile(s);
        if(flagment== -1)
        {
            printf("该文件不存在!\n");
        }
        else
        {
//            changeString((MFDUser[k].strNext+ flagment)->power, power1);
//            printf("权限为%s\n", (MFDUser[k].strNext+ flagment)->power);
//            printf("权限为%d%d%d\n", power1[0], power1[1], power1[2]);
        //拥有读的权限
//        strcmp(((MFDUser[k].strNext+ afd)->power), "100")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "101")==1 ||
//            strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//            int n=1;
//            isPower(n), ((MFDUser[k].strNext+flagment)->power)
            //拥有读的权限
            if( (((MFDUser[k].strNext+ flagment)->power)/100)== 1 )
                printf("%s %d %d\n", (MFDUser[k].strNext+ flagment)->filename,
                       (MFDUser[k].strNext+ flagment)->power, (MFDUser[k].strNext+ flagment)->length);
            else
                printf("该文件不允许被阅读！\n");
        }
    }
    menu();
}
//写文件
void writeFile()
{
    printf("输入要编写的文件的文件名：");
	char s[10];
	int flagment;
	scanf("%s", s);
	if(afd!= -1)
        flagment= afd;
    else
        flagment= queryFile(s);
    if(flagment== -1)
    {
        printf("该文件不存在!\n");
    }
    else
    {
//        strcmp(((MFDUser[k].strNext+ afd)->power), "010")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "011")==1 ||
//            strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//        int n=2;
//        isPower(n, ((MFDUser[k].strNext+flagment)->power))
        //拥有写的权限
        if( ( ( ( (MFDUser[k].strNext+flagment)->power)%100)/10)== 1 )
        {
            struct ufd t=*(MFDUser[k].strNext+flagment);
            char name[100];
            int pow;
            int length;
            while(1)
            {
                printf("输入文件名：");
                int flag;
                scanf("%s",&name);
                flag= queryFile(name);
                if(flag!= -1)
                {
                    printf("%s\n", &name);
                    printf("文件名一致，错误！\n");
                    continue;
                }
                break;
            }
            printf("输入3位保护码（操作顺序：读，写，执行）（0为不可，1为可）（例:110,可读可写不可执行）:\n") ;
            scanf("%d",&pow);
            printf("输入文件长度：");
            scanf("%d",&length);
            strcpy(t.filename, name);
            t.power=pow;
            t.length=length;
            printf("%s %d %d\n", t.filename, t.power, t.length);
            *(MFDUser[k].strNext+flagment)=t;
            printf("编写成功！\n");
        }
        else
        {
            printf("该文件不允许被编写！\n");
        }
    }
    menu();
}
//打开文件
void openFile()
{
    int flagment;
    while(1)
    {
        printf("输入要打开的文件的文件名：");
        char s[10];
        scanf("%s", s);
        flagment= queryFile(s);
//        printf("flagment= %d\n", flagment);
        if(flagment== -1)
        {
            printf("该文件不存在! %d\n", afd);
            afd= -1;
        }
        else
            break;
    }
    afd= flagment;
//    strcpy(afd.filename, (MFDUser[k].strNext+ flagment)->filename);
//    strcpy(afd.power, (MFDUser[k].strNext+ flagment)->power);
//    afd.length= (MFDUser[k].strNext+ flagment)->length;
//    printf("afd=%d\n", afd);
    printf("%s文件已经打开！\n", (MFDUser[k].strNext+ afd)->filename);
    menu();
}
//关闭文件
void closeFile()
{
    if(afd== -1)
        printf("没有文件被打开！\n");
    else
    {
        int i= afd;
        afd= -1;
//        strcpy(afd.filename, "file");
//        strcpy(afd.power, "000");
//        afd.length=-1;
        printf("%s文件已经关闭！\n", ((MFDUser[k].strNext+ i)->filename));
    }
    menu();
}
//退出程序
void stop()//------------------------退出程序需要按2次操作，有问题
{
    return 0;
}
//输入数字错误
void restart()
{
    printf("输入数字错误!\n");
    menu();
}
/*//判断是否有读/写的权限
int isPower(int n, char power[])
{
    char *p= power[0];
//    printf("%s\ns", *p+n-1);
    if(*p+n-1 =='1')
        return 1;
    else
        return 0;
}
//强制转换字符串
void changeString(char str1[], int *str2[])
{
    int i;
    int arr[3];
    for(i=0; i<3; i++)
        arr[i]= (int)(str1[i]);
    for(i=0; i<3; i++)
        str2[i]= arr[i];
}*/
//打印所有文件
void printAllFile()
{
    UFD temp;
    int i;
    for(i=0;i<10;i++)
    {
        temp[i]=*(MFDUser[k].strNext+i);
    }

    for(i=0;i<10;i++)
    {
        if(temp[i].length>=0)
        printf("%s %d %d\n",temp[i].filename,temp[i].power,temp[i].length);
    }
    menu();
}
//主菜单
void menu()
{
	int operNum;
	printf("\n");
	printf("操作菜单：\n");
	printf("1.创建\n");
	printf("2.删除\n");
	printf("3.打开\n");
	printf("4.关闭\n");
	printf("5.阅读\n");
	printf("6.编写\n");
	printf("7.打印所有文件\n");
	printf("8.切换用户\n");
	printf("9.退出\n");
	printf("请选择一个操作：");
	scanf("%d",&operNum);
	switch(operNum)
	{
		case 1:createFile();break;
		case 2:deleteFile();break;
		case 3:openFile();break;
		case 4:closeFile();break;
		case 5:readFile();break;
		case 6:writeFile();break;
		case 7:printAllFile();break;
        case 8:testUser();break;
        case 9:stop();break;
		default :restart();break;
    }
}
//检测用户，判断是否允许登录
void testUser()
{
    int i;
	char s[100];
	if(k!= -1)//判断是否是第一个登录的用户；如果不是，则需要换行
        printf("\n");
	k= -1;
	printf("输入用户名:");
	scanf("%s",&s);
	for(i=0; i<4; i++)
    {
        if(strcmp(s, MFDUser[i].username)== 0)
        {
            k=i;
            break;
        }
    }
	if(k==-1)
	{
		printf("无该用户\n");
	}
	else
	{
		printf("该用户为%s\n其下文件为:\n",MFDUser[k].username);
		printAllFile();
		menu();
	}
}
//查找指定文件名的文件,并返回文件的位置
int queryFile(char fname[])
{
    int i;
    int flagment= -1;
    for(i=0; i<10; i++)
    {
/*        if(((MFDUser[k].strNext+flagment)->length)== -1)
            break;
        如果把上面if语句放在这里，会出现一个大bug；在文件目录中，
        当有空文件在有值的文件之前，后面有值的文件将无法被检测到*/
        if((strcmp((MFDUser[k].strNext+i)->filename, fname))== 0)
        {
            flagment= i;
            break;
        }
    }
    if(flagment== -1)
        return -1;
    else
    {
        if(((MFDUser[k].strNext+flagment)->length)== -1)
            return -1;
//        printf("查询方法内的值%d\n", flagment);
        return flagment;
    }
}
int main()
{
	testUser();
	return 0;
}

