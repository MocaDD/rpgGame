package ro.dmoca.FileWork;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by MocaDD on 2/25/2016.
 */
public class Flux {

    private String fileName = "hero.txt";
    private String string = new String();
    private int index = 0;
    public void readFile() {

        String line = null;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null)  {
                this.string = line;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file" + fileName);
        } catch (IOException ex)    {
            ex.printStackTrace();
        }
    }

    public void writeFile(String writeString) {

        try {
            FileWriter fileWriter = new FileWriter(fileName);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(writeString);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex)    {
            ex.printStackTrace();
        }
    }

    public String getString() {
        return string;
    }
}
