package edu.dhu.poetryanalysis.mapper;

import edu.dhu.poetryanalysis.domain.Author;
import edu.dhu.poetryanalysis.domain.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthorMapper {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(String id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectOneByExample(AuthorExample example);

    Author selectOneByExampleSelective(@Param("example") AuthorExample example, @Param("selective") Author.Column ... selective);

    List<Author> selectByExampleSelective(@Param("example") AuthorExample example, @Param("selective") Author.Column ... selective);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") Author.Column ... selective);

    Author selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    int batchInsert(@Param("list") List<Author> list);

    int batchInsertSelective(@Param("list") List<Author> list, @Param("selective") Author.Column ... selective);
}