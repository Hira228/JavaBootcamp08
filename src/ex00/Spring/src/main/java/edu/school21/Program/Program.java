package edu.school21.Program;

import edu.school21.models.PreProcessorToUpperImpl;
import edu.school21.models.PrinterWithPrefixImpl;
import edu.school21.models.RendererErrImpl;
import edu.school21.repositories.PreProcessor;
import edu.school21.repositories.Renderer;

public class Program {
    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix");
        printer.print("Hello!");

    }
}
