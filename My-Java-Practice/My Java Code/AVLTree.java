public class AVLTree extends TreeNode{

    private TreeNode root;
    

    public AVLTree(int data){
        super(data);
        this.root = new TreeNode(data);
        this.height = 1;
    }

    public void insert(int data){
        this.root = insert(data, this.root);
        this.root.setHeight(updateHeight(this.root));

    }

    public void setHeight(int height){
        this.height = height;
    }

    public int updateHeight(TreeNode node){
        if(node == null){
            return 0;
        } else{
            int maxHeight = Math.max(updateHeight(node.left), updateHeight(node.right));
            return maxHeight + 1;
        
        }
    }

    public void Rotation(TreeNode node){
        int balance = getBalance(node);
        if(balance > 1){
            if(getBalance(node.left) < 0){
                node.left = rotateLeft(node.left);
            }
        } else if(balance < -1){
            if(getBalance(node.right) > 0){
                node.right = rotateRight(node.right);
            }
        }
    }

    public TreeNode rotateRight(TreeNode node){
        TreeNode leftNode = node.left;
        leftNode.right = node;
        node.left = leftNode.right;
        node.setHeight(updateHeight(node));
        leftNode.setHeight(updateHeight(leftNode));
        return leftNode;
    }

    public TreeNode rotateLeft(TreeNode node){
        TreeNode rightNode = node.right;
        rightNode.left = node;
        node.right = rightNode.left;
        node.setHeight(updateHeight(node));
        rightNode.setHeight(updateHeight(rightNode));
        return rightNode;
    }

    public int getBalance(TreeNode node){
        if(node == null){
            return 0;
        } else{
            return updateHeight(node.left) - updateHeight(node.right);
       }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree(5);
        avlTree.insert(8);
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(9);
        avlTree.insert(5);


    }
    


    




}