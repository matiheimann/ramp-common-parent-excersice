package demo.src.main.java.com.demo;
import java.util.List;
import java.util.LinkedList;

public class File {
    private List<File> children;
    private String name;

    public File(String name) {
        this.name = name;
        this.children = new LinkedList<>();
    }

    public File(String name, List<File> children) {
        this.name = name;
    }

    public void addChild(File file) {
        this.children.add(file);
    }

    public List<File> getChildren() {
        return this.children;
    }    

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }
        File fileObj = (File) obj;
        return this.name.equals(fileObj.name) && this.children.equals(fileObj.children);
    }

    @Override
    public String toString() {
        return "File: " + name;
    }
}