class Solution {
    public String addBinary(String a, String b) {
        // flag for carry
        boolean flag = false;

        // if str are 1,1 or 0,0 or 0,1
        if(a.length() == 1 && b.length() == 1){
            int sum = a.charAt(0)-'0' + b.charAt(0)-'0' ;
            if(sum==2){
                return "10";
            }
            else{
                return String.valueOf(sum);
            }
        }

        // replace a with longest number/string
        if(a.length()<b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        // mutable string from longest string
        StringBuilder sb = new StringBuilder(a);

        // get cursor for str 1
        int i = a.length()-1;

        // a and b
        for(int j = b.length()-1;j>=0;i--,j--){
            int carry = flag ? 1 : 0;
            int sum = a.charAt(i)-'0' + b.charAt(j)-'0' + carry;
            flag = Solution.checkSum(sum,i,sb);
        }

        // add carry to a after addition with b [ a > b]
        for(;i>=0;i--){
            if(flag){
                int sum = sb.charAt(i)-'0' + 1;
                flag = Solution.checkSum(sum,i,sb);
            }
            else{
                return sb.toString();
            }
        }
        // if a = b then insert 1 at beggining because the number has 1 & 1 at start
        sb.insert(0,'1');
        return sb.toString();
    }

    // helper method for sum condition and seting the addition
    public static boolean checkSum(int sum,int i,StringBuilder sb){
        if(sum==3){
            sb.setCharAt(i,'1');
        }
        else if(sum==2){
            sb.setCharAt(i,'0');
        }
        else{
            // sum is converted to int then added to 0 [same but we get ascii] then casted to char
            sb.setCharAt(i,(char)(sum+'0'));
            return false;
        }
        return true;
    }
}
