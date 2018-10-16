package com.yes.dl.shop.service.impl;

import com.yes.dl.shop.db.domain.VO.FirstModule;
import com.yes.dl.shop.db.domain.VO.SecondModule;
import com.yes.dl.shop.db.mapper.IndexMapper;
import com.yes.dl.shop.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexMapper indexMapper;

    private List<String> getIds(List<FirstModule> firstModules) {
        return null;
    }

    @Override
    public List<FirstModule> findFirstAndSecondModule() {
        List<Map<String, Object>> firstAndSecondModule = indexMapper.findFirstAndSecondModule();
        Map<String, FirstModule> temp = new LinkedHashMap<>();
        for(Map<String, Object> map: firstAndSecondModule){
            String key = (String)map.get("id");
            if(!temp.containsKey(key)){
                temp.put(key,new FirstModule());
            }
            FirstModule firstModule = temp.get(key);
            firstModule.setId(key);
            firstModule.setIntro((String) map.get("intro"));
            firstModule.setUrl((String)map.get("url"));
            firstModule.setLevel((int)map.get("f_level"));

            SecondModule sm = new SecondModule();
            sm.setId((String)map.get("s_id"));
            sm.setLevel((int)map.get("s_level"));
            sm.setIntro((String)map.get("s_intro"));
            sm.setUrl((String)map.get("s_url"));
            firstModule.getSecondModules().add(sm);
        }
        List<FirstModule> lists = new ArrayList<>();
        for(Map.Entry<String, FirstModule> map: temp.entrySet()){
            lists.add(map.getValue());
        }
        return lists;
    }
}
