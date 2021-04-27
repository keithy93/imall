package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallOrderItem;
import com.imooc.imall.domain.ImoocMallOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallOrderItemMapper {
    long countByExample(ImoocMallOrderItemExample example);

    int deleteByExample(ImoocMallOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImoocMallOrderItem record);

    int insertSelective(ImoocMallOrderItem record);

    List<ImoocMallOrderItem> selectByExample(ImoocMallOrderItemExample example);

    ImoocMallOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImoocMallOrderItem record, @Param("example") ImoocMallOrderItemExample example);

    int updateByExample(@Param("record") ImoocMallOrderItem record, @Param("example") ImoocMallOrderItemExample example);

    int updateByPrimaryKeySelective(ImoocMallOrderItem record);

    int updateByPrimaryKey(ImoocMallOrderItem record);
}