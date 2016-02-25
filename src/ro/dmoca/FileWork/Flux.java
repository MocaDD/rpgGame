package ro.dmoca.FileWork;

import java.io.*;
/**
 * Created by MocaDD on 2/25/2016.
 */
public class Flux {

    public static void readAndWrite(String readFile, String writeFile)  {
        FileInputStream in;
        FileOutputStream out;

        int ok;
        try {
            in = new FileInputStream("heroes.txt");
            try {
                out = new FileOutputStream("monsters.txt");
                ok = 0;

                while (ok != -1)    {
                    try {
                        ok = in.read();
                        out.write(ok);

                        System.out.println((char)ok);
                    }
                    catch (IOException e)   {
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                }
            }
            catch (IOException e)   {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
