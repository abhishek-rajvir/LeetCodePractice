public static String hackerrankInString(String s) {
// Write your code here
    int[] arr = { 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };
    
    int target = 0;
    
    for(int i = 0; i<s.length(); i++){
        if(target==8){
            return "YES";
        }
        if(s.charAt(i)==arr[target]){
            target++;
        }
    }
    return "NO";
}
