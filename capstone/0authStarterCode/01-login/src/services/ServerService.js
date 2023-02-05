import axios from 'axios';

export default {

    getAllProjects() {
        return axios.get("/projects");
    },
    getProject(id) {
        return axios.get(`/projects/${id}`);
    },
    addProject(project) {
        return axios.post(`/projects`, project);
    },
    updateProject(project) {
        return axios.put(`/editProject`, project);
    }
}