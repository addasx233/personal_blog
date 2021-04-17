package com.yamlapkei.controller.type_info;

import com.yamlapkei.service.type_info.TypeInfoService;
import com.yamlapkei.view.TypeInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/type_info")
public class TypeInfoController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private TypeInfoService typeInfoService;
    @RequestMapping("list.do")
    public String list(ModelMap map){
        List<TypeInfo> list = typeInfoService.list();
        map.put("list",list);
        return "admin/typeInfo/list";
    }

}


