package org.jeecg.modules.router.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.router.entity.GoRouter;
import org.jeecg.modules.router.mapper.GoRouterMapper;
import org.jeecg.modules.router.service.IGoRouterService;
import org.springframework.stereotype.Service;

/**
 * @Description: GO路由管理
 * @Author: jeecg-boot
 * @Date: 2024-01-01
 * @Version: V1.0
 */
@Service
public class GoRouterServiceImpl extends ServiceImpl<GoRouterMapper, GoRouter> implements IGoRouterService {

    @Override
    public GoRouter getByPort(int reqPort) {
        return this.getOne(new LambdaQueryWrapper<GoRouter>().eq(GoRouter::getReqPort, StrUtil.toString(reqPort)));
    }
}
