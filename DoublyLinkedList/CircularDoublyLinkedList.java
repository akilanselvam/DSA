public class CircularDoublyLinkedList {
  public DoublyNode head;
  public DoublyNode tail;
  int size;

  public DoublyNode createCDLL(int nodeValue) {
    head = new DoublyNode();
    DoublyNode node = new DoublyNode();
    node.value = nodeValue;
    head = node;
    tail = node;
    node.next = node;
    node.prev = node;
    size = 1;
    return head;
  }

  public void insertCDLL(int nodeValue, int location) {
    DoublyNode newNode = new DoublyNode();
    newNode.value = nodeValue;
    if (head == null) {
      createCDLL(nodeValue);
      return;
    } else if (location == 0) {
      newNode.prev = tail;
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
      tail.next = newNode;
    } else if (location >= size) {

      newNode.next = head;
      newNode.prev = tail;
      tail.next = newNode;
      head.prev = newNode;
      tail = newNode;
    } else {
      DoublyNode tempNode = head;
      for (int i = 0; i < location - 1; i++) {
        tempNode = tempNode.next;
      }
      newNode.next = tempNode.next;
      newNode.prev = tempNode;
      tempNode.next.prev = newNode;
      tempNode.next = newNode;
    }
    size++;
  }

  void traverseCDLL() {
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
      System.out.println("CDLL does not exist");
    }
    System.out.println();
  }

  void reverseTraverseCDLL() {
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
      System.out.println("CDLL does not exist");
    }
    System.out.println();
  }

  public boolean searchNode(int nodeValue) {

    if (head != null) {

      DoublyNode tempNode = head;
      for (int i = 0; i < size; i++) {

        if (tempNode.value == nodeValue) {
          System.out.println("The Node is found at:" + (i + 1));
          return true;
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("Node not found");
    return false;
  }

  public void deleteCDLL(int location) {
    System.out.println("Size at Start:" + size);
    if (head == null) {
      System.out.println("No CDLL is Exist");
      return;
    } else if (location == 0) {
      if (size == 1) {
        head.prev = null;
        head.next = null;
        head = null;
        tail = null;
      }
      head = head.next;
      head.prev = tail;
      tail.next = head;
    } else if (location >= size) {
      if (size == 1) {
        head.prev = null;
        head.next = null;
        head = null;
        tail = null;
      }
      tail = tail.prev;
      tail.next = head;
      head.prev = tail;
    } else {
      DoublyNode tempNode = head;

      for (int i = 0; i < location - 1; i++) {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      tempNode.next.prev = tempNode;
    }
    size--;
    System.out.println("Size at End:" + size);
  }

  public void entireDeleteCDLL() {
    DoublyNode tempNode = head;
    for (int i = 0; i < size; i++) {
      tempNode.prev = null;
      tempNode = tempNode.next;
    }
    head = null;
    tail = null;
    System.out.println("Everything is Gone");
  }
}