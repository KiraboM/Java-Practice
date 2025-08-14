public class AVLTree extends TreeNode{

    private TreeNode root;
    

    public AVLTree(int data){
        super(data);
        this.root = new TreeNode(data);
        this.root.setHeight(1); //Height of root node is initially one
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public void insert(int data){
        this.root = insert(data, this.root);
        this.root.setHeight(updateHeight(this.root));
        Rotation(this.root);

    }
    @Override

    public void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.left);
            System.out.print(node.data + "->");
            inOrderTraversal(node.right);

        }
    }
    @Override

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
            node = rotateRight(node);
        } else if(balance < -1){
            if(getBalance(node.right) > 0){
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
    }

    public TreeNode rotateRight(TreeNode node){
        TreeNode leftNode = node.left;
        TreeNode centerNode = leftNode.right;
        leftNode.right = node;
        node.left = centerNode;
        //Update heights after rotation
        node.setHeight(updateHeight(node));
        leftNode.setHeight(updateHeight(leftNode));
        return leftNode;
    }

    public TreeNode rotateLeft(TreeNode node){
        TreeNode rightNode = node.right;
        TreeNode centerNode = rightNode.left;
        rightNode.left = node;
        node.right = centerNode;
        //Update heights after rotation
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
        avlTree.inOrderTraversal(avlTree.getRoot());


    }
    


    




}