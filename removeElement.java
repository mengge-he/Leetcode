/*
* Given an array and a value val, remove all the element in array that equal val,
* don't need extra array space, return the length of the new array
* Extra space is O(1)
* */
import java.util.Arrays;


public class removeElement {
    //will return the length of the new array
    public static int removeElement(int[] array, int val){
        int left=0;
        int right=array.length-1;
        int temp;

        while(left<=right){
            while(left<right&&array[left]!=val){
                left++;
            }
            while(left<right&&array[right]==val){
                right--;
            }
            temp=array[left];
            array[left]=array[right];
            array[right]=temp;

            left++;
            right--;
        }

        if(array[left]==val){
            return left;
        }
        else{
            return left+1;
        }

    }
    public static void main(String[] args) {

        int[] nums = {3, 2, 2, 3, 4, 3};
        System.out.println("length is "+removeElement(nums,2));
        System.out.println(Arrays.toString(nums));
    }
}
