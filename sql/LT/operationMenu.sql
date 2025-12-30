-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志', '0', '1', 'operation', 'LT/operation/index', 1, 0, 'C', '0', '0', 'LT:operation:list', '#', 'admin', sysdate(), '', null, '操作日志菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'LT:operation:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'LT:operation:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'LT:operation:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'LT:operation:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('操作日志导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'LT:operation:export',       '#', 'admin', sysdate(), '', null, '');