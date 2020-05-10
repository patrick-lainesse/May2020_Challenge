import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {

    /* May 10th (Happy Mothers' Day!): Find the Town Judge
    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

    If the town judge exists, then:
    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Notes:
    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N
     */
    public static int findJudge(int N, int[][] trust) {

        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 1; i<= N; i++) {
            map.put(i, null);
        }

        for(int[] truster : trust) {
            String trusted = map.get(truster[0]);
            if(trusted != null) {
                trusted += truster[1];
            } else {
                trusted = String.valueOf(truster[1]);
            }
            //System.out.println("Trusted : " + trusted);
            map.put(truster[0], trusted);
        }
        System.out.println("map: " + map);

        for(int i = 1; i<=N; i++) {
            if(map.get(i) == null) {
                return i;
            }
        }
        // case where not everyone trusts the same person left to treat (case 4)

        return -1;
    }

    /* May 9th: Valid Perfect Square
    Given a positive integer num, write a function which returns True if num is a perfect square else False.
    Note: Do not use any built-in library function such as sqrt. */
    public static boolean isPerfectSquare(int num) {

        // We'll use binary search to find the number is a perfect square
        int left = 1;
        int right = num-1;

        if(num == 1) return true;
        while(left<= right) {
            long middle = (left + right) / 2;
            if(middle*middle < num) {
                left = (int) (middle + 1);
            } else if(middle*middle > num) {
                right = (int) (middle - 1);
            } else return true;
        }
        return false;
    }

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
        /*int[][] coordinates1 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        int[][] coordinates2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates3 = {{1,2},{1,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates4 = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};

        System.out.println(checkStraightLine(coordinates1));
        System.out.println(checkStraightLine(coordinates2));
        System.out.println(checkStraightLine(coordinates3));
        System.out.println(checkStraightLine(coordinates4));*/

        // May 9th: Valid Perfect Square
        /*System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(14183571));
        System.out.println(isPerfectSquare(2147483647));*/

        // May 10th (Happy Mothers' Day!): Find the Town Judge
        int[][] trust1 = {{1,2}};
        int[][] trust2 = {{1,3},{2,3}};
        int[][] trust3 = {{1,3},{2,3},{3,1}};
        int[][] trust4 = {{1,2},{2,3}};
        int[][] trust5 = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(2, trust1));
        System.out.println(findJudge(3, trust2));
        System.out.println(findJudge(3, trust3));
        System.out.println(findJudge(3, trust4));
        System.out.println(findJudge(4, trust5));
    }
}