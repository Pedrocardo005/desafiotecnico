import http from "../http-common";

const get = nome => {
    return http.get(`?nome=${nome}`);
};

export default { get };
