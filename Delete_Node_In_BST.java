public class Delete_Node_In_BST{
    static class  Node {
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root , int val){
        if(root == null) return new Node(val);

        if(root.data < val){
            root.right = insert(root.right, val);
        }
        else{
            root.left = insert(root.left, val);
        }
        return root;

    }
    public static Node InorderSuccesser(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static Node DeleteNode(Node root , int val) {
        if (root == null) return null;

        if(val < root.data){
            root.left = DeleteNode(root.left, val);
        }else if(root.data < val){
            root.right =  DeleteNode(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }
            Node IS = InorderSuccesser(root.right);
            root.data = IS.data;
            root.right = DeleteNode(root.right , IS.data);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data +"  ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {5,6,3,2,4,8,4,7,9,5};
        Node root = null;
        for (int val : values){
            root = insert(root, val);
        }

        root = DeleteNode(root, 8);
        inorder(root);
    }
}