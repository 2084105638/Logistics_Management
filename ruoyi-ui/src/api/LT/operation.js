import request from '@/utils/request'

// 查询操作日志列表
export function listOperation(query) {
  return request({
    url: '/LT/operation/list',
    method: 'get',
    params: query
  })
}

// 查询操作日志详细
export function getOperation(id) {
  return request({
    url: '/LT/operation/' + id,
    method: 'get'
  })
}

// 新增操作日志
export function addOperation(data) {
  return request({
    url: '/LT/operation',
    method: 'post',
    data: data
  })
}

// 修改操作日志
export function updateOperation(data) {
  return request({
    url: '/LT/operation',
    method: 'put',
    data: data
  })
}

// 删除操作日志
export function delOperation(id) {
  return request({
    url: '/LT/operation/' + id,
    method: 'delete'
  })
}
