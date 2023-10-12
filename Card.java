import java.util.*;
/**
*This is a Card class that contains an ArrayList of cards that all have
*methods to be able to move around and play with your cards.
*
*@Ashleen Sandhu
*@version 5/23/2022
*/
public class Card
{
   private int R;
   private int P;
   private int S;
   /** default constructor that sets to random numbers between
   *given max and min 
   */      
   public Card()
   {
      this.R = new Random().nextInt(1000);
      this.P = new Random().nextInt(1000);
      this.S = new Random().nextInt(1000);
   }
   /** constructor that sets variables to int value given
   *@param x the value for R,P,S
   *@throws IllegalArgumentException if x is not within given bounds 
   */ 
   public Card(int x)
   {
      if(x<1 || x>1000)
      {
         throw new IllegalArgumentException(); 
      }
      
      else
      {
         this.R = x;
         this.P = x;
         this.S = x;
      }
   }
   /** constructor that sets variables to int values given
   *@param R the value for R
   *@param P the value for P
   *@param S the value for S
   *@throws IllegalArgumentException if R,P,S are not within given bounds 
   */ 
   public Card(int R, int P, int S)
   {
      if(R<1 || R>1000 || P<1 || P>1000 || S<1 || S>1000)
      {
         throw new IllegalArgumentException();
      }
      else
      {
         this.R = R;
         this.P = P;
         this.S = S;
      }
   }
   /** Gets the R value
     *
     * @return R value
    */
   public int getR()
   {
      return R;
   }
   /** Gets the P value
     *
     * @return P value
    */
   public int getP()
   {
      return P;
   }
   /** Gets the S value
     *
     * @return S value
    */
   public int getS()
   {
      return S;
   }
   /** Gets the cards cost based on the R,P, and S value
     *
     * @return the cost of the card
    */
   public int getCost()
   {
      double x = R+P+S;
      double rValue = R/x;
      double pValue = P/x;
      double sValue = S/x;  
      int cost = (int) Math.ceil((12/(10*((Math.pow(rValue, 5)) + (Math.pow(pValue, 5)) + (Math.pow(sValue, 5))))));
      return cost;
   }
   /** compares cards costs to see if they are equal
     *
     * @param card the card passed to compare
     * @return True is equal
     * @return false if not equal
    */
   public boolean equals(Card card)
   {
      if(card.getR() == this.R && card.getP() == this.P && card.getS() == this.S)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   /** return the cards values in String format
     *
     * @return String version of card
    */
   public String toString()
   {
      return ("[" + R + "," + P + "," + S + "::" + getCost() +"]");
   }
   /** Permanently lowers this card's R,P, and S.*/
   public void weaken()
   {
    int min = Math.min(P, Math.min(R,S));
      if(min == R)
      {
          R = (int)(R-5);
          if(R<1)
          {
            R=1;
          }      
      }
      else if(min == P)
      {
         P = (int)(P-5);
         if(P<1)
          {
            P=1;
          }
      }
      else
      {
         S = (int)(S-5);
         if(S<1)
          {
            S=1;
          }
      }

}
   /** Permanently increases this card's R,P, and S.*/
   public void boost()
   {
      int min = Math.min(P, Math.min(R,S));
      if(min == R)
      {
          R = (int)(R+5);
          if(R<1)
          {
            R=1;
          }      
      }
      else if(min == P)
      {
         P = (int)(P+5);
         if(P<1)
          {
            P=1;
          }
      }
      else
      {
         S = (int)(S+5);
         if(S<1)
          {
            S=1;
          }
      }
}
   /** Compares by cards
     *
     * @return positive number if they are equal
     * @return negetive number if not equal
     */
   public int compareTo(Card other)
   {
      if (this.getCost() == other.getCost())
      {       
         return this.sum()-other.sum();
      }
      else
      {
         return this.getCost()-other.getCost();
      }
   }
   /** returns total sum of the R,P, and S value*/
   public int sum()
   {
      int sum = this.R+this.P+this.S; 
      return sum;
   }
}