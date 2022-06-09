package com.hgsoft.mapper;

import com.hgsoft.entity.SysrArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 区域表信息MAPPER接口
 * @author draghu
 * @version 2020-04-26 03:08:13
 */
@Mapper
public interface SysrAreaMapper {
    @Select("select * from area")
    List<SysrArea> findList();

    void save(SysrArea sysrArea);
}
