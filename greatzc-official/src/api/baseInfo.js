import request from '@/utils/request'

// 查询关于信息详细
export function getAbout(id) {
  return request({
    url: '/baseInfo/about/' + id,
    method: 'get'
  })
}

// 修改关于信息
export function updateAbout(data) {
  return request({
    url: '/baseInfo/about',
    method: 'put',
    data: data
  })
}
