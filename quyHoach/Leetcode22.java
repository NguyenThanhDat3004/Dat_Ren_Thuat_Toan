package quyHoach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Leetcode22 {
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    //Example 1:
    //Input: n = 3
    //Output: ["((()))","(()())","(())()","()(())","()()()"]
    //Example 2:
    //Input: n = 1
    //Output: ["()"]
    List<String> list = new ArrayList<>();
//     viet ra cac chuoi cap ngoac don dung
    public boolean checkValid(String chuoi){
        char a[] = chuoi.toCharArray();
        Stack<Character> chuoiVao = new Stack<>();
        for(int i = 0;i<a.length;i++){
            if(a[i]=='(') chuoiVao.add('(');
            if(a[i]==')'){
                if(chuoiVao.isEmpty()) return false;
                else chuoiVao.pop();
            }
        }
        return chuoiVao.isEmpty();
    }
//    //sinh ra chuoi
    public void sinhChuoi(int n, String chuoi){
        if(chuoi.length()==2*n&&checkValid(chuoi)){
            list.add(chuoi);
            return;
        }
        if(chuoi.length()>2*n) return;
        sinhChuoi(n,chuoi+"(");
        sinhChuoi(n, chuoi+")");
    }
    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Leetcode22 t = new Leetcode22();
        t.sinhChuoi(n,"");
        for (String i : t.list) {
            System.out.println("[\"" + i + "\"]");
        }
    }
}
