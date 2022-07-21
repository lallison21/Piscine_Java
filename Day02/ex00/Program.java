import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
	public static final String EXIT = "42";
	public static final Integer SIGN_SIZE = 8;
	public static final char[] HEX_CHAR_ARRAY = "0123456789ABCDEF".toCharArray();

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		try (Scanner scanner = new Scanner(new FileInputStream("signatures.txt"))) {
			while (scanner.hasNextLine()) {
				String[] strings = scanner.nextLine().split(",");
				map.put(strings[0], strings[1].replaceAll(" ", ""));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found");
		}

		if (map.size() == 0) {
			return ;
		}

		try (FileOutputStream fileOutputStream = new FileOutputStream("result.txt", true)) {
			try (Scanner scanner = new Scanner(System.in)) {
				String fileName;

				while (true) {
					fileName = scanner.nextLine();

					if (fileName.equals(EXIT)) {
						break ;
					}

					try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
						byte[] bytes = new byte[SIGN_SIZE];

						Integer result = fileInputStream.read(bytes, 0, SIGN_SIZE);

						if (result < SIGN_SIZE) {
							System.out.println("Error");
							return ;
						}

						char[] hexChars = new char[bytes.length * 2];

						for (int j = 0; j < bytes.length; j++) {
							int v = bytes[j] & 0xFF;
							hexChars[j * 2] = HEX_CHAR_ARRAY[v >>> 4];
							hexChars[j * 2 + 1] = HEX_CHAR_ARRAY[v & 0x0F];
						}

						String signature = new String(hexChars);

						for (Map.Entry<String, String> entry : map.entrySet()) {
							if (signature.contains(entry.getValue())) {
								fileOutputStream.write(entry.getKey().getBytes());
								fileOutputStream.write('\n');
								System.out.println("PROCESSED");
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found");
		} catch (IOException e) {
			System.err.println("Error");
		}
	}
}