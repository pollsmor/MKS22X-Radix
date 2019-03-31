public class MyLinkedList {
  private int m_size;
  private Node m_start;
  private Node m_end;

  //Start with empty MyLinkedList and work up from here.
  public MyLinkedList() {
    m_size = 0;
    m_start = null; //nothing in here
    m_end = null; //nothing in here
  }

  public void clear() {
    m_size = 0;
    m_start = null;
    m_end = null;
  }

  //As explained in class, only MyLinkedList has access to all Nodes. Anything that
  //returns Nodes should be private and only be used right in this class.
  private Node getNthNode(int index) {
    if (index == 0) //Whole point of LinkedList: easy access to beginning/end
      return m_start;

    else if (index == m_size - 1) //size - 1 because m_size is 1 more than last index
      return m_end;

    else if (index == 1)
      return m_start.next();

    else if (index == m_size - 2)
      return m_end.prev();

    Node current = m_start; //Start from start and loop through nodes
    int i = 0;
    while (i < index) { //Keep calling for the next node until the index before, calls a final next() for desired index
      current = current.next();
      ++i;
    }

    return current;
  }

  public boolean add(E value) {
    if (m_size == 0) { //If it's an empty list I have to put in a start
      m_start = new Node(value, null, null); //One item, nothing to left or right
      m_end = m_start; //Originally I made a new Node here. Thanks Ethan for tipping me off on this!
    }

    else {
      m_end.setNext(new Node(value, null, m_end));
      m_end = m_end.next(); //Thanks Ethan again for pointing out that I kinda need to set a new end
      m_end.setPrev(m_end.prev());
    }

    ++m_size; //increment size, duh
    return true; //Required to return true to adhere to List interface
  }

  public int size() {
    return m_size;
  }

  public String toString() {
    String output = "[";

    for (int i = 0; i < m_size; ++i)
      output += (getNthNode(i).toString() + ", "); //Get nth node, so that I can run Node.toString() on it

    output += "]";

    return output;
  }

  public String toStringBk() {
    String output = "[";

    for (int i = m_size - 1; i >= 0; --i)
      output += (getNthNode(i).toString() + ", "); //Get nth node, so that I can run Node.toString() on it

    output += "]";

    return output;
  }

  public Integer get(int index) {
    if (index < 0 || index >= m_size)
      throw new IndexOutOfBoundsException("Please specify a valid index.");

    return getNthNode(index).getData(); //Get nth node, so that I can run Node.getData() on it
  }

  public Integer set(int index, Integer value) {
    if (index < 0 || index >= m_size)
      throw new IndexOutOfBoundsException("Please specify a valid index.");

    Integer temp = getNthNode(index).getData(); //Get nth node, so that I can run Node.getData() on it and return it later

    getNthNode(index).setData(value); //Gets nth node, so that I can run Node.setData(Integer value) on it

    return temp; //I have to return old value to adhere to List interface
  }

  public boolean contains(Integer value) {
    for (int i = 0; i < m_size; ++i) //Loop through linkedlist
      if (get(i).equals(value)) //.equals compares 2 objects
        return true;

    return false;
  }

  public int indexOf(Integer value) { //similar to contains() but returns an index
    for (int i = 0; i < m_size; ++i)
      if (get(i).equals(value))
        return i;

    return -1; //No value found in LinkedList
  }

  public void add(int index, Integer value) {
    if (index < 0 || index > m_size)
      throw new IndexOutOfBoundsException("Please specify a valid index.");

    if (m_size == 0) { //from boolean add()
      m_start = new Node(value, null, null);
      m_end = m_start;
    }

    else if (index == 0) { //Adding to before the list's first element
      m_start.setPrev(new Node(value, m_start, null));
      m_start = m_start.prev();
    }

    else if (index == m_size) { //from boolean add()
      add(value); //reuse previous add, suggestion from class
    }

    else {
      //Links forwards and backwards, with the new Node in the middle
      Node temp = getNthNode(index); //suggestion from class to only run this once
      temp.prev().setNext(new Node(value, temp, temp.prev()));
      temp.setPrev(temp.prev().next());
    }

    ++m_size;
  }

  public Integer remove(int index) {
    if (index < 0 || index >= m_size || m_size == 0)
      throw new IndexOutOfBoundsException("Please specify a valid index.");

    Integer temp = get(index);

    if (index == 0)
      m_start = m_start.next();

    else if (index == m_size - 1)
      m_end = m_end.prev();

    else {
      Node tempNode = getNthNode(index); //suggestion from class
      tempNode.prev().setNext(tempNode.next());
      tempNode.next().setPrev(tempNode.prev());
    }

    --m_size;
    return temp;
  }

  boolean remove(Integer value) {
    int indexValue = indexOf(value); //make this a variable so I don't have to run this again in line 157
    if (indexValue == -1)
      return false;

    remove(indexValue); //reuse remove() once I have an index
    return true;
  }

  public void extend(MyLinkedList other) {
    m_size += other.size(); //Since I'm not running add I need to manually increase the size
    m_end.setNext(other.m_start);
    other.m_start.setPrev(m_end);
    m_end = other.m_end; //The other end is now the actual end
    other.m_size = 0; //Sets size to 0 so the other MyLinkedList "disappears"
  }
}
