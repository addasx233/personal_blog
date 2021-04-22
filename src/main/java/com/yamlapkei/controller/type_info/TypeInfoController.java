package com.yamlapkei.controller.type_info;

import com.mysql.jdbc.StringUtils;
import com.yamlapkei.dao.type_info.TypeInfoDao;
import com.yamlapkei.service.type_info.TypeInfoService;
import com.yamlapkei.view.Result;
import com.yamlapkei.view.TypeInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/save.json")
    @ResponseBody
    public Result save(@RequestParam(value = "idArr" ) String[] idArr,
                       @RequestParam(value = "sortArr") String[] sortArr,
                       @RequestParam(value = "nameArr") String[] nameArr){
        typeInfoService.save(idArr,sortArr,nameArr);
        return Result.success();
    }

}


