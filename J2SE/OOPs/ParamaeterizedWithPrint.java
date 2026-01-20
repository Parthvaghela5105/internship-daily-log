// Program to create a class called "Book" with instance variables title, author, and price. 
// Implement a default constructor and two parameterized constructors:
//    a. One constructor takes title and author as parameters.
//    b. The other constructor takes title, author, and price as parameters.
//    c. Print the values of the variables for each constructor.


class Book{
	private String title;
	private String author;
	private int price;
	
	Book(){
		this.title = "Unknown";
		this.author = "Unknown";
		this.price = 0;
	}
	Book(String title , String author){
		this.title = title;
		this.author = author;
		this.price = 0;
	}
	Book(String title , String author , int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void getBookDetails(){
		System.out.println("BookDetails:");
		System.out.println("Title : "+ this.title);
		System.out.println("Author : "+ this.author);
		System.out.println("Price : "+ this.price);
	}
}

class ParamaeterizedWithPrint{
	public static void main(String[] args){
		//Book1 Default Construcor
		Book book1 = new Book();
		book1.getBookDetails();
		
		//Book2 with title and author as a parameter
		Book book2 = new Book("SCJP/OCJP" , "Durga");
		book2.getBookDetails();
		
		//Book3 with title , author and price as a parameter
		Book book3 = new Book("Power Of Subconsius Mind" , "Joseph Morphy" , 200);
		book3.getBookDetails();
	}
}