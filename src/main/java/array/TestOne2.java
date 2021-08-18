package array;

/**
 * 题目2：不修改数组找出重复的数字
 * 在一个长度为n+1的数组中，所有的数字都在1~n的范围内，所以数组至少有一个数字是重复的。
 * 请找出任意一个重复的数字，但不能修改输入的数组
 */
//与1的区别：不是从0开始，与下标关联不强；同时，不能修改原数组
// 1. 依旧可以采用哈希表，借助O(n)的辅助空间
// 2. 观察题目感觉，在某个范围内数字的个数比较重要。把1~n的数字按照中间数m分成两部分， 1~m和m+1~n,
// 查看第一个区间内数字的个数，如果不超过m，那么重复的数字在另外一个区间；反之，则在本区间一分为二继续查找；
// 很像二分查找，但是多了一步统计区间的个数

/**
 * 长度n的数组，二分思想：countRange函数会被调用O(logn)次，每次需要O(n)时间，总的时间：O(nlogn),空间O(1)
 *  相当于时间换空间
 * 同时，这种算法不能找出所有的重复数组；
 * 所以分清楚`任一`还是`所有`，或者根据性能要求不同选出不同的算法
 */
public class TestOne2 {
    public static void main(String[] args) {
        int[] test1={2,3,5,4,3,2,6,7};
        System.out.println(getDuplication(test1));
    }

    public static int getDuplication(int[] nums){
        if(nums == null || nums.length<=0){
            return -1;
        }
        int start=1, end=nums.length-1;
        while(start <= end){
            int m = ((end-start)>>1) + start;
            int count = countRange(m,nums,start);
            if(end == start){
                if(count>1){
                    return start;
                }else {
                    break;
                }
            }

            if(count > (m-start+1) )
                end = m;
            else {
                start = m+1;
            }
        }

        return -1;
    }

    private static int countRange(int m, int[] nums, int start) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=start && nums[i]<=m){
                count ++;
            }
        }
        return count;
    }
}
