var i = function (name) {
    this.name = name;
};

i.prototype = {
    setName: function (name) {
        this.name = name;
    },
    getName: function () {
        return this.name;
    }
};
