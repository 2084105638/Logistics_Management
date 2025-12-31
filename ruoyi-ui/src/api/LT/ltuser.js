import request from '@/utils/request'
import {parseStrEmpty} from "@/utils/ruoyi";

// ==================== 基础CRUD操作 ====================

// 查询系统用户列表
export function listUser(query) {
  return request({
    url: '/LT/ltuser/list',
    method: 'get',
    params: query
  })
}

// 查询系统用户详细
export function getUser(id) {
  return request({
    url: '/LT/ltuser/' + parseStrEmpty(id),
    method: 'get'
  })
}

// 新增系统用户
export function addUser(data) {
  return request({
    url: '/LT/ltuser',
    method: 'post',
    data: data
  })
}

// 修改系统用户
export function updateUser(data) {
  return request({
    url: '/LT/ltuser',
    method: 'put',
    data: data
  })
}

// 删除系统用户（单个）
export function delUser(id) {
  return request({
    url: '/LT/ltuser/' + id,
    method: 'delete'
  })
}

// 删除系统用户（批量）
export function delUsers(ids) {
  return request({
    url: '/LT/ltuser/' + ids,
    method: 'delete'
  })
}

// ==================== 导出数据 ====================

// 导出系统用户列表
export function exportUser(query) {
  return request({
    url: '/LT/ltuser/export',
    method: 'post',
    params: query,
    responseType: 'blob'
  })
}

// ==================== 用户身份验证 ====================

// 用户登录
export function login(data) {
  return request({
    url: '/auth/login',
    method: 'post',
    data: data
  })
}

// 用户登出
export function logout() {
  return request({
    url: '/auth/logout',
    method: 'post'
  })
}

// 获取当前用户个人信息
export function getUserProfile() {
  return request({
    url: '/LT/ltuser/profile',
    method: 'get'
  })
}

//注册
export function register(data) {
  return request({
    url: '/LT/ltuser/register',
    method: 'post'
  })
}

// ==================== 用户密码管理 ====================

// 修改用户密码（当前用户个人修改）
export function updateUserPassword(oldPassword, newPassword) {
  const data = {
    oldPassword,
    newPassword
  }
  return request({
    url: '/LT/ltuser/profile/updatePwd',
    method: 'put',
    data: data
  })
}

// 重置用户密码（管理员重置）
export function resetUserPassword(id, password) {
  const data = {
    id,
    password
  }
  return request({
    url: '/LT/ltuser/resetPwd',
    method: 'put',
    data: data
  })
}

// ==================== 用户状态管理 ====================

// 修改用户状态（启用/禁用）
export function changeUserStatus(id, status) {
  const data = {
    id,
    status
  }
  return request({
    url: '/LT/ltuser/changeStatus',
    method: 'put',
    data: data
  })
}

// ==================== 用户角色管理 ====================

// 查询用户授权角色信息
export function getAuthRole(id) {
  return request({
    url: '/LT/ltuser/authRole/' + id,
    method: 'get'
  })
}

// 保存用户授权的角色信息
export function updateAuthRole(data) {
  return request({
    url: '/LT/ltuser/authRole',
    method: 'put',
    params: data
  })
}

// 查询角色下拉列表
export function getRoleList() {
  return request({
    url: '/LT/ltuser/roleList',
    method: 'get'
  })
}

// ==================== 用户头像管理 ====================

// 用户头像上传
export function uploadAvatar(data) {
  return request({
    url: '/LT/ltuser/profile/avatar',
    method: 'post',
    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
    data: data
  })
}

// ==================== 用户信息修改 ====================

// 修改用户个人信息（当前用户）
export function updateUserProfile(data) {
  return request({
    url: '/LT/ltuser/profile',
    method: 'put',
    data: data
  })
}
