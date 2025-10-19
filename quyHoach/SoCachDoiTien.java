package quyHoach;

public class SoCachDoiTien {
    // De bai:
//    Cho một số tiền cần đổi là amount và một mảng các mệnh giá tiền coins[].
//    Hãy tính số cách để đổi ra đúng số tiền amount.
//    (Mỗi loại coin có thể dùng bao nhiêu lần cũng được).
    // Giai:
    //cac bien can su dung
    int amount; // so tien can doi
    int coin[] = {1,2,3,4,5,6,7,8,9}; // bang menh gia tien
        // cong thuc truy hoi: dp[i]=dp[i]+dp[i−coin]
    int dp[]=new int[1000];
    public void quyHoach(){
        for(int i = 0;i<coin.length;i++){

        }
    }


}
