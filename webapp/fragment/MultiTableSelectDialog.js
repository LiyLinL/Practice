sap.ui.define([
   'fw/fragment/TableSelectDialog'
], function (TableSelectDialog) {
   "use strict";
   return TableSelectDialog.extend("fw.fragment.MultiTableSelectDialog", {
      openDialog: function (oSource, oModel, myfunction) {
         this.open(oSource, oModel, myfunction);
         if (this.multiple) {
            this.setSelect(oSource);
         }
      },
      /**
       * 傳回需勾選值
       * @param {*} oSource 
       */
      setSelect: function (oSource) {
         var table = this.dialog.mAggregations._dialog.mAggregations.content[1];
         this.table = table;
         var items = table.getItems();
         table.removeSelections();

         var mInput = oSource.getTokens();
         if (mInput.length != 0) {
            let list = mInput.map(value => value.getText());
            let token = {};
            let key = this.filterKey;
            this.dialog.getModel().getProperty(this.root)
               .forEach(function (val, index) {
                  token[val[key]] = index;
               });
            list.forEach(to => {
               table.setSelectedItem(items[token[to]], true);
            });
         }
      }
   });
});