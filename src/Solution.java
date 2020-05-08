import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {

    /* May 8th: Check If It Is a Straight Line
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    Check if these points make a straight line in the XY plane. */
    public static boolean checkStraightLine(int[][] coordinates) {

        Arrays.sort(coordinates, (Comparator<int[]>) (o1, o2) -> {
            Integer x1 = o1[0];
            Integer x2 = o2[0];
            return x1.compareTo(x2);
        });

        int size = coordinates.length;

        if((coordinates[1][0] - coordinates[0][0]) == 0) return false;
        int slope0 = (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);

        if(size <= 2)   return true;

        for(int i = 1; i < coordinates.length - 1; i++) {
            int xDiff = (coordinates[i+1][0] - coordinates[i][0]);
            if(xDiff == 0) return false;
            int yDiff = (coordinates[i+1][1] - coordinates[i][1]);

            int slope = (coordinates[i+1][1] - coordinates[i][1]) / xDiff;
            if(Math.abs(slope) != Math.abs(slope0)) return false;
        }
        return true;
    }

    /* May 6th: Majority Element
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    You may assume that the array is non-empty and the majority element always exist in the array.*/
    public static int majorityElement(int[] nums) {
        int majority = -1;
        int mapCount = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            if(map.containsKey(val)) {
                int count = map.get(val);
                map.put(val, count+1);
            }
            else map.put(val, 1);
        }

        for(int val : map.keySet()) {
            if(map.get(val)>mapCount) {
                mapCount = map.get(val);
                majority = val;
            }
        }

        return majority;
    }

    public static void main(String[] args) {
        // May 6th: Majority Element
        /*int[] nums1 = {3,2,3};  // Output: 3
        int [] nums2 = {2,2,1,1,1,2,2}; // Output: 2
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2)); */

        // May 8th: Check If It Is a Straight Line
        int[][] coordinates1 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] coordinates2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates3 = {{1,2},{1,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates4 = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};

        System.out.println(checkStraightLine(coordinates1));
        System.out.println(checkStraightLine(coordinates2));
        System.out.println(checkStraightLine(coordinates3));
        System.out.println(checkStraightLine(coordinates4));

    }
}