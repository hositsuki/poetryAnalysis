package edu.dhu.poetryanalysis.service;


import edu.dhu.poetryanalysis.domain.Ebook;
import edu.dhu.poetryanalysis.domain.EbookExample;
import edu.dhu.poetryanalysis.mapper.EbookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list() {
        return ebookMapper.selectByExample(null);
    }
}
