package shiyan1;

public class PCB {
    //������������ʱ�䣬��������ʱ�䣬����CPUʱ�䣬����״̬
	public String processName;
	public int arriveTime;//ʱ�������ֱ�ʾ,��1,2,3...
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