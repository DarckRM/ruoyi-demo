import request from '@/utils/request'

// 新增站内信
export function addMessage(data) {
  return request({
    url: '/message',
    method: 'post',
    data: data
  })
}