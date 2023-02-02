import axios from 'axios';

export default {

    getAllProjects() {
        return axios.get("/projects");
    },
    getProject() {
        return axios.get("/projects/${id}");
    },
    addProject() {
        return axios.push("/addProject", project);
    },
    updateProject() {
        return axios.put("/editProject", project);
    }
}