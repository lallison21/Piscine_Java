import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

	private static int sumOfList(List<Integer> integerList) {

		int tmp = 0;

		for (int x : integerList) {
			tmp += x;
		}

		return tmp;

	}

	public static void main(String[] args) {

		if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
			System.out.println("Error: Incorrect argument");
			System.exit(-1);
		}

		Integer arraySize = Integer.parseInt(args[0].replaceFirst("--arraySize=", ""));
		Integer threadsCount = Integer.parseInt(args[1].replaceFirst("--threadsCount=", ""));

		List<Integer> integerList = new ArrayList<>(arraySize);

		for (int i = 0; i < arraySize; i++) {
			int random = ThreadLocalRandom.current().nextInt() % 1000;
			if (random < 0) {
				integerList.add(random *= -1);
			} else {
				integerList.add(random);
			}
		}

		System.out.println("Sum: " + sumOfList(integerList));

		int range = arraySize / threadsCount + 1;

		List<Thread> threadList = new ArrayList<>(threadsCount);

		int startIndex = 0, lastIndex = 0;

		for (int i = 0; i < threadsCount - 1; i++) {
			startIndex = i * range;
			lastIndex = (i + 1) * range;
			threadList.add(new InitThreads(integerList.subList(startIndex, lastIndex), startIndex, lastIndex - 1));
		}

		startIndex = (threadsCount - 1) * range;
		lastIndex = arraySize;

		threadList.add(new InitThreads(integerList.subList(startIndex, lastIndex), startIndex, lastIndex - 1));

		for (Thread thread : threadList) {
			thread.start();
		}

		for (Thread thread : threadList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Sum by threads: " + InitThreads.getSumOfThreads());

	}

}
