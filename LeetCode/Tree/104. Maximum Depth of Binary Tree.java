// Solution using DFS

Runtime- 0ms
Beats- 100.00%

Memory- 44.59MB
Beats- 45.51%

class Solution {
    public int maxDepth(TreeNode root) {
        // invoke method
        return recursiveDFS(root,1);
    }

    public int recursiveDFS(TreeNode node,int level){
        // if head is null or current node is null
        // return 0
        if(node == null) return 0;
            int l = 0;
            int r = 0;

        // get max depth on left subtree
        if(node.left!=null){
            l = recursiveDFS(node.left,level+1);
        }
        // get max depth on right subtree
        if(node.right!=null){
            r = recursiveDFS(node.right,level+1);
        }
        
        // return the max depth
        return Math.max(l,Math.max(r,level));
    }
}
