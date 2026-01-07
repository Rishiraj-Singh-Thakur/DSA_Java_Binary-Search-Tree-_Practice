public class Largest_BST_In_BinaryTree {
    static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static class info{
        int size;
        int max;
        int min;
        boolean isBST;

        public info(boolean isBST , int max ,int min , int size){
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    public static int maxBST = 0;
    public static info Balance_BST(Node root){
        if(root == null){
            return new info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        info leftInfo = Balance_BST(root.left);
        info rightInfo = Balance_BST(root.right);

        int size = leftInfo.size + rightInfo.size +1;
        int max = Math.max(root.data, Math.max(leftInfo.max , rightInfo.max));
        int min = Math.min(root.data, Math.min(leftInfo.min , rightInfo.min));

        if(root.data >= rightInfo.min || root.data <= leftInfo.max){
            return new info(false, max, min, size);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new info(true, max, min, size);
        }
        return new info(false, max, min, size);

    }
//     /*
//                       (50)
//                      /    \
//                     /      \
//                   (30)     (60)
//                   /  \     /  \
//                  /    \  (45)  \
//                 (5)   (20)     (70)
//                                /  \
//                               /    \
//                             (65)   (80)

// */
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        info Info = Balance_BST(root);
        System.out.println(maxBST);
    }
}
