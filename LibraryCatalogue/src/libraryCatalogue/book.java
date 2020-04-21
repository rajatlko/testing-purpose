package libraryCatalogue;
public class book {
	//properties,fields ,global variables
	String title;
	int pageCount;
	int ISBN;
	boolean isCheckedOut;	//whether the book is checked out or not....
	int dayCheckedOut=-1;
	
	//constructor
	public book(String bookTitle,int bookPageCount,int bookISBN) {
		this.title=bookTitle;
		this.pageCount=bookPageCount;
		this.ISBN=bookISBN;
		isCheckedOut=false;
	}
	//getters ---> Instance methods
	public String getTitle() {
		return this.title;
	}
	public int getPageCount() {
		return this.pageCount;
	}
	public int getISBN() {
		return this.ISBN;
	}
	public boolean getIsCheckedOut() {
	return this.isCheckedOut;
	}
	public int getDayChaeckedOut() {
		return this.dayCheckedOut;
	}
	
	//Setters
	
	public void setIsCheckedOut(boolean newIsCheckedOut,int currentDayCheckedOut) {
		this.isCheckedOut=newIsCheckedOut;
		setDayCheckedOut(currentDayCheckedOut);
	}
	private void setDayCheckedOut(int day) {
		this.dayCheckedOut=day;
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
