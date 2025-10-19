import java.util.Random;
import java.util.Scanner;

public class testNghe {
    int a[] = new int[10];
    // khoi tao mang ngau nhien
    public void khoiTao(){
        Random ran = new Random();
        for(int i = 0;i<a.length;i++){
            a[i] = ran.nextInt(10);
        }
    }
    public void xuatMang(){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    //phan vung
    public int phanVung(int left, int right){
        int i = left-1;
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
    // ham chinh quick sort
    public void quickSort(int left, int right){
        if(left<right){
            int i = phanVung(left,right);
            quickSort(left,i-1);
            quickSort(i+1,right);
        }
    }
    // ham binary search
    public int binaSearch(int key){
        int left = 0;
        int right = a.length-1;
        while (left<=right){
            int b = (left+right)/2;
            if(a[b]==key) return b;
            else if (a[b]<key) {
                left=b+1;
            }else{
                right = b - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        testNghe t = new testNghe();
        t.khoiTao();
        t.xuatMang();
        t.quickSort(0, t.a.length-1);
        t.xuatMang();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao gia tri can tim");
        int key = sc.nextInt();
        System.out.println("Index: "+t.binaSearch(key));
    }
}
