package edu.dhu.poetryanalysis.controller;


import edu.dhu.poetryanalysis.domain.Ebook;
import edu.dhu.poetryanalysis.res.CommonRes;
import edu.dhu.poetryanalysis.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;
    @Resource
    private WritePoemService writePoemService;

    @Resource
    private UserService userService;

    private final AnalysisService analysisService = AnalysisService.getInstance();

    @GetMapping("/list")
    public CommonRes list(String name) {
        CommonRes<List<Ebook>> res = new CommonRes<>();
        List<Ebook> list = ebookService.list(name);
        res.setContent(list);
        return res;
    }

    @GetMapping("/test")
    public CommonRes analysis(String text) {
        CommonRes<String> res = new CommonRes<>();
        res.setContent(analysisService.getRes(text));
        System.out.println("结束！");
        return res;
    }
}
