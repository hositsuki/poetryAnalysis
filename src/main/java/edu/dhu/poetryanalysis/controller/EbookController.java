package edu.dhu.poetryanalysis.controller;


import edu.dhu.poetryanalysis.domain.Ebook;
import edu.dhu.poetryanalysis.res.CommonRes;
import edu.dhu.poetryanalysis.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonRes list() {
        CommonRes<List<Ebook>> res = new CommonRes<>();
        List<Ebook> list = ebookService.list();
        res.setContent(list);
        return res;
    }
}
