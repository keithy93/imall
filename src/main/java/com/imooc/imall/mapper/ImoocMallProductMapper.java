package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallProduct;
import com.imooc.imall.domain.ImoocMallProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallProductMapper {
    long countByExample(ImoocMallProductExample example);

    int deleteByExample(ImoocMallProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImoocMallProduct record);

    int insertSelective(ImoocMallProduct record);

    List<ImoocMallProduct> selectByExample(ImoocMallProductExample example);

    ImoocMallProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImoocMallProduct record, @Param("example") ImoocMallProductExample example);

    int updateByExample(@Param("record") ImoocMallProduct record, @Param("example") ImoocMallProductExample example);

    int updateByPrimaryKeySelective(ImoocMallProduct record);

    int updateByPrimaryKey(ImoocMallProduct record);
}