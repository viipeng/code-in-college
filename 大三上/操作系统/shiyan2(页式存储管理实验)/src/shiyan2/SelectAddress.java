package shiyan2;


import java.util.Scanner;

public class SelectAddress {
	private PageAddress pa;
	private Memory me;

	SelectAddress(){
		setPa(new PageAddress());
		setMe(new Memory());
/*		for(int i=0; me.pageDiagram[i]!= -1; i++){
			System.out.println(i+ " " +me.pageDiagram[i]+" ");
		}*/
		//��ʼ��ҳ������Ϊ-1����ʾ����
		for(int i=0; i< me.length; i++){
			for(int j=0; j<2; j++)
				me.pageDiagram[i][j]= -1;
		}
		Scanner input= new Scanner(System.in);
		while(true){
			System.out.print("������Ҫ��ѯ�ĵ�ַ:");
			int address= input.nextInt();
			if(address== -1) break;
			else if(address == -2) printpageDiagram();
			else
				selectPhysicalAddress(address);
			System.out.println();
		}
		input.close();
	}
	//���Ҷ�Ӧ�� �����ַ
	public void selectPhysicalAddress(int address){
		int physicalBlock= 0;
		//����ҳ��
		pa.pageNum= address/pa.pageCapacity;
		pa.displacement= address-(pa.pageCapacity* pa.pageNum);
		System.out.println("ҳ��Ϊ��"+pa.pageNum+" "+"ƫ����Ϊ��" +pa.displacement);
		//����ҳ��
		if(pa.pageNum< me.N){//�����ҳ���ڣ�����ȷ���ڲ���ҳ��
			if(selectPhysicalBlock(pa.pageNum)!= 0)//����ҳ���Ƿ�Ҫ���ҵ�ҳ�Ѿ����ڴ�
				physicalBlock= this.selectPhysicalBlock(pa.pageNum);
			else if(AddPageDiagram(pa.pageNum)){//���ҳ���п��У����pageNum��ӽ�ҳ��
				physicalBlock= this.selectPhysicalBlock(pa.pageNum);
			}
			else{//ȱҳ�ж�
				physicalBlock= this.lackPageStop(pa.pageNum);
			}
			int physicalAddress= physicalBlock* pa.pageCapacity+ pa.displacement;
//			printpageDiagram();
			printphysicalAddress(physicalAddress);
		}
		else{
			System.out.println("��ҳ�����ڣ�Խ���жϣ�");
		}
	}
	//ȱҳ�ж�
	public int lackPageStop(int pageNum){
		System.out.println("��ҳ�����ڴ��У�����ȱҳ�жϣ�");
		ExchangePage(pageNum);
		int physicalBlock= this.selectPhysicalBlock(pageNum);
//		int physicalAddress= physicalBlock* pa.pageCapacity+ pa.displacement;
//		printphysicalAddress(physicalAddress);
		//��ӡҳ�����Ϣ
		printpageDiagram();
		return physicalBlock;
	}
	//��ӡҳ��
	public void printpageDiagram(){
		System.out.println("ҳ��Ϊ��");
		for(int i=0; i< me.length; i++){
			System.out.println(me.pageDiagram[i][0] +" "+ me.pageDiagram[i][1]);
		}
	}
	//��ӡ�����ַ(��K��BΪ��λ���)
	public void printphysicalAddress(int physicalAddress) {
		int K= physicalAddress/pa.pageCapacity;
		int B= physicalAddress- K*pa.pageCapacity;
		System.out.println("�����ַΪ��"+ K +"K "+ B +"B");
	}
	//����ҳ���е�������
	public int selectPhysicalBlock(int pageNum){
		int physicalBlock=0, i=0;
//		if(pageNum< me.length){//���ڴ���----------------------��
		if(IsExist(pageNum)){//��ҳ����
			i= SelectPageNum(pageNum);
			physicalBlock= me.pageDiagram[i][1];
//			System.out.println("���ҵ�!");
			TimeAdd();
			me.page.time[i]= 0;
//			PrintTime();
//			System.out.println("�����ţ�"+physicalBlock);
		}
/*		else{
			physicalBlock= lackPageStop();
		}*/
		return physicalBlock;
//		}
	}
	//�û�ҳ����
	public void ExchangePage(int pageNum){
		int i= SelectPageToRemove();//iΪҪ�����û���ҳ�����λ��
/*		int a= (int) (Math.random()*100);
		if(!IsRepetition(a) ){//��������������ظ�
			pageDiagram[i][0]= a;
//			length++;
		}*/
		me.page.status[i]= 0;
		me.pageDiagram[i][0]= pageNum;
		me.page.time[i]= 0;//ÿ�λ����µ�ҳʱҪ��time��0
//		System.out.println("���û�!");
//		PrintTime();
//		System.out.println(pageDiagram[i][0] +" "+ pageDiagram[i][1]);
	}
	//��ҳ���в��Ҷ�Ӧ��ҳ����
	public int SelectPageNum(int pageNum){
		int i=0;
/*		for(i=0; i< me.length; i++)
			if(me.pageDiagram[i][0]== pageNum){
				return i;
			}*/
		while(me.pageDiagram[i][0]!= pageNum)
			i++;
		return i;
	}
	//��ҳ�����ҳ����,�ɹ��Ļ�����true��ʧ�ܷ���false
	public boolean AddPageDiagram(int PageNum){
		//ҳ������,ֻ��length��ҳ�����������
		int i= SelectUnwanted();
//		while(i< me.length){
		if(i!= -1){
			me.pageDiagram[i][0]= PageNum;
			me.page.time[i]= 0;
			me.page.status[i]= 1;
			int a= (int) (Math.random()*100);
			if(!IsRepetition(a) ){//��������������ظ�����i+1
				me.pageDiagram[i][1]= a;
				return true;
			}
		}
		return false;
//				i++;
//			}
	}
	//�ж�ҳ���Ƿ��п��У������ؿ���λ�����
	public int SelectUnwanted(){
		for(int i=0; i< me.length; i++){
			if(me.pageDiagram[i][0]== -1){
				return i;
			}
		}
		return -1;
	}
	//����ҳ���Ƿ����
	public boolean IsExist(int pageNum){
		for(int i=0; i< me.length; i++){
			if(me.pageDiagram[i][0]== pageNum){
				return true;
			}
		}
		return false;
	}
	//���Һ��ʵ�ҳ������û�
	public int SelectPageToRemove(){
		int max= 0;
		for(int j=1; j< me.length; j++){
			if(me.page.time[j]> me.page.time[max])
				max= j;
		}
		return max;
	}
	//�ж�������ɵ����Ƿ��Ѿ�����
	public boolean IsRepetition(int a){
		int i=0;
		while(i< me.length){
			if(me.pageDiagram[i][1]== a)
				return true;
			i++;
		}
		return false;
	}
/*	public void StatusAdd(){
		for(int i=0; i< me.length; i++)
			me.page.status[i]= 0;
	}*/
	public void TimeAdd(){
		for(int i=0; i< me.length; i++)
			me.page.time[i]++;
	}
	public void PrintTime(){
		for(int i=0; i< me.length; i++)
			System.out.println(i+" "+me.page.time[i]);
	}
	public PageAddress getPa() {
		return pa;
	}
	public void setPa(PageAddress pa) {
		this.pa = pa;
	}
	public Memory getMe() {
		return me;
	}
	public void setMe(Memory me) {
		this.me = me;
	}
}
