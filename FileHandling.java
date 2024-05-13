import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;
        FileOutputStream fout;
        try{
            fin=new FileInputStream(args[0]);
            fout=new FileOutputStream(args[1]);
        }
        catch(FileNotFoundException e){
            System.out.println("No such file");
            return;
        }
        try{
            i=fin.read();
            while(i!=-1){
                if(i==-1)
                System.out.println("file is now empty");
                else
                 fout.write(i);
                i=fin.read();
            }
        }
        catch(IOException e){
            System.out.println("error in file operation");
        }
        finally{
            try{
                fin.close();
                fout.close();
            }
            catch(Exception e){
                System.out.println("error in closing file");
            }
        }
    }
}
