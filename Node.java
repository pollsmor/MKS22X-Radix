public class Node {
  private Integer m_data;
  private Node m_next;
  private Node m_prev;

  public Node(Integer data, Node next, Node prev) {
    m_data = data;
    m_next = next;
    m_prev = prev;
  }

  public Node next() {
    return m_next;
  }

  public Node prev() {
    return m_prev;
  }

  public void setNext(Node other) {
    m_next = other;
  }

  public void setPrev(Node other) {
    m_prev = other;
  }

  public Integer getData() {
    return m_data;
  }

  public Integer setData(Integer i) {
    Integer temp = m_data;
    m_data = i;
    return temp;
  }

  public String toString() {
    return Integer.toString(m_data); //m_data is a class variable, can't be directly printed
  }
}
