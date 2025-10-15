package quyHoach;

import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    //Cho một mảng các số nguyên khác nhaucandidates và một số nguyên đích target, trả về danh sách tất cả
    // các tổ hợp duy nhất mà candidatestổng các số đã chọn bằng target.
    // Bạn có thể trả về các tổ hợp này theo bất kỳ thứ tự nào .
    //Cùng một số có thể được chọn từ candidatesmột số lần không giới hạn .
    // Hai tổ hợp là duy nhất nếuTính thường xuyêntrong đó ít nhất một số được chọn là khác nhau.
    //Các trường hợp thử nghiệm được tạo ra sao cho số lượng các tổ hợp
    // duy nhất cộng lại targetít hơn 150số tổ hợp cho đầu vào đã cho.
    //Ví dụ 1:
    //Đầu vào: ứng viên = [2,3,6,7], mục tiêu = 7
    // Đầu ra: [[2,2,3],[7]]
    // Giải thích:
    //2 và 3 là các ứng cử viên, và 2 + 2 + 3 = 7. Lưu ý rằng 2 có thể được sử dụng nhiều lần.
    //7 là một ứng cử viên và 7 = 7.
    //Đây là hai sự kết hợp duy nhất.
    //Ví dụ 2:
    //Đầu vào: ứng viên = [2,3,5], mục tiêu = 8
    // Đầu ra: [[2,2,2,2],[2,3,3],[3,5]]
    //Ví dụ 3:
    //Đầu vào: ứng viên = [2], mục tiêu = 1
    // Đầu ra: []
    List<String> list = new ArrayList<>();
    public boolean check(String chuoi){
        char a[] = chuoi.toCharArray();
        for(int i = 0;i<a.length-1;i++){
            for(int j = i+1;j<a.length;j++){
                if(a[i]>a[j]) return false;
            }
        }
        return true;
    }
    public void add(int target,int tong, int a[], String chuoi){
    if(tong==target&&check(chuoi)){
        list.add(chuoi);
        return;
    }
    if(tong>target) return;
    for(int i = 0;i<a.length;i++){
        add(target,tong+a[i],a,chuoi+a[i]);
    }
    }

    public static void main(String[] args) {
        int a[] = {2,3,6,7};
        leetcode39 t = new leetcode39();
        t.add(7,0,a,"");
        for(String i : t.list) System.out.println(i);
    }
}
