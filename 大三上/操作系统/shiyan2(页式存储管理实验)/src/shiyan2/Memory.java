package shiyan2;

public class Memory {
	int memoryCapacity;
	PageAddress pa;
	Page page;
	int [][]pageDiagram;
//	int []time;//��¼��ҳ������δ��ʹ��
	int length;//���ڴ��е�ҳ��
	int N;//�ڴ���������
	
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
		//ҳ������,n��ҳ���n��ҳ��
		InitializePageDiagram(n);
	}*/
	//���Ҹ��������ʵ����
/*	public void SelectLength(){
		int j=0;
		while(pageDiagram[j]!= -1)//�ӵ�ǰ����ĵ�һ������-1��ֵ���濪ʼ�������
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
