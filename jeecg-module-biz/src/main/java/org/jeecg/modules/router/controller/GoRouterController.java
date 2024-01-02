package org.jeecg.modules.router.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.router.entity.GoRouter;
import org.jeecg.modules.router.service.IGoRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Description: GO路由管理
 * @Author: jeecg-boot
 * @Date: 2024-01-01
 * @Version: V1.0
 */
@Api(tags = "GO路由管理")
@RestController
@RequestMapping("/router/goRouter")
@Slf4j
public class GoRouterController extends JeecgController<GoRouter, IGoRouterService> {
	@Autowired
	private IGoRouterService goRouterService;

	/**
	 * 分页列表查询
	 *
	 * @param goRouter
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "GO路由管理-分页列表查询")
	@ApiOperation(value = "GO路由管理-分页列表查询", notes = "GO路由管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<GoRouter>> queryPageList(GoRouter goRouter,
												 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
												 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
												 HttpServletRequest req) {
		QueryWrapper<GoRouter> queryWrapper = QueryGenerator.initQueryWrapper(goRouter, req.getParameterMap());
		Page<GoRouter> page = new Page<GoRouter>(pageNo, pageSize);
		IPage<GoRouter> pageList = goRouterService.page(page, queryWrapper);
		return Result.OK(pageList);
	}

	/**
	 * 添加
	 *
	 * @param goRouter
	 * @return
	 */
	@AutoLog(value = "GO路由管理-添加")
	@ApiOperation(value = "GO路由管理-添加", notes = "GO路由管理-添加")
	@RequiresPermissions("router:go_router:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody GoRouter goRouter) {
		goRouterService.save(goRouter);
		return Result.OK("添加成功！");
	}

	/**
	 * 编辑
	 *
	 * @param goRouter
	 * @return
	 */
	@AutoLog(value = "GO路由管理-编辑")
	@ApiOperation(value = "GO路由管理-编辑", notes = "GO路由管理-编辑")
	@RequiresPermissions("router:go_router:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
	public Result<String> edit(@RequestBody GoRouter goRouter) {
		goRouterService.updateById(goRouter);
		return Result.OK("编辑成功!");
	}

	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "GO路由管理-通过id删除")
	@ApiOperation(value = "GO路由管理-通过id删除", notes = "GO路由管理-通过id删除")
	@RequiresPermissions("router:go_router:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
		goRouterService.removeById(id);
		return Result.OK("删除成功!");
	}

	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "GO路由管理-批量删除")
	@ApiOperation(value = "GO路由管理-批量删除", notes = "GO路由管理-批量删除")
	@RequiresPermissions("router:go_router:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
		this.goRouterService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}

	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "GO路由管理-通过id查询")
	@ApiOperation(value = "GO路由管理-通过id查询", notes = "GO路由管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<GoRouter> queryById(@RequestParam(name = "id", required = true) String id) {
		GoRouter goRouter = goRouterService.getById(id);
		if (goRouter == null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(goRouter);
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param goRouter
	 */
	@RequiresPermissions("router:go_router:exportXls")
	@RequestMapping(value = "/exportXls")
	public ModelAndView exportXls(HttpServletRequest request, GoRouter goRouter) {
		return super.exportXls(request, goRouter, GoRouter.class, "GO路由管理");
	}

	/**
	 * 通过excel导入数据
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("router:go_router:importExcel")
	@RequestMapping(value = "/importExcel", method = RequestMethod.POST)
	public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
		return super.importExcel(request, response, GoRouter.class);
	}

}
