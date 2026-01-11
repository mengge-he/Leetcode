public class zigzagConversion {
    public static String convert(String s,int numRows){
        if (numRows == 1 || numRows >= s.length()) return s;

        //storage for each row
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }


        int r=0;
        int dir=1;//dir=1, going down; dir=-1, going up

        for(char c:s.toCharArray()){
            rows[r].append(c);
            if(r==0){
                dir=1;
            }
            else if(r==numRows-1){
                dir=-1;
            }

            r=r+dir;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();

    }

    public static void main(String[] args) {
        System.out.println(convert("MerryChirsmas",3));
    }
}
