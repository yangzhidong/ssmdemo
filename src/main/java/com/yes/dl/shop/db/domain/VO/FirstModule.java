package com.yes.dl.shop.db.domain.VO;

import com.yes.dl.shop.db.domain.SysModule;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Alias("firstModule")
public class FirstModule extends SysModule {

    private List<SecondModule> secondModules = new ArrayList<>();

    public List<SecondModule> getSecondModules() {
        return secondModules;
    }

    public void setSecondModules(List<SecondModule> secondModules) {
        this.secondModules = secondModules;
    }

    @Override
    public String toString() {
        return "FirstModule{" + super.toString() +
                ",secondModules=" + secondModules +
                '}';
    }
}
