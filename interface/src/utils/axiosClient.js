import axios from "axios";

export default function axiosClient() {
    const client = axios.create({
        baseURL: "http://localhost:8090/pharmacy",
        timeout: 5000
    })

    client.defaults.auth = {
        username: "user",
        password: "passw"
    }

    return client;
}