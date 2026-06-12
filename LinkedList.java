public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //newNode= head
        newNode.next=head;
        //head=newNode
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node temp=head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
            
        }
        System.out.println();
}
     public void add(int idx, int data){
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        
     }
     public int removeFirst(){
        if(size==0){
            System.out.println("LinkedList is empty");
            size=0;
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;

     }
     public int removeLast(){
        if(size==0){
            System.out.println("LinkedList is emplty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
     }
     public int itrSearch(int key){
        Node temp=head;
        int i=0;
        while (temp != null) {
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;      
        }
        return -1;
     }
     public int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next, key);
        if(idx==-1){
            return -1;
        }
       return idx+1;
     }
     public int recSearch(int key){
        return helper(head, key);
     }
     public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head=prev;

     }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        ll.reverse();
        ll.print();


    }
}
