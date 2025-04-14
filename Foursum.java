import java.util.*;

public class Foursum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);  // Sort the array

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) 
                continue; // Skip duplicates for the first number

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue; // Skip duplicates for the second number

                int k = j + 1;
                int l = len - 1;

                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k] + nums[l];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates for k and l
                        while (k < l && nums[k - 1] == nums[k]) k++; 
                        while (k < l && nums[l + 1] == nums[l]) l--; 
                    } else if (sum < target)
                        k++;
                    else 
                        l--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Foursum solution = new Foursum();  // Corrected class name here
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = solution.fourSum(nums, target);
        
        // Print the result
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}

    

