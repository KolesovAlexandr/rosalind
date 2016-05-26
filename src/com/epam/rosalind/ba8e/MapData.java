package com.epam.rosalind.ba8e;

import com.epam.rosalind.utils.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Aleksandr_Kolesov on 5/18/2016.
 */
public class MapData {
    private int n;
    private Map<String, Map<String, Float>> map;

    public MapData(Reader reader) {
        float[][] data = reader.getData();
        n = reader.getN();
        map = new HashMap<String, Map<String, Float>>();

        for (int i = 0; i < data.length; i++) {
            Map<String, Float> mapJ = new HashMap<String, Float>();
            for (int j = 0; j < data[i].length; j++) {
                mapJ.put(String.valueOf(j + 1), data[i][j]);

            }
            map.put(String.valueOf(i + 1), mapJ);
        }

    }

    public float getData(String c1, String c2) {
        return map.get(c1).get(c2);
    }

    public PairC searchMin() {
        float min = Float.MAX_VALUE;
        String label1 = "";
        String label2 = "";
        for (Map.Entry<String, Map<String, Float>> entryC1 : map.entrySet()) {
            String keysC1 = entryC1.getKey();
            Map<String, Float> valueC1 = entryC1.getValue();
            for (Map.Entry<String, Float> entryC2 : valueC1.entrySet()) {
                String keysC2 = entryC2.getKey();
                Float valueC2 = entryC2.getValue();
                if (!keysC1.equals(keysC2) && valueC2 < min) {
                    min = valueC2;
                    label1 = keysC1;
                    label2 = keysC2;
                }
            }

        }
        return new PairC(label1, label2, min);


    }

    public int getN() {
        return n;
    }

    public Map<String, Float> remove(String c) {
        Map<String, Float> remove = map.remove(c);
        for (Map.Entry<String, Map<String, Float>> entry : map.entrySet()) {
            entry.getValue().remove(c);
        }
        n--;
        return remove;
    }

    public void addC(PairC pairC, Map<String, Float> removeC1, Map<String, Float> removeC2, int size1, int size2) {
        String c1 = pairC.getC1();
        String c2 = pairC.getC2();
        String newName = c1 + "," + c2;
        Map<String, Float> newSubMap = new HashMap<String, Float>();
        map.put(newName, newSubMap);
        for (Map.Entry<String, Map<String, Float>> entry : map.entrySet()) {
            String c = entry.getKey();
            if (!c.equals(newName)) {
                Float nn = (removeC1.get(c) * size1 + removeC2.get(c) * size2) / (size1 + size2);
                newSubMap.put(c, nn);
                entry.getValue().put(newName, nn);
            } else newSubMap.put(c, Float.valueOf(0));
        }
        n++;
    }
}
