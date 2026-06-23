import java.util.*;
public class StackB {

    public static String reverseStrring(String str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        return result.toString();

    }
    public static void main(String[] args) {
        String str="abc";
        String reverse=reverseStrring(str);
        System.out.println(reverse);
        
    }
}