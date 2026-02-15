// Solution 1

public static String pangrams(String s) {

        // to ignore case while matching
        String lower = s.toLowerCase();
    
        long found = IntStream
                        // stream of alphabets
                        .range('a','z'+1)
                        // filter out those letter that are not in string
                        .filter(ch->(lower.indexOf(ch)>-1))
                        // size of found char
                        .count();
        
        // check if alphabets found are all 26
        return found == 26 ? "pangram" : "not pangram";
    }

// Solution 2

    public static String pangrams(String s) {

        // to ignore case while matching
        char[] lower = s.toLowerCase().toCharArray();
        
        Set<Integer> al = IntStream
                        // stream of alphabets
                        .range('a','z'+1)
                        // Wrap primitives
                        .boxed() 
                        .collect(Collectors.toSet());
        
        // iterate the string to find alphabets
        for(int ch : lower){
            // pop if found
            if(al.contains(ch)) al.remove(ch);
            // check if all 26 alphabets are found before or around string iteration ends
            if(al.isEmpty()) return  "pangram";
        }
        // iteration completed and all char not found
        return "not pangram";
    }
