public class _25_reverse_k_nodes {
        public ListNode reverseKGroup(ListNode head, int k) {

            if (head == null || head.next== null || k <=1) return head;
            ListNode prev=null;
            ListNode curr=head;


            while(true){
                ListNode temp=curr;
                int count=0;
                while(temp!=null && count < k){
                    temp=temp.next;
                    count++;
                }
                if(count<k) break;

                ListNode end = curr;
                ListNode last = prev;
                ListNode next=curr.next;

                for (int i = 0; curr != null && i<k; i++){
                    curr.next=prev;
                    prev=curr;
                    curr= next;
                    if (next != null) next= next.next;
                }

                end.next=curr;
                if(last != null){
                    last.next= prev;
                }else{
                    head= prev;
                }

                prev = end;

            }

            return head;
        }

}
