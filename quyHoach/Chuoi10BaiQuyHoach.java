package quyHoach;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chuoi10BaiQuyHoach {
//    Cho n bậc thang. Mỗi lần bạn có thể bước 1 hoặc 2 bậc.
//    Hỏi có bao nhiêu cách leo lên bậc thang thứ n.
//        ----------------------
//    // phat hien quy luat so cach bang so fibonacy thu i+1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int dp[] =new int[n+2];
//        dp[0]=0;
//        dp[1] =1;
//        for(int i = 2;i<n+2;i++){
//            dp[i] = dp[i-1]+dp[i-2];
//        }
//        System.out.println("Ket qua: "+dp[n+1]);
//    }
    // neu muon liet ke het tat ca cac duong
    // phai choi chieu di het moi nhanh
//    List<String> paths = new ArrayList<>();
//    public void add(int path,String sPath, int n){
//        // n la tong bac
//        // path la duong di
//        if(path==n) {
//            paths.add(sPath);
//            return;
//        }
//        if(path>n) return;
//        add(path+1,sPath+"1",n);
//        add(path+2,sPath+"2",n);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String sPath = "";
//        int path=0;
//        Chuoi10BaiQuyHoach t = new Chuoi10BaiQuyHoach();
//        t.add(path,sPath,n);
//        for(String i : t.paths) System.out.println(i);
//    }
//
//








//    Cho danh sách các đồng xu và một số nguyên amount.
//    Tính số cách khác nhau để tạo ra tổng bằng amount
//    từ các đồng xu đã cho (không giới hạn số lượng mỗi đồng).
//    ---------------------------
     // vi du cho 1 2 3 nhap 3 thi dua ra cac menh gia co the co tu 3 dong
//    List<String> cach = new ArrayList<>();
//    public void add(int tong,  String sNumber, int n, int a[], int start){
//        if(tong==n){
//            cach.add(sNumber);
//            return;
//        }
//        if(tong>n) return;
//        for(int i = start;i<a.length;i++){
//            add(tong+a[i],sNumber+a[i]+"",n,a,i);
//        }
//    }
//    public static void main(String[] args) {
//        int n = 100; // so nhap vao
//        int a[] = new int[]{1,3,4};
//        String sNumber = "";
//        Chuoi10BaiQuyHoach t = new Chuoi10BaiQuyHoach();
//        t.add(0,"",n,a,0);
//        for(String i : t.cach) System.out.println(i);
//    }
    //--------------------------
//    Cho số nguyên n.
//    Đếm số chuỗi nhị phân có độ dài n sao cho không có
//    hai số 1 đứng cạnh nhau
    List<String> cacChuoi = new ArrayList<>();
    public void sinhChuoi(int n, String chuoi, char last) {
        if (chuoi.length() == n) {
            cacChuoi.add(chuoi);
            return;
        }
        sinhChuoi(n, chuoi + "0", '0');
        if (last != '1') {
            sinhChuoi(n, chuoi + "1", '1');
        }
    }
    public static void main(String[] args) {
        int n = 4; // độ dài chuỗi
        Chuoi10BaiQuyHoach t = new Chuoi10BaiQuyHoach();
        t.sinhChuoi(n, "", '0');
        System.out.println("Tổng số chuỗi: " + t.cacChuoi.size());
        for (String s : t.cacChuoi) {
            System.out.println(s);
        }
    }
}
