package shiyan2;

public class Page {
	int pageNum;
	int physicalBlock;
	int []status;// 1��ʾ���ڴ棬0��ʾ�����ڴ�
	int []time;//���ʴ���
	int pageCapacity;
	
	Page(){
		this.pageCapacity= 1024;
	}
}
