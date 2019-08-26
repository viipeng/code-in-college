package shiyan1;

public class shiyan1 {

	public static void main(String[] args) {
		System.out.println("进程名字，到达时间，运行时间，占用CPU时间，进程状态");
		ProcessDispatching pdc= new ProcessDispatching();
		pdc.dispatching();
	}
}