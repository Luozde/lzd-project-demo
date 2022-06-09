package com.hgsoft.service.impl;

import com.hgsoft.entity.SysrArea;
import com.hgsoft.mapper.SysrAreaMapper;
import com.hgsoft.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luozhengde
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private SysrAreaMapper sysrAreaMapper;

    @Override
    public List<SysrArea> findList() {
        return sysrAreaMapper.findList();
    }

    @Override
    public void save(SysrArea sysrArea) {
        sysrAreaMapper.save(sysrArea);
    }
}
