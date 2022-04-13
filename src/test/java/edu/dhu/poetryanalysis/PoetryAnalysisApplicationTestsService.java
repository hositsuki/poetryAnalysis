package edu.dhu.poetryanalysis;

import edu.dhu.poetryanalysis.service.WritePoemService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class PoetryAnalysisApplicationTestsService {

    @Resource
    WritePoemService writePoemService;
    @Test
    void contextLoads() {
        writePoemService.writeToSQL();
    }

}
