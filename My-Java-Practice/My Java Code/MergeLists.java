public class MergeLists{

    public static ListNode mergeList(ListNode[] lists){
        int j = 0;// Keeping track of the amount of numbers added to the heap
        Heap heap = new Heap(100);
        for(int i = 0; i < lists.length; i++){
            ListNode current = lists[i];
            while(current != null){
                heap.add(current.getData());
                current = current.getNext();
                j++;
            }
        }
        ListNode mergedList = new ListNode(-1);// Setting up an empty list
        for(int i = 0; i <= j; i++){
            int min = heap.poll();
            if(min != -1){
                mergedList.insert(min, mergedList);
            }

    }
    return mergedList;
}
    public static void main(String[] args){
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].insert(2, lists[0]);
        lists[0].insert(5, lists[0]);
        lists[1] = new ListNode(1);
        lists[1].insert(3, lists[1]);
        lists[1].insert(4, lists[1]);
        lists[1].insert(6, lists[1]);
        lists[2] = new ListNode(2);
        lists[2].insert(7, lists[2]);
        lists[2].insert(9, lists[2]);
        ListNode list = mergeList(lists);
        list.printList(list);
    }
}
