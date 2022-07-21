import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Program {

	private static void fillMap(Map<String, Integer> fileMap, ArrayList<String> fileArray) {
		for (String string : fileArray) {
			int frequency = Collections.frequency(fileArray, string);
			fileMap.put(string, frequency);
		}
	}

	private static Integer countNumerator(Integer[] vector1, Integer[] vector2) {
		Integer numerator = 0;

		for (int i = 0; i < vector1.length; i++) {
			Integer integer1 = vector1[i];
			Integer integer2 = vector2[i];
			numerator += integer1 * integer2;
		}

		return numerator;
	}

	private static Double countDenominator(Integer[] vector1, Integer[] vector2) {
		Double doubleSum1 = 0.0;
		Double doubleSum2 = 0.0;

		for (int i = 0; i < vector1.length; i++) {
			doubleSum1 += vector1[i] * vector1[i];
			doubleSum2 += vector2[i] * vector2[i];
		}

		doubleSum1 = Math.sqrt(doubleSum1);
		doubleSum2 = Math.sqrt(doubleSum2);

		return doubleSum1 * doubleSum2;
	}

	private static void	findSimilarity(Map<String, Integer> fileMap1, Map<String, Integer> fileMap2,
										  HashSet<String> stringHashSet) {
		ArrayList<String> dictionary = new ArrayList<>(stringHashSet);

		Collections.sort(dictionary);

		Integer[] vector1 = new Integer[dictionary.size()];
		Integer[] vector2 = new Integer[dictionary.size()];

		for (int i = 0; i < dictionary.size(); i++) {
			if (fileMap1.get(dictionary.get(i)) == null) {
				vector1[i] = 0;
			} else {
				vector1[i] = fileMap1.get(dictionary.get(i));
			}
			if (fileMap2.get(dictionary.get(i)) == null) {
				vector2[i] = 0;
			} else {
				vector2[i] = fileMap2.get(dictionary.get(i));
			}
		}

		Integer numerator = countNumerator(vector1, vector2);
		Double denominator = countDenominator(vector1, vector2);

		System.out.println("Similarity = " + new BigDecimal(numerator / denominator).setScale(2,
				RoundingMode.FLOOR));
	}

	private static void writeSetToDictionary(HashSet<String> stringHashSet) {
		ArrayList<String> dictionary = new ArrayList<>(stringHashSet);

		Collections.sort(dictionary);

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Dictionary.txt"))) {
			for (String string : dictionary) {
				bufferedWriter.write(string);
				bufferedWriter.write('\n');
			}
		} catch (IOException e) {
			System.err.println("Fatal: IOException");
		}
	}

	private static String readFile(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			String string = bufferedReader.readLine();

			while (string != null) {
				stringBuilder.append(string);
				string = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Fatal: IOException");
			System.exit(-1);
		}

		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Incorrect arguments");
			return ;
		}

		String file1 = readFile(args[0]), file2 = readFile(args[1]);

		if (file1.isEmpty() && file2.isEmpty()) {
			System.err.println("Similarity = " + 1);
			return ;
		}

		if (file1.isEmpty() || file2.isEmpty()) {
			System.err.println("Similarity = " + 0);
			return ;
		}

		ArrayList<String> fileArray1 = new ArrayList<>(Arrays.asList(file1.split(" ")));
		ArrayList<String> fileArray2 = new ArrayList<>(Arrays.asList(file2.split(" ")));

		Map<String, Integer> fileMap1 = new HashMap<>();
		Map<String, Integer> fileMap2 = new HashMap<>();

		fillMap(fileMap1, fileArray1);
		fillMap(fileMap2, fileArray2);

		HashSet<String> stringHashSet = new HashSet<>(fileMap1.keySet());
		stringHashSet.addAll(fileMap2.keySet());

		writeSetToDictionary(stringHashSet);
		findSimilarity(fileMap1, fileMap2, stringHashSet);
	}

}
