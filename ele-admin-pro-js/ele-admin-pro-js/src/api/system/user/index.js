import request from '@/utils/request';

/**
 * 分页查询用户
 */
export async function pageUsers(params) {
  const res = await request.get('/system/user/page', { params });
  if (res.data.code === 0) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 查询用户列表
 */
export async function listUsers(params) {
  const res = await request.get('/system/user', {
    params
  });
  if (res.data.code === 0 && res.data.data) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}

/**商品js代码。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
 * 分页查询商品·························································································
 */
// export async function pageGoods(params) {
//   const res = await request.get('/goods/goods/page', { params });
//   if (res.data.code === 0) {
//     return res.data.data;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
// /**
//  * 查询用户列表
//  */
// export async function listGoods(params) {
//   const res = await request.get('/goods/goods', {
//     params
//   });
//   if (res.data.code === 0 && res.data.data) {
//     return res.data.data;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
// /**
//  * 根据id查询商品
//  */
// export async function getGoods(id) {
//   const res = await request.get('/goods/goods/' + id);
//   if (res.data.code === 0 && res.data.data) {
//     return res.data.data;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
// /**
//  * 修改商品
//  */
// export async function updateGoods(data) {
//   const res = await request.put('/goods/goods', data);
//   if (res.data.code === 0) {
//     return res.data.message;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
// /**
//  * 添加商品
//  */
// export async function addGoods(data) {
//   const res = await request.post('/goods/goods', data);
//   if (res.data.code === 0) {
//     return res.data.message;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
// /**
//  * 删除商品
//  */
// export async function removeGoods(id) {
//   const res = await request.delete('/goods/goods/' + id);
//   if (res.data.code === 0) {
//     return res.data.message;
//   }
//   return Promise.reject(new Error(res.data.message));
// }
//






//···································································································

/**
 * 根据id查询用户
 */
export async function getUser(id) {
  const res = await request.get('/system/user/' + id);
  if (res.data.code === 0 && res.data.data) {
    return res.data.data;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 添加用户
 */
export async function addUser(data) {
  const res = await request.post('/system/user', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 修改用户
 */
export async function updateUser(data) {
  const res = await request.put('/system/user', data);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 删除用户
 */
export async function removeUser(id) {
  const res = await request.delete('/system/user/' + id);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 批量删除用户
 */
export async function removeUsers(data) {
  const res = await request.delete('/system/user/batch', {
    data
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 修改用户状态
 */
export async function updateUserStatus(userId, status) {
  const res = await request.put('/system/user/status', {
    userId,
    status
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 重置用户密码
 */
export async function updateUserPassword(userId, password = '123456') {
  const res = await request.put('/system/user/password', {
    userId,
    password
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 导入用户
 */
export async function importUsers(file) {
  const formData = new FormData();
  formData.append('file', file);
  const res = await request.post('/system/user/import', formData);
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}

/**
 * 检查用户是否存在
 */
export async function checkExistence(field, value, id) {
  const res = await request.get('/system/user/existence', {
    params: { field, value, id }
  });
  if (res.data.code === 0) {
    return res.data.message;
  }
  return Promise.reject(new Error(res.data.message));
}
