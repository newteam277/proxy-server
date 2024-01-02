package org.jeecg.modules.router.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.router.entity.GoRouter;

/**
 * @Description: GO路由管理
 * @Author: jeecg-boot
 * @Date: 2024-01-01
 * @Version: V1.0
 */
public interface IGoRouterService extends IService<GoRouter> {

    GoRouter getByPort(int reqPort);
}
