package renderer;

import preprocessor.PreProcessor;

public class RendererStandardImpl implements Renderer {

	private PreProcessor preProcessor;

	public RendererStandardImpl(PreProcessor preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Override
	public void renderer(String string) {
		System.out.println(preProcessor.preProcess(string));
	}
}
