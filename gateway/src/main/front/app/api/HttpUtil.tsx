import * as rxjs from "rxjs";

export default class HttpUtil {

    static post(url, param, header?) {
        return rxjs.Observable.create((observer) => {
            fetch(url, {
                method: 'POST', credentials: "same-origin", headers: header, body: param
            })
                .then(response => response.json())
                .then(json => {
                    observer.next(json);
                });
        });
    }


    static getHttp(url) {
        return rxjs.Observable.create((observer) => {
            fetch(url, {method: 'GET',  credentials: "same-origin"})
                .then(response => response.json())
                .then(json => {
                    observer.next(json);
                });
        });

    }
}