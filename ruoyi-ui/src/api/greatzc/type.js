import request from '@/utils/request'

// 查询新闻分类列表
export function listType(query) {
  return request({
    url: '/greatzc/type/list',
    method: 'get',
    params: query
  })
}

// 查询新闻分类详细
export function getType(id) {
  return request({
    url: '/greatzc/type/' + id,
    method: 'get'
  })
}

// 新增新闻分类
export function addType(data) {
  return request({
    url: '/greatzc/type',
    method: 'post',
    data: data
  })
}

// 修改新闻分类
export function updateType(data) {
  return request({
    url: '/greatzc/type',
    method: 'put',
    data: data
  })
}

// 删除新闻分类
export function delType(id) {
  return request({
    url: '/greatzc/type/' + id,
    method: 'delete'
  })
}
