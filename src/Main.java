import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        //Leetcode 1389 -- Solved
        // Runtime : 58.40% of Java online submissions for Create Target Array in the Given Order.
        // Memory Usage: 100.00%  of Java online submissions for Create Target Array in the Given Order
        Solution1389 solution1389 = new Solution1389();
        int[] nums = new int[]{4,2,4,3,2};
        int[] index =  new int[]{0,0,1,3,1};
        int[] result1389 = solution1389.createTargetArray(nums,index);
        System.out.print(Arrays.toString(result1389));



    }
}

class Solution2{

    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
     */
    public static void main(String[] args) {


        //List 1
        ListNode listNode = new ListNode(9);
        ListNode listNode2 = new ListNode(8);
        //ListNode listNode3= new ListNode(3);

        //Link Nodes
        listNode.next= listNode2;
        //listNode2.next = listNode3;

        //List 2
        ListNode listNode4 = new ListNode(1);
        //ListNode listNode5 = new ListNode(6);
        //ListNode listNode6 = new ListNode(4);

        //Link Nodes
        //listNode4.next = listNode5;
        //listNode5.next = listNode6;

        //Results
        ListNode result = addTwoNumbers(listNode,listNode4);
        result.printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer=null;
        ListNode tmp=null;
        if (l1==null) return l2;
        if (l2==null) return l1;
        while(l1!=null||l2!=null)
        {
            if (l1!=null&&l2!=null)
            {
                if (answer==null) // Initialization
                {
                    tmp = new ListNode(l1.val+l2.val);
                    if (tmp.val>9)
                    {
                        tmp.val  = l1.val+l2.val-10;
                        tmp.next = new ListNode(1);
                        answer = tmp;
                    }
                    else
                    {
                        answer = tmp;
                    }
                    l1= l1.next;
                    l2= l2.next;

                }
                else
                {
                    if (tmp.next==null) // If on the previous iteration the result was not greater than 9
                    {
                        tmp.next = new ListNode(l1.val+l2.val);
                        tmp = tmp.next;
                        if (tmp.val>9)
                        {
                            tmp.val  -=10;
                            tmp.next = new ListNode(1);
                        }
                    }
                    else
                    {
                        tmp = tmp.next;
                        tmp.val+= l2.val+l1.val;
                        if (tmp.val>9)
                        {
                            tmp.val  -=10;
                            tmp.next = new ListNode(1);
                        }
                    }
                    l1= l1.next;
                    l2= l2.next;
                }
            }
            else if (l1!=null)
            {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            }
            else if (l2!=null)
            {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            }
        }
        return answer;
    }
}

class Solution4{
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double d = findMedianSortedArrays(nums1,nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return 1.0;
    }
} //Not Started


class Solution21{

    /*

    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    Example:
    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
      */

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    Memory Usage: 38.8 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
     */

    public static void main(String[] args) {

        //List 1
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(4);

        //Link Nodes
        listNode.next= listNode2;
        listNode2.next = listNode3;

        //List 2
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        //Link Nodes
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        //Results
        ListNode result = mergeTwoLists(listNode,listNode4);
        result.printList(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode answer=null;
            ListNode tmp=null;
            if (l1==null) return l2;
            if (l2==null) return l1;
            while(l1!=null||l2!=null)
            {
                if (l1!=null&&l2!=null)
                {
                    if (l1.val>l2.val)
                    {
                        if (answer==null)
                        {
                            answer = new ListNode(l2.val);
                            tmp = answer;
                            l2 = l2.next;
                        }
                        else
                        {
                            answer.next = new ListNode(l2.val);
                            answer.next.next = null;
                            answer = answer.next;
                            l2=l2.next;

                        }
                    }
                    else if (l2.val>l1.val)
                    {
                        if (answer==null)
                        {
                            answer = new ListNode(l1.val);
                            tmp = answer;
                            l1 = l1.next;
                        }
                        else
                        {
                            answer.next = new ListNode(l1.val);
                            answer.next.next = null;
                            answer = answer.next;
                            l1 = l1.next;

                        }
                    }
                    else
                    {
                        if (answer==null)
                        {
                            answer = new ListNode(l2.val);
                            tmp = answer;
                            answer.next = new ListNode(l1.val);
                            answer.next.next = null;
                            answer = answer.next;

                            l2 = l2.next;
                            l1 = l1.next;
                        }
                        else
                        {
                            answer.next = new ListNode(l2.val);
                            answer = answer.next;
                            answer.next = new ListNode(l1.val);
                            answer.next.next = null;
                            answer = answer.next;

                            l2 = l2.next;
                            l1 = l1.next;
                        }
                    }
                }
                else if (l1!=null)
                {
                    answer.next = new ListNode(l1.val);
                    answer = answer.next;
                    l1 = l1.next;
                }
                else if (l2!=null)
                {
                    answer.next = new ListNode(l2.val);
                    answer = answer.next;
                    l2 = l2.next;
                }
            }
            return tmp;
    }
} //Solved

class Solution26{

    public static void main(String[] args) {
        int[] nums  = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2  = {1,1,2};
        int[] nums3  = {1,1};
        int[] nums4  = {1,2};
        int[] nums5  = {1,1,2,2};
        int[] nums6 = {1,1,1};
        int result = removeDuplicates(nums);
        System.out.println(result);
        System.out.println();
        int result2 = removeDuplicates(nums2);
        System.out.println(result2);
        System.out.println();
        int result3 = removeDuplicates(nums3);
        System.out.println(result3);
        System.out.println();
        int result4 = removeDuplicates(nums4);
        System.out.println(result4);
        System.out.println();
        int result5 = removeDuplicates(nums5);
        System.out.println(result5);
        System.out.println();
        int result6 = removeDuplicates(nums6);
        System.out.println(result6);

    }

    public static int removeDuplicates(int[] nums) {

//        if (nums.length==1) return 1;
//        int result=0;
//        for (int i =1 ; i < nums.length;)
//        {
//            if(nums[i]==nums[i-1]&&(nums.length-i>1)) // if element equal to previous element
//            {
//                int j =i;
//                while(j<nums.length-1) //Move the element to the end of the array
//                {
//                    int tmp = nums[j+1];
//                        nums[j+1] = nums[j];
//                        nums[j] = tmp;
//                        j++;
//                }
//
//            }
//            else if (nums[i]<nums[i-1])
//            {
//                result++;
//                break;
//            }
//            else if (nums.length-i>=1)
//            {
//                result++;
//                i++;
//                if (i==nums.length&&nums[i-1]!=nums[i-2]) result++;
//            }
//            else
//            {
//                return result+1;
//            }
//        }
//        System.out.println(java.util.Arrays.toString(nums));
//
//        return  result;

        int i = 1, j = 1;
        for (; i < nums.length; i++)
            if (nums[i] != nums[i-1])
                nums[j++] = nums[i];
        System.out.println(java.util.Arrays.toString(nums));
        return j;
    }
}

class Solution37{

