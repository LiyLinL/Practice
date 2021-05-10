sap.ui.define([], function () {
    'use strict';
    return {
        statusFormate: function (text) {
            var self = this,
                I18N = self.getI18N();
            return I18N.getText('job.' + text);
        },
        detailStatusFormate: function (text) {
            var I18N = this.self.getI18N();
            return I18N.getText(text);
        }
    };
});
