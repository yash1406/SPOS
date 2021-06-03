//Roll No : 31358
import java.util.*;
public class fcfs {
		
	int n;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of process: ");
		int n = sc.nextInt();
		int pid[] = new int[n];
		int bt[] = new int[n];
		int at[] = new int[n];
		int wt[] = new int[n];
		int tt[] = new int[n];
		int ct[] = new int[n];

		float awt=0,att=0;
		int temp;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter process "+(i+1)+" Burst time : ");
			bt[i]=sc.nextInt();
			System.out.print("Enter process "+(i+1)+" Arrival time : ");
			at[i]=sc.nextInt();	
			pid[i]=i+1;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-(i+1);j++)
			{
				if(at[j] > at[j+1])
				{
					temp=at[j];
					at[j]=at[j+1];
					at[j+1]=temp;
					
					temp=bt[j];
					bt[j]=bt[j+1];
					bt[j+1]=temp;
					
					temp=pid[j];
					pid[j]=pid[j+1];
					pid[j+1]=temp;
					
				}
			}
		}
		
		for(int  i = 0 ; i < n; i++)
		{
			if( i == 0)
			{	
				ct[i] = at[i] + bt[i];
			}
			else
			{
				if( at[i] > ct[i-1])
				{
					ct[i] = at[i] + bt[i];
				}
				else
					ct[i] = ct[i-1] + bt[i];
			}
			tt[i] = ct[i] - at[i] ;         
			wt[i] = tt[i] - bt[i] ;         
			awt += wt[i] ;              
			att += tt[i] ; 			
		}
		System.out.println("pid    bt    at    wt    tt");
		for(int i=0;i<n;i++)
		{
		System.out.println(pid[i]+"      "+bt[i]+"      "+at[i]+"    "+wt[i]+"    "+tt[i]);
		}
		System.out.println("\naverage waiting time: "+ (awt/n));    
		System.out.println("average turnaround time:"+(att/n));    	

		
	}

	
}
