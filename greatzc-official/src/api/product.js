import request from '@/utils/request'

// 查询产品信息列表
export function listProduct(query) {
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