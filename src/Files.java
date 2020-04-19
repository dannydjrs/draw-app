import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

public class Files {
    public String location;

    /**
     * Save file in following format:
     * - Line 1 = x values
     * - Line 2 = y values
     * - Line 3 = color values
     * - Line 4 = width values
     */
    public void saveFile(String paramString) {
        this.location = paramString + ".txt";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.location));
            byte b;
            for (b = 0; b < Draw.x.size(); b++)
                bufferedWriter.write(String.valueOf(Draw.x.get(b)) + " ");

            bufferedWriter.newLine();

            for (b = 0; b < Draw.y.size(); b++)
                bufferedWriter.write(String.valueOf(Draw.y.get(b)) + " ");

            bufferedWriter.newLine();

            for (b = 0; b < Draw.cols.size(); b++)
                bufferedWriter.write(String.valueOf(Draw.cols.get(b)) + " ");

            bufferedWriter.newLine();

            for (b = 0; b < Draw.w.size(); b++)
                bufferedWriter.write(String.valueOf(Draw.w.get(b)) + " ");

            bufferedWriter.close();
            JOptionPane.showMessageDialog(null, "File Sucessfully saved.");
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "You cannot do that");
        }
    }

    public void openFile(String paramString) {
        this.location = paramString + ".txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.location));
            String str1 = bufferedReader.readLine();
            String str2 = bufferedReader.readLine();
            String str3 = bufferedReader.readLine();
            String str4 = bufferedReader.readLine();
            bufferedReader.close();

            String[] arrayOfString1 = str1.split(" ");
            String[] arrayOfString2 = str2.split(" ");
            String[] arrayOfString3 = str3.split(" ");
            String[] arrayOfString4 = str4.split(" ");
            for (String str : arrayOfString1)
                Draw.x.add(str);
            for (String str : arrayOfString2)
                Draw.y.add(str);
            for (String str : arrayOfString3)
                Draw.cols.add(str);
            for (String str : arrayOfString4)
                Draw.w.add(str);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "There was an error");
        }
    }
}
