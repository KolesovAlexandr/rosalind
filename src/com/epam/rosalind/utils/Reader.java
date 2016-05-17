package com.epam.rosalind.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Aleksandr_Kolesov on 5/10/2016.
 */
public class Reader {
    public int getN() {
        return n;
    }

    private int n;
    private float [][] data;


    public float[][] getData() {
        return data;
    }

    public Reader(String fileName){
        try {
            Scanner in = new Scanner(new File(fileName));
            n = new Integer(in.nextLine());
            data = new float[n][n];
            int i=0, j=0;
            while (in.hasNextFloat()){

                data[i][j] = in.nextFloat();
                i++;
                if (i==n){
                    i=0;
                    j++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
