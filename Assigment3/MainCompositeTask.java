package Assigment1.Assigment3;

import java.util.ArrayList;
import java.util.List;

// Common interface for files and directories
interface FileSystemComponent {
    void showDetails();
}

// Class for files
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Class for directories
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

// Client code for Composite pattern
public class MainCompositeTask {
    public static void main(String[] args) {
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        Directory dir1 = new Directory("Folder1");
        Directory dir2 = new Directory("Folder2");
        dir1.addComponent(file1);
        dir2.addComponent(file2);
        dir1.addComponent(dir2);
        dir1.showDetails(); // Output the contents of Folder1, including nested directories and files
    }
}