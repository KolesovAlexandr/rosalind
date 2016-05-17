package com.epam.rosalind.ba8e;

/**
 * Created by Aleksandr_Kolesov on 5/11/2016.
 */
public class PairClusters{
    public Cluster getCluster1() {
        return cluster1;
    }

    public Cluster getCluster2() {
        return cluster2;
    }

    private Cluster cluster1;
    private Cluster cluster2;

    public PairClusters(Cluster cluster1, Cluster cluster2) {
        this.cluster1 = cluster1;
        this.cluster2 = cluster2;
    }


    @Override
    public int hashCode() {
        return cluster1.hashCode()+cluster2.hashCode();
    }


}
