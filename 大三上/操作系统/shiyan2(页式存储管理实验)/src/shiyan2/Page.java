package shiyan2;

public class Page {
	int pageNum;
	int physicalBlock;
	int []status;// 1表示在内存，0表示不再内存
	int []time;//访问次数
	int pageCapacity;
	
	Page(){
		this.pageCapacity= 1024;
	}
}
