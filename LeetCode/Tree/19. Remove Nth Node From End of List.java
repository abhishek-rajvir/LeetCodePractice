// Solution 2 O(n) avg S.C

Runtime- 0ms
Beats- 100.00%

Memory- 43.70MB
Beats- 36.81%

  
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null || head==null){
            return null;
        }
        
        ListNode temp = head;
        List<ListNode> al = new ArrayList<>() ;

        while(temp!=null){
            al.add(temp);
            temp = temp.next;
        }

        if(al.size()-n==0){
            head = head.next;
        }
        else{
            temp = al.get(al.size()-n-1);
            temp.next = temp.next.next;
            temp = null;
            al = null;
        }
        return head;
    }  
}
