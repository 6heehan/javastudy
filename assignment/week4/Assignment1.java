// 11-2_6heehan
// 한 준 희

package assignment.week4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Assignment1 {
    
    public static void main(String[] args) {

        long totalCount = 127;
        long pageIndex = 12;

        Pager pager = new Pager(totalCount,pageIndex,10);
        System.out.println(pager.html(pageIndex));

        try{
            File file = new File("index.html");
            //BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "UTF-8"));
            writer.write("<head>\n");
            writer.write("<meta charset=\"UTF-8\" />\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write(pager.html(pageIndex));
            writer.write("</body>\n");
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
