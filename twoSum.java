import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 5, 8};
        int target = 10;

        if (!findTwoSum(nums, target)) {
            System.out.println("No two numbers add up to " + target);
        }
    }

    public static boolean findTwoSum(int[] nums, int target) {
        // Map stores value -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int needed = target - num;

            if (map.containsKey(needed)) {
                System.out.println("Found pair: " + needed + " + " + num + " = " + target);
                return true;
            }

            map.put(num, 1); // value stored, index not needed here
        }

        return false;
    }
}
