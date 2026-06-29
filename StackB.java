
import java.util.*;
public class StackB {

    public static void main(String[] args) {
        int arr[]={6,8,1,0,3,1};
        Stack<Integer> s=new Stack<>();
        int nextGreater[]=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            //1 while
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            //if else
                if(s.isEmpty()){
                    nextGreater[i]=-1;
                }
                else{
                    nextGreater[i]=arr[s.peek()];
                }
            //push
            s.push(i);
        }
        for(int i=0;i<nextGreater.length;i++){
        System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
        
    }
}