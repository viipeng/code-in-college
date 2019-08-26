package shiyan2;

public class PageAddress {
	int pageNum;
	int displacement;//位移量
	int pageCapacity;//页面大小
	
	PageAddress(){
		this.pageCapacity= 1024;// 1K=1024
	}/*
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public int getPageCapacity() {
		return pageCapacity;
	}

	public void setPageCapacity(int pageCapacity) {
		this.pageCapacity = pageCapacity;
	}
*/
}
