//Cho một mảng số nguyên numsđược sắp xếp theo thứ tự không giảm,
// hãy tìm vị trí bắt đầu và kết thúc của một targetgiá trị nhất định.
//
//Nếu targetkhông tìm thấy trong mảng, trả về [-1, -1].

import java.util.Random;
import java.util.Scanner;

public class leetCode34_sort_search {

    int a[];
    Random ran = new Random();
    public void taoMang(){
        a = new int[10];
        for(int i = 0; i< a.length;i++){
            a[i] = ran.nextInt(10);
        }
    }
    // xuat mang
    public void xuatMang(){
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    // ham phan hoach mang
    public int phanHoach(int left, int right, int b[]){
        int i = left-1;
        int pivot = right;
        for (int j = left; j < right; j++) {
            if(b[j]<b[pivot]){
                i++;
                int tmp = b[j];
                b[j] = b[i];
                b[i] = tmp;
            }
        }
        i++;
        int temp = b[i];
        b[i] = b[pivot];
        b[pivot] = temp;
        return i;
    }
    public void sortMang(int left, int right, int[] b){
        if(left<right){
            int n = phanHoach(left,right,b);
            sortMang(left,n-1,b);
            sortMang(n+1,right,b);
        }
    }
    // ham binary
    public int search (int key){
        int left = 0;
        int right = a.length-1;
        while (left<=right){
            int b = (left+right)/2;
            if(a[b]==key) return b;
            else if (a[b]>key) {
                right=b-1;
            }else {
                left=b+1;
            }
        }
        return -1;
    }
    // ham ra soat
    public int[] raSoat(int left, int right, int key){
       // mo rong tim
        int top;
        int down;
        if(this.search(key)==-1){
            return new int[]{-1,-1};
        }else {

            top=down = this.search(key);
            while(left<down&&key==a[down]){
                down--;
            }
            down++;
            while(right>top&&key==a[top]){
                top++;
            }
            top--;
        }
        return new int[]{down,top};
    }
// ham chinh
public static void main(String[] args) {
    leetCode34_sort_search t = new leetCode34_sort_search();
    Scanner sc  = new Scanner(System.in);
    t.taoMang();
    t.xuatMang();
    t.sortMang(0,t.a.length-1,t.a);
    t.xuatMang();
    System.out.println("Nhap so: ");
    int key = sc.nextInt();
    int c[] = t.raSoat(0,t.a.length-1,key);
        System.out.print(c[0]+","+c[1]);

}
}