    public static void main(String[] args) {
        char[][] sudoku = new char[9][9];
        sudoku[0][0] = '5';sudoku[0][1] = '3';sudoku[0][2] = '.';sudoku[0][3] = '.';sudoku[0][4] = '7';sudoku[0][5] = '.';sudoku[0][6] = '.';sudoku[0][7] = '.';sudoku[0][8] = '.';
        sudoku[1][0] = '6';sudoku[1][1] = '.';sudoku[1][2] = '.';sudoku[1][3] = '1';sudoku[1][4] = '9';sudoku[1][5] = '5';sudoku[1][6] = '.';sudoku[1][7] = '.';sudoku[1][8] = '.';
        sudoku[2][0] = '.';sudoku[2][1] = '9';sudoku[2][2] = '8';sudoku[2][3] = '.';sudoku[2][4] = '.';sudoku[2][5] = '.';sudoku[2][6] = '.';sudoku[2][7] = '6';sudoku[2][8] = '.';
        sudoku[3][0] = '8';sudoku[3][1] = '.';sudoku[3][2] = '.';sudoku[3][3] = '.';sudoku[3][4] = '6';sudoku[3][5] = '.';sudoku[3][6] = '.';sudoku[3][7] = '.';sudoku[3][8] = '3';
        sudoku[4][0] = '4';sudoku[4][1] = '.';sudoku[4][2] = '.';sudoku[4][3] = '8';sudoku[4][4] = '.';sudoku[4][5] = '3';sudoku[4][6] = '.';sudoku[4][7] = '.';sudoku[4][8] = '1';
        sudoku[5][0] = '7';sudoku[5][1] = '.';sudoku[5][2] = '.';sudoku[5][3] = '.';sudoku[5][4] = '2';sudoku[5][5] = '.';sudoku[5][6] = '.';sudoku[5][7] = '.';sudoku[5][8] = '6';
        sudoku[6][0] = '.';sudoku[6][1] = '6';sudoku[6][2] = '.';sudoku[6][3] = '.';sudoku[6][4] = '.';sudoku[6][5] = '.';sudoku[6][6] = '2';sudoku[6][7] = '8';sudoku[6][8] = '.';
        sudoku[7][0] = '.';sudoku[7][1] = '.';sudoku[7][2] = '.';sudoku[7][3] = '4';sudoku[7][4] = '1';sudoku[7][5] = '9';sudoku[7][6] = '.';sudoku[7][7] = '.';sudoku[7][8] = '5';
        sudoku[8][0] = '.';sudoku[8][1] = '.';sudoku[8][2] = '.';sudoku[8][3] = '.';sudoku[8][4] = '8';sudoku[8][5] = '.';sudoku[8][6] = '.';sudoku[8][7] = '7';sudoku[8][8] = '9';

        solveSudoku(sudoku);
    }

