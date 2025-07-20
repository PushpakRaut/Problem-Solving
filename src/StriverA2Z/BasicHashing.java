package StriverA2Z;

import java.util.LinkedHashMap;
import java.util.Map;

public class BasicHashing {

    public void countingFrequencyArrayElement(int[] arr) {
        // 1st solution
//        boolean[] visited = new boolean[arr.length];
//        for(int i = 0;i<arr.length;i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                int j = i+1;
//                int count = 1;
//                while(j<arr.length) {
//                    if(arr[j] == arr[i]) {
//                        count++;
//                        visited[j] = true;
//                    }
//                    j++;
//                }
//                System.out.println(arr[i] + " " + count);
//            }
//        }

        //2nd solution
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    public void countHighestLowestFrequency(int[] arr) {
//        boolean[] visited = new boolean[arr.length];
//        int maxFreq = 0, minFreq = arr.length;
//        int maxEle = 0, minEle = 0;
//        for(int i=0;i<arr.length;i++) {
//            if(!visited[i]) {
//                visited[i] = true;
//                int count = 1;
//                int j = i + 1;
//                while (j < arr.length) {
//                    if (arr[j] == arr[i]) {
//                        visited[j] = true;
//                        count++;
//                    }
//                    j++;
//                }
//                if (maxFreq < count) {
//                    maxFreq = count;
//                    maxEle = arr[i];
//                }
//
//                if (minFreq > count) {
//                    minFreq = count;
//                    minEle = arr[i];
//                }
//            }
//        }
//        System.out.println(maxEle + " " + maxFreq);
//        System.out.println(minEle + " " + minFreq);

        //2nd solution
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int maxFreq = 0, minFreq = arr.length;
        int maxEle = 0, minEle = 0;
        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                maxEle = e.getKey();
            }

            if(e.getValue() < minFreq) {
                minFreq = e.getValue();
                minEle = e.getKey();
            }
        }

        System.out.println(maxEle + " " + maxFreq);
        System.out.println(minEle + " " + minFreq);
    }
}
