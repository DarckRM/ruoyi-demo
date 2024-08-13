const imgPrefix = import.meta.env.VITE_FILE_API;

export function getImgUrl(url) {
  return imgPrefix + url;
}

// 获取一个随机的轮播图播放时间
export function randomSlideTime(value) {
  if (value == 1) {
    return 0
  }

  return Math.floor(Math.random() * (3000) + 5000)
}