import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ObjectFileProcessing {

    public void storeObject(Object a, String s){
        OutputStream ops = null;
        ObjectOutputStream objOps = null;
        try {
            //the name of the text file can be changed to whatever's convenient
            ops = new FileOutputStream(s);
            objOps = new ObjectOutputStream(ops);
            //writing the client into the text file
            objOps.writeObject(a);
            objOps.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readObject(String s) throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(new File(s));
        int a = fis.read();
        fis.close();
        return a;
    }

    public void storeGarage(int[][] a) throws IOException{
        FileOutputStream fos = new FileOutputStream(new File("arrayData.txt"));
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                fos.write(String.valueOf(a[i][j]).getBytes());
            }
            fos.write(System.getProperty("line.separator").getBytes());
        }
        fos.close();
    } 
    

    public int[][] importGarage(int rows, int columns) throws FileNotFoundException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader("arrayData.txt")));
        int [][] Garage = new int[rows][columns];
        int i =0;
        while (sc.hasNextLine()){
                String woop = sc.nextLine();
                System.out.println(woop);
                String[] line = woop.trim().split(" ");
                for (int j=0; j<line.length; j++){
                    Garage[i][j] = Integer.parseInt(line[j]);
                }
                i++;
            }
        return Garage;
}

}

