import java.util.Random;
import java.util.Scanner;

public class leetcode373_heap_binary {
    // cac bien
    int n = 10;
    int a[] = new int[n];
    // khoi tao mang ngau nhien
    public void khoiTaoMang(){
        Random ran = new Random();
        for(int i = 0;i<n;i++){
            a[i] = ran.nextInt(10);
        }
    }
    // xuat mang
    public void xuatMang(){
        for(int i = 0; i< n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    // cai dat heapify
    public void heapify(int n, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        // neu trai lon hon cha
        if(left<n&&a[largest]<a[left]) largest = left;
        // neu phai lon hon cha
        if(right<n&&a[largest]<a[right]) largest = right;
        // neu thang max khong phai goc thi chung ta phai doi vi tri cua chung lai
        if(largest!=i){
            int tmp = a[i];
            a[i] = a[largest];
            a[largest]=tmp;
            // de quy cho cac nhanh duoi
            heapify(n,largest);
        }
    }
    // build heap
    public void buildHeap(){
        for(int i = n/2-1;i>=0;i--){
            // n/2-1 la nut la dau tien cua cay can bang
            heapify(n,i);
        }
    }
    // cai dat heap sort
    public void heapSort(){
        // buoc 1: xay heap
        buildHeap();
        //buoc 2: trich dan phan tu khoi heap
        for(int i = n-1;i>0;i--){
            // dua max ve cuoi va dua la cuoi len root roi se heapify lai
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(i,0);
            // sap lai tu tren xuong nha
        }
    }
    // cai dat binary search
    public int binaSearch(int key){
        int right = a.length-1;
        int left = 0;
        while(left<right){
            int b = (left+right)/2;
            if(a[b]==key){
                return b;
            } else if (a[b]<key) {
                left = b+1;
            }else{
                right = b-1;
            }
        }
        return -1;
    }
    // xay them quick sort cho vui nha
    // ham phan vung
    public int phanHoach(int left, int right){
        int i = left - 1;
        int pivot = right;
        for(int j = left;j<right;j++){
            if(a[j]<a[pivot]){
                i++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        i++;
        int tmp = a[i];
        a[i] = a[pivot];
        a[pivot] = tmp;
        return i;
    }
    // ham quick sort
    public void quickSort(int left, int right){
        if(left<right){
            int i = phanHoach(left,right);
            quickSort(left,i-1);
            quickSort(i+1, right);
        }
    }
    // ham chinh
    public static void main(String[] args) {
        leetcode373_heap_binary t = new leetcode373_heap_binary();
        Scanner sc = new Scanner(System.in);
        t.khoiTaoMang();
        t.heapSort();
        int c[] = t.a;
        t.xuatMang();
        t.khoiTaoMang();
        t.heapSort();
        int d[] = t.a;
        t.xuatMang();
        // tim k cap co tong nho nhat
        // y tuong cho mot mang 2 chieu gom 3 phan i j tong


    }
}
