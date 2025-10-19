package quyHoach;

import java.util.*;

public class Chuoi_Backtracking {
public void Bai6(){
    //Mô tả:
    //Cho hai số nguyên không âm n và m. Bạn bắt đầu tại vị trí (0,0) và mỗi lần chỉ có thể đi sang phải (R) hoặc đi xuống (D).
    // Hãy sinh và in ra tất cả các đường đi từ (0,0) đến (n,m).
    //Input:
    //n = 2, m = 2
    //Output:
    //RRDD
    //RDRD
    //RDDR
    //DRRD
    //DRDR
    //DDRR
}

}
class Bai1{
    //Mô tả:
    //Cho số nguyên dương n. Hãy sinh và in ra tất cả các chuỗi nhị phân có độ dài đúng bằng n.
    List<String> chuoi1 = new ArrayList<>();
    public void sinhSo(int n, String chuoi){
        if(chuoi.length()==n){
            chuoi1.add(chuoi);
            return;
        }
        if(chuoi.length()>n) return;
        sinhSo(n,chuoi+"1");
        sinhSo(n,chuoi+"0");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai1 t = new Bai1();
        t.sinhSo(n,"");
        for(String i : t.chuoi1) System.out.println(i);
    }
    //Input:
    //n = 3
    //Output:
    //000
    //001
    //010
    //011
    //100
    //101
    //110
    //111
}

class Bai2{
    //Đề 2: Sinh chuỗi nhị phân không có hai số 1 liền nhau
    List<String> Bina = new ArrayList<>();
    public void add(int n, String chuoi, String last){
        // last dung de luu thang ki tu cuoi cung truoc khi sinh chuoi
        if(chuoi.length()==n) {
            Bina.add(chuoi);
            return;
        }
        if(chuoi.length()>n) return;
        add(n,chuoi+"0","0");
        if(!last.equalsIgnoreCase("1")){
            add(n,chuoi+"1","1");
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String chuoi = "";
        String last = "";
        Bai2 t = new Bai2();
        t.add(n,chuoi,last);
        for(String i : t.Bina) System.out.println(i);
    }
    //Mô tả:
    //Cho số nguyên dương n. Hãy sinh tất cả các chuỗi nhị phân có độ dài n sao cho trong chuỗi không có hai số 1 đứng cạnh nhau.
    //Input:
    //n = 3
    //Output:
    //000
    //001
    //010
    //100
    //101
}
class Bai3{
    //Đề 3: Sinh tất cả tập con của tập {1, 2, ..., n}
    List<String> subSet = new ArrayList<>();
    public void add(String chuoi,int n, int begin){
        if(chuoi.length()>n) return;
        subSet.add(chuoi);
        for(int i = begin;i<=n;i++){
            add(chuoi+""+i,n,i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String chuoi = "";
        Bai3 t = new Bai3();
        t.add(chuoi,n,1);
        for(String i : t.subSet) System.out.println("["+i+"]");
    }
    //Mô tả:
    //Cho số nguyên dương n. Hãy sinh và in ra tất cả các tập con của tập {1, 2, ..., n}.
    //Input:
    //n = 3
    //Output:
    //[]
    //[1]
    //[2]
    //[3]
    //[1, 2]
    //[1, 3]
    //[2, 3]
    //[1, 2, 3]
}
class Bai4{
    //Mô tả:
    //Cho hai số nguyên dương n và k. Hãy sinh tất cả các tổ hợp độ dài k từ tập {1, 2, ..., n}.
    List<String> result = new ArrayList<>();
    public void add(int n, int k, String chuoi,int begin){
    if(chuoi.length()==k){
        result.add(chuoi);
        return;
    }
    if(chuoi.length()>k) return;
    for(int i = begin; i<=n;i++){
        add(n,k,chuoi+""+i,i+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Bai4 t = new Bai4();
        t.add(n,k,"",1);
        for(String i : t.result) System.out.println(i);
    }

    //Input:
    //n = 4, k = 2
    //Output:
    //[1, 2]
    //[1, 3]
    //[1, 4]
    //[2, 3]
    //[2, 4]
    //[3, 4]
}
class Bai5{
    //Đề 5: Đếm số cách leo cầu thang
    // neu chi dem so lan thi chung ta choi bai fibonacy
    public void dem(int n){
        int a[] = new int[n+2];
        a[0]=0;
        a[1]=1;
        for(int i = 2;i<n+2;i++){
            a[i]=a[i-1]+a[i-2];
        }
        System.out.println("Tong so cach de leo cau thang: "+a[n+1]);
    }

    public static void main(String[] args) {
        // chi dem cach leo bac thang
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tong so bac cau thang: ");
        int n = sc.nextInt();
        Bai5 t = new Bai5();
        t.dem(n);

    }
    //Mô tả:
    //Một người có thể leo lên 1 hoặc 2 bậc mỗi lần. Cho số nguyên n là tổng số bậc cầu thang. Hãy tính tổng số cách leo lên đỉnh cầu thang.
    //Input:
    //n = 4
    //Output:
    //5
}
class Bai5_1{
    //Đề 5: Đếm số cách leo cầu thang
    // backtrack de liet ke ra cac duong\
    List<String> paths = new ArrayList<>();
    public void add(int n,int tong, String chuoi){
        if(tong==n){
            paths.add(chuoi);
            return;
        }
        if(tong>n) return;
        add(n,tong+1,chuoi+"1");
        add(n,tong+2,chuoi+"2");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap tong so bac cau thang: ");
        int n = sc.nextInt();
        Bai5_1 t = new Bai5_1();
        t.add(n,0,"");
        for(String i : t.paths) System.out.println(i);
    }
    //Mô tả:
    //Một người có thể leo lên 1 hoặc 2 bậc mỗi lần. Cho số nguyên n là tổng số bậc cầu thang. Hãy tính tổng số cách leo lên đỉnh cầu thang.
    //Input:
    //n = 4
    //Output:
    //5
}
class Bai7{
    //Đề 7: Sinh chuỗi ngoặc đúng độ dài 2n
    // ham kiem tra xem chuoi co oke hay khong
    // neu gap dau ( chung ta quang vo stack neu gap ) thi chung ta lay ra ma vay vao mot list
    // neu dau dong ngoac duoc them vao thi kiem tra
    public boolean check(String chuoi){
        Stack<Character> chuoiVao = new Stack<>();
        char a[] = chuoi.toCharArray();
        for(int i = 0; i< chuoi.length();i++){
            if(a[i]=='(') chuoiVao.add('(');
            if(a[i]==')')  {
                if(chuoiVao.isEmpty()) return false;
                else chuoiVao.pop();
            }
        }
        return chuoiVao.isEmpty();
    }
    List<String> chuoiNgoac = new ArrayList<>();
    public void add(int n, String chuoi){
        if(chuoi.length()==2*n&&check(chuoi)){
            chuoiNgoac.add(chuoi);
            return;
        }
        if(chuoi.length()>2*n) return;
        add(n,chuoi+"(");
        add(n,chuoi+")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Bai7 t = new Bai7();
        t.add(n,"");
        for(String i : t.chuoiNgoac) System.out.println(i);
    }
    //Mô tả:
    //Cho số nguyên dương n. Hãy sinh tất cả các chuỗi ngoặc đúng có n cặp ngoặc mở và ngoặc đóng.
    //Input:
    //n = 2
    //Output:
    //()()
    //(())

}