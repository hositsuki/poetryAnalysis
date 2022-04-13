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
import static edu.dhu.poetryanalysis.util.CommonUtils.ins;

@Service
public class WritePoemService implements Runnable{

    @Resource
    private PoemMapper poemMapper;
    @Resource
    private AuthorMapper authorMapper;

    public void writeToSQL() {
        ins.forEach(
                obj->{
                    AuthorExample authorExample = new AuthorExample();
                    AuthorExample.Criteria criteria = authorExample.createCriteria();
                    criteria.andNameEqualTo(obj.getAuthorName());
                    List<Author> list = authorMapper.selectByExample(authorExample);
                    if (!list.isEmpty()) {
                        obj.setAuthor(list.get(0).getId());
                    }
                }
        );
        poemMapper.batchInsert(ins);
    }



    @Override
    public void run() {

    }
}
