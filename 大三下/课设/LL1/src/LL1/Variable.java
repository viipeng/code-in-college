package LL1;

public class Variable {

	int N1;//产生式的个数
	int M1;//终结符的个数（包括‘#’)
	int A1;//非终结符的个数

	Variable(){
		N1=8;
		M1=6;
		A1=5;
	}
	public int getN1() {
		return N1;
	}

	public int getM1() {
		return M1;
	}

	public int getA1() {
		return A1;
	}
}
