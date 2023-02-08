import axios from 'axios';
const http = axios.create({
    baseURL: "http://localhost:9000"
  });
  
export default {

    verifyThroughEmail(email){
        return http.post('http://localhost:9000/user', email)
    },

    getUserByEmail(email){
        return http.get(`http://localhost:9000/user?email=${email}`)
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

    getAllTasks(){
        return http.get('/tasks')
    },
   
    getAllTasksByUserId(userId){
        return http.get(`/tasks/${userId}`)
    },

    getAllTasksByTaskId(taskId){
        return http.get(`/task/${taskId}`)
    },
    
    addTask(task){
        return http.post('/task', task)
    },

    updateTask(task){
        return http.put('task/', task)
    },

    deleteTask(taskId){
        return http.delete(`task/${taskId}`)
    },

    //Worklogs
    
    getAllReports(){
        return http.get('/worklog');
    },

    getAllReportsByUser(userId){
        return null
    },

    getAllReportsByReportId(reportId){
        return null
    },

    createReport(report){
        return null
    },

    updateReport(reportId){
        return null
    },

    deleteReport(reportId){
        return null
    },
}