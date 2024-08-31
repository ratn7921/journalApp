//package net.engineeringdigest.journalApp.entity;
//
//import org.bson.types.ObjectId;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.xml.crypto.Data;
//import java.util.Date;
//
//@Document(collation = "journal_entry")
//public class JournalEntry {
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    @Id
//    private ObjectId id;
//private String title;
//    private String Content;
//    private Date date;
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public String getContent() {
//        return Content;
//    }
//
//    public void setContent(String content) {
//        Content = content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
////    public ObjectId getId() {
////        return id;
////    }
////
////    public void setId(long id) {
////        this.id = ObjectId.get(id);
////    }
//
//
//}
package net.engineeringdigest.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entry")  // Corrected the annotation to refer to "collection"
public class JournalEntry {

    @Id
    private ObjectId id;  // MongoDB automatically generates this id
    private String title;
    private String content;  // Changed "Content" to "content" to follow Java naming conventions
    private LocalDateTime date;

    // Getters and setters

    public ObjectId getId() {  // Added getter for id
        return id;
    }

    public void setId(ObjectId id) {  // Kept the setter for id, useful if you want to manually set it
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {  // Changed method name to match the "content" variable
        return content;
    }

    public void setContent(String content) {  // Changed method name to match the "content" variable
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
