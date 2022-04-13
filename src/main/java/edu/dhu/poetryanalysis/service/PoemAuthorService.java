package edu.dhu.poetryanalysis.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.dhu.poetryanalysis.domain.Author;
import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.mapper.AuthorMapper;
import edu.dhu.poetryanalysis.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class PoemAuthorService {
    @Resource
    private AuthorMapper authorMapper;
    String path = "D:\\author";

    public void writeToSQL() {
        ArrayList<String> files = CommonUtils.getFiles(path);
        for (String iter : files) {
            try {
                JsonArray array = JsonParser.parseReader(new FileReader(iter)).getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    JsonObject obj = array.get(i).getAsJsonObject();
                    Author author1 = new Author();
                    author1.setId(obj.get("id").getAsString());
                    author1.setName(obj.get("name").getAsString());
                    author1.setDesc(obj.get("desc").getAsString());
                    System.out.println(author1);
                    authorMapper.insert(author1);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
