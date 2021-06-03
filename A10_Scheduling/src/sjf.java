//Roll No : 31358
import java.util.*;
public class sjf {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n, BT[], WT[], TAT[];

		System.out.println("Enter no of process");
		n = sc.nextInt();
		BT = new int[n + 1];
		WT = new int[n + 1];
		TAT = new int[n + 1];
		float AWT = 0,ATT=0;
		for (int i = 0; i < n; i++) {
		System.out.println("Enter BT for process " + (i + 1));
		BT[i] = sc.nextInt();
		}


		for (int i = 0; i < n; i++) {
		WT[i] = 0;
		TAT[i] = 0;
		}

		//sort
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-1; j++) {
				if (BT[j] > BT[j + 1]) {
					temp = BT[j];
					BT[j] = BT[j + 1];
					BT[j + 1] = temp;

					temp = WT[j];
					WT[j] = WT[j + 1];
					WT[j + 1] = temp;
		}
		}
		}


		//Calculating TT
		for (int i = 0; i < n; i++) {
			TAT[i] = BT[i] + WT[i];
			WT[i + 1] = TAT[i];
		}


		for(int i=0;i<n;i++)
		{
			System.out.println(WT[i]);	
		}


		TAT[n] = WT[n] + BT[n];
		System.out.println(" PID BT WT TAT ");
		for (int i = 0; i < n; i++)
		System.out.println(" " + i + "   " + BT[i] + "   " + WT[i] + "   " + TAT[i]);

		for (int j = 0; j < n; j++)
		{
			AWT += WT[j];
			ATT += TAT[j];

		}

		System.out.println("Avg waiting time=" + AWT/n);
		System.out.println("Avg turnaround time=" + ATT/n);

		}

}
