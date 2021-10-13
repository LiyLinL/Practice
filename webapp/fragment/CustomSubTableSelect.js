sap.ui.define([
    'fw/fragment/MultiTableSelectDialog',
    "sap/ui/core/Fragment"
], function (MultiTableSelectDialog, Fragment) {
    "use strict";
    return MultiTableSelectDialog.extend("fw.fragment.CustomSubTableSelect", {
        showSfcDialog: function (oSource, oData, methods, subHeaderName, init, end) {
            if (methods) {
                var keys = Object.keys(methods);
                for (const m of keys) {
                    this[m] = methods[m];
                }
            }
            this.open(oSource, oData, end);
            this.changeSearch(subHeaderName);
            if (this.multiple) {
                this.setSelect(oSource);
            }
            if (init) {
                init();
            }
            return this.dialog;
        },
        changeSearch: function (subHeaderName) {
            var dialog = this.dialog;
            var _dialog = this.dialog.mAggregations._dialog;
            // _dialog.setContentWidth('50%');
            // _dialog.destroySubHeader();
            Fragment.load({
                name: subHeaderName,
                controller: this
            }).then(function (bar) {
                var contents = _dialog.removeAllContent();
                _dialog.addContent(bar);
                _dialog.addContent(contents[1]);
                bar.setModel(dialog.getModel('i18n'), 'i18n');
                // _dialog.setSubHeader(bar);
            });

        }

    });
});