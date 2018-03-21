package services;

import models.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultBookService implements BookService{

    private List<Book> books;

    public DefaultBookService() {
        books = new ArrayList<>();
        books.add(createBook());
    }

    private Book createBook() {
        final Book book = new Book();
        book.setId(1l);
        book.setDescription("Dieses Lehrbuch bietet eine umfassende Einführung in Grundlagen und Methoden der Computerlinguistik und stellt die wichtigsten Anwendungsgebiete in der Sprachtechnologie vor. Es richtet sich gleichermaßen an Studierende der Computerlinguistik und verwandter Fächer mit Bezug zur Verarbeitung natürlicher Sprache wie an Entwickler sprachverarbeitender Systeme.");
        book.setIsbn10("3827420237");
        book.setIsbn13("978-3827420237");
        book.setPages(736);
        book.setPublisher("Spektrum Akademischer Verlag");
        book.setTitle("Computerlinguistik und Sprachtechnologie: Eine Einführung (German Edition)");
        return book;
    }

    public List<Book> get() {
        return books;
    }

    public Book get(final Long id) {
        for(Book book: books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public boolean delete(final Long id) {
        for (Iterator<Book> it = books.iterator(); it.hasNext();){
            Book book = it.next();
            if (book.getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Book update(final Book updatedBook) {
        for(Book book: books) {
            if(book.getId() == updatedBook.getId()) {
                book.setTitle(updatedBook.getTitle());
                book.setPublisher(updatedBook.getPublisher());
                book.setPages(updatedBook.getPages());
                book.setIsbn13(updatedBook.getIsbn13());
                book.setIsbn10(updatedBook.getIsbn10());
                book.setDescription(updatedBook.getDescription());
                return book;
            }
        }
        return null;
    }

    public Book add(final Book book) {
        books.add(book);
        return book;
    }

}
