import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
