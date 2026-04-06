import java.util.Stack;

class Main {
    public static void main(String[] args) {
         int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);

         for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize result with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse twice because it's circular
        for (int i = 0; i < 2 * n; i++) {
            int current = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < current) {
                result[stack.pop()] = current;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
