import * as rxjs from "rxjs";

export default class HttpUtil {

    static post(url, param, header?) {
        return rxjs.Observable.create((observer) => {
            fetch(url, {
                method: 'POST', credentials: "include", headers: header, body: param
            })
                .then(response => response.json())
                .then(json => {
                    observer.next(json);
                });
        });
    }


    static get(url) {
        return rxjs.Observable.create((observer) => {
            fetch(url, {method: 'GET',  credentials: "include"})
                .then(response => response.json())
                .then(json => {
                    observer.next(json);
                });
        });

    }
}