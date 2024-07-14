import request from '@/utils/request'

// 查询产品分类列表
export function listCategory(query) {
  return request({
    url: '/greatzc/category/list',
    method: 'get',
    params: query
  })
}

// 查询产品分类详细
export function getCategory(id) {
  return request({
    url: '/greatzc/category/' + id,
    method: 'get'
  })
}

// 新增产品分类
export function addCategory(data) {
  return request({
    url: '/greatzc/category',
    method: 'post',
    data: data
  })
}

// 修改产品分类
export function updateCategory(data) {
  return request({
    url: '/greatzc/category',
    method: 'put',
    data: data
  })
}

// 删除产品分类
export function delCategory(id) {
  return request({
    url: '/greatzc/category/' + id,
    method: 'delete'
  })
}
