-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单', '2003', '1', 'waybill', 'LT/waybill/index', 1, 0, 'C', '0', '0', 'LT:waybill:list', '#', 'admin', sysdate(), '', null, '运单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'LT:waybill:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'LT:waybill:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'LT:waybill:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'LT:waybill:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'LT:waybill:export',       '#', 'admin', sysdate(), '', null, '');