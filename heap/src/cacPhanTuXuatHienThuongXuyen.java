import java.util.Random;

public class cacPhanTuXuatHienThuongXuyen {
    // Cho một mảng số nguyên numsvà một số nguyên k, hãy trả về các phần tử xuất hiện thường xuyên nhất .
    // Bạn có thể trả về câu trả lời theo bất kỳ thứ tự nào .k

    // giai
    private int a[] = new int[50];
    // tom tat nhap vo mot mang
    public void taoMang(){
        Random ran = new Random();
        for(int i = 0; i< 50;i++ ){
            a[i] = ran.nextInt(30);
        }
    }
    // xuat mang
    public void xuatMang(){
        for(Integer x : a){
            System.out.print(x+" ");
        }
    }
    // heapify
    public void heapify(int i, int n){
        // n la size i la chi so duyet
        int goc = i;
        int left = 2*i+1;
        int right = 2*i+2;
        // cac truong hop nhu sau
        // neu lon hon
        if(left<n&&a[left]>a[i]){

        }
        if(right<n&&a[right]>a[i]){

        }
        if(goc!=i){
            int temp = a[i];
            a[i] = a[goc];
            a[goc] = temp;
            heapify(goc,n);
        }

    }


    // main
    public static void main(String[] args) {
        cacPhanTuXuatHienThuongXuyen t = new cacPhanTuXuatHienThuongXuyen();
        t.taoMang();
        t.xuatMang();
    }
}
