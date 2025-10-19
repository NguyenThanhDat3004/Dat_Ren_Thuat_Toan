package quyHoach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chuoiBaiQuyHoachVaBackTracking {

}
class Bai11{
    //Cho số nguyên dương n. Hãy sinh và in ra tất cả các hoán vị của tập {1, 2, ..., n}.
    // ham check chuoi co 2 so giong nhau
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        for(int i = 0;i<a.length;i++){
            for(int j = i+1;j<a.length;j++){
                if(a[i]==a[j]) return false;
            }
        }
        return true;
    }
    // ham sinh chuoi
    List<String> list = new ArrayList<>();
    public void sinhChuoi(int n, String chuoi){
        if(n==chuoi.length()&&check(chuoi)){
            list.add(chuoi);
        }
        if(chuoi.length()>n) return;
        for(int i = 1;i<=n;i++){
            sinhChuoi(n,chuoi+i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai11 t = new Bai11();
        t.sinhChuoi(n,"");
        for(String i : t.list) System.out.println(i);
    }
    //Ví dụ:
    //Input: n = 3
    //Output:
    //123
    //132
    //213
    //231
    //312
    //321
}
class Bai12{
    //Bài 9:
    //Cho số nguyên dương n. Hãy sinh và in ra tất cả các dãy con tăng dần của tập {1, 2, ..., n}.
    //Ví dụ:
    //Input: n = 3
    //Output:
    //1
    //1 2
    //1 2 3
    //1 3
    //2
    //2 3
    //3
}
class Bai13{
    //Bài 10:
    //Cho hai số nguyên dương n và k. Hãy sinh tất cả các tổ hợp độ dài k từ tập {1, 2, ..., n}, cho phép lặp lại phần tử.
    //Ví dụ:
    //Input: n = 3, k = 2
    //Output:
    //11
    //12
    //13
    //22
    //23
    //33
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        for(int i = 0;i<a.length-1;i++){
            if(a[i]>a[i+1]) return false;
        }
        return true;
    }
    List<String> list = new ArrayList<>();
    public void add(int n,int k, String chuoi){
        if(chuoi.length()==k&&check(chuoi)){
            list.add(chuoi);
            return;
        }
        if(chuoi.length()>k) return;
        for(int i = 1;i<=n;i++){
            add(n,k,chuoi+i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int k = sc.nextInt();
        Bai13 t = new Bai13();
        t.add(n,k,"");
        for(String i : t.list) System.out.println(i);
    }
}