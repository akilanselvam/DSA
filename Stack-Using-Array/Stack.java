public class Stack {
  int[] arr;
  int topofStack;

  public Stack(int size) {
    this.arr = new int[size];
    this.topofStack = -1;
    System.out.println("The Stack is Created with the Size of: " + size);
  }

  public boolean isEmpty() {
    if (topofStack == -1) {
      System.out.println("Stack is Empty");
      return true;
    } else {
      System.out.println("Stack is Not Empty");
      return false;
    }
  }

  public boolean isFull() {
    if (topofStack == arr.length - 1) {
      System.out.println("Array is Full");
      return true;
    } else {
      System.out.println("Array is Not Full");
      return false;
    }
  }

  public void push(int value) {
    if (isFull()) {
      System.out.println("Stack is Completely Full");
    } else {
      arr[topofStack + 1] = value;
      topofStack++;
      System.out.println("Value is Inserted Successfully");
    }
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is Empty");
      return -1;
    } else {
      int popStack = arr[topofStack];
      topofStack--;
      return popStack;
    }
  }

  public int peek() {
    if (isEmpty()) {
      System.out.println("This Stack is Empty");
      return -1;
    } else {
      return arr[topofStack];
    }
  }

  public void deleteStack() {
    arr = null;
    System.out.println("Stack has been Deleted Successfully");
  }
}