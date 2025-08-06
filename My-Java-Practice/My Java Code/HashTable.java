import java.util.HashMap;

public class HashTable{

    HashMap<Integer, String> table;

    public HashTable(){
        this.table = new HashMap<>();
    }

    public void put(int key, String value){
        this.table.put(key, value);
    }

    public String get(int key){
        return this.table.get(key);
    }

    public boolean containsKey(int key){
        return this.table.containsKey(key);
    }

    public void remove(int key){
        this.table.remove(key);
    }

    public void printTable(){
        for(int key : table.keySet()){
            System.out.println(key % 100 + " : " + key + " : " + table.get(key));
        }
    }

    public static void main(String[] args){
        HashTable table = new HashTable();
        table.put(100,"A");
        table.put(123,"B");
        table.put(555,"A");
        table.put(127,"D");
        table.put(135,"E");
        table.printTable();
    }


}