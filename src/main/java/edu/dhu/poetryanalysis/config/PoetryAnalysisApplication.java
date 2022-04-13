package edu.dhu.poetryanalysis.config;
import edu.dhu.poetryanalysis.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@ComponentScan("edu.dhu")
@SpringBootApplication
@MapperScan("edu.dhu.poetryanalysis.mapper")
public class PoetryAnalysisApplication {
    private static final Logger LOG = LoggerFactory.getLogger(PoetryAnalysisApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PoetryAnalysisApplication.class);
        ConfigurableApplicationContext context = app.run(args);
        Environment env = context.getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
        SpringUtil.set(context);
    }
}
