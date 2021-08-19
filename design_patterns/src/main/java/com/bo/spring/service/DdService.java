package com.bo.spring.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bo.spring.pojo.Dd;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HM
 * @since 2021-07-07
 */
public interface DdService extends IService<Dd> {

    void add() throws Exception;
}
