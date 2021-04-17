package com.yamlapkei.service.type_info;

import com.yamlapkei.dao.type_info.TypeInfoDao;
import com.yamlapkei.view.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TypeInfoService")
public class TypeInfoService {
    @Autowired
    private TypeInfoDao typeInfoDao;
    public List<TypeInfo> list(){
        return typeInfoDao.findAllType();
    }

}
