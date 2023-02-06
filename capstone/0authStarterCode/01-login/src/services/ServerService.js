import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:9000"
  });
  
export default {

    getAllProjects() {
        return http.get('/projects');
    },
    // getProject(id) {
    //     return http.get(`/projects/${id}`);
    // },
    addProject(project) {
        return http.post(`/projects`, project);
    },
    updateProject(project) {
        return http.put(`/editProject`, project);
    },
    getAllProjectsByUserId(id){
        return http.get(`/projects/${id}`)
    }

    
}