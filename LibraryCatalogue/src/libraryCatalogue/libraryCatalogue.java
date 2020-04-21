package libraryCatalogue;

import java.util.HashMap;
//import pk1.pk2.....pkn.class;
import java.util.Map;

public class libraryCatalogue {
	//properties fields global variables
			Map<String,book> bookCollection=new HashMap<String,book>();
			int currentDay=0;
			int lenghtOfCheckoutPeriod=7;
			double initialLateFees=0.50;
			double feesPerLateDay=1.0;
			
			public libraryCatalogue(Map<String,book> collection) {
				this.bookCollection=collection;
			}
			
			public libraryCatalogue(Map<String,book> collection,int lengthofCheckOutPeriod, double initialLatefees,double feesPerLateDay) {
				this.bookCollection=collection;
				this.lenghtOfCheckoutPeriod=lengthofCheckOutPeriod;
				this.initialLateFees=initialLatefees;
				this.feesPerLateDay=feesPerLateDay;
			}
			//gettters
			public int getCurrentDay() {
				return this.currentDay;
			}
			public Map<String,book> getBooksCollection() {
				return this.bookCollection;
			}
			public book getBook(String bookTitle) {
				return getBooksCollection().get(bookTitle);
			}
			public int getLengthOfCheckOutPeriod() {
				return this.lenghtOfCheckoutPeriod;
			} 
			
			public double getInitialLateFees() {
				return this.initialLateFees;
			}
			public double getFeesPerLateDay() {
				return this.feesPerLateDay;
			}
			//Setters
			public void nextDay() {
				currentDay++;
			}
			public void setDay(int day) {
				currentDay=day;
			}
			
			//instance methods-->they dont have static in front of them...static methods are class methods
			public void checkOut(String title) {
				book Book=getBook(title);
				if(Book.getIsCheckedOut()) {
					sorryBookIsAlreadyCheckedOut(Book);
				}else{
					Book.setIsCheckedOut(true, currentDay);
					System.out.print("you just check out"+title+" it is due on day"+(getCurrentDay()+getLengthOfCheckOutPeriod())+".");
				}
			}
			public void returnBook(String title) {
				book Book=getBook(title);
				int daysLate=currentDay-(Book.getDayChaeckedOut()+getLengthOfCheckOutPeriod());//if it is negative it is returned early if positive it is returned late if zero its on tym
				if(daysLate>0) {
					System.out.println("you the library $"+(getInitialLateFees()+daysLate*getFeesPerLateDay())+"because ur book is "+daysLate+"days over due");
				}else {
					System.out.println("book returned thnk yu");
				}
				Book.setIsCheckedOut(false, -1);
			}
			public void sorryBookIsAlreadyCheckedOut(book Book) {
				System.out.println("sorry"+Book.getTitle()+"is already checked out"+
			"it should be back on day"+Book.getDayChaeckedOut()+getLengthOfCheckOutPeriod()+".");
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,book> bookCollection=new HashMap<String,book>();
		book harry=new book("harry potter",484864,99999);
		bookCollection.put("harry potter",harry);
		libraryCatalogue lib=new libraryCatalogue(bookCollection);
		lib.checkOut("harry potter");
		lib.nextDay();
		lib.nextDay();
		lib.nextDay();
		lib.checkOut("harry potter");
		lib.setDay(17);
		lib.returnBook("harry potter");
		lib.checkOut("harry potter");
		lib.nextDay();
		lib.nextDay();
		lib.nextDay();
		lib.nextDay();
		
		
		
	}

}
