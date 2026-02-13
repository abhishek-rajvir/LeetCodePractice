Runtime- 0ms
Beats- 100.00%

Memory- 43.15MB
Beats- 69.23%


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // arraylist instance
        List<Integer> al = new ArrayList<>();

        // invoke recursive method
        printRecursive(root,al);

        // return the arraylist with values
        return al;
    }

    public void printRecursive(TreeNode node,List<Integer> al){
        // edge case
        if(node==null) return;

        // print left
        printRecursive(node.left,al);

        // print current node
        al.add(node.val);

        // print right 
        printRecursive(node.right,al);

    }
}
