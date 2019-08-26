package shiyan1;

import java.util.LinkedList;
import java.util.Queue;

public class ProcessDispatching {

	private int time= 0;
    private Queue<Process> processQueue= new LinkedList<Process>();//�洢���н��̵���Ϣ
    private Queue<Process> readyQueue= new LinkedList<Process>();
    
    ProcessDispatching(){
		//������������ʱ�䣬��������ʱ�䣬����CPUʱ�䣬����״̬
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
    //���������
    public void dispatching(){
    	int n=1;
        while(processAreAllFinished()){
        	time++;
        	System.out.println("��ʱʱ����" +time+ "");
        	insertProcessIntoReadyQueue();//�����̲����������
        	if(readyQueue.peek()!= null){//����������в�Ϊ��
        		Process pro= readyQueue.poll();
            	System.out.println("��" +n+ "�ε���:");
            	
            	//CPU���д���
            	pro.getPcb().CPUTime+= 1;//��ռ��һ��CPU��CPUTime��1
            	pro.getPcb().processStatus= "Run";
            	
            	//��ӡ���н��̣��������У��Լ��������̵�PCB����ع�ϵ
            	pro.printRunProcess();
            	printReadyQueue();
            	printAllProcess();
            	
            	//CPU�������
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
        		System.out.println("��ʱ�������������");
        	}
    	    System.out.println();
        }
        System.out.println("���������" +time+ "������н��̶�����ˣ�");
    	printAllProcess();
    }
    //�鿴�Ƿ����еĽ��̶��Ѿ�����
    public boolean processAreAllFinished(){
    	for(Process p: processQueue){
    		if(p.getPcb().processStatus!= "Finish"){
    			return true;
    		}
    	}
    	return false;
    }
    //�����̲����������
    public void insertProcessIntoReadyQueue() {
    	for(Process p: processQueue){
    		if(time== p.getPcb().arriveTime && p.getPcb().processStatus== "null"){
    			readyQueue.offer(p);
    			p.getPcb().processStatus= "Wait";
    		}
    	}
    }
    //��ӡ��������
    public void printReadyQueue() {
    	System.out.print("�������У�");
    	for(Process p: readyQueue){
    		System.out.print(p.getPcb().processName+" ");
    	}
    	System.out.println();
    }
    //��ӡ���еĶ���
    public void printAllProcess() {
    	System.out.println("���н��̵���Ϣ��");
    	for(Process p: processQueue){
    		p.printPCB();
    	}
    }
}