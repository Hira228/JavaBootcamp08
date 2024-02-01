package edu.school21.models;

import edu.school21.repositories.Printer;
import edu.school21.repositories.Renderer;

public class PrinterWithPrefixImpl implements Printer {
    String prefix;
    Renderer renderer;
    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }
    @Override
    public void print(String str){
        renderer.print((prefix == null ? "" : prefix + " ") + str);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}

