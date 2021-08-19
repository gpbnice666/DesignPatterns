package com.bo.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bo.spring.mapper.DdMapper;
import com.bo.spring.pojo.Dd;
import com.bo.spring.service.DdService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HM
 * @since 2021-07-07
 */
@Service
public class DdServiceImpl extends ServiceImpl<DdMapper, Dd> implements DdService {

    @Override
    public void add() throws Exception {
        Dd dd = new Dd();
        dd.setA("123");
        dd.setAb(new Date());
        this.save(dd);
        throw new Exception();
    }
}
