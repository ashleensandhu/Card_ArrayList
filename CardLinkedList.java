import java.util.*;
/**
*This is a Card Linked List class that maintains a list of cards
*allowing for the methods listed below to manage the list of cards.
*
*@Ashleen Sandhu
*@version 5/29/2022
*/

public class CardLinkedList implements CardList
{
   private CardLinkedList cards;
   private class Node
   {
      public Card data;       
      public Node next;            
   
      public Node(Card r)
      {
        data = r;
        next = null;
      }
    }

   
   private Node head;
   private int size;
   /** default constructor that sets head pointer to null */ 
   public CardLinkedList()
   {
      head = null;
      size = 0;
   }
   /** This method returns a representation of the list.
     *
     * @return The string visulation of the list. */
   public String toString()
   {
      if (head == null) return "[0:  :0]";
      
      String result = "";
      Node current = head;
      while(current != null)
      {
         result = result + "," + current.data.toString();
         current = current.next;
      }
      
      return "[:" + result.substring(1) + size+ ":]";      
   }
   /** This method returns the current number of elements in the list.
     *  @return the size of the list as an integer */
   public int size()
   {
      return size;
   }
   /** This method adds a card to the end of the list in the first available spot.
     * 
     * @param x the Card object to be added. */
   public void add(Card x)
   {
      size++;
      if (head == null)
      {
         head = new Node(x);
      }
      else 
      {
         Node current = head;
         while (current.next != null)   
           { current = current.next;}   
        
        current.next = new Node(x);
      }
      
   }
   /** This method should remove the last element from the list.
     *
     * @return The card object removed from the list.
     */
   public Card remove()
   {
      if(head==null) return null;
      
      Node current = head;
      Node behind  = head;
      
      for(int i=1; i<size; i++)
      {
         behind = current;
         current = current.next;
      }
      
      behind.next = null;
      size--;
      return current.data;
   }
   /** This method returns the card located at in the array at the x location.
     *
     * @param x The index of the desired card. 
     * @return The card object locatated in index x from the list.
     * @throws IndexOutOfBoundsException if the x value is outside the range of the list
     */  
   public Card get(int x)
   {
      if(x>size-1 || x<0) throw new IndexOutOfBoundsException();
      if(size==0) return null;
      else
      {
         Node current = head;
         for(int i=0; i<x; i++)
         {
           current=current.next;
         }
        return current.data;
      }
    }
   /** Returns the location of the first location of the first card
     *equal to the card that is provided.
     *
     * @param x Card object
     * @return index of Card otherwise -1 if not found
    */
   public int indexOf(Card x)
   {
      Node current = head;
      
      for(int i=0; i<size; i++)
      {
         if(current.data.compareTo(x) <=0)
         {
            return i;
         }
         current=current.next;
      }
      
      return -1;

   }
   /** This method adds a card to the indicated location
     * sliding all other elements over one.
     * 
     * @param loc the desired index of the card to be added.
     * @param x the Card object to be added. 
     * @throws IndexOutOfBoundsException if the loc is outside the current list.
     */
   public void add(int loc, Card x)
   {
      if (loc <0 ) throw new IndexOutOfBoundsException();
      if (loc > size) throw new IndexOutOfBoundsException();
      if (loc == size) this.add(x);
      else if (loc == 0)
      {
         size++;
         Node temp = new Node(x);
         temp.next = head;
         head = temp;
      }
      else 
      {
         Node current = head;
         for( int i = 1; i < loc; i++)  current = current.next;
         
         Node temp = new Node(x);
         temp.next = current.next;
         current.next = temp;
         size++;
      }
   }
   /** This method removes the identified card from the list and return it.
     *
     * @param x the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the loc is outside the current array size.
     */
   public Card remove(int x)
   {
      if(x<0 || x>=size) throw new IndexOutOfBoundsException();
      if (head == null) return null;
      
      else if(x==0)
      {
         Node temp = head;
         head = head.next;
         size--;
         return temp.data;
      }
      else
      {
         Node current = head;
         Node back = head;
         
         for(int i=0; i<x; i++)
         {
            back = current;
            current = current.next;
         }
         
         back.next = current.next;
         size--;
         return current.data;
      }      
   }
   /** Sort the items in the list from smallest to largest */
   public void sort()
   {
      sort(this);
   }
   //sort() method helper
    private static void merge(CardLinkedList result, CardLinkedList left, CardLinkedList right)
   {
      while(left.size() + right.size() > 0)
      {
         if(left.size() == 0)
         {
            result.add(right.remove(0));
         }
         else if(right.size() == 0)
         {
            result.add(left.remove(0));
         }
         else if(left.head.data.compareTo(right.head.data) <= 0)
         {
            result.add(left.remove(0));
         }
         else
         {
            result.add(right.remove(0));
         }
      } 
   }
   //sort() method helper
   private void sort(CardLinkedList x)
   {
      if(x.size()>=2)
      {
        CardLinkedList left = new CardLinkedList(); 
        CardLinkedList right = new CardLinkedList(); 
        
        int half = x.size()/2;
        
        for(int i=0; i<half;i++)
        {
         left.add(x.remove(0));
        }
        
        while(x.size() != 0)
        {
           right.add(x.remove(0));
        }
        
        sort(left);
        sort(right);
        merge(x, left, right);
      }
      
   }
   /** a shuffly algorthm to rearrange the items in the list. */
   public void shuffle()
   {
      Random rand = new Random();
      int a = rand.nextInt(size);
      int b = rand.nextInt(size);
      swap(a,b);   
   }
   
   private void swap(int a, int b)
   {
        Card temp;
        Node current = head;
        Node pointer = head;
        for(int i=0; i<a; i++)
        {
           current=current.next;
        }
        temp = current.data;
        
        for(int i=0; i<b; i++)
        {
           pointer=pointer.next;
        }
        current.data = pointer.data;
        pointer.data = temp;
   }
   /** Empty the list of all items. */
   public void clear()
   {
      head = null;
      size = 0;
   }


}