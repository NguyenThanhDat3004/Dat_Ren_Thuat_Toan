package quyHoach;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    //Cho một mảng số nguyên numsgồm các phần tử duy nhất ,
    // trả về tất cả các phần tử có thể các tập hợp con (bộ công suất) .
    //Tập hợp lời giải không được chứa các tập con trùng lặp. Trả về lời giải theo bất kỳ thứ tự nào .
    //Ví dụ 1:
    //Đầu vào: nums = [1,2,3]
    // Đầu ra: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //Ví dụ 2:
    //Đầu vào: nums = [0]
    // Đầu ra: [[],[0]]
    List<String> list = new ArrayList<>();
    public void add(int a[],String chuoi,int begin){
        if(a.length<chuoi.length()) return;
        list.add(chuoi);
        for(int i = begin;i<a.length;i++){
            add(a,chuoi+a[i],i+1);
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        leetcode_78 t = new leetcode_78();
        t.add(a,"",0);
        for(String i : t.list) System.out.println("[" + i + "]");
    }
}
