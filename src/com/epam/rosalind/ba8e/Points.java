package com.epam.rosalind.ba8e;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Created by Aleksandr_Kolesov on 5/12/2016.
 */
public class Points {
    private HashMap<String, HashMap<String, Float>> points;
    public HashMap<String, HashMap<String, Float>> getPoints() {
        return points;
    }

    public Points(float[][] data) {
        points = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            HashMap<String, Float> linkPoints = new HashMap<>();
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != 0) {
                    linkPoints.put(Integer.toString(j), data[i][j]);
                }
            }
            if (linkPoints.size() > 0) points.put(Integer.toString(i), linkPoints);
        }
    }

    public ArrayList<String> searchMin() {
        float min = Float.MAX_VALUE;
        String point1Min = "";
        String point2Min = "";
        for (Map.Entry<String, HashMap<String, Float>> p1: points.entrySet()) {
            String p1Key = p1.getKey();
            HashMap<String, Float> p1Value = p1.getValue();
            for (Map.Entry<String,Float> p2: p1Value.entrySet()){
                String p2Key = p2.getKey();
                Float p2Value = p2.getValue();
                if(p2Value<min){
                    min=p2Value;
                    point1Min=p1Key;
                    point2Min=p2Key;
                }

            }

        }
        ArrayList list= new ArrayList(2);
        list.add(point1Min);
        list.add(point2Min);
        return list;

    }

    public void merge(ArrayList<String> PairPoints,Clusters clusters){
        String point1 = PairPoints.get(0);
        String point2 = PairPoints.get(1);
        String mergePoint = point1 + point2;
        deletePoints(point1);
        deletePoints(point2);
        addPoint(mergePoint,point1,);



    }

    private void addPoint(String mergePoint) {
    }

    private void deletePoints(String point) {
        HashMap<String, Float> pointsForDelete = points.remove(point);
        for (Map.Entry<String,Float> pointDel:pointsForDelete.entrySet()){
            points.get(pointDel).remove(point);
        }

    }
}
