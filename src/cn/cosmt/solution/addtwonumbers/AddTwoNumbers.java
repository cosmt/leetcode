package cn.cosmt.solution.addtwonumbers;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //返回的结果
        ListNode result = null;
        ListNode last = null;
        //进位数
        int carry = 0;
        //循环所有节点
        while (l1 != null || l2 != null) {
            int l1v = l1 != null ? l1.val : 0;
            int l2v = l2 != null ? l2.val : 0;
            int sum = l1v + l2v + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (result == null) {
                result = node;
            } else {
                last.next = node;
            }
            last = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        //循环完成如果进位数不为0，则需要再补一位。
        if (carry > 0) {
            last.next = new ListNode(1);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