    public static void solveSudoku(char[][] board) {

        for (int i = 0; i< board.length ; i++)
        {
            for (int j = 0 ; j < board[i].length ; j++)
            {
                System.out.print("   " + board[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i< board.length ; i++)
        {
            for (int j = 0 ; j < board[i].length ; j++)
            {

            }

        }
    }
    public static boolean isSolved(char[][] board)
    {
        return false;
    }

}

class Solution83{

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
    Memory Usage: 39.7 MB, less than 7.14% of Java online submissions for Remove Duplicates from Sorted List.
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2= new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(3);
        head.next= head2;
        head2.next =head3;
        head3.next = head4;
        head4.next = head5;
        System.out.println("Current List");
        head.printList(head);
        ListNode result = deleteDuplicates(head);

        System.out.println("List After Changes");
        result.printList(result);
    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode listNode =  head;
        if (head==null) return head;
        while(head.next!=null)
        {
            if (head.val == head.next.val)
            {

                ListNode next = head.next;
                head.next = next.next;
            }
            else
            {
                if (head.next!=null)
                    head = head.next;
            }

        }
        return listNode;
    }



} //Solved

class Solution88{

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = 3;
        int n = 3;
        merge(nums1,m,nums2,n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {


            for (int i = 0 ,j=0;i<m+n;)
            {

                if (nums1[i]>=nums2[j])
                {
                    int k = nums1.length-1;
                    while(k>i)
                    {
                        int tmp = nums1[k-1];
                        nums1[k-1] = nums1[k];
                        nums1[k] = tmp;
                        k--;
                    }
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                    if (j>=n) break;
                }
                else if (nums1[i]<nums2[j])
                {
                    if (i-j>=n)
                    {
                        nums1[i] = nums2[j];
                        i++;
                        j++;
                    }
                    else
                    {
                        i++;
                    }
                }


            }


        System.out.println(java.util.Arrays.toString(nums1));
    }
} //HARD - Not Solved

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public void printList(ListNode head)
    {
        while(head!=null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
} // Part Of Solution83
class Solution118 //Solved
{
    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
    Memory Usage: 37.3 MB, less than 6.02% of Java online submissions for Pascal's Triangle.
     */
    public static void main(String[] args) {
        int num = 5;
        List<List<Integer>> lists = generate(num);
        System.out.println(lists);

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows==0) return lists;
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        lists.add(newList);
        int sum;
        for (int i=1;i<numRows;i++)
        {
              List<Integer> previousList = lists.get(lists.size()-1);
              List<Integer> currentList = new ArrayList<>();
              currentList.add(1);
              for (int j=1;j<i;j++)
              {
                  currentList.add(previousList.get(j-1)+previousList.get(j));
              }
              currentList.add(1);
              lists.add(currentList);
        }
        return  lists;
    }
}

class Solution203{

    public static void main(String[] args) {

        //Create Nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(6);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
//        ListNode node7 = new ListNode(6);

        //Link Nodes
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        ListNode result = removeElements(node1,1);
        result.printList(result);

    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode tmp = head;
        ListNode prev  = head;
        if (head==null) return null;
        if (head.next==null&&head.val == val) return null;

        while(head.next!=null)
        {
            prev = head;
            head = head.next;
            if (head.val == val)
            {
                ListNode temp = head.next;
                prev.next = temp;
            }
        }
        if (prev.val == val) prev = null;
        return tmp;
    }

    //Working but not in all cases -Rewriting the function above


//    public static ListNode removeElements(ListNode head, int val) {
//
//        ListNode tmp = head;
//        ListNode prev  = null;
//        if (head==null) return null;
//        if (head.next==null&&head.val == val) return null;
//
//        while(head!=null)
//        {
//            if (head.val == val)
//            {
//                if (head.next==null)
//                {
//                    prev.next= null;
//                    break;
//                }
//                else
//                {
//                    ListNode next = head.next;
//                    head.val = head.next.val;
//                    head.next = next.next;
//
//                }
//
//            }
//            prev = head;
//            head = head.next;
//        }
//        return tmp;
//    }
}

class Solution204{


    /*

    Count the number of prime numbers less than a non-negative number, n.

    Example:

    Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */

    public static void main(String[] args) {


        int result = countPrimes(499999);
        System.out.println(result);
    }

    public static int countPrimes(int n) {

        int result = 0;
        int tmp = n;
        int i = 2 ;
        if (n<2) return 0;
        //int counter = 0;
//        for (int iterator = n-1,j=iterator/2;iterator>1;)
//        {
//            if (iterator%j==0)
//            {
//                //counter++;
//                if (iterator==2||iterator==3)result++;
//                iterator--;
//                j= iterator/2;
//                //counter = 0;
//            } else j--;
//
//
//
//            if (j==1)
//            {
//                result++;
//                iterator--;
//                j = iterator/2;
//            }
//        }


        //TOO SLOW

//        int counter= 0;
//        for (int iterator = n-1,j=1;iterator>1;)
//        {
//            if (iterator%2==0&&iterator!=2)
//            {
//                iterator--;
//                j=1;
//            }
//            else if (iterator ==2 || iterator==3)
//            {
//                result++;
//                iterator--;
//                j=1;
//            }
//            else if (iterator%j==0)
//            {
//                counter++;
//                if (counter==2)
//                {
//                    iterator--;
//                    j=1;
//                    counter=0;
//                }
//                else
//                {
//                    j++;
//                }
//            }
//            else if (j==iterator/2)
//            {
//                result++;
//                counter=0;
//                iterator--;
//                j=1;
//            }
//            else
//            {
//                j++;
//            }
//        }

        int count =0;
        //  if(n==2)return 0;
        for(int k=2;k<n;k++){
            if(isPrime(k))count++;
        }
        return count ;



    }

    public static boolean isPrime(int n){

        if(n<=1)return false;
        for (int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}

class Solution206{

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    Memory Usage: 39.3 MB, less than 5.04% of Java online submissions for Reverse Linked List.

     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        //ListNode listNode6 = new ListNode(6);
        listNode.next= listNode2;
        listNode2.next = listNode3;
        listNode3.next =listNode4;
        listNode4.next = listNode5;
        //listNode5.next = listNode6;
        ListNode result = reverseList(listNode);
        result.printList(result);
    }

    public static ListNode reverseList(ListNode head) {

        ListNode reversedList = null;

        while(head!=null)
        {
            if (reversedList==null)
            {
                reversedList = new ListNode(head.val);
                reversedList.next=null;
                head = head.next;
            }
            else
            {
                ListNode newHead = new ListNode(head.val); // Create a new node that will be the new head
                newHead.next = reversedList;
                reversedList = newHead;
                head= head.next;
            }
        }

        return  reversedList;
    }
} //Solved


class Solution234{
/*
    Given a singly linked list, determine if it is a palindrome.
    Example 1:
    Input: 1->2
    Output: false

    Example 2:
    Input: 1->2->2->1
    Output: true
    Follow up:
    Could you do it in O(n) time and O(1) space?
 */

/*
    26 / 26 test cases passed.
    Status: Accepted
    Runtime: 4 ms
    Memory Usage: 43.1 MB
 */

    public static void main(String[] args) {

        //Create Nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);

        //Link Nodes
        node1.next = node2;
        node2.next = node3;

        boolean result = isPalindrome(node1);
        System.out.println(result);

    }

    public static boolean isPalindrome(ListNode head) {

        if (head==null) return true;
        List<Integer> nodes = new ArrayList<>();
        while(head!=null)
        {
            nodes.add(head.val);
            head = head.next;
        }
        if (nodes.size()==1) return true;
        else if (nodes.size()>1&&nodes.size()%2==0)
        {
            Collections.reverse(nodes.subList(nodes.size()/2,nodes.size()));
            if (nodes.subList(0,nodes.size()/2).equals(nodes.subList(nodes.size()/2,nodes.size())))
            {
                return true;
            }
        }
        else if (nodes.size()>1 &&nodes.size()%2!=0)
        {
            Collections.reverse(nodes.subList(nodes.size()/2+1,nodes.size()));
            if (nodes.subList(0,nodes.size()/2).equals(nodes.subList(nodes.size()/2+1,nodes.size())))
            {
                return true;
            }
        }
        return false;
    }
} //Solved

class Solution237{

    /*
    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

    Given linked list -- head = [4,5,1,9], which looks like following:

                4----->5----->1----->9

    Example 1:

    Input: head = [4,5,1,9], node = 5
    Output: [4,1,9]
    Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
    Example 2:

    Input: head = [4,5,1,9], node = 1
    Output: [4,5,9]
    Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

    Note:

    The linked list will have at least two elements.
    All of the nodes' values will be unique.
    The given node will not be the tail and it will always be a valid node of the linked list.
    Do not return anything from your function.

     */
/*
        Success
        Details
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
        Memory Usage: 39.1 MB, less than 5.09% of Java online submissions for Delete Node in a Linked List.
        Next challenges:
 */



    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3= new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        //ListNode listNode5 = new ListNode(5);
        //ListNode listNode6 = new ListNode(6);
        listNode.next= listNode2;
        listNode2.next = listNode3;
        listNode3.next =listNode4;
        //listNode4.next = listNode5;
        //listNode5.next = listNode6;
         deleteNode(listNode);

    }

    public static void deleteNode(ListNode node) {

        ListNode tmp = node.next.next;
        node.val = node.next.val;
        node.next = tmp;
    }
} //Solved

class Solution507{

    public static void main(String[] args) {
        /*
        We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

        Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
        Example:
        Input: 28
        Output: True
        Explanation: 28 = 1 + 2 + 4 + 7 + 14
        Note: The input number n will not exceed 100,000,000. (1e8)

         */

        /*

        Success
        Details
        Runtime: 1511 ms, faster than 27.70% of Java online submissions for Perfect Number.
        Memory Usage: 36.3 MB, less than 5.88% of Java online submissions for Perfect Number.
         */
        int num =28;
        boolean result = checkPerfectNumber(num);
        System.out.println(result);
    }


    public static boolean checkPerfectNumber(int num) {

        int sum=0;
        if (num<1) return false;
        for (int i = num/2 ; i>0 ;i--)
        {
            if (num%i==0)
            {
                sum+=i;
            }
        }
        if (sum==num) return true;
        return false;
    }
}

class Solution728{

    /*
    Success
    Details
    Runtime: 2 ms, faster than 80.58% of Java online submissions for Self Dividing Numbers.
    Memory Usage: 36.7 MB, less than 6.67% of Java online submissions for Self Dividing Numbers.
     */

    /*
    A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

    Also, a self-dividing number is not allowed to contain the digit zero.

    Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

    Example 1:
    Input:
    left = 1, right = 22
    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    Note:

    The boundaries of each input argument are 1 <= left <= right <= 10000.

     */
    public static void main(String[] args) {
        int left =66;
        int right =708;
        List<Integer> result = selfDividingNumbers(left,right);
        System.out.println(result);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i=left;i<=right;)
        {
            if (i<10)
            {
                result.add(i);
                i++;
            }
            else if (i%10==0)
            {
                i++;
            }
            else
            {
                List<Integer> digits = new ArrayList<>();
                if (selfDividing(i))
                {
                    result.add(i);
                }
                i++;
            }
        }
        return result;
    }
    public static boolean selfDividing(int num)
    {
        int tmp = num;
        int originalNum = num;
        while(tmp>0)
        {
            tmp = tmp%10;

            if (tmp==0) return false;

            if (originalNum%tmp!=0)
            {
                return false;
            }
            num = num / 10;
            tmp =num;
        }
        return true;
    }
} //Solved

class Solution771 {
    /*
    You're given strings J representing the types of stones that are jewels,
    and S representing the stones you have.
    Each character in S is a type of stone you have.
    You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct,
    and all characters in J and S are letters.
    Letters are case sensitive, so "a" is considered a different type of stone from "A".

    Example 1:

    Input: J = "aA", S = "aAAbbbb"
    Output: 3
    */

    /* SOLVED
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Jewels and Stones.
    Memory Usage: 38 MB, less than 5.05% of Java online submissions for Jewels and Stones.
    */
    public static void main(String[] args) {

        String J = "aA";
        String S = "aAAbbbb";
        int result = numJewelsInStones(J,S);
        System.out.println(result);

    }
    public static int numJewelsInStones(String J, String S)
    {
        int result = 0; //the returned value
        for (int j=0,s=0;j<J.length();)
        {

            if (J.charAt(j)==S.charAt(s))
            {
                result++;
            }
            s++;
            if (s==S.length())
            {
                s=0;
                j++;
            }
        }
        return result;
    }
} //Solved

class Solution804{


    /*
    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

    For convenience, the full table for the 26 letters of the English alphabet is given below:

    [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

    Return the number of different transformations among all words we have.

    Example:
    Input: words = ["gin", "zen", "gig", "msg"]
    Output: 2
    Explanation:
    The transformation of each word is:
    "gin" -> "--...-."
    "zen" -> "--...-."
    "gig" -> "--...--."
    "msg" -> "--...--."

    There are 2 different transformations, "--...-." and "--...--.".
    Note:

    The length of words will be at most 100.
    Each words[i] will have length in range [1, 12].
    words[i] will only consist of lowercase letters.
     */

    /*
    Success
    Details
    Runtime: 2 ms, faster than 47.72% of Java online submissions for Unique Morse Code Words.
    Memory Usage: 37.4 MB, less than 5.26% of Java online submissions for Unique Morse Code Words.

     */

    public static void main(String[] args) {

        String[] words = {"gin","zen","gig","msg"};
        int result = uniqueMorseRepresentations(words);
        System.out.println(result);

    }

    public static int uniqueMorseRepresentations(String[] words) {
                            //A     B     C      D    E    F      G      H     I     J     K      L
         String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",

                            //M    N     O     P      Q     R     S    T    U     V     W     X       Y      Z
                            "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
         int result = 0;
         List<String> transformations = new ArrayList<>();
         char c;
         int charValue;
         for (int i = 0; i < words.length;i++)
         {
             StringBuilder stringBuilder = new StringBuilder();
             for (int j = 0; j< words[i].length();j++)
             {
                 //Extract the letter
                  c = words[i].charAt(j);
                  charValue = words[i].charAt(j); //Get Decimal Value of a char
                 stringBuilder.append(morse[(97-charValue)*-1]);

             }
             if (!transformations.contains(stringBuilder.toString()))
             {
                 transformations.add(stringBuilder.toString());
                 result++;
             }
         }
         return  result;
    }
} //Solved

class Solution876 {

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 36.5 MB, less than 7.84% of Java online submissions for Middle of the Linked List.
     */
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3= new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode.next= listNode2;
        listNode2.next = listNode3;
        listNode3.next =listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = middleNode(listNode);
        result.printList(result);
    }

    public static ListNode middleNode(ListNode head)
    {
        ListNode result  = head;
        List<ListNode> listNodes = new ArrayList<>();
        while(head!=null)
        {
            listNodes.add(head);
            head = head.next;
        }
        result = listNodes.get(listNodes.size()/2);
        return result;
    }
} //Solved

class Solution942{

