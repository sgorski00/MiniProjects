package pl.learning.database.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AUTHORS")
public class Author implements BaseModel{
    public Author(){}

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "NAME", canBeNull = false)
    private String fullName;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Book> books;

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String fullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ForeignCollection<Book> books() {
        return books;
    }

    public void setBooks(ForeignCollection<Book> books) {
        this.books = books;
    }
}
