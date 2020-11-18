

	import java.util.Scanner;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;

	public class ApplicationScheduledThreadPool {

		public static void main(String[] args) throws Exception {

			System.out.println("Ââåä³òü ê³ëüê³ñòü ÷èñåë Ô³áîíà÷³, ÿê³ ïîòð³áíî âèâåñòè");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			ExecutorService executable = Executors.newScheduledThreadPool(1);
			executable.execute(new MyThread("myThread", n));
			executable.execute(new MyRunnable("myRunnable", n));

			executable.shutdown();

			sc.close();

		}

	}

