package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer {

	private PreProcessor preProcessor;

	public RendererErrImpl(PreProcessor preProcessor) {
		this.preProcessor = preProcessor;
	}

	@Override
	public void renderer(String string) {
		System.err.println(preProcessor.preProcess(string));
	}
}
