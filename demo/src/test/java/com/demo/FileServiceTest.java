package demo.src.test.java.com.demo;

import demo.src.main.java.com.demo.File;
import demo.src.main.java.com.demo.FileService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.LinkedList;
import java.util.List;

import demo.src.main.java.com.demo.File;

/**
 * Unit test for simple App.
 */
public class FileServiceTest 
{
    /**
     * Rigorous Test :-)
     */
    /** root
        |
        |_ A
           |_ A1
              |_ A11
              |_ A12
           |_ A2
              |_ A21
        |_ B
           |_ B1
              |_ B11
              |_ B12
           |_ B2

     */
    private File root;
    private File directoryA;
    private File directoryA1;
    private File directoryA11;
    private File directoryA12;
    private File directoryA2;
    private File directoryA21;
    private File directoryB;
    private File directoryB1;
    private File directoryB11;
    private File directoryB12;
    private File directoryB2;
    
    public FileServiceTest() {

    }

    @BeforeEach
    public void setup() {
        root = new File("root"); //creates root directory
        createAndAddChildrenOfRootDirectory();
        createAndAddChildrenOfDirectoryA();
        createAndAddChildrenOfDirectoryA1();
        createAndAddChildrenOfDirectoryA2();
        createAndAddChildrenOfDirectoryB();
        createAndAddChildrenOfDirectoryB1();
    }

    private void createAndAddChildrenOfRootDirectory() {
        directoryA = new File("a"); //create directory A
        directoryB = new File("b"); // create directory B
        root.addChild(directoryA); //add directory A as a child of root
        root.addChild(directoryB); //add directory B as a child of root
    }

    private void createAndAddChildrenOfDirectoryA() {
        directoryA1 = new File("a1");
        directoryA2 = new File("a2");
        directoryA.addChild(directoryA1); //add directory A1 as a child of directory A
        directoryA.addChild(directoryA2); //add directory A2 as a child of directory A
    }

    private void createAndAddChildrenOfDirectoryA1() {
        directoryA11 = new File("a11"); 
        directoryA12 = new File("a12");
        directoryA1.addChild(directoryA11); //add directory A11 as a child of directory A1
        directoryA1.addChild(directoryA12); //add directory A12 as a child of directory A1
    }

    private void createAndAddChildrenOfDirectoryA2() {
        directoryA21 = new File("a21");
        directoryA2.addChild(directoryA21); //add directory A21 as a child of directory A2
    }

    private void createAndAddChildrenOfDirectoryB() {
        directoryB1 = new File("b1");
        directoryB2 = new File("b2");
        directoryB.addChild(directoryB1);
        directoryB.addChild(directoryB2);
    }

    private void createAndAddChildrenOfDirectoryB1() {
        directoryB11 = new File("b11");
        directoryB12 = new File("b12");
        directoryB1.addChild(directoryB11);
        directoryB1.addChild(directoryB12);
    }


    @Test
    public void shouldReturnRootDirectoryForDirectoryAAndDirectoryB()
    {
        File commonFile = FileService.findCommonParent(root, directoryA, directoryB);
        assertEquals(root, commonFile);
    }

    @Test
    public void shouldReturnDirectoryAForDirectoryA1AndDirectoryA2() {
        File commonFile = FileService.findCommonParent(root, directoryA1, directoryA2);
        assertEquals(directoryA, commonFile);
    }

    @Test
    public void shouldReturnDirectoryAForDirectoryA11AndDirectoryA21() {
        File commonFile = FileService.findCommonParent(root, directoryA11, directoryA21);
        assertEquals(directoryA, commonFile);
    }

    @Test
    public void shouldReturnRootForDirectoryB1AndDirectoryA11() {
        File commonFile = FileService.findCommonParent(root, directoryA11, directoryB1);
        assertEquals(root, commonFile);
    }

    @Test
    public void shouldReturnRootForDirectoryB11AndDirectoryA() {
        File commonFile = FileService.findCommonParent(root, directoryA, directoryB11);
        assertEquals(root, commonFile);
    }

    @Test
    public void shouldReturnNullForNullParam() {
        File commonFile = FileService.findCommonParent(root, null, directoryB1);
        assertNull(commonFile);
    }

    @Test
    public void shouldReturnNullForNotExistentFile() {
        File fileNotExist = new File("Not exist");
        File commonFile = FileService.findCommonParent(root, directoryA, fileNotExist);
        assertNull(commonFile);
    }

    @Test
    public void shouldReturnRootParamWhenIsUsed() {
        File commonFile = FileService.findCommonParent(root, root, directoryB1);
        assertEquals(root, commonFile);
    }

    @Test
    public void shouldReturnDirectoryBForDirectoryB11AndDirectoryB2() {
        File commonFile = FileService.findCommonParent(root, directoryB11, directoryB2);
        assertEquals(directoryB, commonFile);
    }
}
