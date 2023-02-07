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

    //Projects

    getAllProjects() {
        return http.get('/projects');
    },

    getAllProjectsByUserId(id){
        return http.get(`/projects/${id}`)
        
    },

    getAllProjectByProjectId(userid, projectid){
        return http.get(`/projects/${userid}/${projectid}`)
    },
    
    addProject(project) {
        return http.post(`/projects`, project);
    },
    
    updateProject(project) {
        return http.put(`/editProject`, project);
    },

    deleteProject(id) {
        return http.delete(`/projects/${id}`);
    },

    //Tasks

    getAllTasksByUserId(id){
        return http.get(`/tasks/${id}`)
    },
    getAllTasks(){
        return http.get('/tasks')
    },

    //Worklogs
    
    getAllReports(){
        return http.get('/worklog');
    },

    
    


    
}