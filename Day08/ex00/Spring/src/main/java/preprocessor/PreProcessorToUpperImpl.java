package preprocessor;

public class PreProcessorToUpperImpl implements PreProcessor {

	@Override
	public String preProcess(String string) {
		return string.toUpperCase();
	}
}
