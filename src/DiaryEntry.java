import java.util.List;
import java.util.Random;

// Запись в дневнике
public class DiaryEntry {
    private int id;
    private String category;
    private String title;
    private String content;
    private List<String> tags;
    private String date;

    public DiaryEntry(int id, String category, String title, String content, List<String> tags, String date){
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.date = date;
    }



    public int getId(){
        return id;
    }

    public String getCategory(){
        return category;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public List<String> getTags(){
        return tags;
    }

    public String getDate(){
        return date;
    }

    public void editContent(String newContent){
        this.content = newContent;
    }

    public void editCategory(String newCategory){
        this.category = newCategory;
    }

    public void editTitle(String newTitle){
        this.title = newTitle;
    }

    public void editTags(List<String> newTags){
        this.tags = newTags;
    }

    public void editDate(String newDate){
        this.date = newDate;
    }


}
