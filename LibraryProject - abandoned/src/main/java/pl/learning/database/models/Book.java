package pl.learning.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "BOOKS")
public class Book implements BaseModel{
    public Book(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "AUTHOR_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Author author;

    @DatabaseField(columnName = "CATEGORY_ID", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Category category;

    @DatabaseField(columnName = "TITLE", canBeNull = false)
    private String title;

    @DatabaseField(columnName = "RELEASE_DATE", canBeNull = false)
    private Date releaseDate;

    @DatabaseField(columnName = "ISBN", width = 1)
    private long isbn;

    @DatabaseField(columnName = "RATING", width = 1)
    private int rating;

    @DatabaseField(columnName = "ADDED_DATE")
    private Date addedDate;

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author author() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category category() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date releaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long isbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int rating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date addedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
