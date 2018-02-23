/**
 * 
 */
/**
 * @author sophiagannon
 *
 */

package javaCollection;

import java.util.HashSet;

public class hashSetItemSearch {
	public static void main(String a[]){
        
        HashSet<Price> lhs = new HashSet<Price>();
        lhs.add(new Price("Guava", 10));
        lhs.add(new Price("Watermelon", 15));
        lhs.add(new Price("Nactarine", 3));
        for(Price pr:lhs){
            System.out.println(pr);
        }
        Price key = new Price("Guava", 10);
        System.out.println("Does set contains key? "+lhs.contains(key));
    }
}
 
class Price{
     
    private String item;
    private int price;
     
    public Price(String frut, int value){
        this.item = frut;
        this.price = value;
    }
     
    public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = price*10;
        hashcode += item.hashCode();
        return hashcode;
    }
     
    public boolean equals(Object obj){
        System.out.println("In equals");
        if (obj instanceof Price) {
            Price prc = (Price) obj;
            return (prc.item.equals(this.item) && prc.price == this.price);
        } else {
            return false;
        }
    }
     
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
     
    public String toString(){
        return "item: "+ item +"  price: "+ price;
    }
}


