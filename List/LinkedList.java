class LinkedList {
    Node start;
    int size;
    public static class Node{
        private int val;
        private Node next;
        public Node(){
            val=0;
            next=null;
        }
        public Node(int v,Node n){
            val=v;
            next=n;
        }
        public void setNext(Node n){
            next=n;
        }
        public void setVal(int v){
            val=v;
        }
        public Node getNext(){
            return next;
        }
        public int getVal(){
            return val;
        }
    }

    public LinkedList() {
        start =null;
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }
        else{
            Node tempNode=start;
            for(int i=0;i<index;i++)
                tempNode=tempNode.getNext();
            return tempNode.getVal();
        }
    }
    
    public void addAtHead(int val) {
        Node newNode=new Node(val,start);
        start=newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        Node tempNode=start;
        Node newNode=new Node(val,null);
        if(size==0){
            start=newNode;
        }
        else{
            while(tempNode.getNext()!=null)
                tempNode=tempNode.getNext();
            tempNode.setNext(newNode);
        }
            size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0){
            addAtHead(val);
        }
        else if(index==size){
            addAtTail(val);
        }
        else if(index>size || index<0){
            return;
        }
        else{
            Node tempNode=start;
            for(int i=0;i<index-1;i++)
                tempNode=tempNode.getNext();
            Node newNode=new Node(val,tempNode.getNext());
            tempNode.setNext(newNode);
            size++;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        if(index==0){
            start=start.getNext();
            size--;
        }
        else if(index>=size || index<0){
            int k=1;
        }
        else{
            Node t=start;
            for(int i=0;i<index-1;i++)
                t=t.getNext();
            Node t2=t.getNext();
            t.setNext(t2.getNext());
            size--;
        }
    }
}