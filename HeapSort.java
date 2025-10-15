import java.util.Random;

public class HeapSort {
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
    // heapify
    public void heapify(int n, int i){
        // n la size;
        // i la chi so not cha
        int largest = i; // la goc
        int left = 2*i+1; // la trai
        int right = 2*i+2; // la phai
        // 2 truong hop
        // la trai lon hon cha
        if(left<n&&a[largest]<a[left]){
            largest = left;
        }
        // neu la phai lon hon
        if(right<n&&a[largest]<a[right]){
            largest = right;
        }
        // buoc hoan doi
        if(largest!=i){
            int tmp = a[largest];
            a[largest] = a[i];
            a[i] = tmp;
            // thuc hien de quy cho cac nhanh duoi
            heapify(n,largest);
        }
    }
    // build max heap
    public void buildHeap(){
        for(int i = n/2-1;i>=0;i--){
            // duyet tu duoi len de build max heap
            heapify(n,i);
        }
    }
    // heap sort
    public void heapSort(){
        // buoc 1: xay mot cai max heap
        buildHeap();
        // buoc 2 : tach biet thang lon nhat, cho lon nhat ve cuoi va thuc hien heapify lai mang moi tru thang cuoi
        for(int i = n-1;i>=0;i--){
            int tmp = a[i];
            a[i] = a[0]; // gan max la cuoi, min len dau
            a[0] = tmp;
            // tien hanh thuc hien heapify lai
            heapify(i,0); // chi can xay tren xuong la oke
        }
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        h.khoiTaoMang();
        h.xuatMang();
        h.heapSort();
        h.xuatMang();
    }
    }















// kien thuc
//not trai= 2i+1
//not phai = 2i+2
// heap la cay nhi phan hoanh chinh
// max heap la cha luon lon hon con
// min heap la cha luon nho hon con
// not la dau tien la n/2-1
