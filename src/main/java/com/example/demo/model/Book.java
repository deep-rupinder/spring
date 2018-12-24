package com.example.demo.model;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;
    @ManyToMany
    @JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors =new HashSet<Author>();

    public Book(){

    }
    public Book(String tit,String isb,String publisher)
    {
        title = tit;
        isbn = isb;
        this.publisher = publisher;
    }
    public Book(String tit,String isb,String publisher,Set<Author>Authors)
    {
        title =tit;
        isbn= isb;
        this.authors = Authors;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String tit)
    {
        this.title = tit;
    }
    public void setIsbn(String isb)
    {
        this.isbn = isb;
    }
    public void setPublisher(String publisher)
    {
        this.isbn = publisher;
    }
    public Set<Author> getAuthors(Set<Author>book){
        return authors;
    }
    public void setAuthors(Set<Author>book){
        this.authors = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id!=null?id.equals(book.id):book.id==null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
