const imgPrefix = import.meta.env.VITE_FILE_API;

export function getImgUrl(url) {
  console.log(imgPrefix)
  return imgPrefix + url;
}
