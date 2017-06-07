import java.util.Enumeration;
import java.util.Vector;

class Customer {
   private String _name;
   private Vector<Rental> _rentals = new Vector<Rental>();

   public Customer (String name){
       _name = name;
   };

   public void addRental(Rental arg) {
     _rentals.addElement(arg);
   }
   public String getName (){
       return _name;
   };
   public String statement() {
       double totalAmount = 0;
       int frequentRenterPoints = 0;
       Enumeration<Rental> rentals = _rentals.elements();
       String result = "Rental Record for " + getName() + "\n";
       while (rentals.hasMoreElements()) {
           double thisAmount = 0;
           Rental aRental = (Rental) rentals.nextElement();

           //determine amounts for each line
           thisAmount = compareMovie(aRental);

           // add frequent renter points
           frequentRenterPoints ++;
           // add bonus for a two day new release rental
           if ((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
aRental.getDaysRented() > 1) frequentRenterPoints ++;

           //show figures for this rental
           result += "\t" + aRental.getMovie().getTitle()+ "\t" +
String.valueOf(thisAmount) + "\n";
           totalAmount += thisAmount;

       }
       //add footer lines
       result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
       result += "You earned " + String.valueOf(frequentRenterPoints) +
" frequent renter points";
       System.out.println("result");
       System.out.println(result);
       return result;

   }

private double compareMovie(Rental each) {
	double result = 0;
	switch (each.getMovie().getPriceCode()) {
	       case Movie.REGULAR:
	           result += 2;
	           if (each.getDaysRented() > 2)
	               result += (each.getDaysRented() - 2) * 1.5;
	           break;
	       case Movie.NEW_RELEASE:
	           result += each.getDaysRented() * 3;
	           break;
	       case Movie.CHILDRENS:
	           result += 1.5;
	           if (each.getDaysRented() > 3)
	               result += (each.getDaysRented() - 3) * 1.5;
	           break;

	   }
	return result;
}
}