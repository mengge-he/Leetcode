public class palindromeNumber {
    public boolean isPalindrome(int x){
        int length =String.valueOf(x).length();
        String str=String.valueOf(x);
        int left=0, right=length-1;

        //handle the false part
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }

        while(left<=(length-1)/2){
            if(str.charAt(left)==str.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }

        }

        //finish the comparison
        return true;
    }





}
