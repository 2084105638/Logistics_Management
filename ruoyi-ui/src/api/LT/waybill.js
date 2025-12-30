import request from '@/utils/request'

// 查询运单列表
export function listWaybill(query) {
  return request({
    url: '/LT/waybill/list',
    method: 'get',
    params: query
  })
}

// 查询运单详细
export function getWaybill(id) {
  return request({
    url: '/LT/waybill/' + id,
    method: 'get'
  })
}

// 新增运单
export function addWaybill(data) {
  return request({
    url: '/LT/waybill',
    method: 'post',
    data: data
  })
}

// 修改运单
export function updateWaybill(data) {
  return request({
    url: '/LT/waybill',
    method: 'put',
    data: data
  })
}

// 删除运单
export function delWaybill(id) {
  return request({
    url: '/LT/waybill/' + id,
    method: 'delete'
  })
}
