package edu.dhu.poetryanalysis.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.dhu.poetryanalysis.domain.Author;
import edu.dhu.poetryanalysis.domain.AuthorExample;
import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.mapper.AuthorMapper;
import edu.dhu.poetryanalysis.mapper.PoemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static edu.dhu.poetryanalysis.util.CommonUtils.getFiles;

@Service
public class WritePoemService {

    @Resource
    private PoemMapper poemMapper;
    @Resource
    private AuthorMapper authorMapper;

    String path = "C:\\Users\\雪桜Sayu\\IdeaProjects\\chinese-poetry\\json";


    public void writeToSQL() {
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
                    AuthorExample authorExample = new AuthorExample();
                    AuthorExample.Criteria criteria = authorExample.createCriteria();
                    criteria.andNameEqualTo(author);
                    List<Author> list = authorMapper.selectByExample(authorExample);
                    if (!list.isEmpty()) {
                        poem.setAuthor(list.get(0).getId());
                    }
                    poemMapper.insert(poem);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
