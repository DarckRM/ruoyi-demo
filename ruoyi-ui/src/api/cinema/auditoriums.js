import request from '@/utils/request'

// 查询影厅列表
export function listAuditoriums(query) {
  return request({
    url: '/cinema/auditoriums/list',
    method: 'get',
    params: query
  })
}

// 查询影厅详细
export function getAuditoriums(auditoriumId) {
  return request({
    url: '/cinema/auditoriums/' + auditoriumId,
    method: 'get'
  })
}

// 新增影厅
export function addAuditoriums(data) {
  return request({
    url: '/cinema/auditoriums',
    method: 'post',
    data: data
  })
}

// 修改影厅
export function updateAuditoriums(data) {
  return request({
    url: '/cinema/auditoriums',
    method: 'put',
    data: data
  })
}

// 删除影厅
export function delAuditoriums(auditoriumId) {
  return request({
    url: '/cinema/auditoriums/' + auditoriumId,
    method: 'delete'
  })
}
