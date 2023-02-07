import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:9000"
  });
  
export default {

    verifyThroughEmail(data){
        return http.post('http://localhost:9000/user', data)
    },

    getUserByEmail(data){
        return http.get(`http://localhost:9000/user?email=${data}`)
    },
    
    getAllProjects() {
        return http.get('/projects');
    },
    
    getProject(id) {
        return http.get(`/projects/${id}`);
    },

    getAllReports(){
        return http.get('/worklog');
    },

    addProject(project) {
        return http.post(`/projects`, project);
    },
    
    updateProject(project) {
        return http.put(`/editProject`, project);
    },
    getAllProjectsByUserId(id){
        return http.get(`/projects/${id}`)
    },
    getAllTasksByUserId(id){
        return http.get(`/tasks/${id}`)
    },
    getAllTasks(){
        return http.get('/tasks')
    }


    
}