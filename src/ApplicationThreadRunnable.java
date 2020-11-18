
import java.util.Scanner;

public class ApplicationThreadRunnable {

	public static void main(String[] args) throws Exception {

		System.out.println("Ââåä³òü ê³ëüê³ñòü ÷èñåë Ô³áîíà÷³, ÿê³ ïîòð³áíî âèâåñòè");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		MyThread myThread = new MyThread("MyThread", n);
		myThread.start();
		myThread.join();
		
		MyRunnable myRunnable = new MyRunnable("MyRunnable", n);
		new Thread(myRunnable).start();

		sc.close();

	}
}

class MyThread extends Thread {
	
	private String name;
	private int n;

	public MyThread(String name, int n) {
		this.name = name;
		this.n = n;
	}

	@Override
	public void run() {

		System.out.print("Ïîò³ê Thread : ");
		int[] f = new int[n];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		for (int j = 0; j < n; j++) {
			System.out.print(f[j] + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

}

class MyRunnable implements Runnable {
	
	private String name;
	private int n;
 
	public MyRunnable(String name, int n) {
		this.name = name;
		this.n = n; 
	}

	@Override
	public void run() {
		
		System.out.print("Ïîò³ê Runnable: ");
		int[] fib = new int[n];
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		for (int j = n - 1; j >= 0; j--) {
			System.out.print(fib[j] + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}