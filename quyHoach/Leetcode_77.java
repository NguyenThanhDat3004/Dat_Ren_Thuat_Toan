package quyHoach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode_77 {
    //77. Combinations
    //Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
    //You may return the answer in any order.
    //Example 1:
    //Input: n = 4, k = 2
    //Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    //Explanation: There are 4 choose 2 = 6 total combinations.
    //Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
    //Example 2:
    //Input: n = 1, k = 1
    //Output: [[1]]
    //Explanation: There is 1 choose 1 = 1 total combination.
    // cho 2 so nguyen n va k hay tim ra cac to hop co k phan tu trong nay
    List<String> list = new ArrayList<>();
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        for(int i = 0;i<a.length-1;i++){
            if(a[i]>=a[i+1]) return false;
        }
        return true;
    }
    public void add(int n, int k, String chuoi, int begin){
        if(chuoi.length()==k&&check(chuoi)){
            list.add(chuoi);
            return;
        }
        if(chuoi.length()>k) return;
        for(int i = begin;i<=n;i++){
            add(n,k,chuoi+i,i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Leetcode_77 t = new Leetcode_77();
        t.add(n,k,"",1);
        for(String i : t.list) System.out.println(i);
    }
}
