// 11-2_6heehan
// 한 준 희
package assignment.week2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Assignment1 {
    public static void main(String[] args) {

        try {
            File file = new File("index.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<head>\n");
            writer.write("<meta charset=\"UTF-8\" />\n");
            writer.write("<style>\n");
            writer.write("table { border-collapse: collapse; width: 100%; }\n");
            writer.write("th, td { border: solid 1px #000; }\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h1>자바 환경정보</h1>\n");
            writer.write("<table>\n");
            writer.write("<th>키</th>\n");
            writer.write("<th>값</th>\n");
            for ( Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("<tr>\n");
                writer.write("<td>"+key+"</td>\n");
                writer.write("<td>"+value+"</td>\n");
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}