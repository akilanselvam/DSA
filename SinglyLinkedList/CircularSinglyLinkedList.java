public class CircularSinglyLinkedList {
  public Node head;
  public Node tail;
  public int size;

  public Node createCSLL(int nodeValue) {
    head = new Node();
    Node node = new Node();
    node.value = nodeValue;
    node.next = node;
    head = node;
    tail = node;
    size = 1;
    return head;
  }

  public void insertCSLL(int newValue, int location) {
    Node node = new Node();
    node.value = newValue;
    if (head == null) {
      createCSLL(newValue);
      return;
    } else if (location == 0) {
      node.next = head;
      head = node;
      tail.next = head;
    } else if (location >= size) {
      tail.next = node;
      tail = node;
      tail.next = head;
    } else {
      Node tempNode = head;
      int index = 0;
      while (index < location - 1) {
        tempNode = tempNode.next;
        index++;
      }
      node.next = tempNode.next;
      tempNode.next = node;
    }
    size++;
  }

  public void traverseCSLL() {
    if (head == null) {
      System.out.println("Does not Exist");
    } else {
      Node tempNode = head;
      for (int i = 0; i < size; i++) {
        System.out.print(tempNode.value);
        if (i != size - 1) {
          System.out.print("->");
        }
        tempNode = tempNode.next;
      }
    }

  }

  boolean searchNode(int nodeValue) {
    Node tempNode = head;
    for (int i = 0; i < size; i++) {
      if (nodeValue == tempNode.value) {
        System.out.println("Node is Found at " + (i + 1));
        return true;
      }
      tempNode = tempNode.next;
    }
    System.out.println("Node is Not Found");
    return false;
  }

  public void deleteNode(int location) {
    if (head == null) {
      System.out.println("The CSLL does not exist");
      return;
    } else if (location == 0) {
      head = head.next;
      tail.next = head;
      size--;
      if (size == 0) {
        tail = null;
        head.next = null;
        head = null;
      }
    } else if (location >= size) {
      Node tempNode = head;
      for (int i = 0; i < size - 1; i++) {
        tempNode = tempNode.next;
      }
      if (tempNode == head) {
        head.next = null;
        tail = head = null;
        return;
      }
      tempNode.next = head;
      tail = tempNode;
      size--;
    } else {
      Node tempNode = head;
      for (int i = 0; i < location - 1; i++) {
        tempNode = tempNode.next;
      }
      tempNode.next = tempNode.next.next;
      size--;
    }
  }

  public void deleteEntireCSSL() {
    head = null;
    tail.next = null;
    tail = null;
    System.out.println("SSL is Deleted");
  }

}