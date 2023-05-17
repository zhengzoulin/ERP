import axios from 'axios';


export class demoService{
  static findStudentInfos () {
    return axios.request({
      url: '/api/test/student/findAllStudents',
      method: 'POST',
    });
  }

  static deleteStudent (rowId) {
    query ={
      rowId
    }
    return axios({
      url: '/test/student/deleteStudent',
      data: query,
      method: 'GET'
    });
  }
}
