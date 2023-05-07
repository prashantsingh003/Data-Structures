import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public Node(){
        data=0;
        next=null;
    }
    public Node(int d,Node n){
        data=d;
        next=n;
    }

    public Node getNext(){
        return next;
    }
    public int getData() {
        return data;
    }

    public void setData(int d){
        data=d;
    }
    public void setNext(Node n){
        next=n;
    }
}

public class LinkedList{
    private Node start;
    private int size;

    LinkedList(){
        start=null;
        size=0;
    }

    public boolean isEmpty(){
        if(start==null)
            return true;
        else
            return false;
    }

    public int getSize(){
        return size;
    }

    public void viewList(){
        if(start==null){
            System.out.println("The list is empty");
            return;
        }
        Node tempNode=start;
        for(int i=0;i<size;i++){
            System.out.print(tempNode.getData()+" ");
            tempNode=tempNode.getNext();
        }
        System.out.println();
    }

    public void insertAtStart(int val){
        Node newNode= new Node(val,start);
        start=newNode;
        size++;
    }

    public void insertAtLast(int val){
        Node newNode= new Node(val,null);
        if(isEmpty())
            start=newNode;
        else{
            Node tempNode=start;
            while(tempNode.getNext() != null)
                tempNode=tempNode.getNext();
            tempNode.setNext(newNode);
        }
        size++;
    }
    
    public void insert(int val){
        insertAtLast(val);
    }

    public void insertAtPos(int pos,int val){
        if(isEmpty())
            System.out.println("List is Empty");
        else if(pos==0){
            insertAtStart(val);
        }
        else if(pos==size){
            insertAtLast(val);
        }
        else if(pos<size || pos >0){
            Node tempNode=start;
            for(int i=1;i<pos;i++){
                tempNode=tempNode.getNext();
            }

            Node newNode=new Node(val,tempNode.getNext());
            tempNode.setNext(newNode);
            size++;
        }
        else
            System.out.println(val+" can't be inserted at index: "+pos+"\nInvalid Index");
        return;
    }

    public void deleteFirst(){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        else{
            start=start.getNext();
            size--;
        }
        return;
    }
    
    public void deleteLast(){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        else if(size==1){
            start=null;
            size--;
        }
        else{
            Node tempNode=start;
            for(int i=0;i<size-1;i++)
                tempNode=tempNode.getNext();
            tempNode.setNext(null);
            size--;
        }
        return;
    }

    public void deleteAtPos(int pos){
        if(isEmpty()){
            System.out.println("The list is empty");
        }
        else if(pos==0){
            deleteFirst();
        }
        else if(pos==size-1){
            deleteLast();
        }
        else if(pos<0 || pos > size-1){
            System.out.println("Invalid Index: "+pos);
        }
        else{
            Node tempNode=start;
            for(int i=1;i<pos;i++)
                tempNode=tempNode.getNext();
            tempNode.setNext(tempNode.getNext().getNext());
            size--;
        }
        return;
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        for(int i=0;i<10;i++){
            list.insert(i);
        }
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
        int input=9,val,pos;
        while(input!=0){
            input=sc.nextInt();
            switch(input){
                case(1):
                    list.viewList();
                    break;
                case(2):
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.insert(val);
                    break;
                case(3):
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.insertAtStart(val);
                    break;
                case(4):
                    System.out.println("Enter position\t");
                    pos=sc.nextInt();
                    System.out.println("Enter Value\t");
                    val=sc.nextInt();
                    list.insertAtPos(pos, val);
                    list.viewList();
                    break;
                case(5):
                    list.deleteFirst();
                    break;
                case(6):
                    list.deleteLast();
                    break;
                case(7):
                    System.out.println("Enter position\t");
                    pos=sc.nextInt();
                    list.deleteAtPos(pos);
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
