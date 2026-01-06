import java.util.*;
public class Find_Paths_of_BST {
    static class Node{
        int data;
        Node left , right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void PrintPath(ArrayList<Integer> paths){
        for(int i = 0; i<paths.size(); i++){
            System.out.print(paths.get(i)+"->");
        }
        System.out.println("null");
    }


    public static Node insert(Node root , int val){
        if(root == null) return new Node(val);

        if(val <root.data){
            root.left = insert(root.left, val);
        }else if(val> root.data){
            root.right = insert(root.right, val);
        }
        return root;
    }


    public static void PathsOfBST(Node root , ArrayList<Integer> paths){
        if(root == null){
            return;
        }
        paths.add(root.data);
        if(root.left == null && root.right == null){
            PrintPath(paths);
        }
        PathsOfBST(root.left ,paths);
        PathsOfBST(root.right , paths);
        paths.remove(paths.size()-1);
    }


    public static void main(String[] args) {
        int values[] = {5,6,3,5,7,9,31};
        Node root = null;
        for(int val : values){
            root = insert(root , val);
        }
        // ArrayList<Integer> paths = new ArrayList<>();
        PathsOfBST(root ,new ArrayList<>());
    }
}
