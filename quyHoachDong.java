import java.util.Random;

public class quyHoachDong {
    //Có n món đồ, mỗi món có:
    //trọng lượng w[i]
    //giá trị v[i].
    //Cái túi có sức chứa tối đa W.
    //Mỗi món chỉ được chọn 0 hoặc 1 lần.
    //Yêu cầu: chọn các món sao cho tổng trọng lượng ≤ W và tổng giá trị là lớn nhất.

    // Bai lam:
    int n = 5; // so mon do
    int W = 10; // suc chua balo toi da
    int v[] = new int[n];
    int w[] = new int[n];
    int dp[][];
    // random mang
    public void taoMang(int[] a, int maxVal) {
        Random ran = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = ran.nextInt(maxVal) + 1; // tránh 0
        }
    }
    // xuat mang
    public void xuatMang(int[] a, String name) {
        System.out.print(name + ": ");
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
    public void quyHoach(){
        dp = new int[n][W+1];
        //khoi tao mang dau tien chi co mon 0
        for(int j = 0;j<=W;j++){
            if(w[0]<=j) dp[0][j] = v[0];
            else dp[0][j]=0;
        }
        // dien cac hang con lai
        for(int i = 1;i<n;i++){
            for(int j = 0; j<=W;j++){
                // khong chon mon i
                dp[i][j] = dp[i-1][j];
                // neu du cho thi chung ta thu chon
                if(j>=w[i]){
                    dp[i][j] = Math.max(dp[i][j],v[i]+dp[i-1][j-w[i]]);
                }
            }

        }


    }
    public void inBangDP() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        quyHoachDong t = new quyHoachDong();
        t.taoMang(t.v, 10);
        t.taoMang(t.w, 5);

        t.xuatMang(t.v, "Value");
        t.xuatMang(t.w, "Weight");

        t.quyHoach();
        System.out.println("Bảng DP:");
        t.inBangDP();

        System.out.println("Kết quả tối ưu = " + t.dp[t.n - 1][t.W]);
    }
}
