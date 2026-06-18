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
     public void deleteFromEnd(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while (temp != null) {
            temp=temp.next;
            sz++;
            
        }
        if(n==sz){
            head=head.next;
            return;
        }
        //si-n
        int i=1;
        int idx=sz-n;
        Node prev=head;
        while(i<idx){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
     }
     //slow-fast apporch
     public Node findMidNode(Node head){
        Node slow=head;
        Node fast=head;
        while (fast != null && fast.next != null) {
            fast=fast.next.next;
            slow=slow.next;   
        }
        return slow;
     }
     //check palindrome
     public boolean checkPalidrome(){
        //base case
        if(head == null || head.next==null){
            return true;
        }
        //find mid
        Node mid = findMidNode(head);
        //reverse half
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //check data
        Node left=head;
        Node right=prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
     }
     public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast != null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
     }
    // public static void main(String[] args) {
    //     LinkedList ll = new LinkedList();
        
    //     ll.addLast(1);
    //     ll.addLast(5);       
    //     ll.addLast(5);
    //     ll.addLast(1);
    //     ll.print();
    //     System.out.print(ll.checkPalidrome());;
    //}
    public static void removeCycle(){
        //detect cycle
        Node fast=head;
        Node slow=head;
        boolean cycle=false;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(fast==slow){
                cycle= true;
                break;
            }
        }
          if(cycle==false){
             return;
           }
         
        //find meeting point
        slow=head;
        Node prev=null;
        while(fast != slow){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //remove cycle
        prev.next=null;

    }

    //geting mid
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //merge
    private Node merge(Node head1, Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!= null && head2 != null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next; 
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    // mergeSort
    public Node mergeSort(Node head){
        //base case
        if(head==null || head.next==null){
            return head;
        }
        //get mid
        Node mid = getMid(head);
        //merge sort of leftHead and rightHead
        Node rightHead=mid.next;
        mid.next=null;
        Node leftSort=mergeSort(head);
        Node rightSort=mergeSort(rightHead);
        //merge
        return merge(leftSort, rightSort);
    }


    public void zigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        //zig zag arrange
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }
    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addFirst(11);
        ll.addFirst(10);
        ll.addFirst(21);
        ll.addFirst(1);
        ll.addFirst(19);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
