import java.util.*;
/**
*This is a Card Array List class that maintains a list of cards
*allowing for the methods listed below to manage the lsit of cards.
*
*@Ashleen Sandhu
*@version 5/23/2022
*/
public class CardArrayList implements CardList
{
   private int count;
   private Card[] cards; 
   /** default constructor that sets value of array to size 10 */   
   public CardArrayList()
   {
      cards = new Card[10];
      count = 0;
   }
   /**  A constructor that creates array of initial size x
     *
     * @param x The size of the array. 
     * @throws IndexOutOfBoundsException if x is a negetive number */
   public CardArrayList(int x)
   {
      if(x<1) throw new IndexOutOfBoundsException();
     
      cards = new Card[x];
      count=0;
      
   }
   /** This method returnd a representation of the list from index 0 to the final index.
     *
     * @return The string visulation of the list. */
   public String toString()
   {     
      String Front = "[0: ";
      String Back = " :" + count + "]";
      String value = "";
      
      for(Card x : cards)
      {
         if(x != null)
         {
            value += x.toString();
         }
      }
      return (Front + value + Back);
   }
   /** This method returns the current number of elements in the list.
     *  @return the size of the list as an integer */
   public int size()
   {
      int value = 0;
      for(int i=0; i<cards.length; i++)
      {
         if(cards[i] != null)
         {
            value = value+1;
         }
      }
      
      return value;
   }
   /** This method adds a card to the end of the list in the first available spot.
     * 
     * @param x the Card object to be added. */
   public void add(Card x)
   {
      if(!isRoom())
      {
         cards = Arrays.copyOf(cards, cards.length+1);
      }
      cards[count] = x;    
      count++;
   }
   /** This method should remove the last element from the list.
     *
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
   public Card remove()
   {     
      if(count<1) throw new IndexOutOfBoundsException();
      
      Card last = cards[count-1];
      cards[count-1] = null;
      count--;
      
      return last;
   }
   /** This method returns the i'th last element from the list.
     *
     * @param x The index of the desired card. 
     * @return The card object locatated in index x from the list.
     * @throws IndexOutOfBoundsException if the i value is outside the range of the list
     */   
   public Card get(int x)
   {
      if(x>cards.length -1) throw new IndexOutOfBoundsException();
 
      return cards[x];
   }
   /** Returns the index of specified Card object
     *
     * @param x Card object
     * @return index of Card otherwise -1 if not found
    */
   public int indexOf(Card x)
   {
      for(int i=0; i<count; i++)
      {
         if(x.toString().equals(cards[i].toString()))
         {
            return i;
         }
      }
      
      return -1;
   }
   /** This method adds a card to the indicated location
     * sliding all other elements over one.
     * 
     * @param l the desired index of the card to be added.
     * @param x the Card object to be added. 
     * @throws IndexOutOfBoundsException if the loc is outside the current list.
     */
   public void add(int l, Card x)
   {
      if(l<0 || l>=count)
      {
         throw new IndexOutOfBoundsException();
      }
      
      if(!isRoom())
      {
         expand();
      }
         
      for(int i=count; i>=l; i--)
      {
         cards[i] = cards[i-1];
      }
      
      cards[l] = x;
      count++;
   }
   /** This method removes the identified card from the list and return it.
     *
     * @param j the index of the card to be removed.
     * @return The card object removed from the list.
     * @throws IndexOutOfBoundsException if the loc is outside the current array size.
     */
   public Card remove(int j)
   {
      
      if(j<0 || j>=count) throw new IndexOutOfBoundsException();
      Card temp = cards[j];
      for(int i=j; i<count-1; i++)
      {
         cards[i] = cards[i+1];
         cards[i+1] = null;
      }
      
      count--;
      return temp;
   }
   //sort() method helper
   private Card[] helper(Card[] a)
   {
      if(a.length > 1)
      {
         Card[] left = Arrays.copyOfRange(a, 0, a.length/2);
         Card[] right = Arrays.copyOfRange(a, a.length/2, a.length);
         
         helper(left);
         helper(right);
         
         merge(a, left, right);      
      }
      return a;
   }
   //sort() method helper
   private static void merge(Card[] result, Card[] left, Card[] right)
   {
      int i1 = 0;
      int i2 = 0;
      
      for(int i=0; i<result.length;i++)
      {
         if(i2>= right.length || (i1<left.length && left[i1].compareTo(right[i2])<=0))
         {
            result[i] = left[i1];
            i1++;
         }
         else
         {
            result[i] = right[i2];
            i2++;
         }
      }
      
   }
   /** Sort the items in the list from smallest to largest */
   public void sort()
   {
      Card[] a = Arrays.copyOfRange(cards, 0, count);
      helper(a);
      for(int i=0; i<count; i++)
      {
         cards[i] = a[i];
      }
   }
   /** a shuffly algorthm to rearrange the items in the list. */
   public void shuffle()
   {
        Random rand = new Random();
        
        for(int i=0; i<cards.length*5; i++)
        {
            int a = rand.nextInt(count);
            Card temp = cards[a];
            int b = rand.nextInt(count);
            cards[a] = cards[b];
            cards[b] = temp;
        }           
   }
   
   private boolean isRoom()
   {
      return count<cards.length;
   }

   private void expand()
   {
      Card[] newArray = new Card[cards.length * 2];
      
      for(int i=0; i<count; i++)
      {
         newArray[i] = cards[i];
      }  
      cards = newArray;     
   }

   private void swap(int a, int b)
   {
      Card temp = cards[b];
      cards[b] = cards[a];
      cards[a] = temp;
   }
   /** Empty the list of all items. */
   public void clear()
   {
      cards = new Card[10];
      count = 0;
   }

}