var ajax = function (url) {
    this.url = url;
    // this.language = jQuery.sap.storage(jQuery.sap.storage.Type.local).get("locale");
};

ajax.prototype = new ajax();

ajax.prototype.get = function (parm, type, success, fail) {
    return $.ajax({
        url: this.url + parm,
        type: 'GET',
        cache: false,
        async: false,
        dataType: type,
        processData: false,
        contentType: false,
        headers: {
            'Accept-Language': this.language
        }
    }).then(
        (res) => success(res),
        (res) => fail(res)
    );
};

ajax.prototype.post = function (parm, data, type, success, fail) {
    return $.ajax({
        url: this.url + parm,
        type: 'POST',
        cache: false,
        async: false,
        crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        dataType: type,
        contentType: 'application/json',
        data: JSON.stringify(data),
        processData: false,
        headers: {
            'Accept-Language': this.language
        }
    }).then(
        (res) => success(res),
        (res) => fail(res)
    );
};

ajax.prototype.delete = function (parm, type, success, fail) {
    return $.ajax({
        url: this.url + parm,
        type: 'DELETE',
        cache: false,
        async: false,
        crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        dataType: type,
        processData: false,
        headers: {
            'Accept-Language': this.language
        }
    }).then(
        (res) => success(res),
        (res) => fail(res)
    );
};

ajax.prototype.deleteData = function (parm, data, type, success, fail) {
    return $.ajax({
        url: this.url + parm,
        type: 'DELETE',
        cache: false,
        async: false,
        crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        dataType: type,
        contentType: 'application/json',
        data: JSON.stringify(data),
        processData: false,
        headers: {
            'Accept-Language': this.language
        }
    }).then(
        (res) => success(res),
        (res) => fail(res)
    );
};
