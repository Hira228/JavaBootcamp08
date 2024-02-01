package edu.school21.Program;

import edu.school21.repositories.Printer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramSpring {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("context.xml")){
            Printer printer = context.getBean("printer", Printer.class);
            printer.print("Hello!");

        }
    }
}
