class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        char carry = '0';
        while(i>=0 || j>=0){
            char val1 = '0', val2 = '0';
            if(i>=0) val1 = a.charAt(i);
            if(j>=0) val2 = b.charAt(j);
            if(val1=='1' && val2=='1'){
                if(carry=='0'){
                    sb.append('0');
                    carry='1';
                }
                else {
                    sb.append('1');
                    carry='1';
                }
            }
            else if((val1=='1' && val2=='0') || (val1=='0' && val2=='1')){
                if(carry=='0'){
                    sb.append('1');
                }
                else{
                    sb.append('0');
                    carry = '1';
                } 
            }
            else if(val1=='0' && val2=='0'){
                if(carry=='0'){
                    sb.append('0');
                }
                else{
                    sb.append('1');
                    carry = '0';
                } 
            }
            i--;j--;
        }
        if(carry=='1') sb.append('1');
        return sb.reverse().toString(); 
    }
}