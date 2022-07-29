package preprocessor;

public class PreProcessorToLower implements PreProcessor {

	@Override
	public String preProcess(String string) {
		return string.toLowerCase();
	}
}
