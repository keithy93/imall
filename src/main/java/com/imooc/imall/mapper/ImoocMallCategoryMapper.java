package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallCategory;
import com.imooc.imall.domain.ImoocMallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallCategoryMapper {
    long countByExample(ImoocMallCategoryExample example);

    int deleteByExample(ImoocMallCategoryExample example);

    int insert(ImoocMallCategory record);

    int insertSelective(ImoocMallCategory record);

    List<ImoocMallCategory> selectByExample(ImoocMallCategoryExample example);

    int updateByExampleSelective(@Param("record") ImoocMallCategory record, @Param("example") ImoocMallCategoryExample example);

    int updateByExample(@Param("record") ImoocMallCategory record, @Param("example") ImoocMallCategoryExample example);
}