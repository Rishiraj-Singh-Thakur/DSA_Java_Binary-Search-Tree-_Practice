import java.util.*;
public class BST_into_BalancedBST{
    static class Node{
        int data;
        Node left ,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void inOrder(ArrayList<Integer>arr, Node root){
        if (root == null){
            return;
        }
        inOrder(arr , root.left);
        arr.add(root.data);
        inOrder(arr, root.right);
    }
    public static Node Balance_BST(ArrayList<Integer>arr , int str , int end){
        if(str > end){
            return null;
        }
        int mid = (str+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = Balance_BST(arr, str, mid-1);
        root.right = Balance_BST(arr, mid+1, end);
        return root;

    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
        root.left.left.left = new Node(2);
        root.right = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);

        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(arr,root);
        System.out.println(arr);
        int str = 0;
        int end = arr.size()-1;
        Node newroot = Balance_BST(arr , str , end);
        System.out.println(newroot.right.right.data);
    }
}