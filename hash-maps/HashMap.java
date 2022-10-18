import java.util.*;
import java.io.*;
public class HashMap <K,V>{
    private class HMnode{
        K key;
        V value;
        public HMnode(K key,V value){
            this.key=key;
            this.value=value;
        }
    }
    
    int size;
    LinkedList<HMnode>[] buckets;
    double lambda_th;
    
    public HashMap(){
        initBuckets(4);
        this.size=0;
        this.lambda_th=2;
    }
    public void initBuckets(int n){
        this.buckets=new LinkedList[n];
        for(int i=0;i<n;i++)
            this.buckets[i]=new LinkedList<>();
    }

    public void put(K key, V value){
        int bucket_i=getBucketIndex(key);
        int list_i=getListIndex(key,bucket_i);
        if(list_i==-1){
            HMnode node=new HMnode(key, value);
            this.buckets[bucket_i].add(node);
            System.out.println("Inserted: "+key);
            this.size++;
        }
        else{
            this.buckets[bucket_i].get(list_i).value= value;
            System.out.println("Updated: "+key);
        }

        double lambda= this.size*1.0/this.buckets.length;
        if(lambda>this.lambda_th)
        {
            rehash();
            System.out.println("rehash: ");
        }
    }

    public boolean containsKey(K key){
        int bucket_i=getBucketIndex(key);
        return getListIndex(key, bucket_i)!=-1;
    }

    public V get(K key){
        int bucket_i= getBucketIndex(key);
        int list_i=getListIndex(key, bucket_i);
        return list_i!=-1 ? this.buckets[bucket_i].get(list_i).value : null;
    }

    public V remove(K key){
        int bucket_i= getBucketIndex(key);
        int list_i=getListIndex(key, bucket_i);
        if(list_i==-1)
            return null;
        HMnode node=this.buckets[bucket_i].remove(list_i);
        this.size--;
        return node.value;
    }

    public ArrayList<K> getKeys(){
        ArrayList<K> keys=new ArrayList<>();
        for(int i=0;i<this.buckets.length;i++){
            for(HMnode node:buckets[i]){
                keys.add(node.key);
            }
        }
        return keys;
    }
    
    public ArrayList<V> getValues(){
        ArrayList<V> values=new ArrayList<>();
        for(int i=0;i<this.buckets.length;i++){
            for(HMnode node:buckets[i]){
                values.add(node.value);
            }
        }
        return values;
    }

    public int getBucketIndex(K key){
        return Math.abs(key.hashCode() % this.buckets.length);
    }
    public int getListIndex(K key, int b_index){
        int i=0;
        for(HMnode node:this.buckets[b_index]){
            if(node.key.equals(key))
                return i;
            i++;
        }
        return -1;
    }

    private void rehash(){
        LinkedList<HMnode>[] old_buckets=this.buckets;
        initBuckets(2*old_buckets.length);
        this.size=0;
        for(int i=0;i<old_buckets.length;i++){
            for(HMnode node: old_buckets[i]){
                put(node.key, node.value);
            }
        }
    }

    // DRIVER FUNCTION
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap hash=new HashMap<>();
        
        System.out.println("The key string + index will be the final key used and the value will be the index itself\nEnter a string for key:");
        String key=sc.next();
        System.out.println("Please enter the number of elements to be inserted: ");
        int size=sc.nextInt();

        for(int i=0;i<size;i++){
            hash.put(key+i, i);
        }
        System.out.println("""
                KEYS\tOPERATIONS
                1\tAdd or Update Element
                2\tCheck Key existance
                3\tGet
                4\tRemove
                5\tGet all keys
                6\tGet all values
                7\tGet complete data
                9\tView Commands
                0\tQuit
                """);
        int input=9,key_i,value;
        while(input!=0){
            input=sc.nextInt();
            switch(input){
                case(1):
                    System.out.print("\tEnter Value to add or update\t");
                    hash.put(key+size++, sc.nextInt());
                    break;
                case(2):
                    System.out.println("\tEnter Key index to check\t");
                    key_i=sc.nextInt();
                    System.out.println(hash.containsKey(key+key_i));
                    break;
                case(3):
                    System.out.println("\tEnter Key index to get\t");
                    key_i=sc.nextInt();
                    System.out.println(hash.get(key+key_i));
                    break;
                case(4):
                    System.out.println("\tEnter Key index to remove\t");
                    key_i=sc.nextInt();
                    System.out.println(hash.remove(key+key_i));
                    break;
                case(5):
                System.out.println("/tNot ready yet\t");
                    // for(String s:hash.getKeys()){
                    //     System.out.print(s);
                    //     System.out.print('\t');
                    // }
                    break;
                case(6):
                System.out.println("/tNot ready yet\t");
                    // for(String s:hash.getValues()){
                    //     System.out.print(s);
                    //     System.out.print('\t');
                    // }
                    break;
                case(7):
                    System.out.println("/tNot ready yet\t");
                    break;
                case(9):
                    System.out.println("""
                        KEYS\tOPERATIONS
                        1\tAdd or Update Element
                        2\tCheck Key existance
                        3\tGet
                        4\tRemove
                        5\tGet all keys
                        6\tGet all values
                        7\tGet complete data
                        9\tView Commands
                        0\tQuit
                        """);
                    break;
                default:
                    System.out.println("Invalid input\t");
                    break;
            }
        }
        sc.close();
    }
}
