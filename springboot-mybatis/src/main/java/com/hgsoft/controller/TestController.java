package com.hgsoft.controller;

import com.hgsoft.entity.SysrArea;
import com.hgsoft.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/test")
    public String test() {
        List<SysrArea> areaList = areaService.findList();
        SysrArea sysrArea = new SysrArea();
        sysrArea.setId(System.currentTimeMillis() + "");
        sysrArea.setName("test");
        areaService.save(sysrArea);
        return "ok";
    }

}
