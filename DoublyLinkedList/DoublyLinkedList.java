public class DoublyLinkedList {
  DoublyNode head;
  DoublyNode tail;
  int size;

  public DoublyNode createDLL(int nodeValue) {
    head = new DoublyNode();
    DoublyNode newNode = new DoublyNode();
    newNode.value = nodeValue;
    newNode.next = null;
    newNode.prev = null;
    head = newNode;
    tail = newNode;
    size = 1;
    return head;
  }

  public void insertDLL(int nodeValue, int location) {
    DoublyNode newNode = new DoublyNode();
    newNode.value = nodeValue;
    if (head == null) {
      createDLL(nodeValue);
      return;
    } else if (location == 0) {
      newNode.prev = null;
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    } else if (location >= size) {
      newNode.next = null;
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    } else {
      DoublyNode tempNode = head;
      for (int i = 0; i < location - 1; i++) {
        tempNode = tempNode.next;
      }
      newNode.next = tempNode.next;
      newNode.prev = tempNode;
      newNode.next.prev = newNode;
      tempNode.next = newNode;
    }
    size++;
  }

  public void traverseDLL() {
    if (head != null) {
      DoublyNode tempNode = head;
      for (int i = 0; i < size; i++) {
        System.out.print(tempNode.value);
        if (i != size - 1) {
          System.out.print(" -> ");
        }
        tempNode = tempNode.next;
      }
    } else {
      System.out.println("DLL Does not Exist");
    }
    System.out.println("\n");
  }

  public void reverseTraverseDLL() {
    if (head != null) {
      DoublyNode tempNode = tail;
      for (int i = 0; i < size; i++) {
        System.out.print(tempNode.value);
        if (i != size - 1) {
          System.out.print(" -> ");
        }
        tempNode = tempNode.prev;
      }
    } else {
      System.out.println("DLL Does not Exist");
    }
    System.out.println("\n");
  }

  public boolean searchNode(int nodeValue) {
    if (head != null) {
      DoublyNode tempNode = head;
      for (int i = 0; i < size; i++) {
        if (tempNode.value == nodeValue) {
          System.out.println("The Node is found at " + (i + 1));
          return true;
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("The Node is Not Found");
    return false;
  }

  public void deleteNodeDLL(int location) {
    if (head == null) {
      System.out.println("Doubly Linked List Does Not Exist");
      return;
    } else if (location == 0) {
      if (size == 1) {
        head = null;
        tail = null;
        size--;
        return;
      } else {
        head = head.next;
        head.prev = null;
        size--;
      }
    } else if (location >= size) {
      DoublyNode tempNode = tail.prev;
      if (size == 1) {
        head = null;
        tail = null;
        size--;
        return;
      } else {
        tempNode.next = null;
        tail = tempNode;
        size--;
      }
    } else {
      DoublyNode tempNode = head;
      for (int i = 0; i < location-1; i++) {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      tempNode.next.prev = tempNode;
      size--;
    }
  }
  public void entireDLLDelete(){
    DoublyNode tempNode = head;
    for(int i=0;i<size;i++){
      tempNode.prev=null;
      tempNode=tempNode.next;
    }
    head=null;
    tail=null;
    System.out.print("Entire DLL is Deleted \n");
  }

}