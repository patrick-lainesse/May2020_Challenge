import java.util.HashMap;

class Solution {

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
        int[] nums1 = {3,2,3};  // Output: 3
        int [] nums2 = {2,2,1,1,1,2,2}; // Output: 2*/
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
    }
}