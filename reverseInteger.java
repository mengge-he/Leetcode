public class reverseInteger {
    public static int reverse(int x){
        int result=0;

        while(x!=0){

            //get the last digit
            int digit=x%10;

            //remove the last digit of x
            x=x/10;

            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > 7)
            {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && digit < -8)
            {
                return 0;
            }

            result=result*10+digit;


        }


        return result;

    }

    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }
}