    /*
    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

    Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]

    Example 1:

    Input: "IDID"
    Output: [0,4,1,3,2]
    Example 2:

    Input: "III"
    Output: [0,1,2,3]
    Example 3:

    Input: "DDI"
    Output: [3,2,0,1]

    Note:

    1 <= S.length <= 10000
    S only contains characters "I" or "D".
     */

    /*
    Success
    Details
    Runtime: 2 ms, faster than 93.19% of Java online submissions for DI String Match.
    Memory Usage: 41 MB, less than 6.82% of Java online submissions for DI String Match.
     */

    public static void main(String[] args) {
        String s = "III";
        int[] result = diStringMatch(s);
        System.out.println(java.util.Arrays.toString(result));
    }

    public static int[] diStringMatch(String S) {
        int [] result = new int[S.length()+1];
        int minIndex = 0 , maxIndex = S.length();
        for (int i = 0;i<result.length-1;i++)
        {
            if (S.charAt(i)=='I')
            {
                result[i] = minIndex;
                minIndex++;
            }
            else if (S.charAt(i)=='D')
            {
                result[i] = maxIndex;
                maxIndex--;
            }
        }
        if (S.charAt(S.length()-1)=='I')
        {
            result[result.length-1] = maxIndex;
        }
        else if (S.charAt(S.length()-1)=='D')
        {
            result[result.length-1] = minIndex;
        }
        return  result;
    }
} //Solved

class Solution1108{
    /*
    Given a valid (IPv4) IP address, return a defanged version of that IP address.

    A defanged IP address replaces every period "." with "[.]".

    Example 1:

    Input: address = "1.1.1.1"
    Output: "1[.]1[.]1[.]1"
    Example 2:

    Input: address = "255.100.50.0"
    Output: "255[.]100[.]50[.]0"

    Constraints:

    The given address is a valid IPv4 address.

     */

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
    Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    Next challenges:


     */
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String res = defangIPaddr(address);
        System.out.println(res);
    }

    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }


} //Solved
class Solution1221 {

    /*
    Balanced strings are those who have equal quantity of 'L' and 'R' characters.
    Given a balanced string s split it in the maximum amount of balanced strings.
    Return the maximum amount of splitted balanced strings.

    Example 1:
    Input: s = "RLRRLLRLRL"
    Output: 4
    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

     */

    public static void main(String[] args) {

        String s = "RLRRRLLRLL";
        int result = balancedStringSplit(s);
        System.out.println(result);
    }
    public static int balancedStringSplit(String s) {

        int sum = 0;  // The returned result
        int c = 1; // letter counter
        char k = s.charAt(0); // takes the first character of the string
        for(int  i = 1 ;i  < s.length(); i++){
            if (s.charAt(i) == k){ // if equal  , increment letter counter
                c++;
            }
            else{ // decrement letter counter
                c--;
            }
            if (c == 0){ //if letter counter = 0 it means equal number of "L" and "R" in the current string
                sum++;
            }
        }
        return sum;
    }
}

class Solution1252{

    /*
    Success
    Details
    Runtime: 2 ms, faster than 28.71% of Java online submissions for Cells with Odd Values in a Matrix.
    Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Cells with Odd Values in a Matrix.
     */


