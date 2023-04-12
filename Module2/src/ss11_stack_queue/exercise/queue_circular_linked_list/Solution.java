package lesson11_stack_queue.exercise.queue_circular_linked_list;

public class Solution {
    Queue queue = new Queue();

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (queue.rear == null) {
            queue.front = queue.rear = newNode;
            queue.rear.link = queue.front;
        } else {
            queue.rear.link = newNode;
            queue.rear = newNode;
            queue.rear.link = queue.front;
        }
    }

    public void deQueue() {
        if (queue.front == null) {
            System.out.println("NULL");
        } else if (queue.front == queue.rear) {
            queue.front = queue.rear = null;
        } else {
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
    }

    public void displayQueue() {
        Node temp = queue.front;
        while (temp != queue.rear) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(queue.rear.data);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.enQueue(14);
        solution.enQueue(22);
        solution.enQueue(-6);
        solution.deQueue();
        solution.deQueue();
        solution.enQueue(9);
        solution.enQueue(20);
        solution.displayQueue();
    }
}
