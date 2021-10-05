var base = function (me) {
    this.me = me;
};

base.prototype = {
    include: function () {
        sap.ui.require(
            ['sap/ui/dom/includeStylesheet', 'sap/ui/dom/includeScript'],
            function (includeStylesheet, includeScript) {
                // style
                includeStylesheet(sap.ui.require.toUrl('gen/style.css'));
                includeStylesheet(sap.ui.require.toUrl('gen/css/dhtmlxscheduler_material.css'));
            }
        );
        return this;
    },
    load: function () {
        sap.ui.loader.config({
            paths: {
                fw: './fw'
            }
        });
    }
};
