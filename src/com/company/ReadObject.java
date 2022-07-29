package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ReadObject {
private String fileName;
private Exception e = null;
    public ReadObject(String fileName)
    {
        this.fileName = fileName;
    }

    public Object[] ProcessDesirializing() throws IOException {
        Boat[] object =  null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            object = (Boat[]) ois.readObject();
            object = (Boat[]) TryDownCasting(object);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            this.e = e;
        }
        return object;
}
    public String LogInfo() throws IOException {
        if(e!= null)
        {

            return e.toString();
        }
        else{
            return "Deserializng success";
        }
    }

    private Object[] TryDownCasting(Object[] object)
    {
        Boat[] bt = new Boat[object.length];
        char[] animationChars = new char[]{'|', '/', '-', '\\'};
        for (int i=0;i<object.length;i++) {
            try {
                bt[i] = (WaterBike) object[i];
            } catch (ClassCastException e) {
                bt[i] = (Boat) object[i];
            }
        }
        for (int i = 0; i <= 100; i++) {
            System.out.print("Deserializing in process: " + i + "% " + animationChars[i % 4] + "\r");
            try{
                Thread.sleep(40);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print("Deserializing completed succesfully");
        return bt;
    }
}
