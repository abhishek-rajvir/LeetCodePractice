public static List<String> weightedUniformStrings(String s, List<Integer> queries) {

        // to store the possible weighted substrings
        Set<Integer> combArray = new HashSet<>();
        
        int i = 0;
        while(i<s.length()){
            int j = i;
            // store the current weight
            int currVal = s.charAt(j)-'a' +1;
            while(j<s.length() && s.charAt(i)==s.charAt(j)){
                // multiply weight linearly (1,2,3) till n occurences
                // append the possible weighted substring
                combArray.add(currVal*(j++-i+1));
            }
            // jump to j skip already read elements
            i=j;
        }
        
        // create a new arraylist for results
        List<String> resultArr = new ArrayList<>();
        
        // iterate queries
        for(int key : queries){
            // if query in set YES
            if(combArray.contains(key)){
                resultArr.add("Yes");
            }
            else resultArr.add("No");
        }
        
        return resultArr;
    }
