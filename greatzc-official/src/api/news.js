import request from "@/utils/request";

// 查询新闻列表列表
export function listNews(query) {
  return request({
    url: "/news/list",
    method: "get",
    params: query,
  });
}

// 查询新闻列表详细
export function getNews(id) {
  return request({
    url: "/news/" + id,
    method: "get",
  });
}

// 查询新闻分类列表
export function listType(query) {
  return request({
    url: "/type/list",
    method: "get",
    params: query,
  });
}
