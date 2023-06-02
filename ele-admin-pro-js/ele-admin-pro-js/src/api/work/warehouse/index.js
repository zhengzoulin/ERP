import request from '@/utils/request';

/**商品js代码。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
 * 分页查询商品·························································································
 */
export async function pageGoods(params) {
  const res = await request.get('/work/warehouse/page', { params });
  if (res.data.code === 0) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 查询用户列表
 */
export async function listGoods(params) {
  const res = await request.get('/work/warehouse', {
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
  const res = await request.get('/work/warehouse/' + id);
  if (res.data.code === 0 && res.data.data) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 修改商品
 */
export async function updateGoods(data) {
  const res = await request.put('/work/warehouse', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 添加商品
 */
export async function addGoods(data) {
  const res = await request.post('/work/warehouse', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 删除商品
 */
export async function removeGoods(id) {
  const res = await request.delete('/work/warehouse/' + id);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
/**
 * 修改用户状态
 */
export async function updateUserStatus(id, status) {
  const res = await request.put('/work/warehouse/status', {
    id,
    status
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

// /**
//  * 查询角色列表
//  */
// export async function listRoles(params) {
//   const res = await request.get('/work/raw-material-supplier/unitNames', {
//     params
//   });
//   if (res.data.code === 0 && res.data.data) {
//     return res.data.data;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
//
// /**
//  * 查询原材料列表
//  */
// export async function listRMs(params) {
//   const res = await request.get('/work/raw-materials', {
//     params
//   });
//   if (res.data.code === 0 && res.data.data) {
//     return res.data.data;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
