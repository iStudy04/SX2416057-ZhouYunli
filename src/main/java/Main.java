import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 输入memoryUsage数组
        String input = scanner.nextLine().trim();
        input = input.substring(1, input.length() - 1); // 去掉方括号
        String[] tokens = input.split(",");
        int[] memoryUsage = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            memoryUsage[i] = Integer.parseInt(tokens[i].trim());
        }
        // 输入k值
        int k = scanner.nextInt();

        int[] fluctuations = getFluctuations(memoryUsage, k);
        System.out.println(fluctuations);
    }

    public static int[] getFluctuations(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}