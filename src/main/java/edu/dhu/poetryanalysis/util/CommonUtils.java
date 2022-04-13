package edu.dhu.poetryanalysis.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.dhu.poetryanalysis.domain.Author;
import edu.dhu.poetryanalysis.domain.AuthorExample;
import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.service.WritePoemService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonUtils {

    public static String path = "C:\\Users\\雪桜Sayu\\IdeaProjects\\chinese-poetry\\json";
    public static List<Poem> ins = new ArrayList<>();
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();

        for (int i = 0; i < Objects.requireNonNull(tempList).length; i++) {
            if (tempList[i].isFile()) {
//              System.out.println("file:" + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
//              System.out.println("文件夹：" + tempList[i]);
            }
        }
        return files;
    }
    public static void insSQL() {
        ArrayList<String> files = getFiles(path);
        for (String iter : files) {
            try {
                JsonArray array = JsonParser.parseReader(new FileReader(iter)).getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    JsonObject obj = array.get(i).getAsJsonObject();
                    String id = obj.get("id").getAsString();
                    String author = obj.get("author").getAsString();
                    JsonArray paragraphs = obj.get("paragraphs").getAsJsonArray();
                    StringBuilder par = new StringBuilder();
                    for (int j = 0; j < paragraphs.size(); j++) {
                        par.append(paragraphs.get(j).getAsString());
                        par.append('\n');
                    }
                    String title = obj.get("title").getAsString();
                    Poem poem = new Poem();
                    poem.setId(id);
                    poem.setAuthorName(author);
                    poem.setParagraphs(par.toString());
                    poem.setTitle(title);
                    ins.add(poem);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
