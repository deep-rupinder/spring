package com.example.demo.model;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books =new HashSet<Book>();

    public Author(){

    }
    public Author(String fn,String ln)
    {
        first_name = fn;
        last_name = ln;
    }
    public Author(String fn,String ln,Set<Book>books)
    {
        first_name =fn;
        last_name= ln;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName()
    {
        return this.first_name;
    }

    public String getLastName()
    {
        return this.last_name;
    }
    public void setFirstName(String fn)
    {
        this.first_name = fn;
    }
    public void setLastName(String ln)
    {
        this.last_name = ln;
    }
     public Set<Book> getBooks(Set<Book>book){
        return books;
     }
     public void setBooks(Set<Book>book){
        this.books = book;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id!=null?id.equals(author.id):author.id==null;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
