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

    //Manager
    getAllProjects() {
        return http.get('/projects');
    },

    //Employee
    getAllProjectsByUserId(userid){
        return http.get(`/projects/${userid}`)
    },

    //Individual Project Page
    getProjectByProjectId(projectid){
        return http.get(`/singleProject/${projectid}`)
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

    getAllTasksByProjectId(projectId){
        return http.get(`/singletask/${projectId}`)
    },

    getAllTasksByTaskId(taskId){
        return http.get(`/task/${taskId}`)
    },
    
    addTask(task){
        return http.post('/task', task)
    },

    updateTask(task){
        return http.put(`/task`, task)
    },

    deleteTask(taskId){
        return http.delete(`task/${taskId}`)
    },

    //Worklogs
    
    getAllReports(){
        return http.get('/worklog');
    },

    getAllReportsByUser(userId){
        return http.get(`/worklog/user/${userId}`)
    },

    getAllReportsForUserByProjectId(userId, projectid){
        return http.get(`/worklog/${userId}/${projectid}`)
    },

    getReportByReportId(reportId){
        return http.get(`/worklog/${reportId}`)
    },

    createReport(report){
        return http.post('/worklog', report)
    },

    updateReport(reportId, report){
        return http.put(`/worklog/${reportId}`, report)
    },

    deleteReport(reportId){
        return http.delete(`/worklog/${reportId}`)
    },
}