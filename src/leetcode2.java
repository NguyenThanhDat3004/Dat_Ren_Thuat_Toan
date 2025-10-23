public class leetcode2 {
    //Đầu vào: l1 = [0], l2 = [0]
    // Đầu ra: [0]

    int du = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode kq = new ListNode(0);
        ListNode current = kq;

        while(l1!=null||l2!=null){
            int x =  (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int ketQua = x+y+du;
            if(ketQua>=10){
                current.next = new ListNode(ketQua%10);
                du = ketQua/10;
            }else{
                current.next = new ListNode(ketQua);
                du=0;
            }
            if (l1 != null) l1 = l1.next;// tranh 1 trong 2 null
            if (l2 != null) l2 = l2.next;
            current = current.next;
        }
        if(du>0){
            current.next = new ListNode(du);
        }
        return kq.next;
}
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  class Main1{
      public static void printList(ListNode node) {
          while (node != null) {
              System.out.print(node.val);
              if (node.next != null) System.out.print(" -> ");
              node = node.next;
          }
          System.out.println();
      }
      public static void main(String[] args) {
          leetcode2 sol =new leetcode2();
          // Tạo danh sách 1: 2 -> 4 -> 3
          ListNode l1 = new ListNode(2);
          l1.next = new ListNode(4);
          l1.next.next = new ListNode(3);

          // Tạo danh sách 2: 5 -> 6 -> 4
          ListNode l2 = new ListNode(5);
          l2.next = new ListNode(6);
          l2.next.next = new ListNode(4);

          // Gọi hàm cộng
          ListNode result = sol.addTwoNumbers(l1, l2);

          // In kết quả
          System.out.print("Kết quả: ");
          printList(result);  // mong đợi: 7 -> 0 -> 8
      }
}
