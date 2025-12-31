import request from '@/utils/request'
import { parseStrEmpty } from "@/utils/ruoyi";

// ==================== 管理员操作：司机信息管理（CRUD） ====================

// 查询司机信息列表（管理员维护）
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
    url: '/LT/driver/' + parseStrEmpty(id),
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

// 删除司机信息（单个）
export function delDriver(id) {
  return request({
    url: '/LT/driver/' + id,
    method: 'delete'
  })
}

// 删除司机信息（批量）
export function delDrivers(ids) {
  return request({
    url: '/LT/driver/' + ids,
    method: 'delete'
  })
}

// 导出司机列表
export function exportDriver(query) {
  return request({
    url: '/LT/driver/export',
    method: 'post',
    params: query,
    responseType: 'blob'
  })
}

// ==================== 任务管理（司机端） ====================

// 查询司机待接收的任务列表
export function listPendingTasks(query) {
  return request({
    url: '/LT/driver/task/pending',
    method: 'get',
    params: query
  })
}

// 查询司机已接收的任务列表
export function listAcceptedTasks(query) {
  return request({
    url: '/LT/driver/task/accepted',
    method: 'get',
    params: query
  })
}

// 查询司机运输中的任务
export function listTransitingTasks(query) {
  return request({
    url: '/LT/driver/task/transiting',
    method: 'get',
    params: query
  })
}

// 查询司机已完成的任务
export function listCompletedTasks(query) {
  return request({
    url: '/LT/driver/task/completed',
    method: 'get',
    params: query
  })
}

// 查询任务详情（提货点、卸货点、联系人等）
export function getTaskDetail(waybillId) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId),
    method: 'get'
  })
}

// 接收任务（司机确认接单）
export function acceptTask(waybillId) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/accept',
    method: 'put'
  })
}

// 拒绝任务
export function rejectTask(waybillId, reason) {
  const data = { reason }
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/reject',
    method: 'put',
    data: data
  })
}

// ==================== 运输过程控制 ====================

// 开始运输（到达提货点后）
export function startTransport(waybillId, data) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/start',
    method: 'put',
    data: data
  })
}

// 结束运输（到达卸货点后）
export function endTransport(waybillId, data) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/end',
    method: 'put',
    data: data
  })
}

// 获取运输进度
export function getTransportProgress(waybillId) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/progress',
    method: 'get'
  })
}

// ==================== 位置实时上报 ====================

// 上报车辆GPS位置（实时、高频次）
export function reportLocation(data) {
  return request({
    url: '/LT/driver/location/report',
    method: 'post',
    data: data
  })
}

// 查询自己的位置历史（轨迹）
export function getLocationHistory(query) {
  return request({
    url: '/LT/driver/location/history',
    method: 'get',
    params: query
  })
}

// 获取当前位置
export function getCurrentLocation() {
  return request({
    url: '/LT/driver/location/current',
    method: 'get'
  })
}

// ==================== 异常事件上报 ====================

// 上报异常情况（堵车、等待、事故、故障等）
export function reportException(waybillId, data) {
  return request({
    url: '/LT/driver/exception/report',
    method: 'post',
    data: data
  })
}

// 查询司机已上报的异常列表
export function listExceptions(query) {
  return request({
    url: '/LT/driver/exception/list',
    method: 'get',
    params: query
  })
}

// 获取异常详情
export function getExceptionDetail(exceptionId) {
  return request({
    url: '/LT/driver/exception/' + parseStrEmpty(exceptionId),
    method: 'get'
  })
}

// 查询异常类型列表（堵车、等待、事故等）
export function getExceptionTypes() {
  return request({
    url: '/LT/driver/exception/types',
    method: 'get'
  })
}

// ==================== 电子回单管理 ====================

// 上传电子回单（签收单、货品照片等）
export function uploadReceipt(waybillId, data) {
  return request({
    url: '/LT/driver/receipt/upload',
    method: 'post',
    data: data
  })
}

// 查询电子回单详情
export function getReceiptDetail(waybillId) {
  return request({
    url: '/LT/driver/receipt/' + parseStrEmpty(waybillId),
    method: 'get'
  })
}

// 查询电子回单列表（已上传的回单）
export function listReceipts(query) {
  return request({
    url: '/LT/driver/receipt/list',
    method: 'get',
    params: query
  })
}

// ==================== 收入与结算 ====================

// 查询司机个人已完成任务记录
export function listCompletedTasksForEarnings(query) {
  return request({
    url: '/LT/driver/earnings/completed-tasks',
    method: 'get',
    params: query
  })
}

// 查询司机收入统计
export function getEarningsStatistics(query) {
  return request({
    url: '/LT/driver/earnings/statistics',
    method: 'get',
    params: query
  })
}

// 查询任务收入详情
export function getTaskEarnings(waybillId) {
  return request({
    url: '/LT/driver/earnings/task/' + parseStrEmpty(waybillId),
    method: 'get'
  })
}

// 查询司机结算单列表
export function listSettlementOrders(query) {
  return request({
    url: '/LT/driver/earnings/settlement',
    method: 'get',
    params: query
  })
}

// 查询结算单详情
export function getSettlementOrderDetail(settlementId) {
  return request({
    url: '/LT/driver/earnings/settlement/' + parseStrEmpty(settlementId),
    method: 'get'
  })
}

// ==================== 司机个人信息管理 ====================

// 查询司机本人的详细信息
export function getDriverProfile() {
  return request({
    url: '/LT/driver/profile',
    method: 'get'
  })
}

// 更新司机信息（司机端只能修改部分信息）
export function updateDriverProfile(data) {
  return request({
    url: '/LT/driver/profile',
    method: 'put',
    data: data
  })
}

// 查询司机证件信息
export function getDriverLicense() {
  return request({
    url: '/LT/driver/license',
    method: 'get'
  })
}

// ==================== 任务沟通与通知 ====================

// 查询与货主或调度的消息通知
export function listNotifications(query) {
  return request({
    url: '/LT/driver/notifications',
    method: 'get',
    params: query
  })
}

// 标记消息为已读
export function markNotificationAsRead(notificationId) {
  return request({
    url: '/LT/driver/notifications/' + parseStrEmpty(notificationId) + '/read',
    method: 'put'
  })
}

// 获取任务的沟通记录（与货主、调度员的对话）
export function getTaskCommunication(waybillId) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/communication',
    method: 'get'
  })
}

// 发送消息给货主或调度员
export function sendMessage(waybillId, data) {
  return request({
    url: '/LT/driver/task/' + parseStrEmpty(waybillId) + '/message',
    method: 'post',
    data: data
  })
}

// ==================== 司机状态管理 ====================

// 更新司机在线状态（在职/休息）
export function updateDriverStatus(status) {
  const data = { status }
  return request({
    url: '/LT/driver/status',
    method: 'put',
    data: data
  })
}

// 查询司机当前状态
export function getDriverStatus() {
  return request({
    url: '/LT/driver/status',
    method: 'get'
  })
}

// ==================== 评价与评分 ====================

// 查询司机获得的评价列表
export function listRatings(query) {
  return request({
    url: '/LT/driver/ratings',
    method: 'get',
    params: query
  })
}

// 获取司机平均评分
export function getDriverRating() {
  return request({
    url: '/LT/driver/rating',
    method: 'get'
  })
}
