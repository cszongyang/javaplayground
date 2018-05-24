package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zongyangli on 5/23/18.
 */
public class ReverseFibo {
    public static void main(String a[])  throws Exception {
        int[] nums = {80, 50};
        for (Integer num : printReverseFibo(nums)) {
            System.out.println(num);
        }
    }

    public static List<Integer> printReverseFibo(int[] nums) {
        int first = nums[0];
        int second = nums[1];
        List<Integer> res = new ArrayList<Integer>();
        res.add(first);
        res.add(second);

        while (first > second) {
            int temp = first - second;
            res.add(temp);
            first = second;
            second = temp;
        }
        return res;
    }
}
