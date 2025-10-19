package tree;

import java.util.List;

public class chuoiBaiTree {
    //Same Tree — kiểm tra hai cây có giống nhau không
    //Symmetric Tree — kiểm tra cây có đối xứng không
    //Maximum Depth of Binary Tree — độ sâu tối đa của cây nhị phân
    //Minimum Depth of Binary Tree — độ sâu tối thiểu của cây nhị phân
    //Invert Binary Tree — đảo ngược (lật) cây nhị phân
    //Binary Tree Paths — liệt kê tất cả đường từ gốc đến lá
    //Merge Two Binary Trees
    //Path Sum
    //Sum of Left Leaves
    //Leaf-Similar Trees
    //Balanced Binary Tree
    //Convert Sorted Array to Binary Search Tree
    //Search in a Binary Search Tree
    //Lowest Common Ancestor of a Binary Search Tree

}
class Node {
    //con
    Node right;
    Node left;
    int data;

    public Node(Node right,Node left, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }
}

class sameTree {
    //Same Tree — kiểm tra hai cây có giống nhau không
    // so sanh 2 cay
    public boolean soSanh2Cay(Node tree1, Node tree2){
        if(tree1==null&&tree2==null){
            return true;
        }else if(tree1==null||tree2==null){
            return false;
        }else{
            if(tree1.data==tree2.data){
                boolean a = soSanh2Cay(tree1.left, tree2.left);
                boolean b = soSanh2Cay(tree1.right, tree2.right);
                if(a==false||b==false) return false;
            }else{
                return false;
            }
        }
        return true;
    }
    //Symmetric Tree — kiểm tra cây có đối xứng không
    // tu duy bo root so sanh tu cay thu 2 kiem tra neu trai = phai==> oke
    public boolean isSymmetric(Node left, Node right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        else{
            if(right.data==left.data){
                boolean a = isSymmetric(left.left,right.right);
                boolean b = isSymmetric(left.right, right.left);
                if(a==false||b==false) return false;
            }else return false;
        }
        return true;
    }
    //Maximum Depth of Binary Tree — độ sâu tối đa của cây nhị phân
    // duma qua dinh cao
    public int maxDepth(Node cay){
        // chieu cao max khi no la 1 lien ket thoi:))
        // chieu cao max bang kich thuoc mang
        int dem=0;
        // duyet dang pre
        if(cay==null) return dem;
        if(cay!=null){
            dem++;
            int a = maxDepth(cay.left);
            int b = maxDepth(cay.right);
            dem = dem+a+b;
        }
    return dem;
    }
    //Maximum Depth of Binary Tree — độ sâu tối đa của cây nhị phân
    // loi nghi khac
    public int maxDepthBalanceTree(Node cay2){
        // chieu cao max khi no la 1 lien ket thoi:))
        // chieu cao max bang kich thuoc mang
        int dem=0;
        // duyet dang pre
        if(cay2==null) return dem;
        if(cay2!=null){
            int a = maxDepthBalanceTree(cay2.left);
            int b = maxDepthBalanceTree(cay2.right);
            dem = 1+Math.max(a,b);
        }
        return dem;
    }
    //Minimum Depth of Binary Tree — độ sâu tối thiểu của cây nhị phân
    // duma dang cap nha:)))
    public int minHeight(Node tree){
        int dem = 0;
        if(tree == null) return 0;
        if(tree.left==null) return dem = 1 + minHeight(tree.right);
        if(tree.right==null) return dem = 1 + minHeight(tree.left);
        return 1+Math.min(minHeight(tree.left), minHeight(tree.right));
    }
    //Invert Binary Tree — đảo ngược (lật) cây nhị phân
    // tuc la hoan doi trai phai thoi
    public void invertBinary(Node tree){
        if(tree==null) return;
        Node tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
        invertBinary(tree.right);
        invertBinary(tree.left);
    }
    //Binary Tree Paths — liệt kê tất cả đường từ gốc đến lá
    // quy hoach dong
    public void quyHoach(Node dau, String path, List<String> result){
        if(dau==null) return;
        // cap nhat duong di
        if(path.isEmpty()) path = ""+dau.data;
        else path+="-"+dau.data;
        // neu la la thi ghi vao result
        if(dau.right==null&&dau.left==null) {
            result.add(path);
            return;
        }
        // phai luu duong di hien ta da
        quyHoach(dau.left,path,result);
        quyHoach(dau.right,path,result);
    }
    // Leetcode 617: //Merge Two Binary Trees
    // neu cung 1 node co 2 gia tri thi lay sum khong thi lay gia tri 1 node
    // khong co node tra ve null
    public Node mergeBinary(Node tree1, Node tree2){
        if(tree1==null&&tree2==null) return null;
        if(tree1==null) return tree2;
        if(tree2==null) return tree1;
        tree1.data = tree1.data+tree2.data;
        tree1.left = mergeBinary(tree1.left,tree2.left);
        tree1.right = mergeBinary(tree1.right,tree2.right);
        return tree1;
    }
    //Path Sum leetcode 112
    // cho mot cay nhi phan va mot taget, muc tieu tim path = target
    // dung quy hoach dong tiep =))
    public void quyHoach(Node dau, int sum, List<Integer> result){
        if(dau==null) return;
        sum+=dau.data;
        // cong toi khi la thi cho vao list
        if(dau.left==null&&dau.right==null){
            result.add(sum);
        }
        quyHoach(dau.left, sum, result);
        quyHoach(dau.right, sum, result);
    }
    // search
    public boolean search(int target, List<Integer> list){
        for(Integer i : list){
            if(i == target) return true;
        }
        return false;
    }

}
