package edu.dhu.poetryanalysis.service;

import edu.dhu.poetryanalysis.domain.Author;
import edu.dhu.poetryanalysis.domain.AuthorExample;
import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.mapper.AuthorMapper;
import edu.dhu.poetryanalysis.mapper.PoemMapper;
import edu.dhu.poetryanalysis.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static edu.dhu.poetryanalysis.util.CommonUtils.ins;
public class UserThread implements Runnable {
    Logger logger = LoggerFactory.getLogger(UserThread.class);

    CountDownLatch cdl;
    List<Poem> userList;

//    @Autowired
//    private PoemMapper userMapper;
//    @Autowired
//    private AuthorMapper authorMapper;

    public UserThread(CountDownLatch cdl, List<Poem> userList) {
        this.cdl = cdl;
        this.userList = userList;
    }

    @Override
    public void run() {
        PoemMapper userMapper = (PoemMapper) SpringUtil.getBean("poemMapper");
        AuthorMapper authorMapper = (AuthorMapper) SpringUtil.getBean("authorMapper");
        userList.forEach(
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
        userMapper.batchInsert(userList);
        logger.info("插入成功，当前线程是:" + Thread.currentThread().getName());
        cdl.countDown();
    }
}
