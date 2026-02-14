Here i have provided 4 solutions for the problem [3 in java and 1 in c++]

// Solution 1.1 [1 pass HashMap best tc and avg sc ]

// Runtime
// 2
// ms
// Beats
// 99.16%
// Analyze Complexity
// Memory
// 47.41
// MB
// Beats
// 8.54%

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // intialising variable
        int i = 0, j = 1;

        // create a map data as index and position as value
        Map<Integer,Integer> hm = new HashMap<>();

        // iterate over array
        for (int k = 0; k < nums.length; k++) {
            // diff between target and curr index [9-2]=7
            int diff = target-nums[k];

            // if diff is in the map break
            if( hm.containsKey(diff) ){
                i = k;
                // get the index of diff value from map
                j = hm.get(diff);
                break;
            }
            // else add the curr to map
            hm.put(nums[k],k);
        }

        // return i and j
        return new int[] { i, j };
    }
}

// Solution 1.2 [HashMap avg tc and avg sc ]

// Runtime
// 10
// ms
// Beats
// 45.99%
// Analyze Complexity
// Memory
// 47.38
// MB
// Beats
// 19.09%

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // intialising variable
        int i = 0, j = 1;

        // create a map data(can be duplicate so value is list) as index and position as value
        Map<Integer,List<Integer>> hm = new HashMap<>();

        // add all to map
        for (int k = 0; k < nums.length; k++) {
            List<Integer> ls = hm.get(nums[k]);
            if(ls == null){
                ls = new ArrayList<>(Arrays.asList(k));
                hm.put(nums[k], ls);
                continue;
            }
            ls.add(k);
        }

        // iterate and find diff in hashset
        for (; i < nums.length; i++) { 
            List<Integer> ls;
            ls = hm.get(target-nums[i]);
            if(ls!=null){
                // if the number is 6[ 3 + 3 is possible] but 
                // the array has [3,2,4] then check if the map has duplicates
                if(nums[i]==target-nums[i] && ls.size()==1){
                    continue;
                }
                // get the last 0 or 1 position
                j = ls.getLast();
                // if found no need to iterate ahead
                break;
            }
        }
        return new int[] { i, j };
    }
}

// solution 2  [bruteforce avg tc and avg sc ]

// Runtime
// 37
// ms
// Beats
// 41.29%
// Analyze Complexity
// Memory
// 47.27
// MB
// Beats
// 35.24%

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0,j=0;
        
        for(;i<nums.length;i++){
            j = findElement(nums,i,target);
            if(j>-1){
                break;
            }
        }
        return new int[] {i,j};
    }

    public int findElement(int[] arr,int start,int target){
        for(int i = start+1;i<arr.length;i++){
            if(arr[i]+arr[start] == target){
                return i;
            }
        }
        return -1;
    }
}

// solution 3 [ C++ best sc worst tc]

// Runtime
// 155
// ms
// Beats
// 5.04%
// Analyze Complexity
// Memory
// 13.99
// MB
// Beats
// 93.64%

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ls1;
        bool done = false;
        for (int j=0;j<nums.size();j++){
            if (done){
                break;
            }
            else {
                for (int i=0;i<nums.size();i++){
                    if (j == i){continue;}
                    else if (nums[j] + nums[i] == target){
                        ls1.push_back(j);
                        ls1.push_back(i);
                        done = true;
                        break;
                    }
                    else{
                        continue;
                    }
                }
            }
        }
        return ls1;
    }
};
