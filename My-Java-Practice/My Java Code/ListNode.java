
public class ListNode{
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }

    public ListNode getNext(){
        return this.next;
    }

    //recieving data from the node
    public int getData(){
        return this.data;
    }

    public void assignData(int data){
        this.data = data;
    }

    public int retrieve(int n, ListNode root){
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
    public void insert(int n, ListNode root){
        //Create new node
        if (root == null){
            return;
        } 
        if (root.next == null){
            root.next = new ListNode(n);
        } else{
            insert(n, root.next);
        }
        }
    public int delete(int n, ListNode root){
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
    public void printList(ListNode root){
        if(root == null){
            System.out.println("End of list");
        } else{
            System.out.print(root.data + "  -> ");
            printList(root.next);
        }
        }
    public ListNode reverseList(ListNode head){
        //Initialising new list pointers
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            //Reversing the pointers at each node of the list
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //Returning the new head of the list
        return prev;
        //This function has a time complexity of O(n) as it linearly goes through the entire linked list
        //This function has a space complexity of O(1) as it does not use any additional data structers
    }
    public boolean hasCycle(ListNode head){
        if(head == null){
            //checking for empty list
            return false;
        } else if(head.next == null){
            // checking if the list has only one node
            return false;
        } else{
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                
                //Checking if a cycle has been detected
                if(slow == fast){
                    return true;
                } 
            }
            
        }
        return false;
        }
        
    

    public static void main(String[] args){
        ListNode root = new ListNode(4);
        root.insert(2,root);
        root.insert(8,root);
        root.insert(6,root);
        root.insert(2,root);
        root.insert(8,root);
        root.insert(6,root);
        root.printList(root);
        root = root.reverseList(root);
        root.printList(root);
    
    }


}