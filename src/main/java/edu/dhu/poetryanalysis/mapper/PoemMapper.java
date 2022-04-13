package edu.dhu.poetryanalysis.mapper;

import edu.dhu.poetryanalysis.domain.Poem;
import edu.dhu.poetryanalysis.domain.PoemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PoemMapper {
    long countByExample(PoemExample example);

    int deleteByExample(PoemExample example);

    int deleteByPrimaryKey(String id);

    int insert(Poem record);

    int insertSelective(Poem record);

    List<Poem> selectByExample(PoemExample example);

    Poem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Poem record, @Param("example") PoemExample example);

    int updateByExample(@Param("record") Poem record, @Param("example") PoemExample example);

    int updateByPrimaryKeySelective(Poem record);

    int updateByPrimaryKey(Poem record);
}