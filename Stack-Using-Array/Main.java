class Main {
  public static void main(String[] args) {
    Stack newStack = new Stack(4);
    newStack.isEmpty();
    newStack.isFull();
    newStack.push(4);
    newStack.push(5);
    newStack.push(6);
    newStack.push(7);
    System.out.println(newStack.pop());
    System.out.println(newStack.pop());
    System.out.println(newStack.peek());
    System.out.println(newStack.peek());
    newStack.deleteStack();
  }
}