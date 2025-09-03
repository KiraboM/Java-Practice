public class Heap{

    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity){
        this.heap = new int[capacity];
        this.size = -1;
        this.capacity = capacity;
    }

    public int getSize(){
        return this.size;
    }

    public void add(int item){
        if(this.size >= this.capacity){
            System.out.println("Heap is full");//Check if heap if full
        } else{
            if(this.size < 0){
                this.size++;
                this.heap[this.size] = item;
            } else{
                this.size++;
                this.heap[this.size] = item;
                this.heapifyUp(this.size);//Restoring the heap property
            }
        }
        }

    public int poll(){//Retrieve largest item and remove it from the heap
        if(this.size < 0){
            return -1;
        } else{
            int item = this.heap[0];
            this.heap[0] = this.heap[this.size];
            this.size--;
            this.heapifyDown(0);
            return item;
        }
    }

    public int delete(int item){
        if(this.size < 0){
            return -1; //List is empty
        } else{
            int i = 0;
            while(i <= this.size && this.heap[i] != item){
                i++;
            }
            if(this.heap[i] == item){
                int num = this.heap[i];// Extract the deleted item
                this.heap[i] = this.heap[this.size]; //Erase the item by replacing it with the last element
                this.size--;
                this.heapifyDown(i); //Restore the heap property
                return num;
            } else{
                return -1; //Element not found
            }
        }
    }
   

    public void heapifyDown(int i){
        if(i*2 + 1 > this.size || i*2 + 1 <= 0){
            return;
        } else{
            if(this.heap[i*2 + 1] > this.heap[i]){
                int temp = this.heap[i*2 + 1];
                this.heap[i*2 + 1] = this.heap[i];
                this.heap[i] = temp;
                heapifyDown(i);
                heapifyDown(i*2+1);
            } else if(this.heap[i*2 + 2] > this.heap[i]){
                int temp = this.heap[i*2 + 2];
                this.heap[i*2 + 2] = this.heap[i];
                this.heap[i] = temp;
                heapifyDown(i*2+2);
         } else{
            return;
         }
    }
}
public void heapifyUp(int i){
        if((i - 1)/2 < 0){
            return;
        } else{
            if(this.heap[i] > this.heap[(i-1)/2]){
                int temp = this.heap[(i-1)/2];
                this.heap[(i-1)/2] = this.heap[i];
                this.heap[i] = temp;
                heapifyUp((i-1)/2);
         } else{
            return;
         }
    }
    }

    public int[] returnHeap(){
        return this.heap;
    }
    
     public static void main(String[] args) {
         Heap heap = new Heap(8);
         heap.add(5);
         heap.add(3);
         heap.add(9);
         heap.add(4);
         heap.add(12);
         heap.add(13);
         heap.add(1);
         heap.add(2);
        

     }
}
