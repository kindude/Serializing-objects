package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Handler {
    private WriteObject wo;
    private ReadObject ro;
    private Boat[] boats;
    private String fileName;
    private String logFile;
    private FileWriter fw;
    public Handler() throws IOException {
       fileName = "oiFile.csv";
       logFile = "Logs.txt";
       Scanner in =  new Scanner(System.in);
       System.out.println("Pier was created, what is number of boats and water bikes?");

       MyLogger.log(Level.INFO,"Pier was created, what is number of boats and water bikes?");

       System.out.print("Boats:");
       int n = in.nextInt();

       MyLogger.log(Level.INFO,"Boats " + n);
       System.out.print("Water Bikes:");
       int m = in.nextInt();
       MyLogger.log(Level.INFO,"Water Bikes: " + m);
       CreatingObjects(n,m);
       MyLogger.log(Level.INFO,"Serializing in file " + fileName);
       Serializing();
       MyLogger.log(Level.INFO,"Deserializing");
       Deserializing();
       in.close();
       MyLogger.log(Level.INFO,"Deserializing");


    }
    private void CreatingObjects(int n, int m)
    {
       boats =  new Boat[n + m];
       for (int i = 0; i < n  ;i ++)
       {
           boats[i] =  new Boat();
       }
       for(int i=0;i<m;i++)
       {
           boats[n+i] = new WaterBike();
       }
    }

    private void Serializing() throws IOException {
        wo =  new WriteObject(boats, fileName);
        String result =  wo.ProcessingSerializing();
        MyLogger.log(Level.INFO,result);
    }

    private void Deserializing() throws IOException {
        ro = new ReadObject(fileName);
        System.out.println(Arrays.toString(ro.ProcessDesirializing()));
        String result = ro.LogInfo();
        MyLogger.log(Level.INFO,result);

    }
}