    /*
    Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci].
     For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
    Return the number of cells with odd values in the matrix after applying the increment to all indices.


Example 1:

Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
Example 2:

Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.

Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m

     */

    public static void main(String[] args) {

        int n = 1;
        int m  =1;
        int[][] indices ={{0,0},{0,0}};
        int result = oddCells(n,m,indices);
        System.out.println(result);
    }

    public static int oddCells(int n, int m, int[][] indices) {

        int result = 0;
        int[][] arr = new int[n][m];

        for (int i = 0; i< indices.length ; i++)
        {
            for (int j =0 ; j< indices[i].length ; j++)
            {
                if (j%2==0) //The Row
                {
                    int[] row = arr[indices[i][j]];
                    for (int temp=0;temp<row.length;temp++)
                    {
                        row[temp]++;
                         if (row[temp]%2!=0) result++;
                        else result--;
                    }
                }
                else //The Column
                {
                    int temp = 0;
                    while(temp<arr.length)
                    {
                        arr[temp][indices[i][j]]++;
                        if (arr[temp][indices[i][j]]%2!=0) result++;
                        else result--;
                        temp++;
                    }
                }
            }
        }
        return result;
    }
} //Solved

class Solution1266{

    public static void main(String[] args) {
            int[][] points = new int[2][3];
            points[0][0] = 1;
        points[0][0] = 1;
        points[0][1] = 1;
        points[0][2] = 3;
        points[1][0] = 4;
        points[1][1] = -1;
        points[1][2] = 0;
        int answer = minTimeToVisitAllPoints(points);
        System.out.println(answer);
    }

    public static int minTimeToVisitAllPoints(int[][] points) {


        int counter =0;
        //2D Array  - We must move to each point according to the array indices
        //The movement can be either upwards or downwards
        //Each move increment the counter

        for (int i=0,j=0;i<points.length-1;)
        {
            int xDiff = points[i+1][j] - points[i][j];
        }
        return counter;
    }
} //Not Solved

class Solution1290{

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
    Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     */
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        listNode.next =listNode1;
        listNode1.next = listNode2;
        int result = getDecimalValue(listNode);
        System.out.println(result);

    }

    public static int getDecimalValue(ListNode head) {
        int num=0;
        StringBuilder binaryString  = new StringBuilder("");
        while(head!=null)
        {
            binaryString.append(head.val);
            head = head.next;
        }
        num = Integer.parseInt(binaryString.toString(),2);
        return num;
    }
} //Solved

class Solution1309{

    /*
    Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
    Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
    Return the string formed after mapping.

    It's guaranteed that a unique mapping will always exist.

    Example 1:

    Input: s = "10#11#12"
    Output: "jkab"
    Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
    Example 2:

    Input: s = "1326#"
    Output: "acz"
    Example 3:

    Input: s = "25#"
    Output: "y"
    Example 4:

    Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
    Output: "abcdefghijklmnopqrstuvwxyz"


    Constraints:

    1 <= s.length <= 1000
    s[i] only contains digits letters ('0'-'9') and '#' letter.
    s will be valid string such that mapping is always possible.

     */

    /*
    Success
    Details
    Runtime: 1 ms, faster than 76.46% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
    Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     */

    public static void main(String[] args) {
        String s = "25#";
        String result = freqAlphabets(s);
        System.out.println(result);
    }

    public static String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        char tmp = 'a'+1;
        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)=='#')
            {
                String number = s.substring(i-2,i);
                int toNum = Integer.parseInt(number);
                result.delete(result.length()-2,result.length());
                char appendChar = (char)(96+toNum);
                result.append(appendChar);
            }
            else
            {
                char sCharAt = s.charAt(i);
                char a = (char)(48 + sCharAt);
                result.append(a);
            }
        }
        return  result.toString();
    }



} //Solved

class Solution1356{

    public static void main(String[] args) {
    int[] arr = {0,1,2,3,4,5,6,7,8};
    int[] result = sortByBits(arr);
        System.out.println(java.util.Arrays.toString(result));
    }

    public static int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];
       // int count = sb.length() - sb.toString().replace(".", "").length();

        for (int i = 0; i< arr.length ; i++)
        {
            StringBuilder sb = new StringBuilder();
            convert(1234, sb);
            long java8 = sb.chars().filter(ch -> ch =='1').count();
            for (int j = 0;j<result.length-1;)
            {
                
            }
        }

        return result;
    }

    public static void convert(int n, StringBuilder sb) {

        if (n > 0) {
            sb.append(n % 2);
            convert(n >> 1, sb);
        } else {
            System.out.println(sb.reverse().toString());
        }
    }

}
class Solution1370 {
    /*
    Given a string s. You should re-order the string using the following algorithm:

    Pick the smallest character from s and append it to the result.
    Pick the smallest character from s which is greater than the last appended character to the result and append it.
    Repeat step 2 until you cannot pick more characters.
    Pick the largest character from s and append it to the result.
    Pick the largest character from s which is smaller than the last appended character to the result and append it.
    Repeat step 5 until you cannot pick more characters.
    Repeat the steps from 1 to 6 until you pick all characters from s.
    In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

    Return the result string after sorting s with this algorithm.

    Example 1:

    Input: s = "aaaabbbbcccc"
    Output: "abccbaabccba"
    Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
    After steps 4, 5 and 6 of the first iteration, result = "abccba"
    First iteration is done. Now s = "aabbcc" and we go back to step 1
    After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
    After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"

    */

    public static void main(String[] args) {

        String s= "aaaabbbbcccc";
        String result = sortString(s);
        System.out.println(result);
    }
    public static String sortString(String s) {

        StringBuilder  result= new StringBuilder("");
        StringBuilder temp = new StringBuilder(s);
        char minChar = s.charAt(0);
        int index = 0;
        boolean upstream = true;
        for (int i=0;temp.length()>=0;)
        {
            if (upstream)
            {
                int compare = Character.compare(minChar,temp.charAt(i));
                if (compare>0)
                {
                    minChar = temp.charAt(i);
                    index = i;
                }
                i++;
                if (i==temp.length()-1)
                {
                    temp.deleteCharAt(index);
                    //if (result.chars().anyMatch(minChar))
                    result.append(minChar);
                }
            }

        }


        String returnValue = result.toString();
        return returnValue;
    }
}

class Solution1374{

    /*
    Success
    Details
    Runtime: 1 ms, faster than 67.95% of Java online submissions for Generate a String With Characters That Have Odd Counts.
    Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Generate a String With Characters That Have Odd Counts.
     */


    /*
    Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

    The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.

    Example 1:

    Input: n = 4
    Output: "pppz"
    Explanation: "pppz" is a valid string since the character 'p'
    occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".

     */

    public static void main(String[] args) {
        int numOdd = 181;
        int numEven = 8;

        System.out.println("Odd Result: "+generateTheString(numOdd));

        System.out.println("Now Even: " + generateTheString(numEven));
    }

