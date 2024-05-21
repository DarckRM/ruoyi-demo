import request from '@/utils/request'

// 查询会员列表
export function listMembers(query) {
  return request({
    url: '/cinema/members/list',
    method: 'get',
    params: query
  })
}

// 查询会员详细
export function getMembers(memberId) {
  return request({
    url: '/cinema/members/' + memberId,
    method: 'get'
  })
}

// 新增会员
export function addMembers(data) {
  return request({
    url: '/cinema/members',
    method: 'post',
    data: data
  })
}

// 修改会员
export function updateMembers(data) {
  return request({
    url: '/cinema/members',
    method: 'put',
    data: data
  })
}

// 删除会员
export function delMembers(memberId) {
  return request({
    url: '/cinema/members/' + memberId,
    method: 'delete'
  })
}
