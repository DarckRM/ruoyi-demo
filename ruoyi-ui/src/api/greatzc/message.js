import request from '@/utils/request'

// 查询站内信列表
export function listMessage(query) {
  return request({
    url: '/greatzc/message/list',
    method: 'get',
    params: query
  })
}

// 查询站内信详细
export function getMessage(id) {
  return request({
    url: '/greatzc/message/' + id,
    method: 'get'
  })
}

// 新增站内信
export function addMessage(data) {
  return request({
    url: '/greatzc/message',
    method: 'post',
    data: data
  })
}

// 修改站内信
export function updateMessage(data) {
  return request({
    url: '/greatzc/message',
    method: 'put',
    data: data
  })
}

// 删除站内信
export function delMessage(id) {
  return request({
    url: '/greatzc/message/' + id,
    method: 'delete'
  })
}
