sap.ui.define(['sap/ui/table/Table'], function (Table) {
    'use strict';
    var t = Table.extend('gen.view.lib.customTable', {
        metadata: {
            properties: {},
            aggregations: {},
            events: {}
        },
        invalidate: function () {
            Table.prototype.invalidate.call(this);
        },
        renderer: function (oRm, oTable) {
            sap.ui.table.TableRenderer.render(oRm, oTable);
        },
        onAfterRendering: function () {
            Table.prototype.onAfterRendering.apply(this);
        }
    });
    return t;
});
