
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Movie movie=new Movie("abc",500);
			movie.setPriceCode(500);
			Rental rent = new Rental(movie,5);
			rent.getDaysRented();
			rent.getMovie();
			Customer c1=new Customer("laxmi maurya");
			c1.statement();
	}

}
