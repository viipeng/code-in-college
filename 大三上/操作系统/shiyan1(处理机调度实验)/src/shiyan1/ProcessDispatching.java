package shiyan1;

import java.util.LinkedList;
import java.util.Queue;

public class ProcessDispatching {

	private int time= 0;
    private Queue<Process> processQueue= new LinkedList<Process>();//存储所有进程的信息
    private Queue<Process> readyQueue= new LinkedList<Process>();
    
    ProcessDispatching(){
		//进程名，到达时间，运行所需时间，已用CPU时间，进程状态
	    Process pro1= new Process("process1", 1, 4, 0, "null");
	    Process pro2= new Process("process2", 2, 2, 0, "null");
	    Process pro3= new Process("process3", 3, 2, 0, "null");
	    Process pro4= new Process("process4", 8, 4, 0, "null");
//	    Process pro5= new Process("process5", 10, 4, 0, "null");
	    processQueue.offer(pro1);
	    processQueue.offer(pro2);
	    processQueue.offer(pro3);
	    processQueue.offer(pro4);
//	    processQueue.offer(pro5);
    }
    //处理机调度
    public void dispatching(){
    	int n=1;
        while(processAreAllFinished()){
        	time++;
        	System.out.println("此时时刻是" +time+ "");
        	insertProcessIntoReadyQueue();//将进程插入就绪队列
        	if(readyQueue.peek()!= null){//如果就绪队列不为空
        		Process pro= readyQueue.poll();
            	System.out.println("第" +n+ "次调度:");
            	
            	//CPU进行处理
            	pro.getPcb().CPUTime+= 1;//已占用一次CPU，CPUTime加1
            	pro.getPcb().processStatus= "Run";
            	
            	//打印运行进程，就绪队列，以及各个进程的PCB的相关关系
            	pro.printRunProcess();
            	printReadyQueue();
            	printAllProcess();
            	
            	//CPU处理结束
            	if(pro.getPcb().CPUTime== pro.getPcb().runTime){
        	    	pro.getPcb().processStatus= "Finish";
            	}
            	else{
        	    	pro.getPcb().processStatus= "Wait";
        		    readyQueue.offer(pro);
            	}
        	    n++;
        	}
        	else{
        		System.out.println("此时处理机不工作！");
        	}
    	    System.out.println();
        }
        System.out.println("处理机花了" +time+ "秒把所有进程都完成了！");
    	printAllProcess();
    }
    //查看是否所有的进程都已经结束
    public boolean processAreAllFinished(){
    	for(Process p: processQueue){
    		if(p.getPcb().processStatus!= "Finish"){
    			return true;
    		}
    	}
    	return false;
    }
    //将进程插入就绪队列
    public void insertProcessIntoReadyQueue() {
    	for(Process p: processQueue){
    		if(time== p.getPcb().arriveTime && p.getPcb().processStatus== "null"){
    			readyQueue.offer(p);
    			p.getPcb().processStatus= "Wait";
    		}
    	}
    }
    //打印就绪队列
    public void printReadyQueue() {
    	System.out.print("就绪队列：");
    	for(Process p: readyQueue){
    		System.out.print(p.getPcb().processName+" ");
    	}
    	System.out.println();
    }
    //打印所有的队列
    public void printAllProcess() {
    	System.out.println("所有进程的信息：");
    	for(Process p: processQueue){
    		p.printPCB();
    	}
    }
}