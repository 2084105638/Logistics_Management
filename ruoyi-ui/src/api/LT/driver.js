import request from '@/utils/request'

// 查询司机信息列表
export function listDriver(query) {
  return request({
    url: '/LT/driver/list',
    method: 'get',
    params: query
  })
}

// 查询司机信息详细
export function getDriver(id) {
  return request({
    url: '/LT/driver/' + id,
    method: 'get'
  })
}

// 新增司机信息
export function addDriver(data) {
  return request({
    url: '/LT/driver',
    method: 'post',
    data: data
  })
}

// 修改司机信息
export function updateDriver(data) {
  return request({
    url: '/LT/driver',
    method: 'put',
    data: data
  })
}

// 删除司机信息
export function delDriver(id) {
  return request({
    url: '/LT/driver/' + id,
    method: 'delete'
  })
}
