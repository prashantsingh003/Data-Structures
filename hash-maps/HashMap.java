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
            System.out.println("Insert: "+key);
            this.size++;
        }
        else{
            this.buckets[bucket_i].get(list_i).value= value;
            System.out.println("Update: "+key);
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

    public V get(K key) throws Exception{
        int bucket_i= getBucketIndex(key);
        int list_i=getListIndex(key, bucket_i);
        return list_i!=-1 ? this.buckets[bucket_i].get(list_i).value : null;
    }

    public V remove(K key) throws Exception{
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

    private void rehash(){}

    public static void main(String[] args) {
        HashMap h=new HashMap<>();
        for(int i=0;i<15;i++){
            h.put("asd"+i, i);
        }
        System.out.println(h.size);
    }
}
