public class stringToInteger {
    public static int myAtoi(String s){
        int i=0, n=s.length();

        //skip leading space
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign=1;
        //handle for signs
        if(i<n&&s.charAt(i)=='+'||s.charAt(i) == '-'){
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4. Overflow check before adding
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;


    }



}
