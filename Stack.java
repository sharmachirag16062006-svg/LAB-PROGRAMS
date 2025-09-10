package stackofbooks;

public class Stack {
	private int arr[];
	private int top;
	private int capacity;
	
	
Stack(int size) {
	capacity = size;
	arr = new int[capacity];
	top = -1;
}


Stack(int[] inputArr) {
	capacity = inputArr.length;
	arr = new int[capacity];
	for (int i = 0; i < inputArr.length; i++) {
		arr[i] = inputArr[i];
}
top = inputArr.length - 1;
}
void push(int x) {
	if (top == capacity - 1) {
		System.out.println("Stack Overflow! Cannot push " + x);
		return;
   }
      arr[++top] = x;
      System.out.println(x + " pushed into stack.");
}
void push(int x,int y) {
	push(x);
	push(y);
}
int pop() {
	if (top == -1) {
		System.out.println("Stack Underflow!");
		return -1;
}
return arr[top--];
}
void pop(int n) {
	if (n > top + 1) {
		System.out.println("not enough elements to pop " + n);
		return;
}
System.out.print("Popped elements: ");
for (int i = 0; i < n; i++) {
	System.out.print(arr[top--] + " ");
}
System.out.println();
}
void display() {
	if (top == -1) {
		System.out.println("Stack is empty.");
		return;}
	System.out.print("Stack (top to bottom): ");
	for (int i = top; i >=0; i--) {
		System.out.print(arr[i] + " ");
}
System.out.println();
}
void display(int n) {
	if (top == -1) {
		System.out.println("Stack is empty.");
		return;
}
	if (n> top + 1) {
		System.out.println("Stack has only " + (top + 1)+ " elements.");
		n = top + 1;
}
System.out.print("Top " + n + " elements: ");
for (int i = top; i > top - n; i--) {
	System.out.print(arr[i] + " ");
}
System.out.println();
}
}