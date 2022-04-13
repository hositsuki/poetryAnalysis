package edu.dhu.poetryanalysis.service;

import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.domain.PoemExample;
import edu.dhu.poetryanalysis.mapper.PoemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PoemService {

    @Resource
    private PoemMapper poemMapper;

    public List<Poem> list(String title) {
        PoemExample example = new PoemExample();
        PoemExample.Criteria criteria = example.createCriteria();
        criteria.andTitleEqualTo(title);
        return poemMapper.selectByExample(example);
    }
}
