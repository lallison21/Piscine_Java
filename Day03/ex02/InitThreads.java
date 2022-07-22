import java.util.List;

public class InitThreads extends Thread {

	private static int SumOfThreads = 0;

	int startIndex, lastIndex, localSum;

	private static synchronized void addToSum(int localSum, int startIndex, int lastIndex) {

		System.out.println(Thread.currentThread().getName() + ": from " + startIndex + " to "
				+ lastIndex + " sum is " + localSum);
		SumOfThreads += localSum;

	}

	public static int getSumOfThreads() {

		return SumOfThreads;

	}

	public InitThreads(List<Integer> integerList, int startIndex, int lastIndex) {

		this.startIndex = startIndex;
		this.lastIndex = lastIndex;
		localSum = 0;

		for (int x : integerList) {
			localSum += x;
		}

	}

	@Override
	public void run() {

		addToSum(localSum, startIndex, lastIndex);

	}

}
