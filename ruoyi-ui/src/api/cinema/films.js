import request from '@/utils/request'

// 查询影片列表
export function listFilms(query) {
  return request({
    url: '/cinema/films/list',
    method: 'get',
    params: query
  })
}

// 查询影片详细
export function getFilms(filmId) {
  return request({
    url: '/cinema/films/' + filmId,
    method: 'get'
  })
}

// 新增影片
export function addFilms(data) {
  return request({
    url: '/cinema/films',
    method: 'post',
    data: data
  })
}

// 修改影片
export function updateFilms(data) {
  return request({
    url: '/cinema/films',
    method: 'put',
    data: data
  })
}

// 删除影片
export function delFilms(filmId) {
  return request({
    url: '/cinema/films/' + filmId,
    method: 'delete'
  })
}
