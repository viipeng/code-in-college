//����ϵͳ    ʵ����
//�����ļ�Ŀ¼     �ļ�ϵͳ���ʵ��
//����һ���ļ�����ɾ���󣬾��޷����������ļ����ˣ���������ѭ��������Ū��
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
//���ݳ�ʼ��
//   UFD��ʼ��
 UFD UFD1={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD2={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD3={{"file1",111,30},{"file2",111,20},{"file3",111,40},{"file4",011,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 UFD UFD4={{"file1",101,30},{"file2",111,20},{"file3",110,40},{"file4",111,20},{"file5",101,20},{"file6",100,20},{"file7",001,20},{"file",000,-1},{"file",000,-1},{"file",000,-1}};      //{"fileufd",000,-1}
 //  MFD��ʼ��
  mfd MFDUser[4]={{"user1",UFD1},{"user2",UFD2},{"user3",UFD3},{"user4",UFD4}};
  //AFD��ʼ��
  int afd= -1;
//���ֱ���ַ�
  int k=-1;//��¼�û�λ��
// int *read;
// int *write;
//�½��ļ�
void createFile()
{
    int i;
	int flag=1,kx;   //flag:�жϸ��û��ļ����Ƿ�����   kx:���б�־λ
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
		printf("�û��ɴ����ļ�����\n");
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
			printf("�����ļ�����");
			int flagname=0;
			scanf("%s",&name);
			flagname= queryFile(name);
			if(flagname!= -1)
			{
                printf("%s\n", &name);
				printf("�ļ���һ�£�����\n");
				continue;
			}
			break;
		}
		printf("����3λ�����루����˳�򣺶���д��ִ�У���0Ϊ���ɣ�1Ϊ�ɣ�����:110,�ɶ���д����ִ�У�:\n") ;
		scanf("%3d",&pow);
		printf("�����ļ����ȣ�");
		scanf("%d",&length);
		strcpy(t.filename, name);
		t.power= pow;
		t.length=length;
		*(MFDUser[k].strNext+kx)=t;
		printf("�����ɹ���\n");
//		int i=0;
//		for(i=0;i<10;i++)
//		{
//			if((MFDUser[k].strNext+i)->length!=-1)
//			printf("%s %s %d\n",(MFDUser[k].strNext+i)->filename,(MFDUser[k].strNext+i)->power,(MFDUser[k].strNext+i)->length);
//		}
    }
    menu();
}
//ɾ���ļ�
void deleteFile()
{
	printf("����Ҫɾ�����ļ�����");
	int flagment= 0;
	char name[3];
	scanf("%s", &name);
	if(afd!= -1 && strcmp((MFDUser[k].strNext+afd)->filename, name)== 0)
    {
        flagment= afd;
        afd= -1;//ɾ�����ļ�����Ѿ����򿪣���ôҲ�ᱻɾ����afdҲ�ᱻ���
    }
    else
        flagment= queryFile(name);
//	flagname= queryFile(name);
//    printf("��ɾ����ֵ�� %d λ,afd= %d\n", flagment, afd);
	if(flagment== -1)
        printf("���ļ������ڣ�\n");
    else{
        strcpy((MFDUser[k].strNext+flagment)->filename, "file");
        ((MFDUser[k].strNext+flagment)->power)= 000;
        ((MFDUser[k].strNext+flagment)->length)= -1;
        printf("ɾ���ɹ���\n");
    }
    menu();
}
//���ļ�
void readFile()
{
	printf("����Ҫ�Ķ����ļ����ļ�����");
	char s[10];
	int flagment;
//	int power1[3];
	scanf("%s", s);
	if(afd!= -1 && strcmp(((MFDUser[k].strNext+ afd)->filename), s)== 0)
    {
//        changeString((MFDUser[k].strNext+ afd)->power, power1);
//        printf("Ȩ��Ϊ%s\n", (MFDUser[k].strNext+ afd)->power);
//        printf("Ȩ��Ϊ%d%d%d\n", power1[0], power1[1], power1[2]);
//        strcmp(((MFDUser[k].strNext+ afd)->power), "100")==1 || strcmp(((MFDUser[k].strNext+ afd)->power), "101")==1 ||
//           strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 || strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//        int n=1;
//        isPower(n), ((MFDUser[k].strNext+flagment)->power)
        //ӵ�ж���Ȩ��
        if( (((MFDUser[k].strNext+ afd)->power)/100)== 1)
            printf("%s %d %d\n", (MFDUser[k].strNext+ afd)->filename,
                   (MFDUser[k].strNext+ afd)->power, (MFDUser[k].strNext+ afd)->length);
        else
            printf("���ļ��������Ķ���\n");
    }
    else
    {
        flagment= queryFile(s);
        if(flagment== -1)
        {
            printf("���ļ�������!\n");
        }
        else
        {
//            changeString((MFDUser[k].strNext+ flagment)->power, power1);
//            printf("Ȩ��Ϊ%s\n", (MFDUser[k].strNext+ flagment)->power);
//            printf("Ȩ��Ϊ%d%d%d\n", power1[0], power1[1], power1[2]);
        //ӵ�ж���Ȩ��
//        strcmp(((MFDUser[k].strNext+ afd)->power), "100")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "101")==1 ||
//            strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//            int n=1;
//            isPower(n), ((MFDUser[k].strNext+flagment)->power)
            //ӵ�ж���Ȩ��
            if( (((MFDUser[k].strNext+ flagment)->power)/100)== 1 )
                printf("%s %d %d\n", (MFDUser[k].strNext+ flagment)->filename,
                       (MFDUser[k].strNext+ flagment)->power, (MFDUser[k].strNext+ flagment)->length);
            else
                printf("���ļ��������Ķ���\n");
        }
    }
    menu();
}
//д�ļ�
void writeFile()
{
    printf("����Ҫ��д���ļ����ļ�����");
	char s[10];
	int flagment;
	scanf("%s", s);
	if(afd!= -1)
        flagment= afd;
    else
        flagment= queryFile(s);
    if(flagment== -1)
    {
        printf("���ļ�������!\n");
    }
    else
    {
//        strcmp(((MFDUser[k].strNext+ afd)->power), "010")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "011")==1 ||
//            strcmp(((MFDUser[k].strNext+ afd)->power), "110")==1 ||  strcmp(((MFDUser[k].strNext+ afd)->power), "111")==1
//        int n=2;
//        isPower(n, ((MFDUser[k].strNext+flagment)->power))
        //ӵ��д��Ȩ��
        if( ( ( ( (MFDUser[k].strNext+flagment)->power)%100)/10)== 1 )
        {
            struct ufd t=*(MFDUser[k].strNext+flagment);
            char name[100];
            int pow;
            int length;
            while(1)
            {
                printf("�����ļ�����");
                int flag;
                scanf("%s",&name);
                flag= queryFile(name);
                if(flag!= -1)
                {
                    printf("%s\n", &name);
                    printf("�ļ���һ�£�����\n");
                    continue;
                }
                break;
            }
            printf("����3λ�����루����˳�򣺶���д��ִ�У���0Ϊ���ɣ�1Ϊ�ɣ�����:110,�ɶ���д����ִ�У�:\n") ;
            scanf("%d",&pow);
            printf("�����ļ����ȣ�");
            scanf("%d",&length);
            strcpy(t.filename, name);
            t.power=pow;
            t.length=length;
            printf("%s %d %d\n", t.filename, t.power, t.length);
            *(MFDUser[k].strNext+flagment)=t;
            printf("��д�ɹ���\n");
        }
        else
        {
            printf("���ļ���������д��\n");
        }
    }
    menu();
}
//���ļ�
void openFile()
{
    int flagment;
    while(1)
    {
        printf("����Ҫ�򿪵��ļ����ļ�����");
        char s[10];
        scanf("%s", s);
        flagment= queryFile(s);
//        printf("flagment= %d\n", flagment);
        if(flagment== -1)
        {
            printf("���ļ�������! %d\n", afd);
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
    printf("%s�ļ��Ѿ��򿪣�\n", (MFDUser[k].strNext+ afd)->filename);
    menu();
}
//�ر��ļ�
void closeFile()
{
    if(afd== -1)
        printf("û���ļ����򿪣�\n");
    else
    {
        int i= afd;
        afd= -1;
//        strcpy(afd.filename, "file");
//        strcpy(afd.power, "000");
//        afd.length=-1;
        printf("%s�ļ��Ѿ��رգ�\n", ((MFDUser[k].strNext+ i)->filename));
    }
    menu();
}
//�˳�����
void stop()//------------------------�˳�������Ҫ��2�β�����������
{
    return 0;
}
//�������ִ���
void restart()
{
    printf("�������ִ���!\n");
    menu();
}
/*//�ж��Ƿ��ж�/д��Ȩ��
int isPower(int n, char power[])
{
    char *p= power[0];
//    printf("%s\ns", *p+n-1);
    if(*p+n-1 =='1')
        return 1;
    else
        return 0;
}
//ǿ��ת���ַ���
void changeString(char str1[], int *str2[])
{
    int i;
    int arr[3];
    for(i=0; i<3; i++)
        arr[i]= (int)(str1[i]);
    for(i=0; i<3; i++)
        str2[i]= arr[i];
}*/
//��ӡ�����ļ�
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
//���˵�
void menu()
{
	int operNum;
	printf("\n");
	printf("�����˵���\n");
	printf("1.����\n");
	printf("2.ɾ��\n");
	printf("3.��\n");
	printf("4.�ر�\n");
	printf("5.�Ķ�\n");
	printf("6.��д\n");
	printf("7.��ӡ�����ļ�\n");
	printf("8.�л��û�\n");
	printf("9.�˳�\n");
	printf("��ѡ��һ��������");
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
//����û����ж��Ƿ������¼
void testUser()
{
    int i;
	char s[100];
	if(k!= -1)//�ж��Ƿ��ǵ�һ����¼���û���������ǣ�����Ҫ����
        printf("\n");
	k= -1;
	printf("�����û���:");
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
		printf("�޸��û�\n");
	}
	else
	{
		printf("���û�Ϊ%s\n�����ļ�Ϊ:\n",MFDUser[k].username);
		printAllFile();
		menu();
	}
}
//����ָ���ļ������ļ�,�������ļ���λ��
int queryFile(char fname[])
{
    int i;
    int flagment= -1;
    for(i=0; i<10; i++)
    {
/*        if(((MFDUser[k].strNext+flagment)->length)== -1)
            break;
        ���������if��������������һ����bug�����ļ�Ŀ¼�У�
        ���п��ļ�����ֵ���ļ�֮ǰ��������ֵ���ļ����޷�����⵽*/
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
//        printf("��ѯ�����ڵ�ֵ%d\n", flagment);
        return flagment;
    }
}
int main()
{
	testUser();
	return 0;
}

