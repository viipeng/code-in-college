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
		//初始化页表，都置为-1，表示空闲
		for(int i=0; i< me.length; i++){
			for(int j=0; j<2; j++)
				me.pageDiagram[i][j]= -1;
		}
		Scanner input= new Scanner(System.in);
		while(true){
			System.out.print("输入你要查询的地址:");
			int address= input.nextInt();
			if(address== -1) break;
			else if(address == -2) printpageDiagram();
			else
				selectPhysicalAddress(address);
			System.out.println();
		}
		input.close();
	}
	//查找对应的 物理地址
	public void selectPhysicalAddress(int address){
		int physicalBlock= 0;
		//计算页号
		pa.pageNum= address/pa.pageCapacity;
		pa.displacement= address-(pa.pageCapacity* pa.pageNum);
		System.out.println("页号为："+pa.pageNum+" "+"偏移量为：" +pa.displacement);
		//查找页表
		if(pa.pageNum< me.N){//如果该页存在，但不确定在不在页表
			if(selectPhysicalBlock(pa.pageNum)!= 0)//查找页表，是否要查找的页已经在内存
				physicalBlock= this.selectPhysicalBlock(pa.pageNum);
			else if(AddPageDiagram(pa.pageNum)){//如果页表有空闲，则把pageNum添加进页表
				physicalBlock= this.selectPhysicalBlock(pa.pageNum);
			}
			else{//缺页中断
				physicalBlock= this.lackPageStop(pa.pageNum);
			}
			int physicalAddress= physicalBlock* pa.pageCapacity+ pa.displacement;
//			printpageDiagram();
			printphysicalAddress(physicalAddress);
		}
		else{
			System.out.println("该页不存在，越界中断！");
		}
	}
	//缺页中断
	public int lackPageStop(int pageNum){
		System.out.println("该页不在内存中，进行缺页中断！");
		ExchangePage(pageNum);
		int physicalBlock= this.selectPhysicalBlock(pageNum);
//		int physicalAddress= physicalBlock* pa.pageCapacity+ pa.displacement;
//		printphysicalAddress(physicalAddress);
		//打印页表的信息
		printpageDiagram();
		return physicalBlock;
	}
	//打印页表
	public void printpageDiagram(){
		System.out.println("页表为：");
		for(int i=0; i< me.length; i++){
			System.out.println(me.pageDiagram[i][0] +" "+ me.pageDiagram[i][1]);
		}
	}
	//打印物理地址(以K、B为单位输出)
	public void printphysicalAddress(int physicalAddress) {
		int K= physicalAddress/pa.pageCapacity;
		int B= physicalAddress- K*pa.pageCapacity;
		System.out.println("物理地址为："+ K +"K "+ B +"B");
	}
	//查找页表中的物理块号
	public int selectPhysicalBlock(int pageNum){
		int physicalBlock=0, i=0;
//		if(pageNum< me.length){//在内存中----------------------？
		if(IsExist(pageNum)){//在页表中
			i= SelectPageNum(pageNum);
			physicalBlock= me.pageDiagram[i][1];
//			System.out.println("已找到!");
			TimeAdd();
			me.page.time[i]= 0;
//			PrintTime();
//			System.out.println("物理块号："+physicalBlock);
		}
/*		else{
			physicalBlock= lackPageStop();
		}*/
		return physicalBlock;
//		}
	}
	//置换页表项
	public void ExchangePage(int pageNum){
		int i= SelectPageToRemove();//i为要进行置换的页表项的位置
/*		int a= (int) (Math.random()*100);
		if(!IsRepetition(a) ){//如果产生的数不重复
			pageDiagram[i][0]= a;
//			length++;
		}*/
		me.page.status[i]= 0;
		me.pageDiagram[i][0]= pageNum;
		me.page.time[i]= 0;//每次换入新的页时要讲time置0
//		System.out.println("已置换!");
//		PrintTime();
//		System.out.println(pageDiagram[i][0] +" "+ pageDiagram[i][1]);
	}
	//在页表中查找对应的页表项
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
	//向页表添加页表项,成功的话返回true，失败返回false
	public boolean AddPageDiagram(int PageNum){
		//页表数据,只有length个页表项和物理块号
		int i= SelectUnwanted();
//		while(i< me.length){
		if(i!= -1){
			me.pageDiagram[i][0]= PageNum;
			me.page.time[i]= 0;
			me.page.status[i]= 1;
			int a= (int) (Math.random()*100);
			if(!IsRepetition(a) ){//如果产生的数不重复，则i+1
				me.pageDiagram[i][1]= a;
				return true;
			}
		}
		return false;
//				i++;
//			}
	}
	//判断页表是否有空闲，并返回空闲位的序号
	public int SelectUnwanted(){
		for(int i=0; i< me.length; i++){
			if(me.pageDiagram[i][0]== -1){
				return i;
			}
		}
		return -1;
	}
	//查找页号是否存在
	public boolean IsExist(int pageNum){
		for(int i=0; i< me.length; i++){
			if(me.pageDiagram[i][0]== pageNum){
				return true;
			}
		}
		return false;
	}
	//查找合适的页面进行置换
	public int SelectPageToRemove(){
		int max= 0;
		for(int j=1; j< me.length; j++){
			if(me.page.time[j]> me.page.time[max])
				max= j;
		}
		return max;
	}
	//判断随机生成的数是否已经存在
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
