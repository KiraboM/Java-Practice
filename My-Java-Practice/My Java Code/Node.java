public class Node{
    int data;
    Node next;
//constructor of linked list node
    public Node(int data){
        this.data = data;
        this.next = null;
    }
//recieving data from the node
    public int getData(){
        return this.data;
    }

    public void assignData(int data){
        this.data = data;
    }

    public int retrieve(int n, Node root){
        if (root == null){
            return -1; //element not found
        } else{
            if(root.getData() == n){
                return root.getData(); //element found
            } else{
                return retrieve(n, root.next);
            }
            }
        }
    public void insert(int n, Node root){
        //Create new node
        Node newNode = new Node(n);
        if (root == null){
            root = newNode;
            return;
        } else{
            insert(n, root.next);
        }
        }
    public int delete(int n, Node root){
        if (root == null){
            System.out.println("Element not found");
            return -1;
        } else{
            if(root.data == n){
                root.data = -1;
                return n;

            } else{
                return delete(n, root.next);
            }
        }
        }
    public void printList(Node root){
        if(root == null){
            return;
        } else{
            System.out.println(root.data + "  -> ");
            printList(root.next);
        }
        }
    
    
    public static void main(String[] args) {
        Node root = new Node(5);
        root.insert(12, root);
        root.insert(1, root);
        root.insert(4, root);
        root.delete(1, root);
        root.insert(15, root);
        root.printList(root);

    }
}
        