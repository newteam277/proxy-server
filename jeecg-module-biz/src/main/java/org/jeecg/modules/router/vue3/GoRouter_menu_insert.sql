-- 注意：该页面对应的前台目录为views/router文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type,
                           sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description,
                           status, del_flag, rule_flag, create_by, create_time, update_by, update_time,
                           internal_or_external)
VALUES ('2024010111234520480', NULL, 'GO路由管理', '/router/goRouterList', 'router/GoRouterList', NULL, NULL, 0, NULL,
        '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-01-01 23:23:48', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520481', '2024010111234520480', '添加GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL, NULL, 0, 0,
        '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520482', '2024010111234520480', '编辑GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL, NULL, 0, 0,
        '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520483', '2024010111234520480', '删除GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL, NULL, 0,
        0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520484', '2024010111234520480', '批量删除GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL,
        NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520485', '2024010111234520480', '导出excel_GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL, NULL,
        0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms,
                           perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description,
                           create_by, create_time, update_by, update_time, del_flag, rule_flag, status,
                           internal_or_external)
VALUES ('2024010111234520486', '2024010111234520480', '导入excel_GO路由管理', NULL, NULL, 0, NULL, NULL, 2,
        'router:go_router:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-01-01 23:23:48', NULL,
        NULL, 0, 0, '1', 0);