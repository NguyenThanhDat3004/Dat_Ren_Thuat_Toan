package quyHoach;

import java.util.ArrayList;
import java.util.List;

public class leetcode131 {
    

    //Cho một chuỗi s, phân vùng ssao cho mọichuỗi concủa phân vùng là mộtxuôi ngược đều giống nhau. Trả về tất cả các phân vùng palindrome có thể có củas .
    //Ví dụ 1:
    //Đầu vào: s = "aab"
    // Đầu ra: [["a","a","b"],["aa","b"]]
    //Ví dụ 2:
    //Đầu vào: s = "a"
    // Đầu ra: [["a"]]
    // chuoi con xuoi nguoc giong nhau
    List<String> list = new ArrayList<>();
    List<List<String>> tong = new ArrayList<>();
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        char b[] = new char[a.length];
        int j = a.length-1;
        for (int i = 0; i < a.length; i++) {
            b[j] = a[i];
            j--;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
    public void add (String chuoi, char a[], int begin){
        if(chuoi.length()>a.length) return;
        if(check(chuoi)) {
            list.add(chuoi);
            tong.add(list);
            return;
        }
        for(int i =begin; i<a.length;i++){
            add(chuoi+a[i],a,begin+1);
        }
    }

    public static void main(String[] args) {
        char a[] = {'a','b','b'};
        leetcode131 t = new leetcode131();
        t.add("",a,0);
        for(int i = 0;i<t.tong.size();i++){
            for(String j : t.list) System.out.println(j);
        }
    }
}
