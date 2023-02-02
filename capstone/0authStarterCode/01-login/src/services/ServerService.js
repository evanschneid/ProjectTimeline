import axios from 'axios';

export default {

    getAllProjects() {
        return axios.get("/projects");
    },
    getProject(id) {
        return axios.get("/projects/${id}");
    },
    addProject() {
        return axios.post("/projects", project);
    },
    updateProject() {
        return axios.put("/editProject", project);
    }
}