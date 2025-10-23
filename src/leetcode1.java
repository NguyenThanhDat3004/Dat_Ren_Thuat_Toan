import java.util.*;

public class leetcode1 {
    //
    public int[] twoSum(int[] nums, int target) {

        int k = 0;
        int a[] = new int[2];
        for(int i = 0;i<nums.length-1;i++){
            for(int j = i+1;j< nums.length;j++){
                if(nums[i]+nums[j]==target) {
                    a[k] = i;
                    k++;
                    a[k] = j;
                    k++;
                }
            }
        }
        return a;
    }
}
// leetcode 3
class Leetcode3{
        //Cho một chuỗi s, hãy tìm độ dài của chuỗi dài nhất chuỗi con không có ký tự trùng lặp.
        List<String> list = new ArrayList<>();
        public boolean check(String s){
            char[] a = s.toCharArray();
            for(int i = 0;i<a.length-1;i++){
                for(int j = i+1;j<a.length;j++){
                    if(a[i]==a[j]) return false;
                }
            }
        return true;
        }
        public void quyHoach(String s, char[] a, int begin){
            if(!check(s)) return;
            list.add(s);
            for(int i = begin;i<a.length;i++){
                quyHoach(s+a[i],a,i+1);
            }
        }
        public int lengthOfLongestSubstring(String s) {
            quyHoach("",s.toCharArray(),0);
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i<this.list.size();i++){
                set.add(this.list.get(i).length());
            }
            int result = set.stream().max(Integer::compareTo).orElse(0);
            return result;
        }

}