    public static String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.1
        Random random = new Random();
        int randomResult;
        for (int i = 0 ; i < n ;)
        {

            randomResult = random.nextInt(26);
            char c = (char)(97+ randomResult);
            if (stringBuilder.toString().contains(String.valueOf(c)))
            {
                while (n-i>=2)
                {
                    stringBuilder.append(c);
                    stringBuilder.append(c);
                    i+=2;
                }

            }
            else
            {
                stringBuilder.append(c);
                i++;
            }
        }
        return  stringBuilder.toString();

    }
} //Solved
class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        ArrayList<Integer> tmpArray = new ArrayList<>();
        Arrays.fill(result, -1);
        for (int i=0,j=0;i<nums.length;i++)
        {
            int tmp = index[i];
            if (!tmpArray.contains(tmp)) // the array filled with -1 , if index filled with -1 , place value
            {
                if (result[tmp]==-1)
                {
                    result[tmp] = nums[i];
                    tmpArray.add(tmp);
                }
                else
                {
                    for (int t = result.length-1; t >tmp; t--)
                        result[t] = result[t-1];
                    result[tmp] = nums[i];
                }
            }
            else
            {
                for (int t = result.length-1; t >tmp; t--)
                    result[t] = result[t-1];
                result[tmp] = nums[i];
            }
        }
        return  result;
    }
}
class Solution1395{
/*
        There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

        You have to form a team of 3 soldiers amongst them under the following rules:

        Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
        A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
        Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).



        Example 1:

        Input: rating = [2,5,3,4,1]
        Output: 3
        Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
        Example 2:

        Input: rating = [2,1,3]
        Output: 0
        Explanation: We can't form any team given the conditions.
        Example 3:

        Input: rating = [1,2,3,4]
        Output: 4


        Constraints:

        n == rating.length
        1 <= n <= 200
        1 <= rating[i] <= 10^5

 */


    public static void main(String[] args) {

        int arr[] = {1,2,3,4};
        int result = numTeams(arr);
        System.out.println(result);
    }

    public static int numTeams(int[] rating) {

        int result = 0;
        int ascending=0;
        int descending=0;
        int placeHolderUp = 0; // handling third element for comparison
        int tmpMax = 0;

        //Start at index 0 and iterate the array , as long as you have a sequence ascending or descending it's a match
        // when you find a combination of 3 , store it (maybe array list of array list of numbers)

        //i need i and j as iterators , i=0 , j= i+1 always to iterate from i to end of list with j , then
        // increment i and place j+1 to continue

        for (int i=0,j=1,k=2;i<rating.length-2;)
        {
            if (k<rating.length && rating[i]<rating[j])// First comparison : case when next element is greater than current element
            {
                if (k<rating.length && rating[j]<rating[k])
                {
                    result++;
                    if (j==rating.length-1) // j reached end of array -continue looping with i increment
                    {
                        i++;
                        j=i+1; // j is always one value greater than i
                        k=j+1; // k is always one value greater than j
                    }
                    else
                    {
                        //j++;
                        if (k==rating.length-1)
                        {
                            i++;
                            j=i+1;
                            k=j+1;
                        }
                        else
                        {
                            k++;
                        }

                    }
                }
                else
                {
                    if (k==rating.length-1)
                    {
                        j++;
                        if (j!=rating.length-1)
                            k=j+1;
                    }
                    else
                    {
                        k++;
                    }
                }
            }
            else
            {
                if (j==rating.length-1)
                {
                    i++;
                    j=i+1;
                    if (j!=rating.length-1)
                        k=j+1;
                }
                else
                {
                    j++;
                    k=j+1;
                }

            }
        }

        //Descending

        for (int i=0,j=1,k=2;i<rating.length-2;)
        {
            if (k<rating.length && rating[i]>rating[j])// First comparison : case when next element is greater than current element
            {
                if (k<rating.length && rating[j]>rating[k])
                {
                    result++;
                    if (j==rating.length-1) // j reached end of array -continue looping with i increment
                    {
                        i++;
                        j=i+1; // j is always one value greater than i
                        k=j+1; // k is always one value greater than j
                    }
                    else
                    {
                        j++;
                        if (k==rating.length-1)
                        {
                            i++;
                            j=i+1;
                            k=j+1;
                        }
                        else
                        {
                            k=j+1;
                        }

                    }
                }
                else
                {
                    if (k==rating.length-1)
                    {
                        j++;
                        if (j!=rating.length-1)
                            k=j+1;
                    }
                    else
                    {
                        k++;
                    }
                }
            }
            else
            {
                if (j==rating.length-1)
                {
                    i++;
                    j=i+1;
                    if (j!=rating.length-1)
                        k=j+1;
                }
                else
                {
                    j++;
                    k=j+1;
                }

            }
        }


        return result;
    }


}
class Solution1408{

    /*
    Given an array of string words. Return all strings in words which is substring of another word in any order.

    String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].



    Example 1:

    Input: words = ["mass","as","hero","superhero"]
    Output: ["as","hero"]
    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
    ["hero","as"] is also a valid answer.
    Example 2:

    Input: words = ["leetcode","et","code"]
    Output: ["et","code"]
    Explanation: "et", "code" are substring of "leetcode".
    Example 3:

    Input: words = ["blue","green","bu"]
    Output: []


    Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 30
    words[i] contains only lowercase English letters.
    It's guaranteed that words[i] will be unique.

    SOLVED
    Runtime: 3 ms, faster than 95.90% of Java online submissions for String Matching in an Array.
    Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for String Matching in an Array.

     */
    public static void main(String[] args) {
        String[] array = {"superhero","mass","as","hero"};
        List<String> result = stringMatching(array);
        System.out.println(result);
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i=0,j=i+1;i<words.length&&j<words.length;)
        {
            if (words[i].contains(words[j]) && !result.contains(words[j]))
            {
                result.add(words[j]);
            }
            else if (words[j].contains(words[i]) && !result.contains(words[i]))
            {
                result.add(words[i]);
            }
            j++;
            if (j==words.length)
            {
                i++;
                if (i<words.length)
                    j=i+1;

            }
        }
        return result;
    }
} //Solved
class Solution1413{

        /*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.



Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
                step by step sum
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive.


Example 3:

Input: nums = [1,-2,-3]
Output: 5


Constraints:

        1 <= nums.length <= 100
        -100 <= nums[i] <= 100

    */

    public static void main(String[] args) {

    }



    public static int minStartValue(int[] nums) {
        return 0;
    }
}
class Solution1417 {
    /*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is
 followed by another digit. That is, no two adjacent characters have the same type.
Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.
Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.
Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"
Example 5:

Input: s = "ab123"


    SOLVED
    301 / 301 test cases passed.
    Status: Accepted
    Runtime: 3 ms
    Memory Usage: 39.5 MB



    */

