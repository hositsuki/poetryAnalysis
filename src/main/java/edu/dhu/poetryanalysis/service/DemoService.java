package edu.dhu.poetryanalysis.service;

import edu.dhu.poetryanalysis.domain.Demo;
import edu.dhu.poetryanalysis.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper demoMapper;

    public List<Demo> list() {
        return demoMapper.selectByExample(null);
    }
}
