import request from '@/utils/request'

// 查询座位列表
export function listSeats(query) {
  return request({
    url: '/cinema/seats/list',
    method: 'get',
    params: query
  })
}

// 查询座位详细
export function getSeats(seatId) {
  return request({
    url: '/cinema/seats/' + seatId,
    method: 'get'
  })
}

// 新增座位
export function addSeats(data) {
  return request({
    url: '/cinema/seats',
    method: 'post',
    data: data
  })
}

// 修改座位
export function updateSeats(data) {
  return request({
    url: '/cinema/seats',
    method: 'put',
    data: data
  })
}

// 删除座位
export function delSeats(seatId) {
  return request({
    url: '/cinema/seats/' + seatId,
    method: 'delete'
  })
}
