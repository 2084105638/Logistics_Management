-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆', '0', '1', 'vehicle', 'LT/vehicle/index', 1, 0, 'C', '0', '0', 'LT:vehicle:list', '#', 'admin', sysdate(), '', null, '车辆菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'LT:vehicle:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'LT:vehicle:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'LT:vehicle:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'LT:vehicle:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('车辆导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'LT:vehicle:export',       '#', 'admin', sysdate(), '', null, '');