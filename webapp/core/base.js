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

                // js
                includeScript(sap.ui.require.toUrl('gen/utils/decimal.min.js'));
                includeScript(sap.ui.require.toUrl('gen/utils/moment.js'));
                includeScript(sap.ui.require.toUrl('gen/utils/excelJS.min.js'));
                includeScript(sap.ui.require.toUrl('gen/utils/FileSaver.js'));
                includeScript(sap.ui.require.toUrl('gen/ajax.js'));
                includeScript(sap.ui.require.toUrl('gen/core/fn.js'));
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
