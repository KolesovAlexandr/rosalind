package com.epam.rosalind.ba8e;

import com.epam.rosalind.utils.Reader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksandr_Kolesov on 5/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader("D:\\IdeaProjects\\rosalind\\src\\resources\\Input.txt");
        int n = reader.getN();
        float[][] data = reader.getData();
        Points points= new Points(data);
//        Map<String, Cluster> clusters = generateClusterMap(n);
//        Map<PairClusters, Float> dataMap = generateDataMap(n, data, clusters);
//        Map<HashSet<String>,Float> dataMap2 = new HashMap<>();
//        for (int i = 0;i<n;i++){
//            for (int j=i+1;j<n;j++){
//                HashSet<String> set = new HashSet<String>();
//                set.add("g"+i);
//                set.add("g"+j);
//                dataMap2.put(set,data[i][j]);
//            }
//        }
//        Set<String> minSet=min(dataMap2);
//        dataMap2=merge(dataMap2,minSet);
//
//        PairClusters min =min2(dataMap);
//
//
//
//

        System.out.println();
    }

//    private static Map<HashSet<String>, Float> merge(Map<HashSet<String>, Float> dataMap2, Set<String> minSet) {
//        Object[] a = new Object[2];
//        minSet.toArray(a);
//        for (.;:
//             ) {
//
//        }
        

//        return dataMap2;
//    }

    private static Set<String> min(Map<HashSet<String>, Float> dataMap2) {
        Set<String> minSet = null;
        float min = Float.MAX_VALUE;
        for (Map.Entry<HashSet<String>, Float> dataEntry : dataMap2.entrySet()){
            if(dataEntry.getValue()<min){
                min=dataEntry.getValue();
                minSet=dataEntry.getKey();
            }

        }
        return minSet;
    }

    private static Map<PairClusters, Float> generateDataMap(int n, float[][] data, Map<String, Cluster> clusters) {
        Map<PairClusters,Float> dataMap = new HashMap<>();
        for (int i = 0;i<n;i++){
            for (int j=i+1;j<n;j++){
                Cluster clusterI = clusters.get("g" + i);
                Cluster clusterJ = clusters.get("g" + j);
                dataMap.put(new PairClusters(clusterI,clusterJ),data[i][j]);
            }
        }
        return dataMap;
    }

//    private static Map<String, Cluster> generateClusterMap(int n) {
//        Map<String,Cluster> clusters = new HashMap<>();
//        for (int i=0;i<n;i++){
//            clusters.put("g"+i,new Cluster(i));
//        }
//        return clusters;
//    }

    private static PairClusters min2(Map<PairClusters, Float> dataMap) {
        float min = Float.MAX_VALUE;
        PairClusters minPair=null;

        for (Map.Entry<PairClusters,Float> dataEntry:dataMap.entrySet()){
            if (dataEntry.getValue()<min) {
                min=dataEntry.getValue();
                minPair=dataEntry.getKey();
            }
        }
        return minPair;
    }
}
