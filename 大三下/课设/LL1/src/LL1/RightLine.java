package LL1;

public class RightLine {

	private	char left;
	private String right;
	
	/*public void initialize(char s1, String s2){
		left= s1;
		right= s2;
	}*/
	public void setLeft(char left) {
		this.left = left;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public String getright(){
		String str= right;
		return str;
	}
	public char getleft(){
		char c= left;
		return c;
	}
	public void printRightLine(){
		System.out.println(left + "->" + right);
	}
}
