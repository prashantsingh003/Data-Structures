import java.util.Scanner;
public class DoublyLinkedList {
    Node head;
    Node end;
    int size;
    public static class Node{
        Node prev;
        Node next;
        int val;
        
        Node(int v){
            val=v;
        }
        Node(Node p, Node n, int v){
            prev=p;
            next=n;
            val=v;
        }

        public void setNext(Node n){ next=n; }
        public void setPrev(Node p){ prev=p; }
        public void setVal(int v){ val=v; }

        public Node getPrev(){ return prev; }
        public Node getNext(){ return next; }
        public int getval(){ return val; }
    }

    DoublyLinkedList(){}
    DoublyLinkedList(int v){ val=val; }

    public boolean isEmpty(){ return head==null?true:false;}

    public void viewList(){
        Node temp=head;
        for(int i=0;i<size;i++){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
    public int get(int index){
        if(index<0 || index>size){
            System.out.println("not valid index");
            return -1;
        }
        else{
            Node temp=head;
            for( int i=0;i<index;i++)
                temp=temp.next;
            return temp.val;
        }
    }
    public void addAtHead(int val){
        Node newNode=new Node(null,head,val);
        if(head != null){
            head.setPrev(newNode);
        }
        else{
            end=newNode;
        }
        head=newNode;
        size++;
    }
    public void addAtTail(int val){
        if(head == null){ 
            addAtHead(val);
        }
        else{
            Node newNode=new Node(end,null,val);
            end.setNext(newNode);
            end=newNode;
            size++;
        }

    }
    public void addAtIndex(int index, int val){
        if(index==0){
            addAtHead(val);
        }
        else if(index==size){
            addAtTail(val);
        }
        else if(index<0 || index>size){
            System.out.println("not valid index");
        }
        else{
            Node curr=head;
            for( int i=0;i<index-1;i++ )
                curr=curr.next;
            Node newNode=new Node(curr,curr.next,val);
            curr.next.setPrev(newNode);
            curr.setNext(newNode);
            size++;
        }
    }

    public void deleteAtHead(){
        if(isEmpty()){
            System.out.println("List empty");
        }
        else if(size==1){
            head=null;
            end=null;
            size--;
        }
        else{
            head=head.getNext();
            head.setPrev(null);
            size--;
        }
    }
    public void deleteAtLast(){
        if( isEmpty() ){
            System.out.println("List empty");
        }
        else if(size==1){
            deleteAtHead();
        }
        else{
            end=end.getPrev();
            end.setNext(null);
            size--;
        }
    }
    public void deleteAtIndex(int index){
        if( index==0 ){ deleteAtHead();}
        else if( index==size-1 ){deleteAtLast();}
        else if( index<0 || index>size-1 ){
            System.out.println("Index Not valid");
        }
        else{
            Node temp=head;
            for(int i=0;i<index-1;i++)
                temp=temp.getNext();
            temp.setNext(temp.getNext().getNext());
            temp.getNext().setPrev(temp);
            size--;        
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list=new DoublyLinkedList();
        for( int i=0;i<1;i++)
            list.addAtTail(i);
        System.out.println("""
            KEYS\tOPERATIONS
            1\tView List
            2\tInsert
            3\tInsert At Start
            4\tInsert At Position
            5\tDelete At Start
            6\tDelete At Last
            7\tDelete At Position
            9\tView Commands
            0\tQuit
            """);
        Scanner sc=new Scanner(System.in);
        int input=9,val,index;
        while(input!=0){
            input=sc.nextInt();
            switch(input){
                case(1):
                    list.viewList();
                    break;
                case(2):
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.addAtTail(val);
                    break;
                case(3):
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.addAtHead(val);
                    break;
                case(4):
                    System.out.println("Enter position\t");
                    index=sc.nextInt();
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.addAtIndex(index, val);
                    list.viewList();
                    break;
                case(5):
                    list.deleteAtHead();
                    break;
                case(6):
                    list.deleteAtLast();
                    break;
                case(7):
                    System.out.println("Enter position\t");
                    index=sc.nextInt();
                    list.deleteAtIndex(index);
                    break;
                case(9):
                    System.out.println("""
                        KEYS\tOPERATIONS
                        1\tView List
                        2\tInsert
                        3\tInsert At Start
                        4\tInsert At Position
                        5\tDelete At Start
                        6\tDelete At Last
                        7\tDelete At Position
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
