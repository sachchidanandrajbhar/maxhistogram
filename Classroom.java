import java.util.ArrayList;

public class Classroom {
  //Tow pointer apporch
  public static int storedwater(ArrayList<Integer> height){
    int maxWater=0;
    int leftPointer=0;
    int rightPointer=height.size()-1;
    while (leftPointer<rightPointer) {
        int minHeight=Math.min(height.get(rightPointer),height.get(leftPointer));
        int width=rightPointer-leftPointer;
        int currWater=minHeight*width;
        maxWater=Math.max(maxWater, currWater);

        if(leftPointer<rightPointer){
            leftPointer++;
        }
        else{
            rightPointer--;
        }
        
    }
    return maxWater;
  }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1); height.add(8); height.add(6); height.add(2);
         height.add(5);  height.add(4);  height.add(8); height.add(3);
          height.add(7);
          System.out.print(storedwater(height));
    }
}