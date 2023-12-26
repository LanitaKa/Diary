import java.util.ArrayList;
import java.util.List;


//Дневник с историей записей
public class Diary {
    private List<DiaryEntry> entries;

    public Diary() {
        this.entries = new ArrayList<>();
    }
// Добавление новой записи
    public void addEntry(DiaryEntry entry){
        entries.add(entry);
    }
// Получение истории записей
    public List<DiaryEntry> getHistory(){
        return entries;
    }
// Поиск записи по ID
    public DiaryEntry findEntryById (int id){
        for (DiaryEntry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null; // Если запись с указанным ID не найдена
    }

// Удалить запись
    public void deleteEntry(int id){
        entries.removeIf(entry -> entry.getId() == id);
    }

// Поиск по категории
    public List<DiaryEntry> searchEntriesByCategory (String category){
        List<DiaryEntry> searchResultsByCategory = new ArrayList<>();
        for (DiaryEntry entry : entries) {
            if (entry.getCategory().toLowerCase().contains(category.toLowerCase())){
                searchResultsByCategory.add(entry);
            }
        }
        return searchResultsByCategory;
    }

    // Поиск по tag
    public List<DiaryEntry> searchEntriesByTag (List<String> tags){
        List<DiaryEntry> searchResultsByTag = new ArrayList<>();
        for (DiaryEntry entry : entries) {

            if (matchTagsIgnoreCase(entry.getTags(), tags)){
                searchResultsByTag.add(entry);
            }
        }
        return searchResultsByTag;
    }

    private static boolean matchTagsIgnoreCase(List<String> entryTags, List<String> tagsToMatch) {
        List<String> lowerCaseEntryTags = new ArrayList<>();
        for (String tag : entryTags) {
            lowerCaseEntryTags.add(tag.toLowerCase());
        }

        List<String> lowerCaseTagsToMatch = new ArrayList<>();
        for (String tag : tagsToMatch) {
            lowerCaseTagsToMatch.add(tag.toLowerCase());
        }
        for (String tagToMatch : lowerCaseTagsToMatch) {
            if (lowerCaseEntryTags.contains(tagToMatch)) {
                return true;
            }
        }
        return false;
    }
}
