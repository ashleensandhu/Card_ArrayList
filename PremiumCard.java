import java.util.*;
/**
*This is a Premium Card class that extends the Card class
*this type of card is the same as Card however it has a different
toString() method.
*
*@Ashleen Sandhu
*@version 5/23/2022
*/
public class PremiumCard extends Card
{
   /** default constructor that does whatever the super does*/ 
   public PremiumCard()
   {
      super();
   }
    /**constructor that does whatever the super does
    *which would be to set all values to x
    *
    *@param x the value that will be used for the R,P,S
    */ 
    public PremiumCard(int x)
   {
      super(x);
   }
   /** constructor that sets variables to int values given
   *@param R the value for R
   *@param P the value for P
   *@param S the value for S
   */ 
   public PremiumCard(int R, int P, int S)
   {
      super(R, P, S);
   }
   /** return the cards values in String format
     *
     * @return String version of card
    */         
   public String toString()
   {
      return ("{{{" + getR() + "|" + getP() + "|" + getS() + ":" + getCost() + "}}}");
   }   
}