package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallCart;
import com.imooc.imall.domain.ImoocMallCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallCartMapper {
    long countByExample(ImoocMallCartExample example);

    int deleteByExample(ImoocMallCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImoocMallCart record);

    int insertSelective(ImoocMallCart record);

    List<ImoocMallCart> selectByExample(ImoocMallCartExample example);

    ImoocMallCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImoocMallCart record, @Param("example") ImoocMallCartExample example);

    int updateByExample(@Param("record") ImoocMallCart record, @Param("example") ImoocMallCartExample example);

    int updateByPrimaryKeySelective(ImoocMallCart record);

    int updateByPrimaryKey(ImoocMallCart record);
}