    public static void main(String[] args) {

        String s = "ab123";
        String result = reformat(s);
        System.out.println(result);

    }
    public static String reformat(String s) {
        StringBuilder result=new StringBuilder(""); // We return this as an empty String in case no permutations found
        //If count of numbers is same as letters, we place letter,digit
        //If count of numbers is greater than letters we place digit,letter
        //If count of numbers is smaller than letters we place letter,digit
        StringBuilder numbers=new StringBuilder("");
        StringBuilder letters=new StringBuilder("");

        for (int i=0;i<s.length();i++)
        {
            if (s.charAt(i)>='a'&&s.charAt(i)<='z') letters.append(s.charAt(i));
            if (s.charAt(i)>='0'&&s.charAt(i)<='9')  numbers.append(s.charAt(i));
        }

        if (numbers.length()==letters.length()+1)
        {
            for (int i =0,j=0,tmp=0; i< numbers.length()|| j<letters.length();)
            {
                if (tmp%2==0)
                {
                    result.append(numbers.charAt(i));
                    i++;
                }
                else
                {
                    result.append(letters.charAt(j));
                    j++;
                }
                tmp++;
            }
        }

        else if (numbers.length()==letters.length())
        {
            for (int i =0,j=0,tmp=0; i< numbers.length()|| j<letters.length();)
            {
                if (tmp%2==0)
                {
                    result.append(numbers.charAt(i));
                    i++;
                }
                else
                {
                    result.append(letters.charAt(j));
                    j++;
                }
                tmp++;
            }
        }

        else if (numbers.length()+1==letters.length())
        {
            for (int i =0,j=0,tmp=0; i< letters.length()|| j<numbers.length();)
            {
                if (tmp%2==0)
                {
                    result.append(letters.charAt(i));
                    i++;
                }
                else
                {
                    result.append(numbers.charAt(j));
                    j++;
                }
                tmp++;
            }
        }
        String returnValue = result.toString();
        return  returnValue;
    }
}

class Solution1422{

    public static void main(String[] args) {
        String s ="011101";
        int result = maxScore(s);
        System.out.println(result);
    }

    public static int maxScore(String s) {
        int result  = 0;
         for (int i=0,j=1;j< s.length();)
        {
            String left= s.substring(i,j);
            String right = s.substring(j,s.length());
            long cnt = left.chars().filter(num -> num == '0').count();
            long cnt2 = right.chars().filter(num -> num == '1').count();
            //long count = left.chars().filter(ch -> ch == '0').count();
            //long count2 = right.chars().filter(ch -> ch == '1').count();
            if (cnt+cnt2>result)
            {
                result = (int)(cnt+cnt2);
            }
            j++;
        }
        return result;
    }
} //Solved But not optimal at all


class Solution1423{

    public static void main(String[] args) {

        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        int result = maxScore(cardPoints,k);
        System.out.println(result);
    }

    public static int maxScore(int[] cardPoints, int k) {


        int result=0;


        return result;
    }

}

class Solution1431{

    public static void main(String[] args) {

        int[] candies  = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies,extraCandies);
        System.out.println(result);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int max=candies[0];
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0 ; i< candies.length; i++)
        {
            if (candies[i]>max) max = candies[i];
        }
        for (int j = 0; j< candies.length; j++)
        {
                if (candies[j]+extraCandies>=max) result.add(true);
                else result.add(false);
        }
        return  result;
    }
} //Solved

class Solution1436{



    /*

    [["zGirRtGNQE","okhpFEyNpL"],["zDIDhfkQyP","skvVXzpXZT"],
    ["jlYNctQVfl","HNFCAzAeUY"],["cRedXvY Fl","zDIDhfkQyP"],
    ["EtRvnuwEQL","GJDNbCDoF "],["OkIHLxaunD","zGirRtGNQE"],
    ["TUWRUvvhgA","hHJUuUyUkE"],["hjulshiBSv","KMXYhUGaWI"],
    ["lSMZK wpJy","BAYJqiDkYQ"],["fcYwKOP Sd","jlYNctQVfl"],
    ["uQUvIQyYzH","rTGbPgjNVV"],["HNFCAzAeUY","lSMZK wpJy"],
    ["oIvRr MqcY","VoRQpoPPDl"],["BAYJqiDkYQ","IFdpTACiDh"],
    ["ylLWbmsjoh","DWjaiMtibq"],["gegXGUCIiC","cqIZwtcBvh"],
    ["dmVigKBJQr","OkIHLxaunD"],["KMXYhUGaWI","kECT zpiUa"],
    ["hHJUuUyUkE","cRedXvY Fl"],["gyZleGIp c","hjulshiBSv"],
    ["IFdpTACiDh","ICRxHbFMBf"],["ICRxHbFMBf","oIvRr MqcY"],
    ["VoRQpoPPDl","ylLWbmsjoh"],["kECT zpiUa","TUWRUvvhgA"],
    ["cqIZwtcBvh","RFQzUFTCYD"],["DWjaiMtibq","EtRvnuwEQL"],
    ["rTGbPgjNVV","gyZleGIp c"],["qRHnsLGOZO","fcYwKOP Sd"],
    ["GJDNbCDoF ","gegXGUCIiC"],["skvVXzpXZT","dmVigKBJQr"],
    ["RFQzUFTCYD","uQUvIQyYzH"]]
     */

    //[["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    public static void main(String[] args) {
        List<List<String>> paths=new ArrayList<>();
        List<String> tmp1 = new ArrayList<>();
        tmp1.add("London");
        tmp1.add("New York");
        List<String> tmp2 = new ArrayList<>();
        tmp2.add("New York");
        tmp2.add("Lima");
        List<String> tmp3 = new ArrayList<>();
        tmp3.add("Lima");
        tmp3.add("Sao Paulo");
        paths.add(tmp1);
        paths.add(tmp2);
        paths.add(tmp3);
        String result = destCity(paths);
        System.out.println(result);

    }

    public static String destCity(List<List<String>> paths) {
        String result="";
        List<String> citiesSource = new ArrayList<>();
        List<String> citiesDest = new ArrayList<>();
        String path1;
        String path2;
        int i = 0;
        for (List<String> tmp :  paths)
        {
            citiesSource.add(tmp.get(0));

            if ((!citiesSource.contains(tmp.get(1)))&&(!citiesDest.contains(tmp.get(1))))
            {
                citiesDest.add(tmp.get(1));
            }
            else if (citiesDest.contains(tmp.get(0)))
            {

                citiesDest.remove(tmp.get(0));
            }
            //path1= tmp.get(0);
            //path2= tmp.get(1);
        }
        return citiesDest.get(citiesDest.size()-1);
    }
}

class Solution1441{
    /*
    Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

    Build the target array using the following operations:

    Push: Read a new element from the beginning list, and push it in the array.
    Pop: delete the last element of the array.
    If the target array is already built, stop reading more elements.
    You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

    Return the operations to build the target array.

    You are guaranteed that the answer is unique.



    Example 1:

    Input: target = [1,3], n = 3
    Output: ["Push","Push","Pop","Push"]
    Explanation:
    Read number 1 and automatically push in the array -> [1]
    Read number 2 and automatically push in the array then Pop it -> [1]
    Read number 3 and automatically push in the array -> [1,3]
    Example 2:

    Input: target = [1,2,3], n = 3
    Output: ["Push","Push","Push"]
    Example 3:

    Input: target = [1,2], n = 4
    Output: ["Push","Push"]
    Explanation: You only need to read the first 2 numbers and stop.
    Example 4:

    Input: target = [2,3,4], n = 4
    Output: ["Push","Pop","Push","Push","Push"]


    Constraints:

    1 <= target.length <= 100
    1 <= target[i] <= 100
    1 <= n <= 100
    target is strictly increasing.

     */

