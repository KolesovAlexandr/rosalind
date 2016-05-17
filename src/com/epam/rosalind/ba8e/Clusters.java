package com.epam.rosalind.ba8e;

import java.util.HashMap;

/**
 * Created by Aleksandr_Kolesov on 5/12/2016.
 */
public class Clusters {
    HashMap<String,Cluster> clusters;
    public Clusters(int n){
        clusters = new HashMap<>();
        for (int i=0;i<n;i++){
            Cluster cluster = new Cluster(Integer.toString(i), null, null,-1);
            clusters.put(Integer.toString(i),cluster);
        }

    }
    public void mergeClusters(String clusterName1,String clusterName2,float value){
        Cluster cluster1 = clusters.remove(clusterName1);
        Cluster cluster2 = clusters.remove(clusterName2);
        String newClusteName = clusterName1+clusterName2;
        Cluster newCluster = new Cluster(newClusteName,cluster1,cluster2,value);
        clusters.put(newClusteName,newCluster);
    }
}
