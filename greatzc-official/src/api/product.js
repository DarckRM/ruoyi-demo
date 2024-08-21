import request from '@/utils/request'

// 查询产品信息列表
export function listProduct(query) {
  query.lang = 'en-US'
  return request({
    url: '/product/list',
    method: 'get',
    params: query
  })
}

// 查询产品信息详细
export function getProduct(id) {
  return request({
    url: '/product/' + id,
    method: 'get'
  })
}

export function listCategory(query) {
  return request({
    url: '/category/list',
    method: 'get',
    params: query
  })
}