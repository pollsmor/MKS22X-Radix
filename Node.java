public class Node<E> {
  private E m_data;
  private Node<E> m_next;
  private Node<E> m_prev;

  public Node(E data, Node<E> next, Node<E> prev) {
    m_data = data;
    m_next = next;
    m_prev = prev;
  }

  public Node<E> next() {
    return m_next;
  }

  public Node<E> prev() {
    return m_prev;
  }

  public void setNext(Node<E> other) {
    m_next = other;
  }

  public void setPrev(Node<E> other) {
    m_prev = other;
  }

  public E getData() {
    return m_data;
  }

  public E setData(E i) {
    E temp = m_data;
    m_data = i;
    return temp;
  }

  public String toString() {
    return m_data + ""; //m_data is a class variable, can't be directly printed
  }
}
