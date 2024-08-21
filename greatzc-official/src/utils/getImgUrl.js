const imgPrefix = import.meta.env.VITE_FILE_API;

export function getImgUrl(url) {
  if (url == "" || url == null)
    return "/assets/img/BxImages.svg"
  return imgPrefix + url;
}

// 获取一个随机的轮播图播放时间
export function randomSlideTime(param) {
  if (param == undefined || param == null)
    return 0

  let value = param.split(',').length

  if (value == 1) {
    return 0
  }

  return Math.floor(Math.random() * (3000) + 5000)
}