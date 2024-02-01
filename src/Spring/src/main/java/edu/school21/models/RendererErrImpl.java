package edu.school21.models;

import edu.school21.repositories.PreProcessor;
import edu.school21.repositories.Renderer;

public class RendererErrImpl implements Renderer {
    PreProcessor preProcessor;
    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String str) {
        System.err.println(preProcessor.changeCase(str));
    }
}
