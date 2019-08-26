package shiyan2;

public class Memory {
	int memoryCapacity;
	PageAddress pa;
	Page page;
	int [][]pageDiagram;
//	int []time;//记录该页表项多久未被使用
	int length;//在内存中的页数
	int N;//内存的物理块数
	
	Memory(){
		length= 5;
		N=100;
		setPa(new PageAddress());
		setPage(new Page());
		pageDiagram= new int[length][2];
		page.time= new int[length];
		page.status= new int[length];
		memoryCapacity= pa.pageCapacity* N;
//		InitializePageDiagram(length);
	}
	
/*	public void definePageDiagram(){
		for(int i=0; i< pageDiagram.length; i++){
				pageDiagram[i]= -1;
		}
		//页表数据,n个页表项，n个页号
		InitializePageDiagram(n);
	}*/
	//查找该数组的真实长度
/*	public void SelectLength(){
		int j=0;
		while(pageDiagram[j]!= -1)//从当前数组的第一个等于-1的值后面开始添加数据
			j++;
		length= j;
		return;
	}
*/	public PageAddress getPa() {
		return pa;
	}
	public void setPa(PageAddress pa) {
		this.pa = pa;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
