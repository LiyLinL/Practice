sap.ui.define(
    ['sap/m/Input', 'sap/ui/dom/jquery/selectText', 'sap/m/Input'],
    function (Input, selectText) {
        'use strict';
        var i = Input.extend('gen.view.lib.cI', {
            metadata: {
                properties: {
                    text: {
                        type: 'string'
                    },
                    test: {
                        type: 'string'
                    }
                },
                aggregations: {},
                events: {
                    newChange: {
                        allowPreventDefault: true,
                        parameters: {
                            material: {
                                type: 'string'
                            },
                            materialDescription: {
                                type: 'string'
                            }
                        }
                    }
                },
                renderer: null
            },
            init: function () {
                Input.prototype.init.call(this);

                this.attachChange(this.onChange);
            },
            renderer: function (oRm, oInput) {
                oRm.write('<Label>');
                oRm.write(oInput.getTest());
                oRm.write(':');
                oRm.write('</Label>');
                sap.m.InputRenderer.render(oRm, oInput);
            },
            onAfterRendering: function (oRm) {
                var that = this,
                    id = oRm.srcControl.sId;

                sap.m.Input.prototype.onAfterRendering.apply(this, arguments);

                if (this.getEditable() && this.getEnabled()) {
                    $('#' + id + '-inner').focus(function () {
                        that.onFocus();
                    });
                }
            },
            setTest: function (sValue) {
                this.setProperty('test', sValue, true);
                return this;
            },
            getTest: function () {
                return this.getProperty('test');
            }
        });

        i.prototype.onFocus = function () {
            this.fireOnFocus();
        };

        i.prototype.onChange = function (e, p, n) {
            var v = this._getInputValue(n);
            var p = this.getChangeEventParams();
            var l = this._lastValue;
            var o = selectText.extend(
                {
                    material: v,
                    materialDescription: v
                },
                p
            );
            if (v != l) {
                this._lastValue = v;
                this.fireNewChange(o);
                return true;
            } else {
                this._bCheckDomValue = false;
            }
        };

        return i;
    }
);
