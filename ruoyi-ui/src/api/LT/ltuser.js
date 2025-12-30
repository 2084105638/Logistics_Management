import request from '@/utils/request'

// 查询系统用户列表
export function listLtuser(query) {
  return request({
    url: '/LT/ltuser/list',
    method: 'get',
    params: query
  })
}

// 查询系统用户详细
export function getLtuser(id) {
  return request({
    url: '/LT/ltuser/' + id,
    method: 'get'
  })
}

// 新增系统用户
export function addLtuser(data) {
  return request({
    url: '/LT/ltuser',
    method: 'post',
    data: data
  })
}

// 修改系统用户
export function updateLtuser(data) {
  return request({
    url: '/LT/ltuser',
    method: 'put',
    data: data
  })
}

// 删除系统用户
export function delLtuser(id) {
  return request({
    url: '/LT/ltuser/' + id,
    method: 'delete'
  })
}
