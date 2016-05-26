package com.epam.rosalind.ba8e;

import java.util.*;

/**
 * Created by Aleksandr_Kolesov on 5/18/2016.
 */
public class Clusters {
    public Map<String, Cluster> getClusters() {
        return clusters;
    }

    private Map<String, Cluster> clusters;

    public Clusters(int n) {
        clusters = new HashMap<String, Cluster>();
        for (int i = 1; i <= n; i++) {
            clusters.put(String.valueOf(i), new Cluster(String.valueOf(i)));
        }
    }


    public Cluster getCluster(String label) {
        return clusters.get(label);
    }

    public void addCluster(Cluster cluster) {
        clusters.put(cluster.getLabel(), cluster);
    }

    public void deleteCluster(String label) {
        clusters.remove(label);
    }
}
