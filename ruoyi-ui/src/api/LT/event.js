import request from '@/utils/request'

// 查询运输异常列表
export function listEvent(query) {
  return request({
    url: '/LT/event/list',
    method: 'get',
    params: query
  })
}

// 查询运输异常详细
export function getEvent(id) {
  return request({
    url: '/LT/event/' + id,
    method: 'get'
  })
}

// 新增运输异常
export function addEvent(data) {
  return request({
    url: '/LT/event',
    method: 'post',
    data: data
  })
}

// 修改运输异常
export function updateEvent(data) {
  return request({
    url: '/LT/event',
    method: 'put',
    data: data
  })
}

// 删除运输异常
export function delEvent(id) {
  return request({
    url: '/LT/event/' + id,
    method: 'delete'
  })
}
