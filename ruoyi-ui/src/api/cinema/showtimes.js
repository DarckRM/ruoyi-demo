import request from '@/utils/request'

// 查询放映列表
export function listShowtimes(query) {
  return request({
    url: '/cinema/showtimes/list',
    method: 'get',
    params: query
  })
}

// 查询放映详细
export function getShowtimes(showtimeId) {
  return request({
    url: '/cinema/showtimes/' + showtimeId,
    method: 'get'
  })
}

// 新增放映
export function addShowtimes(data) {
  return request({
    url: '/cinema/showtimes',
    method: 'post',
    data: data
  })
}

// 修改放映
export function updateShowtimes(data) {
  return request({
    url: '/cinema/showtimes',
    method: 'put',
    data: data
  })
}

// 删除放映
export function delShowtimes(showtimeId) {
  return request({
    url: '/cinema/showtimes/' + showtimeId,
    method: 'delete'
  })
}

export function autoArrange(data) {
  return request({
    url: '/cinema/arrange/auto',
    method: 'post',
    data: data
  })
}
