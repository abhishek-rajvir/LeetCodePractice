class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        // iterate over the array
        for(char i : letters){
            // i & target will be converted to 'int' values and if difference is > 0
            // then 'i' is lexicographically greater than target 
            if(i-target>0){
                // return the letter
                return i ;
            }
        }
        // if no letter greater than target return index 0
        return letters[0];
    }
}
