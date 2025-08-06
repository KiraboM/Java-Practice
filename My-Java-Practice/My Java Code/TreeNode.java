
public class TreeNode{

    protected  int data;
    protected TreeNode left;
    protected TreeNode right;
    protected int height;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1; //Height of new node is 1
    }

    public void setHeight(int height){
        this.height = height;
    }
    
    public TreeNode insert(int data, TreeNode root){
        if(root == null){
            root = new TreeNode(data);
            return root;
        } else if(data > root.data){
            root.right = insert(data, root.right);
        } else if(data < root.data){
            root.left = insert(data, root.left);
        }
        return root;
    }

    public TreeNode delete(int data, TreeNode root){
        //Checking if the tree is empty
        if(root == null){
            return root; //Item not found
        } else{
            //Recursively searching for the item to delete
            if(root.data < data){
                root.right = delete(data, root.right);
            } else if(root.data > data){
                root.left = delete(data, root.left);
            } else if(root.data == data){
                //Case when deleted node has no children or has one child
                if(root.left == null){
                    root.data = root.right.data;
                    root.right = root.right.right;
                    return root;
                } else if(root.right == null){
                    root.data = root.left.data;
                    root.left = root.left.left;
                    return root;
                    //Case when deleted node has two children
                } else{
                    //Finding the smallest value in the right subtree
                    TreeNode current = root.right;
                    while(current.left != null){
                        current = current.left;
                    }
                    //replacing the data of the deleted node with the smallest value
                    root.data = current.data;
                    //Deleting the smallest value from the right subtree to maintain the BST property
                    root.right = delete(current.data, root.right);
                    
                }
            }
        }
        return root;
    }

    public boolean ValidateBST(TreeNode root, int min, int max){
        boolean isValid = true;
        //Checking if tree has only one node
        if(root == null){
            return isValid;
        } else{
            //Checking if the data of the node is within the acceptable range
            if(root.data < min || root.data > max){
                isValid = false;
                //Checking if the left child is greater than the root or the right child is less than the root
            } else if (root.left.data > root.data || root.right.data < root.data){
                isValid = false;
            } else{
                //Recursively checking the left and right subtrees
                isValid = ValidateBST(root.left, min, root.data) && ValidateBST(root.right, root.data, max);
            }
            }
            return isValid;
            
        }

    
    }
    
