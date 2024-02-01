package edu.school21.models;

import edu.school21.repositories.PreProcessor;

public class PreProcessorToUpperImpl implements PreProcessor {
    @Override
    public String changeCase(String str){
        return str.toUpperCase();
    }

}
