package edu.dhu.poetryanalysis.mapper;

import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.domain.PoemExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PoemMapper {
    long countByExample(PoemExample example);

    int deleteByExample(PoemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Poem record);

    int insertSelective(Poem record);

    Poem selectOneByExample(PoemExample example);

    Poem selectOneByExampleSelective(@Param("example") PoemExample example, @Param("selective") Poem.Column ... selective);

    List<Poem> selectByExampleSelective(@Param("example") PoemExample example, @Param("selective") Poem.Column ... selective);

    List<Poem> selectByExample(PoemExample example);

    Poem selectByPrimaryKeySelective(@Param("id") String id, @Param("selective") Poem.Column ... selective);

    Poem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Poem record, @Param("example") PoemExample example);

    int updateByExample(@Param("record") Poem record, @Param("example") PoemExample example);

    int updateByPrimaryKeySelective(Poem record);

    int updateByPrimaryKey(Poem record);

    int batchInsert(@Param("list") List<Poem> list);

    int batchInsertSelective(@Param("list") List<Poem> list, @Param("selective") Poem.Column ... selective);
}