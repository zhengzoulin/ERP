import request from '@/utils/request';

/**商品js代码。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
 * 分页查询商品·························································································
 */
export async function pageGoods(params) {
  const res = await request.get('/work/engineering/page', { params });
  if (res.data.code === 0) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 查询用户列表
 */
export async function listGoods(params) {
  const res = await request.get('/work/engineering', {
    params
  });
  if (res.data.code === 0 && res.data.data) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 根据id查询商品
 */
export async function getGoods(id) {
  const res = await request.get('/work/engineering/' + id);
  if (res.data.code === 0 && res.data.data) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 修改商品
 */
export async function updateGoods(data) {
  const res = await request.put('/work/engineering', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 添加商品
 */
export async function addGoods(data) {
  const res = await request.post('/work/engineering', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 删除商品
 */
export async function removeGoods(id) {
  const res = await request.delete('/work/engineering/' + id);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 修改用户状态
 */
export async function updateUserStatus(id, status) {
  const res = await request.put('/work/engineering/status', {
    id,
    status
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

