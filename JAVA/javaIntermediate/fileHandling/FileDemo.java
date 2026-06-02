package fileHandling;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        System.out.println("This is File Handling Demo");
        File f1 = new File("example.txt");
        try{
            f1.createNewFile();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        f1.setWritable(false);
        f1.renameTo(new File("demo.txt"));
        if(f1.exists()) {
            System.out.println("File Name: "+f1.getName());
            System.out.println("File Path: "+f1.getAbsolutePath());
            System.out.println("Is File Writable? "+f1.canWrite());
            System.out.println("Is File Readable? "+f1.canRead());
            System.out.println("File Size in Bytes: "+f1.length());
        } else {
            System.out.println("File does not exist");
        }
    }
}
