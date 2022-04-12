package edu.dhu.poetryanalysis.service;

import edu.dhu.poetryanalysis.domain.Test;
import edu.dhu.poetryanalysis.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public List<Test> list() {
        return testMapper.selectByExample(null);
    }
}
