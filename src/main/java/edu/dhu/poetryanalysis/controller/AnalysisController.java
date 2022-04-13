package edu.dhu.poetryanalysis.controller;

import edu.dhu.poetryanalysis.service.AnalysisService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;


}
