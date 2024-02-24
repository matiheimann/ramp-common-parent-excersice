package demo.src.main.java.com.demo;

import java.util.LinkedList;
import java.util.List;

public class FileService {
    public static File findCommonParent(File root, File file1, File file2) {
        if(root == null || file1 == null || file2 == null) {
            return null;
        }

        List<File> path1 = getPath(root, new LinkedList<>(), file1);

        List<File> path2 = getPath(root, new LinkedList<>(), file2);

        if(path1 == null || path2 == null) {
            return null;
        }

        if(file1.equals(root) || file2.equals(root)) {
            return root;
        }

        File[] path1Arr = path1.toArray(new File[path1.size()]);
        File[] path2Arr = path2.toArray(new File[path2.size()]);

        int i = 0;
        int j = 0;
        while(i < path1Arr.length && j < path2Arr.length) {
            if(!path1Arr[i].equals(path2Arr[i])) {
                if(i == 0 && j == 0) {
                    return null;
                }
                return path1Arr[i-1];
            }
            i++;
            j++;
        }
        if(i < path1Arr.length) {
            if(path1Arr[i].equals(file2)) {
                return file2;
            }
            else {
                return path1Arr[i-1];
            }
        }
        else if(j < path2Arr.length) {
            if(path2Arr[j].equals(file1)) {
                return file1;
            }
            else {
                return path2Arr[j-1];
            }
        }
        else {
            return path1Arr[path1Arr.length - 1];
        }
    }

    public static List<File> getPath(File root, List<File> path, File file) {
        if(root.equals(file)) {
            return path;
        }

        path.add(root);

        for(File child : root.getChildren()) {
            List<File> pathToReturn = getPath(child, path, file);

            if(pathToReturn != null) {
                return pathToReturn;
            }
        }

        path.remove(root);

        return null;
    }
}
