package quyHoach;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_46 {
    //Cho một mảng numscác số nguyên riêng biệt, trả về tất cả các số nguyên có thểhoán vị. Bạn có thể trả lời theo bất kỳ thứ tự nào .
    //Ví dụ 1:
    //Đầu vào: nums = [1,2,3]
    // Đầu ra: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    //Ví dụ 2:
    //Đầu vào: nums = [0,1]
    // Đầu ra: [[0,1],[1,0]]
    // chi can sinh mang va khong co 2 phan tu nao trong mang giong nhau la duoc
    List<String> toHop = new ArrayList<>();
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        for(int i = 0;i<a.length-1;i++){
            for(int j =i+1;j<a.length;j++){
                if(a[i]==a[j]) return false;
            }
        }
        return true;
    }
    public void add(String chuoi,int a[]){
        if(chuoi.length()==a.length&&check(chuoi)){
            toHop.add(chuoi);
            return;
        }
        if(chuoi.length()>a.length) return;
        for(int i = 0;i<a.length;i++){
            add(chuoi+a[i],a);
        }
    }
    public static void main(String[] args) {
        int a[]={1,4,5};
        Leetcode_46 t = new Leetcode_46();
        t.add("",a);
        for(String i : t.toHop) System.out.println(i);
    }
}
