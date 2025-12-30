-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常', '0', '1', 'event', 'LT/event/index', 1, 0, 'C', '0', '0', 'LT:event:list', '#', 'admin', sysdate(), '', null, '运输异常菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'LT:event:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'LT:event:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'LT:event:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'LT:event:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('运输异常导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'LT:event:export',       '#', 'admin', sysdate(), '', null, '');