/* Q:1 Reverse K elements of queue. Input of size of queue : 5 , value of K : 3 ; If  the elements of queue is
1,2,3,4,5; reverse the first 3 elements
Output: 3,2,1,4,5
* */

package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int i, k;

        System.out.println("Enter the size of the queue: ");
        int n = sc.nextInt();  // Size of the queue

        System.out.println("Enter the elements of the queue: ");
        for (i = 0; i < n; i++) {
            queue.add(sc.nextInt());  // Add elements to the queue
        }

        System.out.println("Enter the value of K: ");
        k = sc.nextInt();  // Number of elements to reverse

        // Check if K is valid
        if (k > n || k <= 0) {
            System.out.println("Invalid value of K. It should be between 1 and " + n);
            return;
        }

        // Step 1: Push the first K elements onto the stack
        for (i = 0; i < k; i++) {
            stack.push(queue.poll());  // Poll from queue and push onto stack
        }

        // Step 2: Pop from stack and enqueue back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());  // Pop from stack and offer to queue
        }

        // Step 3: Move the remaining elements from the front to the back to maintain order
        for (i = 0; i < n - k; i++) {
            queue.offer(queue.poll());  // Rotate remaining elements
        }

        // Print the modified queue
        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}