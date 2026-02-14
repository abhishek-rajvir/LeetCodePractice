public static int alternatingCharacters(String s) {
    // Write your code here
        Deque<Character> st = new ArrayDeque<>();
        int count = 0;
        for(char c :s.toCharArray()){
            Character c2 = st.peek();
            if(c2==null || c2!=c){
                st.push(c);
            }
            else{
                count++;
            }
        }
        return count;
    }