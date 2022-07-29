package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class WriteObject {

    private char[] animationChars;
    private String fileName;
    private Object obj;

    public WriteObject(Object obj, String fileName) throws IOException {
        animationChars = new char[]{'|', '/', '-', '\\'};
        this.fileName = fileName;
        this.obj = obj;
    }

    public String ProcessingSerializing() throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            for (int i = 0; i <= 100; i++) {
                System.out.print("Serializing in process: " + i + "% " + animationChars[i % 4] + "\r");
                try{
                    Thread.sleep(40);
                }
                catch (InterruptedException e){
                     e.printStackTrace();
                     return e.toString();
                }
            }
            Thread.sleep(500);
            System.out.print("Serializing completed successfully");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.toString();
        }
    return "Serializing Success";
    }

}
