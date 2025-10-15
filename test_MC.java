import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test_MC {
    // dong ddau cho tong so hoc sinh va so hoc sinh co mat
    // dong 2 bieu dien cho cac id hoc sinh vang
    //In ra một dòng chứa danh sách ID của những sinh viên vắng mặt, theo thứ tự tăng dần, cách nhau bởi khoảng trắng.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // nhap hoc sinh
        int tong=0;
        tong = sc.nextInt();
        int vang = sc.nextInt();
        int a[] = new int[tong];
        for(int i = 0;i<tong;i++){
            a[i] = i+1;
        }
        for(int i =0;i<vang;i++){
            int id = sc.nextInt();
            for(int j=0;j<tong;j++){
                if(a[j]==id) {
                    for(int k = j+1;k<tong;k++){
                        a[j]=a[j+1];
                    }
                    tong--;
                }
            }
        }
        for(int i = 0;i<tong;i++){
            System.out.print(a[i]+" ");
        }

    }
}
