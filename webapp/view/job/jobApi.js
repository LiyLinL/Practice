var jobApi = function (url) {
    this.url = url;
};

jobApi.prototype = new ajax();

jobApi.prototype.getJob = function (success, fail) {
    this.get('/findJob', 'JSON', success, fail);
};

jobApi.prototype.pause = function (success, fail) {
    this.get('/pause', 'html', success, fail);
};

jobApi.prototype.resume = function (success, fail) {
    this.get('/resume', 'html', success, fail);
};

jobApi.prototype.run = function (success, fail) {
    this.get('/run', 'html', success, fail);
};

jobApi.prototype.upd = function (body, success, fail) {
    this.post('/upd', body, 'html', success, fail);
};

jobApi.prototype.getDetail = function (success, fail) {
    this.get('/findJobRecords?taskNo=program1', 'JSON', success, fail);
};
