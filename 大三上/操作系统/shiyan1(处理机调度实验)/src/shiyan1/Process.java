package shiyan1;

public class Process {
		//��ص����ݽṹ
		//private String procedure;//�����
		private PCB pcb;
		
		Process(String processName, int arriveTime, int runTime, int CPUTime, String processStatus){
			setPcb(new PCB(processName, arriveTime, runTime, CPUTime, processStatus));
		}
		public PCB getPcb() {
			return pcb;
		}
		public void setPcb(PCB pcb) {
			this.pcb = pcb;
		}
		public void printRunProcess(){
			System.out.print("���н��̣�");
			printPCB();
		}
		public void printPCB(){
			System.out.print(this.getPcb().processName+ " ");
			System.out.print(this.getPcb().arriveTime+ " ");
			System.out.print(this.getPcb().runTime+ " ");
			System.out.print(this.getPcb().CPUTime+ " ");
			System.out.print(this.getPcb().processStatus);
			System.out.println();
		}
}