sap.ui.define(
    [
        'sap/ui/core/mvc/Controller',
        'sap/m/MessageToast',
        'sap/m/MessageBox',
        'sap/ui/core/routing/History',
        'sap/m/Button',
        'sap/m/Dialog',
        'sap/m/Text',
        'jquery.sap.global'
    ],
    function (Controller, MessageToast, MessageBox, History) {
        'use strict';
        return Controller.extend('fw.core.BaseController', {
            /**
             * Convenience method for accessing the router.
             * @public
             * @returns {sap.ui.core.routing.Router} the router for this component
             */
            getRouter: function () {
                return sap.ui.core.UIComponent.getRouterFor(this);
            },

            getI18N: function (sName) {
                if (sName) {
                    return this.getModel(sName).getResourceBundle();
                } else {
                    return this.getModel('i18n').getResourceBundle();
                }
            },

            /**
             * Convenience method for getting the view model by name.
             * @public
             * @param {string} sName the model name
             * @returns {sap.ui.model.Model} the model instance
             */
            getModel: function (sName) {
                return sName == undefined ? this.getView().getModel() : this.getView().getModel(sName);
            },
            getProperty: function (sPath, sName) {
                return sName == undefined
                    ? this.getView().getModel().getProperty(sPath)
                    : this.getView().getModel(sName).getProperty(sPath);
            },
            getPath: function (oEvent, sName) {
                return sName == undefined
                    ? oEvent.getSource().getBindingContext(undefined).getPath()
                    : oEvent.getSource().getBindingContext(sName).getPath();
            },
            getBindData: function (oEvent, sName) {
                return sName == undefined
                    ? this.getProperty(this.getPath(oEvent, undefined), undefined)
                    : this.getProperty(this.getPath(oEvent, sName), sName);
            },
            getData: function (sName) {
                return sName == undefined
                    ? this.getView().getModel().getData()
                    : this.getView().getModel(sName).getData();
            },
            refresh: function (sName) {
                return sName == undefined
                    ? this.getView().getModel().refresh()
                    : this.getView().getModel(sName).refresh();
            },

            /**
             * Convenience method for setting the view model.
             * @public
             * @param {object} oModel the model instance
             * @param {string} sName the model name
             * @returns {sap.ui.mvc.View} the view instance
             */
            setModel: function (oModel, sName) {
                return sName == undefined
                    ? this.getView()
                          .setModel(new sap.ui.model.json.JSONModel(oModel))
                          .getModel()
                          .getData()
                    : this.getView()
                          .setModel(new sap.ui.model.json.JSONModel(oModel), sName)
                          .getModel(sName)
                          .getData();
            },
            getSite: function () {
                var site = undefined;
                new common(this.getWebApi()).info(
                    function (res) {
                        if (res.site) {
                            site = res.site;
                        }
                    },
                    function (err) {
                        jQuery.sap.log.error(err.message);
                        return;
                    }
                );
                return site;
            },
            getUser: function () {
                var user;
                $.ajax({
                    type: 'get',
                    async: false,
                    url:
                        location.protocol +
                        '//' +
                        location.host +
                        '/manufacturing-odata/AppConfig.svc/GetSiteForUser',
                    dataType: 'json',
                    crossDomain: true,
                    success: function (data) {
                        user = data.d.GetSiteForUser.userId;
                    },
                    error: function (err) {
                        jQuery.sap.log.error(err.message);
                        return;
                    }
                });
                return user;
            },

            /**
             * Convenience method for getting the root url of web api.
             * @public
             * @returns {string} the url.
             */
            getWebApi: function () {
                return new setting().webApi();
            },

            showMessage: function (errorCode) {
                if (errorCode.responseText != undefined && errorCode.responseText != '') {
                    if (typeof errorCode.responseText == 'string') {
                        try {
                            errorCode = JSON.parse(errorCode.responseText);
                            MessageBox.error('message : ' + errorCode.message);
                        } catch (e) {
                            MessageBox.error(errorCode.status + ' ' + errorCode.statusText);
                        }
                    }
                } else {
                    MessageBox.error('error,please check');
                }
                throw errorCode;
            },

            showMessageClose: function (errorCode, funct) {
                if (errorCode.responseText != undefined && errorCode.responseText != '') {
                    if (typeof errorCode.responseText == 'string') {
                        try {
                            errorCode = JSON.parse(errorCode.responseText);
                            MessageBox.error('message : ' + errorCode.message, {
                                onClose: function () {
                                    funct();
                                }
                            });
                        } catch (e) {
                            MessageBox.error(errorCode.status + ' ' + errorCode.statusText);
                        }
                    }
                } else {
                    MessageBox.error('error,please check');
                }
            },

            /**
             * Convenience method for getting the configuration from manifest.
             * @public
             * @param {string} sName the route name.
             * @param {function} handle Callback of attachPatternMatched.
             */
            attachPatternMatched: function (sName, handle) {
                //設定主題
                var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
                oRouter.getRoute(sName).attachPatternMatched(handle, this);

                // 改變配色
                const viewNames = ['productKanBanByItem'];
                oRouter.getRoute(sName).attachMatched(function (oEvent) {
                    var viewName = oEvent.getParameter('name');

                    if (viewNames.includes(viewName)) {
                        sap.ui.getCore().applyTheme('sap_fiori_3_dark');
                    } else {
                        sap.ui.getCore().applyTheme('sap_belize_plus');
                    }
                }, this);

                if (oRouter.mEventRegistry.titleChanged === undefined) {
                    oRouter.attachTitleChanged(function (oEvent) {
                        var title = oEvent.getParameter('title');
                        document.title = 'FW - ' + title;
                    });
                }
            },
            /**
             * 導航至特定畫面
             * @param {*} sName 畫面名稱
             * @param {*} key request的key
             * @param {*} value request的value
             */
            navTo: function (sName, key, value) {
                var oRouter = sap.ui.core.UIComponent.getRouterFor(this);
                if (key) {
                    var request = {};
                    request[key] = value;
                    oRouter.navTo(sName, { req: request });
                } else {
                    oRouter.navTo(sName);
                }
            },
            /**
             * 返回至指定畫面
             * @param {*} sName
             * @param {*} parameters
             * @param {*} replace
             */
            navBack: function (sName, parameters, replace) {
                var sPreviousHash = History.getInstance().getPreviousHash();
                if (sPreviousHash !== undefined) {
                    window.history.go(-1);
                } else {
                    if (parameters) {
                        this.navTo(sName, parameters, replace);
                    } else {
                        this.navTo(sName, replace);
                    }
                }
            },
            /**
             * 取得ui:table的選擇
             */
            getIndex: function (evt, modelName) {
                if (modelName) {
                    return evt
                        .getSource()
                        .oPropagatedProperties.oBindingContexts[modelName].sPath.split('/')[2];
                } else {
                    return evt
                        .getSource()
                        .oPropagatedProperties.oBindingContexts[undefined].sPath.split('/')[2];
                }
            },
            isEmpty: function (array, textArray) {
                var I18N = this.getI18N();
                var message = '';
                if (typeof array === 'object') {
                    for (let i = 0; i < array.length; i++) {
                        const element = array[i];
                        if (
                            element === undefined ||
                            element === null ||
                            element === '' ||
                            (Array.isArray(element) && element.length === 0)
                        ) {
                            message =
                                '「' + I18N.getText(textArray[i]) + '」' + I18N.getText('g.is.empty');
                            MessageBox.error(message);
                            throw message;
                        }
                    }
                } else {
                    if (array === undefined || array === null || array === '') {
                        message = '「' + I18N.getText(textArray) + '」' + I18N.getText('g.is.empty');
                        MessageBox.error(
                            '「' + I18N.getText(textArray) + '」' + I18N.getText('g.is.empty')
                        );
                        throw message;
                    }
                }
            },
            checkData: function (data, message) {
                if (data.length == 0) {
                    if (!message) {
                        message = this.getI18N().getText('g.retrieve.please');
                    }
                    MessageBox.error(message);
                    throw message;
                }
            },
            confirmMessage: function (message, funct, cancel) {
                MessageBox.confirm(message, {
                    actions: [MessageBox.Action.OK, MessageBox.Action.CANCEL],
                    onClose: function (sAction) {
                        if (sAction == 'OK') {
                            if (funct) {
                                funct();
                            }
                        } else {
                            if (cancel) {
                                cancel();
                            }
                        }
                    }
                });
            },
            newJson: function (json) {
                return JSON.parse(JSON.stringify(json));
            },
            getDateRange: function (key, format) {
                var time = {
                    start: '',
                    end: ''
                };
                switch (key) {
                    case '0': //今天
                        time.start = moment().day(moment().day()).startOf('day').format(format);
                        time.end = moment().day(moment().day()).endOf('day').format(format);
                        break;
                    case '1': //昨天
                        time.start = moment()
                            .day(moment().day() - 1)
                            .startOf('day')
                            .format(format);
                        time.end = moment()
                            .day(moment().day() - 1)
                            .endOf('day')
                            .format(format);
                        break;
                    case '2': //本周
                        time.start = moment().week(moment().week()).startOf('isoWeek').format(format);
                        time.end = moment().week(moment().week()).endOf('isoWeek').format(format);
                        break;
                    case '3': //上週
                        time.start = moment()
                            .week(moment().week() - 1)
                            .startOf('week')
                            .format(format);
                        time.end = moment()
                            .week(moment().week() - 1)
                            .endOf('week')
                            .format(format);
                        break;
                    case '4': //本月
                        time.start = moment().month(moment().month()).startOf('month').format(format);
                        time.end = moment().month(moment().month()).endOf('month').format(format);
                        break;
                    case '5': //上個月
                        time.start = moment()
                            .month(moment().month() - 1)
                            .startOf('month')
                            .format(format);
                        time.end = moment()
                            .month(moment().month() - 1)
                            .endOf('month')
                            .format(format);
                        break;
                    case '6': //今年
                        time.start = moment().year(moment().year()).startOf('year').format(format);
                        time.end = moment().year(moment().year()).endOf('year').format(format);
                        break;
                    case '7': //去年
                        time.start = moment()
                            .year(moment().year() - 1)
                            .startOf('year')
                            .format(format);
                        time.end = moment()
                            .year(moment().year() - 1)
                            .endOf('year')
                            .format(format);
                        break;
                }
                return time;
            },
            /**
             * 驗證日期
             * @param {陣列，時間資料} times
             * @param {陣列，資料名稱} array
             * @param {時間格式} format
             */
            validDate: function (times, array, format) {
                var I18N = this.getI18N();
                for (let i = 0; i < times.length; i++) {
                    if (!moment(times[i], format, true).isValid()) {
                        var txt = '「' + I18N.getText(array[i]) + '」' + I18N.getText('g.is.wrong');
                        MessageBox.error(txt);
                        throw txt;
                    }
                }
            },

            /**
             *
             * @param {設定的陣列} arr
             * @param {排序的key} key
             * @param {*} flag
             */
            sort: function (arr, key, flag) {
                if (flag) {
                    return arr.sort((a, b) => (a[key] < b[key] ? 1 : a[key] == b[key] ? 0 : -1));
                } else {
                    return arr.sort((a, b) => (a[key] > b[key] ? 1 : a[key] == b[key] ? 0 : -1));
                }
            },
            /**
             *
             * @param {為json} arr
             * @param {設定的key} key
             */
            setSeq(arr, key) {
                for (let i = 0; i < arr.length; i++) {
                    arr[i][key] = i + 1;
                }
                return arr;
            },
            /**
             * 第一參數為i18n的key，非value
             * 其他為i18n的value中的{0},{1}...
             */
            stringFormat: function (args) {
                if (arguments.length == 0) return null;
                var str = arguments[0];
                for (var i = 1; i < arguments.length; i++) {
                    var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
                    str = str.replace(re, arguments[i]);
                }
                return str;
            },
            error: function (txt) {
                txt = this.getI18N().getText(txt);
                MessageBox.error(txt);
                throw txt;
            },
            /**
             * 第一參數為i18n的key，非value
             * 其他為i18n的value中的{0},{1}...
             */
            i18nFormatError: function (args) {
                if (arguments.length == 0) return null;
                var str = this.getI18N().getText(arguments[0]);
                for (var i = 1; i < arguments.length; i++) {
                    var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
                    str = str.replace(re, arguments[i]);
                }
                MessageBox.error(str);
                throw str;
            },
            handleChange: function (oEvent) {
                var oDP = oEvent.getSource(),
                    bValid = oEvent.getParameter('valid');
                if (bValid) {
                    oDP.setValueState(sap.ui.core.ValueState.None);
                } else {
                    oDP.setValueState(sap.ui.core.ValueState.Error);
                }
            },
            /**
             * 預設跳過'site', 'user', 'activity'
             * @param {json 清除的資料} data
             * @param {array 跳過的key} exclude
             */
            clearData: function (data, exclude) {
                var keys = ['site', 'user', 'activity'];
                var include = Object.keys(data);
                if (exclude) {
                    keys = keys.concat(exclude);
                }
                for (let i = 0; i < include.length; i++) {
                    if (keys.indexOf(include[i]) != -1) {
                        continue;
                    }
                    switch (typeof data[include[i]]) {
                        case 'string':
                            data[include[i]] = '';
                            break;
                        case 'number':
                            data[include[i]] = '';
                            break;
                        case 'boolean':
                            data[include[i]] = false;
                            break;
                        case 'object':
                            if (Array.isArray(data[include[i]])) {
                                data[include[i]] = [];
                            }
                            break;
                    }
                }
            },
            /**
             *
             * @param {'new','before','after','delete','all'} doWhat
             * @param {表id，僅限listBase的table} tableId
             */
            doTable: function (doWhat, tableId) {
                var me = this;
                var oData = this.getData();
                var table = this.byId(tableId);
                var path = table.getBinding('rows').getPath();
                var indices = table.getSelectedIndices();
                if (doWhat == 'new') {
                    oData[path].push({});
                } else if (doWhat == 'all') {
                    oData[path] = [];
                } else if (indices.length != 0) {
                    switch (doWhat) {
                        case 'before':
                            oData[path].splice(indices[0], 0, {});
                            break;
                        case 'after':
                            oData[path].splice(indices[0] + 1, 0, {});
                            break;
                        case 'delete':
                            indices.reverse().forEach(function (index) {
                                oData[path].splice(index, 1);
                            });
                            break;
                    }
                }
                me.setSeq(me.getData()[path], 'seq');
                table.clearSelection();
                me.refresh();
            },
            removeAllEventDelegate: function () {
                for (var i = this.oView.aDelegates.length - 1; i >= 0; i--) {
                    this.oView.removeEventDelegate(this.oView.aDelegates[i]);
                }
            },
            /**
             *
             * @param {表id} id
             * @param {boolean}} functKey 回傳是否讓checkBox選擇，function(value,index,array)
             */
            changeTebelAllCheckBox: function (id, functKey) {
                var me = this;
                var table = me.byId(id);
                var data = this.getProperty(table.getBindingInfo('items').path);
                var items = [];
                for (let i = 0; i < data.length; i++) {
                    let item = table.getAggregation('items')[i];
                    let checkBox = sap.ui.getCore().byId(item.sId + '-selectMulti');
                    let flag = functKey(data[i], i, data);
                    if (flag) {
                        items.push({
                            id: item.sId + '-selectMulti',
                            path: checkBox.getBindingContext(undefined).getPath()
                        });
                    }
                    //設定checkBox能選
                    checkBox.setEnabled(flag);
                    checkBox.mEventRegistry.select[0].fFunction = function (evt) {
                        var path = evt.getSource().getBindingContext(undefined).getPath();

                        //設定選擇後是否要打勾全選
                        if (evt.getParameter('selected')) {
                            let all = true;
                            for (let j = 0; j < items.length; j++) {
                                if (sap.ui.getCore().byId(items[j].id).getSelected() == false) {
                                    all = false;
                                }
                            }
                            table._selectAllCheckBox.setSelected(all);
                            table._aSelectedPaths.push(path);
                        } else {
                            //全選取消
                            table._selectAllCheckBox.setSelected(false);
                            table._aSelectedPaths.splice(table._aSelectedPaths.indexOf(path), 1);
                        }
                    };
                }
                if (data.length) {
                    table._selectAllCheckBox.mEventRegistry.select[0].fFunction = function (evt) {
                        if (
                            evt.getParameter('selected') &&
                            (table.getAggregation('items').length == 0 || items.length == 0)
                        ) {
                            table._selectAllCheckBox.setSelected(false);
                        } else {
                            for (let i = 0; i < items.length; i++) {
                                var index = table._aSelectedPaths.indexOf(items[i].path);
                                if (evt.getParameter('selected')) {
                                    sap.ui.getCore().byId(items[i].id).setSelected(true);
                                    if (index == -1) {
                                        table._aSelectedPaths.push(items[i].path);
                                    }
                                } else {
                                    sap.ui.getCore().byId(items[i].id).setSelected(false);
                                    if (index != -1) {
                                        table._aSelectedPaths.splice(index, 1);
                                    }
                                }
                            }
                        }
                    };
                }
            },
            //
            tokenUpdate: function (oEvent) {
                var oSource = oEvent.getSource();
                var type = oEvent.getParameter('type');
                var tokens = oSource.getAggregation('tokenizer').getBindingInfo('tokens');
                var keyPath = tokens.template.getBindingInfo('key').parts[0].path;
                var textPath = tokens.template.getBindingInfo('text').parts[0].path;
                var oModel = tokens.binding.oModel;
                var oContext = tokens.binding.oContext;
                var table;
                var data;
                if (oContext) {
                    table = tokens.binding.oContext.sPath;
                }
                if (table) {
                    data = oModel.getProperty(table + '/' + tokens.path);
                } else {
                    data = oModel.getProperty(tokens.path);
                }
                if (type == 'removed') {
                    var value = oEvent.getParameter('removedTokens')[0].getKey();
                    var index = data.findIndex((x) => x[keyPath] == value);
                    data.splice(index, 1);
                } else {
                    var keyValue = oEvent.getParameter('addedTokens')[0].getKey();
                    var text = oEvent.getParameter('addedTokens')[0].getText();
                    var obj = {};
                    obj[keyPath] = keyValue;
                    obj[textPath] = text;
                    data.push(obj);
                }
                oModel.refresh();
            },
            //enter增加token
            addToken: function (oEvent) {
                var oSource = oEvent.getSource();
                var value = oSource.getValue();
                oSource.setValue('');
                if (value != '') {
                    var tokens = oSource.getAggregation('tokenizer').getBindingInfo('tokens');
                    var key = tokens.template.getBindingInfo('key').parts[0].path;
                    var oModel = tokens.binding.oModel;
                    var oContext = tokens.binding.oContext;
                    var table;
                    var data;
                    if (oContext) {
                        table = tokens.binding.oContext.sPath;
                    }
                    if (table) {
                        data = oModel.getProperty(table + '/' + tokens.path);
                    } else {
                        data = oModel.getProperty(tokens.path);
                    }
                    if (data.findIndex((x) => x[key] == value) == -1) {
                        var obj = {};
                        obj[key] = value;
                        data.push(obj);
                        oModel.refresh();
                    }
                }
            },
            //秒轉時間
            timeFormat: function (second) {
                return [parseInt(second / 60 / 60), (second / 60) % 60, second % 60]
                    .join(':')
                    .replace(/\b(\d)\b/g, '0$1');
            },
            //計算陣列key總和
            sumKey: function (data, key) {
                var value = data
                    .map((x) => x[key])
                    .reduce((a, b) => a + ($.isNumeric(b) ? parseFloat(b) : 0), 0);
                return $.isNumeric(value) && value !== 0 ? value : 0;
            },
            keyToKey: function (from, to) {
                var keys = Object.keys(from);
                var toKeys = Object.keys(to);
                for (let key of keys) {
                    if (toKeys.indexOf(key) !== -1) {
                        if (Array.isArray(to[key])) {
                            let o = {};
                            o[key] = from[key];
                            to[key].push(o);
                        } else {
                            to[key] = from[key];
                        }
                    }
                }
                return to;
            },
            isJsonString(str) {
                try {
                    if (typeof JSON.parse(str) == 'object') {
                        return true;
                    }
                } catch (e) {}
                return false;
            },
            /**
             * 防止輸入中文、全部空白、特殊字符
             * @param {*} value
             */
            chkChineseSpace: function (value, key) {
                var I18N = this.getI18N();
                if (!key) key = '';
                if (escape(value).indexOf('%u') == 0) {
                    this.i18nFormatError('g.error1', I18N.getText(key));
                }

                if (value.replace(/\s/g, '').length == 0) {
                    this.i18nFormatError('g.error2', I18N.getText(key));
                }

                if (value.match(/[\w.-]/g) == null) {
                    this.i18nFormatError('g.error3', I18N.getText(key));
                }

                if (value.match(/[\w.-]/g).length < value.length) {
                    this.i18nFormatError('g.error4', I18N.getText(key));
                }
            },
            /**
             * 數字卡控
             * @param {*} number 傳入數字
             * @param {*} max 最大幾位
             * @param {*} negative 是否能負數 true:不能 false:能
             * @param {*} decimal 是否能小數 true:不能 false:能
             * @param {*} decimalMax 小數點最多幾位
             * @param {*} symbol 是否能符號 true:不能 false:能
             *
             */
            numberControl: function (oEvent) {
                var oSource = oEvent.getSource();
                var customDatas = oSource.getCustomData();
                var number = oSource.getValue();
                var max, negative, decimal, decimalMax, symbol;
                if (customDatas) {
                    customDatas.forEach(function (cData, index) {
                        switch (cData.getKey().toUpperCase()) {
                            case 'max'.toUpperCase():
                                if (cData.getValue()) max = parseInt(cData.getValue());
                                break;
                            case 'negative'.toUpperCase():
                                negative = cData.getValue() == 'true' ? true : false;
                                break;
                            case 'decimal'.toUpperCase():
                                decimal = cData.getValue() == 'true' ? true : false;
                                break;
                            case 'decimalMax'.toUpperCase():
                                if (cData.getValue()) decimalMax = parseInt(cData.getValue());
                                break;
                            case 'symbol'.toUpperCase():
                                symbol = cData.getValue() == 'true' ? true : false;
                                break;
                        }
                    });
                }

                number = number.replace(/[A-Za-z]/g, ''); // 不能英文
                number = number.replace(/[^\x00-\x80]/g, ''); // 不能中文
                number = number.replace(/[^\d\\?\\*\\,\\/.-]/g, ''); // 不能? * , . - /以外符號

                if (max > 0) number = number.substring(0, max);

                if (negative) number = number.replace(/-/g, '');

                if (decimal) number = number.replace(/\./g, '');

                if (symbol) {
                    number = number.replace(/[/\\?\\*\\,]/g, '');
                }

                if (number.match(/\./g)) {
                    var arr = number.split('.');
                    number = arr[0] + '.' + arr[1].substring(0, decimalMax);
                }

                oSource.setValue(number);
            },
            /**
             * 中文字卡控
             * @param {*} Symbol 是否能符號 true:不能 false:能
             */
            stringControl: function (oEvent) {
                var oSource = oEvent.getSource();
                var customDatas = oSource.getCustomData();
                var symbol;
                if (customDatas) {
                    customDatas.forEach(function (cData, index) {
                        switch (cData.getKey().toUpperCase()) {
                            case 'symbol'.toUpperCase():
                                symbol = cData.getValue() == 'true' ? true : false;
                                break;
                        }
                    });
                }

                var string = oSource.getValue();
                string = string.replace(/[^\x00-\x80]/g, ''); // 不能中文
                string = string.replace(/[^\w\\?\\*\\,\\/.-]/g, ''); // 不能_ ? * , . - /以外符號

                if (symbol) {
                    string = string.replace(/[/\\?\\*\\,]/g, '');
                }

                oSource.setValue(string);
            },
            /**
             * messageBox
             * @param {Object} {
             *                  key: I18N的key Or ajax Error response,
             *                  type: 彈出類型
             *                  title: 彈出框標題
             *                  actionButton: 按鈕文字
             *                 }
             * @param {Function} action 確認後執行的function
             * @param {Function} cancel 取消後執行的function
             */
            messageBox: function (obj, action, cancel) {
                var i18n = this.getI18N();
                var type = obj.type;
                var title = obj.title;
                var text = this.resolution(obj.key);
                var actionButton = obj.actionButton;
                var actionOk = !this.strIsNullEmpty(actionButton)
                    ? i18n.getText(actionButton)
                    : MessageBox.Action.OK;
                switch (type.toUpperCase()) {
                    case 'CONFIRM':
                        MessageBox.confirm(text, {
                            title: !this.strIsNullEmpty(title)
                                ? i18n.getText('g.confirm')
                                : i18n.getText(title),
                            actions: [MessageBox.Action.OK, MessageBox.Action.CANCEL],
                            onClose: function (sAction) {
                                if (sAction == 'OK') {
                                    if (action) {
                                        action();
                                    }
                                } else {
                                    if (cancel) {
                                        cancel();
                                    }
                                }
                            }
                        });
                        break;
                    case 'ALERT':
                        MessageBox.alert(text, {
                            title: this.strIsNullEmpty(title)
                                ? i18n.getText('g.alert')
                                : i18n.getText(title),
                            onClose: function () {
                                if (cancel) cancel();
                            }
                        });
                        break;
                    case 'ERROR':
                        MessageBox.error('message : ' + text, {
                            title: this.strIsNullEmpty(title)
                                ? i18n.getText('g.error')
                                : i18n.getText(title),
                            onClose: function () {
                                if (cancel) cancel();
                            }
                        });
                        break;
                    case 'INFORMATION':
                        MessageBox.information(text, {
                            title: this.strIsNullEmpty(title)
                                ? i18n.getText('g.information')
                                : i18n.getText(title),
                            onClose: function () {
                                if (cancel) cancel();
                            }
                        });
                        break;
                    case 'WARNING':
                        MessageBox.warning(text, {
                            title: this.strIsNullEmpty(title)
                                ? i18n.getText('g.warning')
                                : i18n.getText(title),
                            actions: [actionOk, MessageBox.Action.CANCEL],
                            onClose: function (sAction) {
                                if (sAction == 'OK') {
                                    if (action) action();
                                } else {
                                    if (cancel) cancel();
                                }
                            }
                        });
                        break;
                    case 'SUCCESS':
                        MessageBox.success(text, {
                            title: this.strIsNullEmpty(title)
                                ? i18n.getText('g.success')
                                : i18n.getText(title),
                            onClose: function () {
                                if (cancel) cancel();
                            }
                        });
                        break;
                }
                throw text;
            },
            /**
             * 解析
             * @param {*} errorCode
             */
            resolution: function (errorCode) {
                var me = this,
                    I18N = me.getI18N();
                if (errorCode.responseText != undefined && errorCode.responseText != '') {
                    if (typeof errorCode.responseText == 'string') {
                        try {
                            let parse = JSON.parse(errorCode.responseText);
                            errorCode = parse.message;
                        } catch (e) {
                            errorCode = errorCode.status + ' ' + errorCode.statusText;
                        }
                    }
                } else if (typeof errorCode == 'string') {
                    if (!this.strIsNullEmpty(I18N.getText(errorCode))) {
                        errorCode = I18N.getText(errorCode);
                    }
                } else {
                    errorCode = 'error, please check';
                }
                return errorCode;
            },
            /**
             * 判斷文字是否為空
             * @param {*} str
             */
            strIsNullEmpty: function (str) {
                if (str == null || str == '' || str == undefined || str.length == 0) {
                    return true;
                }
                return false;
            },
            blobFile: function (res, type) {
                var decodedPdfContent = atob(res);
                //建出uint8陣列
                var byteArray = new Uint8Array(decodedPdfContent.length);
                for (var i = 0; i < decodedPdfContent.length; i++) {
                    byteArray[i] = decodedPdfContent.charCodeAt(i);
                }
                //輸出Blob
                var blob = new Blob([byteArray.buffer], {
                    type: type
                });
                //創建url
                var url = URL.createObjectURL(blob);
                //設定白名單
                jQuery.sap.addUrlWhitelist('blob');
                return url;
            },
            //回傳A~
            getAllColumn: function (length) {
                let e = [];
                for (let i = 0; i < 26; i++) {
                    e.push(String.fromCharCode(i + 65));
                }
                var arr = [];
                for (let i = 0; i < length; i++) {
                    let exc = parseInt(i / 27);
                    let quo = i % 27;
                    arr.push(e[exc] + e[quo]);
                }
                return arr;
            },
            checkEmpty(value) {
                return (
                    value == undefined ||
                    value == null ||
                    value.length == 0 ||
                    value == 'null' ||
                    value == 'undefined' ||
                    (this.isPlainObject(value) && Object.keys(value).length == 0)
                );
            },
            isNotEmpty(value) {
                return !this.checkEmpty(value);
            },
            isNull(value) {
                return value === undefined || value === null;
            },
            isNotNull(value) {
                return !this.isNull(value);
            },

            isTrue(value) {
                return true == value || 'true' == value;
            },
            isFalse(value) {
                return !this.isTrue(value);
            },
            executeVal(value, params) {
                if (this.isFunction(value)) {
                    return value(params);
                } else {
                    return value;
                }
            },
            val(text) {
                try {
                    var returnVal = eval(text);
                    return returnVal;
                } catch (e) {
                    return null;
                }
            },
            valueIn(value, collection) {
                if (this.checkEmpty(collection)) {
                    return false;
                }
                if (this.isArray(collection)) {
                    return collection.indexOf(value) != -1;
                } else {
                    return this.isNotEmpty(collection[value]);
                }
                return false;
            },
            valueListIn(values, collection) {
                if (this.checkEmpty(values) || this.checkEmpty(collection)) {
                    return false;
                }
                var i;
                for (i in values) {
                    if (!this.valueIn(values[i], collection)) {
                        return false;
                    }
                }
                return true;
            },
            collectionContains(collection, value) {
                return this.valueIn(value, collection);
            },
            collectionContainsOne(collection, values) {
                if (this.checkEmpty(collection) || this.checkEmpty(values)) {
                    return false;
                }
                var i;
                for (i in values) {
                    if (this.valueIn(values[i], collection)) {
                        return true;
                    }
                }
                return false;
            },
            isPlainObject(obj) {
                return Object.prototype.toString.call(obj) === '[object Object]';
            },
            isFunction(func) {
                return typeof func == this.TYPE_FUNCTION;
            },
            isArray(obj) {
                return Array.isArray(obj);
            },
            /**
             * ui.Table 黏貼事件
             * table rows path必須為data
             * @param {*} oEvent 綁定的input event
             * @param {*} model model key
             */
            copyPaste: function (oEvent, model) {
                var that = this,
                    I18N = this.getModel('i18n').getResourceBundle();
                oEvent.stopPropagation();
                oEvent.preventDefault();

                if (!model) {
                    model = undefined;
                }

                let oData = this.getModel(model).getData();
                let text = (oEvent.originalEvent || oEvent).clipboardData.getData('text/plain');
                let textArray = text.split(/\n/);
                if (model == 'count') {
                    checkPaste(textArray);
                }

                let pathRow = this.getParent().getBindingContext(model).sPath;
                // get which rowIndex, colName you paste
                let startRowIndex = parseInt(pathRow.split('data' + '/')[1]);
                let startColName = this.getBindingPath('value');
                let startColIndex = '';

                // get Col Index you pasted
                let oTable = this.getParent().getParent();
                let totalRows = oTable.getRows();
                let totalRowsCount = oTable.getBindingInfo('rows').binding.aIndices.length;
                let totalCols = oTable.getColumns();

                for (let i = 0; i < totalCols.length; i++) {
                    let col = totalCols[i];
                    let colKey =
                        col.getAggregation('template').getBindingPath('text') ||
                        col.getAggregation('template').getBindingPath('value');

                    if (colKey === startColName) {
                        startColIndex = parseInt(i);
                    }
                }

                // paste 內容每 row 依序放入 oData
                for (let i = 0; i < textArray.length - 1; i++) {
                    let textArray_element = textArray[i];
                    let cells = textArray_element.split(/\t/);

                    var rowIndex = startRowIndex + i;
                    if (rowIndex >= totalRowsCount) {
                        break;
                    }

                    // 每 row 內容依序放入 Odata key
                    for (let j = 0; j < cells.length; j++) {
                        let a = parseInt(startColIndex) + parseInt(j);

                        if (a < totalCols.length) {
                            let oInfo = totalRows[startRowIndex]
                                .getCells()
                                [startColIndex + j].getBindingInfo('value');
                            if (oInfo) {
                                let key = oInfo.binding.sPath;

                                oData.data[startRowIndex + i][key] = cells[j].replace('\r', '');
                            }
                        }
                    }
                }
                this.getModel(model).refresh();

                function checkPaste(textArray) {
                    let flag = false;

                    for (var i in textArray) {
                        if (textArray[i].length > 0) {
                            var cells = textArray[i].split('\t');
                            for (var k in cells) {
                                var text = cells[k].replace('\r', '');
                                if (text != 'NG' && text != 'G') {
                                    flag = true;
                                }
                            }
                        }
                    }

                    if (flag) {
                        sap.m.MessageBox.error(I18N.getText('msaExecute.count.error1'));
                        throw 'only can G or NG';
                    }
                }
            },
            /**
             * change ui.Table td背景色
             * @param {*} params {
             *      id: table id,
             *      cellArr: [0,1,... ], 改變的列
             *      css: css name
             * }
             */
            changeUiTableCellColor: function (params) {
                var me = this,
                    oTable = me.byId(params.id),
                    cellArr = params.cellArr,
                    css = params.css,
                    rows = oTable.getRows();

                for (var i = 0; i < rows.length; i++) {
                    var cells = rows[i].getAggregation('cells');

                    cellArr.forEach((key) => {
                        var cell = cells[key];
                        var id = '#' + cell.getId();
                        $(id).parent().parent().addClass(css);
                    });
                }
            }
        });
    }
);
