import request from '@/utils/request'

// 查询新闻列表列表
export function listNews(query) {
  return request({
    url: '/greatzc/news/list',
    method: 'get',
    params: query
  })
}

// 查询新闻列表详细
export function getNews(id) {
  return request({
    url: '/greatzc/news/' + id,
    method: 'get'
  })
}

// 新增新闻列表
export function addNews(data) {
  return request({
    url: '/greatzc/news',
    method: 'post',
    data: data
  })
}

// 修改新闻列表
export function updateNews(data) {
  return request({
    url: '/greatzc/news',
    method: 'put',
    data: data
  })
}

// 删除新闻列表
export function delNews(id) {
  return request({
    url: '/greatzc/news/' + id,
    method: 'delete'
  })
}
