package edu.school21.models;

import edu.school21.repositories.Printer;
import edu.school21.repositories.Renderer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class PrinterWithDateTimeImpl implements Printer {
    Renderer renderer;
    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String str) {
        renderer.print(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + " " + str);
    }
}
