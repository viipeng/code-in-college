package shiyan1;

public class PCB {
    //进程名，到达时间，运行所需时间，已用CPU时间，进程状态
	public String processName;
	public int arriveTime;//时间用数字表示,如1,2,3...
	public int runTime;
	public int CPUTime;
	public String processStatus;//Wait,Run,Finish
	
	PCB(String processName, int arriveTime, int runTime, int CPUTime, String processStatus){
		this.processName= processName;
		this.arriveTime= arriveTime;
		this.runTime= runTime;
		this.CPUTime= CPUTime;
		this.processStatus= processStatus;
	}
}