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

// Solution 2  O(n) using queue
Runtime-9ms
Beats- 61.29%

Memory- 49.10MB
Beats- 89.29%


class Solution {
    public int maxLevelSum(TreeNode root) {

        TreeNode temp = root;

        // a linked queue to store the nodes at each level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int bestLevel = 1;
        // least default value;
        int maxSum = Integer.MIN_VALUE;

        // iterate if q exists
        while (!q.isEmpty()) {

            // for sum per level
            int levelSum = 0;   
            // size of queue at current level
            int size = q.size();

            // iterate till all nodes from current level are computed from queue
            while (size > 0) {

                // root node for current level
                TreeNode n = q.poll();

                // append node val
                levelSum += n.val;

                // add child nodes for next level
                if (n.left != null)
                    q.add(n.left);
                if (n.right != null)
                    q.add(n.right);
                size--;
            }

            // compute current max level
            if (maxSum < levelSum) {
                maxSum = levelSum;
                bestLevel = level;
            }
            level++;
        }


        // return maxLevel
        return bestLevel;
    }
}
