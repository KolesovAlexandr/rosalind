package com.epam.rosalind.ba8e;

/**
 * Created by Aleksandr_Kolesov on 5/18/2016.
 */
public class Cluster {
    private Cluster cluster1 = null;
    private Cluster cluster2 = null;
    private String label;
    private int size = 1;

    public Cluster(String label) {
        this.label = label;
    }


    public Cluster(Cluster cluster1, Cluster cluster2) {
        this.cluster1 = cluster1;
        this.cluster2 = cluster2;
        this.label = cluster1.getLabel() + "," + cluster2.getLabel();
        this.size = this.size() + cluster1.size() + cluster2.size();
    }

    public String getLabel() {
        return label;
    }

    public int size() {
        return size;
    }

    public Cluster getCluster1() {
        return cluster1;
    }

    public Cluster getCluster2() {
        return cluster2;
    }
}
