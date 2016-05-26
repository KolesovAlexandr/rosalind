package com.epam.rosalind.ba8e;

import com.epam.rosalind.utils.Reader;

import java.util.*;


/**
 * Created by Aleksandr_Kolesov on 5/11/2016.
 */
public class HierarchicalClustering {
    public static void main(String[] args) {
        Reader reader = new Reader("D:\\IdeaProjects\\rosalind\\src\\resources\\Input.txt");
        int n = reader.getN();
        Clusters clusters = new Clusters(n);
        MapData mapData = new MapData(reader);
        while (mapData.getN() != 1) {
            PairC pairC = mapData.searchMin();
            Cluster cluster1 = clusters.getCluster(pairC.getC1());
            Cluster cluster2 = clusters.getCluster(pairC.getC2());
            Cluster newCluster = new Cluster(cluster1, cluster2);
            clusters.addCluster(newCluster);
            Map<String, Float> removeC1 = mapData.remove(pairC.getC1());
            Map<String, Float> removeC2 = mapData.remove(pairC.getC2());
            mapData.addC(pairC, removeC1, removeC2, cluster1.size(), cluster2.size());
            clusters.deleteCluster(cluster1.getLabel());
            clusters.deleteCluster(cluster2.getLabel());
        }
        Cluster[] root = new Cluster[1];
        Map<String, Cluster> mapClusters = clusters.getClusters();
        mapClusters.values().toArray(root);
        Cluster cluster = root[0];
        Stack<String> out = new Stack<String>();
        nodesToStack(cluster, out);
        while (!out.empty()) {
            System.out.println(out.pop());
        }
    }

    private static void nodesToStack(Cluster cluster, Stack<String> out) {
        if (cluster.size() > 1) {
            out.push(cluster.getLabel());
            nodesToStack(cluster.getCluster1(), out);
            nodesToStack(cluster.getCluster2(), out);

        }

    }

}



