package com.epam.rosalind.ba8e;

/**
 * Created by Aleksandr_Kolesov on 5/11/2016.
 */
public class Cluster {
    private String name;
    private float value;
    private Cluster node1;
    private Cluster node2;

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public Cluster getNode1() {
        return node1;
    }

    public Cluster getNode2() {
        return node2;
    }

    public Cluster(String name, Cluster node1, Cluster node2,float value) {
        this.name = name;
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }
}
