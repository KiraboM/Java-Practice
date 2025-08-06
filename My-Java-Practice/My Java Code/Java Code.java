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

    public int assignData(int data){
        this.data = data;
    }

    public int retrieve(int n, Node root){
        if (root.data == null){
            return -1; //element not found
        } else{
            if(root.getData() == n){
                return root.getData(); //element found
            } else{
                retrieve(n, root.next);
            }
            }
        }
    public void insert(int n, Node root){
        if (root.data = null){
            root.data = n;
        } else{
            insert(n, root.next);
        }
        }
    public int delete(int n, Node root){
        if (root.data = null){
            System.out.println("Element not found");
            return -1;
        } else{
            if(root.data == n){
                root.data = null;
                return n;

            } else{
                this.delete(n, root.next);
            }
        }
        }
    public void printList(Node root){
        if(root == null){
            return;
        } else{
            System.out.println(root.data, "  -> ");
            printList(root.next);
        }
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
        