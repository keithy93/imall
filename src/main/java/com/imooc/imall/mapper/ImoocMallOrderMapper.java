package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallOrder;
import com.imooc.imall.domain.ImoocMallOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallOrderMapper {
    long countByExample(ImoocMallOrderExample example);

    int deleteByExample(ImoocMallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImoocMallOrder record);

    int insertSelective(ImoocMallOrder record);

    List<ImoocMallOrder> selectByExample(ImoocMallOrderExample example);

    ImoocMallOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImoocMallOrder record, @Param("example") ImoocMallOrderExample example);

    int updateByExample(@Param("record") ImoocMallOrder record, @Param("example") ImoocMallOrderExample example);

    int updateByPrimaryKeySelective(ImoocMallOrder record);

    int updateByPrimaryKey(ImoocMallOrder record);
}