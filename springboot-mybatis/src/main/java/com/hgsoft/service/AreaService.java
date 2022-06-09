package com.hgsoft.service;

import com.hgsoft.entity.SysrArea;

import java.util.List;

/**
 * @author luozhengde
 */
public interface AreaService {
    List<SysrArea> findList();
    void save(SysrArea sysrArea);
}
