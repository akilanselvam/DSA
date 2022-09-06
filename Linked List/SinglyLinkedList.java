public class SinglyLinkedList {
  public Node head;
  public Node tail;
  public int size;

  public Node createSinglyLinkedList(int nodeValue) {
    head = new Node();
    Node node = new Node();
    node.next = null;
    node.value = nodeValue;
    head = node;
    tail = node;
    size = 1;
    return head;
  }

  public void insertLinkedList(int nodeValue, int location) {
    Node node = new Node();
    node.value = nodeValue;
    if (head == null) {
      createSinglyLinkedList(nodeValue);
      return;
    } else if (location == 0) {
      node.next = head;
      head = node;
    } else if (location >= size) {
      node.next = null;
      tail.next = node;
      tail = node;
    } else {
      Node tempNode = head;
      int index = 0;
      while (index < location - 1) {
        tempNode = tempNode.next;
        index++;
      }
      Node nextNode = tempNode.next;
      tempNode.next = node;
      node.next = nextNode;

    }
    size++;
    System.out.println("Inserted Successfully");
  }

  public void traverseLinkedList() {
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
    System.out.println("\n");
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

  public void deletionOfNode(int location) {
    if (head == null) {
      System.out.println("The SSL does not exist");
      return;
    } else if (location == 0) {
      head = head.next;
      size--;
      if (size == 0) {
        tail = null;
      }
    } else if (location >= size - 1) {
      Node tempNode = head;
      for (int i = 0; i < size - 1; i++) {
        tempNode = tempNode.next;
      }
      if (tempNode == head) {
        tail = null;
        head = null;
        size--;
        return;
      }
      tempNode.next = null;
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

  public void deleteEntireSSL() {
    head = null;
    tail = null;
    System.out.println("SSL is Deleted");
  }
}
