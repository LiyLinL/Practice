sap.ui.define(
    ['sap/m/Input', 'sap/ui/dom/jquery/selectText', 'sap/m/Label'],
    function (Input, selectText, Label) {
        'use strict';
        var i = Input.extend('gen.view.lib.customInput', {
            metadata: {
                properties: {
                    label: {
                        type: 'string'
                    }
                },
                aggregations: {
                    _label: { type: 'sap.m.Label', multiple: false, visibility: 'hidden' }
                },
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
                var that = this;
                Input.prototype.init.call(this);

                this.setAggregation(
                    '_label',
                    new Label({
                        text: ''
                    }).addStyleClass('sapUiSmallMargin')
                );

                this.attachChange(this.onChange);
            },
            renderer: function (oRm, oInput) {
                oRm.renderControl(oInput.getAggregation('_label'));
                sap.m.InputRenderer.render(oRm, oInput);
            },
            onAfterRendering: function (oRm) {
                var that = this,
                    id = oRm.srcControl.sId;

                sap.m.Input.prototype.onAfterRendering.apply(this, arguments);

                that.getAggregation('_label').setText(that.getLabel());
            }
        });

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