    /*
    Runtime: 1 ms, faster than 51.14% of Java online submissions for Build an Array With Stack Operations.
    Memory Usage: 40.4 MB, less than 100.00% of Java online submissions for Build an Array With Stack Operations.

     */
    public static void main(String[] args) {

        int[] arr = {1,2};
        int num = 4;
        List<String> answer = buildArray(arr,num);
        System.out.println(answer);
    }

    public static List<String> buildArray(int[] target, int n) {

        String push = "Push";
        String pop = "Pop";
        List<String> answer = new ArrayList<>();

        //we iterate a loop with max size of n
        //we compare the number in the index to the size of  n , if they match we keep the number(push),if no match we pop
        for (int i = 0,j=1;j<=n;)
        {
            answer.add(push);
            if (target[i]!=j)
            {
                answer.add(pop);
            }
            else
            {
                i++;
            }
            j++;
            if (i==target.length) break;
        }
        return answer;
    }
} //Solved

class Solution1446{


    /*
    Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

    Return the power of the string.



    Example 1:

    Input: s = "leetcode"
    Output: 2
    Explanation: The substring "ee" is of length 2 with the character 'e' only.
    Example 2:

    Input: s = "abbcccddddeeeeedcba"
    Output: 5
    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
    Example 3:

    Input: s = "triplepillooooow"
    Output: 5
    Example 4:

    Input: s = "hooraaaaaaaaaaay"
    Output: 11
    Example 5:

    Input: s = "tourist"
    Output: 1


    Constraints:

    1 <= s.length <= 500
    s contains only lowercase English letters.


     */

    /*
    Success
    Details
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Consecutive Characters.
    Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Consecutive Characters.

     */
    public static void main(String[] args) {





        /*

        Input: s = "leetcode"
        Output: 2
        Explanation: The substring "ee" is of length 2 with the character 'e' only.

         */

        String s = "hooraaaaaaaaaaay";
        int result = maxPower(s);
        System.out.println(result);
    }

    public static int maxPower(String s) {

        int result = 0;
//        HashMap<Character,Integer> checkSum = new HashMap<Character, Integer>();
//        for (int i = 0; i < s.length(); i++)
//        {
//            if (checkSum.containsKey(s.charAt(i)))
//            {
//                checkSum.put(s.charAt(i),checkSum.get(s.charAt(i)).intValue()+1);
//                if (checkSum.get(s.charAt(i)).intValue()>result)
//                {
//                    result = checkSum.get(s.charAt(i)).intValue();
//                }
//            }
//            else
//            {
//                checkSum.put(s.charAt(i),1);
//            }
//        }
        int counter = 0;
        for (int i = 0 ; i < s.length()-1 ; i++)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                counter++;
                if (counter>result)
                {
                    result = counter;
                }
            }
            else
            {
                counter = 0;
            }
        }

        return result+1;
    }
} //Solved


class Solution1450{

    /*
    Example 1:

    Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
    Output: 1
    Explanation: We have 3 students where:
    The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
    The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
    The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
    Example 2:

    Input: startTime = [4], endTime = [4], queryTime = 4
    Output: 1
    Explanation: The only student was doing their homework at the queryTime.
    Example 3:

    Input: startTime = [4], endTime = [4], queryTime = 5
    Output: 0
    Example 4:

    Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
    Output: 0
    Example 5:

    Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
    Output: 5


    Constraints:

    startTime.length == endTime.length
    1 <= startTime.length <= 100
    1 <= startTime[i] <= endTime[i] <= 1000
    1 <= queryTime <= 1000

     */

    /*
    Success
    Details
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Students Doing Homework at a Given Time.
    Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Number of Students Doing Homework at a Given Time.

     */

    public static void main(String[] args) {

        //Example One
        /*

        int[] startTime = {1,2,3};
        int[] endTime = {3,2,7};
        int queryTime = 4;

         */

        //Example Five


        int[] startTime = {9,8,7,6,5,4,3,2,1};
        int[] endTime = {10,10,10,10,10,10,10,10,10};
        int queryTime = 5;


        int result = busyStudent(startTime,endTime,queryTime);
        System.out.println(result);
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int result = 0;
        for (int i = 0 ; i < startTime.length ; i++)
        {
            if (startTime[i]<=queryTime &&endTime[i]>=queryTime)
            {
                result++;
            }
        }
        return result;
    }
} //Solved

class UsefulFunctions{

    public static void main(String[] args) {
        streams(); // Stream functions
        initialize2dArray(); // initialize 2d array
    }

    public static void streams()
    {
        int[] candies = {2,3,4,5,1};
        int extraCandies = 3;
        int maximum = Arrays.stream(candies).max().orElse(0); // Get maximum value from array using streams
        List<Boolean> list = Arrays.stream(candies).mapToObj(x -> x + extraCandies >= maximum).collect(Collectors.toList()); // map to object , stream array and for each x check if x + extraCandies greater or equal to maximum, return boolean
        System.out.println(list);
    }

    public static void initialize2dArray()
    {
        int[][] indices ={{0,0},{0,0},{0,0}};
    }

    //Regular Array
    public static void printArrayOneLine(int[] arr)
    {
        System.out.println(java.util.Arrays.toString(arr));
    }

    //2D Array
    public static void printArrayOneLine(int[][] arr)
    {
        System.out.println(Arrays.deepToString(arr));
    }

    //Hashmap
    public static void hashMap()
    {
        int result = 0;
        String s = "leetcode";
        HashMap<Character,Integer> checkSum = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++)
        {
            if (checkSum.containsKey(s.charAt(i)))
            {
                checkSum.put(s.charAt(i),checkSum.get(s.charAt(i)).intValue()+1);
                if (checkSum.get(s.charAt(i)).intValue()>result)
                {
                    result = checkSum.get(s.charAt(i)).intValue();
                }
            }
            else
            {
                checkSum.put(s.charAt(i),1);
            }
        }
    }


}






class Python {

    public static int big_size =5;
    public static int small_size=1;

    public static void main(String[] args) {

        System.out.println(chocolate_maker(3,2,10));

    }

    public static boolean chocolate_maker(int small,int big, int size)
    {
        if (size%big_size<=small) return true; // אם גודל מודולו גודל גדול קטן או שווה לכמות של small
        else if (small*small_size+big*big_size==size) return true; // אם הכל נכנס בדיוק
        else if (small*small_size==size) return true; // אם רק הsmall מרכיב את השוקולד
        else if (big*big_size==size) return true; // אם רק הbig מרכיב את השוקולד
        else return false; // כל התנאים לא עבדו מחזיר false
    }
}
