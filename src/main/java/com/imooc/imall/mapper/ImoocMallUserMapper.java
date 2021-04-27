package com.imooc.imall.mapper;

import com.imooc.imall.domain.ImoocMallUser;
import com.imooc.imall.domain.ImoocMallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoocMallUserMapper {
    long countByExample(ImoocMallUserExample example);

    int deleteByExample(ImoocMallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImoocMallUser record);

    int insertSelective(ImoocMallUser record);

    List<ImoocMallUser> selectByExample(ImoocMallUserExample example);

    ImoocMallUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImoocMallUser record, @Param("example") ImoocMallUserExample example);

    int updateByExample(@Param("record") ImoocMallUser record, @Param("example") ImoocMallUserExample example);

    int updateByPrimaryKeySelective(ImoocMallUser record);

    int updateByPrimaryKey(ImoocMallUser record);

    ImoocMallUser selectByName(String username);
}