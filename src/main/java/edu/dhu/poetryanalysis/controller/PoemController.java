package edu.dhu.poetryanalysis.controller;

import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.res.CommonRes;
import edu.dhu.poetryanalysis.service.PoemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/poem")
public class PoemController {
    @Resource
    private PoemService poemService;

    @GetMapping("/list")
    public CommonRes list(String title) {
        CommonRes<List<Poem>> res = new CommonRes<>();
        List<Poem> list = poemService.list(title);
        res.setContent(list);
        return res;
    }
}
