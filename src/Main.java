import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Diary diary;
    private static Scanner scanner;


    public static void main(String[] args) {
        diary = new Diary();
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create a post");
            System.out.println("2. View posts");
            System.out.println("3. Edit post");
            System.out.println("4. Delete post");
            System.out.println("5. Search posts");
            System.out.println("6. Exit");
            System.out.println("Enter your answer");
            int choice;
            choice = scanner.nextInt();
            if (choice == 1) {
                createPost();
                }

            if (choice == 2 ) {
                printHistory(diary.getHistory());
            }

            if (choice == 3 ) {
                editPost();
            }

            if (choice == 4 ) {
                //Удаление записи
                System.out.println("Enter the ID of the entry to delete");
                int deleteEntryID = scanner.nextInt();
                scanner.nextLine();
                diary.deleteEntry(deleteEntryID);
                System.out.println("Updated history of diary entries:");
                printHistory(diary.getHistory());
            }

            if (choice == 5 ) {
                searchPost();
            }

            if (choice == 6 ) {
                break;
            }
        }
    }
    private static void createPost(){
        System.out.println("Post creation");

        Random random = new Random();
        int id = random.nextInt(299) + 1;
        // System.out.println("ID: " + id);

        System.out.println("Enter category");
        String category = scanner.next();
        System.out.println("Category: " + category);

        System.out.println("Enter title");
        String title = scanner.next();
        System.out.println("Title: " + title);

        System.out.println("Enter content");
        String content = scanner.next();
        System.out.println("Content: " + content);

        System.out.println("Enter tags separated by commas");
        String[] tagsArray = scanner.next().split(",");
        List<String> tags = List.of(tagsArray);
        System.out.println("Tags: " + tags);

        System.out.println("Enter the date in the format yyyy-mm-dd");
        String date = scanner.next();
        System.out.println("Date: " + date);

        DiaryEntry newEntry = new DiaryEntry(id, category, title, content, tags, date);
        //Добавление записи в дневник
        diary.addEntry(newEntry);
        System.out.println("An entry has been added. ID: " + id);
    }
    private static void printHistory(List<DiaryEntry> history) {
        System.out.println("A history of diary entries:");
        for (DiaryEntry entry: history){
            System.out.println("ID: " + entry.getId() + "; Category: " + entry.getCategory() + "; Title: " + entry.getTitle());
            System.out.println("Content: " + entry.getContent());
            System.out.println("Tags: " + entry.getTags() + "; Date: " + entry.getDate());
            System.out.println();
        }
    }

    private static void editPost() {
        System.out.println("Enter the ID of the entry to edit");
        int entryID = scanner.nextInt();
        DiaryEntry entryToEdit = diary.findEntryById(entryID);

        if (entryToEdit != null) {
            System.out.println("What do you want to edit?");
            System.out.println("1. Category");
            System.out.println("2. Title");
            System.out.println("3. Content");
            System.out.println("4. Tags");
            System.out.println("5. Date");
            int choiceEdit;
            choiceEdit = scanner.nextInt();
            scanner.nextLine();

            if (choiceEdit == 1) {
                System.out.println("Enter a new category:");
                String newCategory = scanner.nextLine();
                entryToEdit.editCategory(newCategory);
            }

            if (choiceEdit == 2) {
                System.out.println("Enter a new title:");
                String newTitle = scanner.nextLine();
                entryToEdit.editTitle(newTitle);
            }

            if (choiceEdit == 3) {
                System.out.println("Enter a new content:");
                String newContent = scanner.nextLine();
                entryToEdit.editContent(newContent);
            }

            if (choiceEdit == 4) {
                System.out.println("Enter a new tags separated by commas:");
                String[] newTagsArray = scanner.next().split(",");
                List<String> newTags = List.of(newTagsArray);
                entryToEdit.editTags(newTags);
            }

            if (choiceEdit == 5) {
                System.out.println("Enter a new date:");
                String newDate = scanner.nextLine();
                entryToEdit.editDate(newDate);
            }

            System.out.println("Updated history of diary entries:");
            printHistory(diary.getHistory());
        } else {
            System.out.println("Entry not found with the entered ID");
        }
    }
    private static void searchPost(){
        System.out.println("What do you want to search?");
        System.out.println("1. Category");
        System.out.println("2. Tags");

        int choiceSearch;
        choiceSearch = scanner.nextInt();
        scanner.nextLine();

        if (choiceSearch == 1) {
            System.out.println("Enter a category to search:");
            String categoryToSearch = scanner.nextLine();
            List<DiaryEntry> searchResults = diary.searchEntriesByCategory(categoryToSearch);
            printHistory(searchResults);
        }

        if (choiceSearch == 2) {
            System.out.println("Enter tags separated by commas");
            String[] tagToSearch = scanner.next().split(",");
            List<String> tags = List.of(tagToSearch);
            List<DiaryEntry> searchResults = diary.searchEntriesByTag(tags);
            printHistory(searchResults);
        }
    }
}