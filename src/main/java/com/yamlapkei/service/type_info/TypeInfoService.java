package com.yamlapkei.service.type_info;

import com.mysql.jdbc.StringUtils;
import com.yamlapkei.dao.type_info.TypeInfoDao;
import com.yamlapkei.view.TypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TypeInfoService")
public class TypeInfoService {
    @Autowired
    private TypeInfoDao typeInfoDao;
//批量更新
    public void save(String[] idArr, String[] sortArr, String[] nameArr) {
        for (int i = 0; i < idArr.length; i++) {
            //判断更新还是插入
            if (StringUtils.isEmptyOrWhitespaceOnly(idArr[i])){
                //插入
                typeInfoDao.insert(sortArr[i],nameArr[i]);
            }else {
                //更新
                typeInfoDao.update(idArr[i],sortArr[i],nameArr[i]);
            }
        }
    }

//    查询所有文章
    public List<TypeInfo> list(){
        return typeInfoDao.findAllType();
    }

}
