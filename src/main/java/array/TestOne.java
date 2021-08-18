package array;

/**
 * 题目一：找出数组中重复的数
 * 在一个长度为n的数组中所有的数字都在0~n-1的范围内。数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次；
 * 请找出数组中任意一个重复的数字。
 * 例如：如果输入一个长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复的数字2或者3
 */
public class TestOne {
    //1.可以先排序，然后从头到位扫描；
    //2.借助哈希表，O（n）的空间来处理
    //3.空间O(1)的方法，每个数字都在0~n-1,那么如果没有重复的数字，则数组排序后，数字i将出现在下标i的位置
    //重排数组，扫描到下标i的数字时，比较这个数字m是不是等于i,是则下一个；
    // 不是，则拿它和第m个数比较：相等则重复；不等则交换，那么m放到了第m个位置放到了属于它的位置
    public static void main(String[] args) {
        int[] test1 = {2, 3, 1, 0, 2, 5, 3};
        int[] test2 ={3,4,5,2,1,3};
        duplicate(test2);
    }

    //虽然有一个双重循环，但是每个数字最多交换2次就能找到自己的位置，因此：时间O(n), 空间O(1)
    public static boolean duplicate(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }

//        for(int i=0; i<numbers.length; ){
//            if(numbers[i] == i){
//                i++;
//                continue;
//            }
//            if((numbers[i] == numbers[numbers[i]])){
//                System.out.println(numbers[i]);
//                return true;
//            }
//            //交换
//            int temp = numbers[i];
//            numbers[i] = numbers[temp];
//            numbers[temp] = temp;
//        }
        for (int i = 0; i < numbers.length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    System.out.println(numbers[i]);
                    return true;
                }

                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }

        }

        return false;
    }
}
