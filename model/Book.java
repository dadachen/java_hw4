package model;

public class Book {
	private String id;
	private String book_id;
	private String book_name;
	private String accession_number;
	private String isbn;
	private String author;
	private String publisher;
	private String publication_date;

	public Book(String book_name, String accession_number, String isbn, String author, String publisher,
			String publication_date) {
		super();
		this.book_name = book_name;
		this.accession_number = accession_number;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.publication_date = publication_date;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAccession_number() {
		return accession_number;
	}

	public void setAccession_number(String accession_number) {
		this.accession_number = accession_number;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

}
