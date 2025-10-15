package quyHoach;

public class Fibonacy {
    //Đề bài: Tính số Fibonacci thứ n.
    //Mục tiêu DP: Lưu trữ kết quả các số Fibonacci trước để tránh tính lại.
    //Kỹ thuật: Bottom-up 1D array.
    // cong thuc fn = fn-1+fn-2
    // giai tao ra mot mang de luu so fibo
    int n=100;
    int a[] = new int[n]; // mot mang de luu so fibo
    public int quyHoachTimFibo(int key){
        if(key==0) return 0;
        else if (key==1) {
            return 1;
        }else{
          a[0]=0;
          a[1]=1;
          for(int i = 2;i<n;i++){
              a[i] = a[i-1]+a[i-2];
              if(key==a[i]) return i;
              if(key<a[i]) break;
              if(i==n-1){
                  moRong();
              }
          }
        }
        return -1;
    }
    // mo rong mang neu vuot chi so
    public void moRong(){
        int b[] = new int[2*n];
        for(int i = 0;i<n;i++){
            b[i] = a[i];
        }
        a = b;
    }
    // ham main
    public static void main(String[] args) {
        Fibonacy t = new Fibonacy();
        int i = t.quyHoachTimFibo(1000);
        if(i==-1){
            System.out.println("Khong phai so Fibo");
        }else{
            System.out.println("So nay la so Fi thu: "+i);
        }
    }
}
