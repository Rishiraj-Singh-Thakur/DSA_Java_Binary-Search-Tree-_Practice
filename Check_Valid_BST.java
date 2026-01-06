public class Check_Valid_BST {
    static class Node{
        int data;
        Node left ,right;
        Node (int data){
            this.data = data;
        }
    }
    public static Node insert(Node root , int val){
        if(root == null){
            return new Node(val);
        }
        if(val<=root.data){
            root.left = insert(root.left, val);
        }
        else if(val>root.data){
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static boolean isValid(Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(min !=null && root.data < min.data){
            return false;
        }
        if(max != null && root.data > max.data){
            return false;
        }
        Boolean left = isValid(root.left, min, root);
        Boolean right = isValid(root.right, root, max);
        return left && right;
    }
    public static void main(String[] args) {
        int value[] = {2,4,6,3,6,8,5,4,73,55};
        Node root = null;
        for(int val: value){
            root = insert(root,val);
        }
        if(isValid(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("inValid");
        }
    }
}
