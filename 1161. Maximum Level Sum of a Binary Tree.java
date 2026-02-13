// Solution 1 O(n+m)
// Approach - using recursion and BFS preOrder

// Avg T.c
Runtime- 9ms
Beats- 61.29%

// Best S.C
Memory- 49.00MB
Beats- 89.29%


class Solution {
    public int maxLevelSum(TreeNode root) {
        TreeNode temp = root;

        List<Integer> al = new ArrayList<>();

        // O(M) // number of nodes
        recursiveSum(root,0,al);

        // O(N) // iterate whole to find max
        // create stream of numbers from 0 to size of AL
        int result = IntStream.range(0,al.size())
            // box from primitive to wrapper
            .boxed()
            // find the max index from arrayList
            .max( (i,j) -> 
                Integer.compare( al.get(i),al.get(j) ) 
            )
            .get();
        // since indexing is from zero return result+1
        return ++result;
    }

    // recursive method to find level wise sum
    public void recursiveSum(TreeNode node, int level, List<Integer> al) {
        // if current node is null skip operations
        if (node == null) {
            return;
        }

        // check index by current level
        if (al.size() < level + 1) {
            // add cur val directly
            al.add(node.val);
        } else {
            // increment existing sum of same level
            al.set(level, 
                al.get(level) + node.val);
        }

        // invoke recursion for left
        recursiveSum(node.left, level + 1, al);
        // invoke recursion for right
        recursiveSum(node.right, level + 1, al);
    }
}
