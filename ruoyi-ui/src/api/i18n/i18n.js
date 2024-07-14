import request from '@/utils/request'

// 查询国际化列表
export function listI18n(query) {
  return request({
    url: '/i18n/i18n/list',
    method: 'get',
    params: query
  })
}

// 查询国际化详细
export function getI18n(id) {
  return request({
    url: '/i18n/i18n/' + id,
    method: 'get'
  })
}

// 新增国际化
export function addI18n(data) {
  return request({
    url: '/i18n/i18n',
    method: 'post',
    data: data
  })
}

// 修改国际化
export function updateI18n(data) {
  return request({
    url: '/i18n/i18n',
    method: 'put',
    data: data
  })
}

// 删除国际化
export function delI18n(id) {
  return request({
    url: '/i18n/i18n/' + id,
    method: 'delete'
  })
}
