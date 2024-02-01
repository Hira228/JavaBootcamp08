package edu.school21.models;

import edu.school21.repositories.PreProcessor;
import edu.school21.repositories.Renderer;

public class RendererStandardImpl implements Renderer {
    PreProcessor preProcessor;
    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void print(String str) {
        System.err.println(preProcessor.changeCase(str));
    }
}
