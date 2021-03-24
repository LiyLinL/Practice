/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){t.attachEvent("onTemplatesReady",function(){var a=new dhtmlDragAndDropObject;var e=a.stopDrag;var n;a.stopDrag=function(t){n=t||event;return e.apply(this,arguments)};function r(a,e,r,o){if(t.checkEvent("onBeforeExternalDragIn")&&!t.callEvent("onBeforeExternalDragIn",[a,e,r,o,n]))return;var d=t.attachEvent("onEventCreated",function(e){if(!t.callEvent("onExternalDragIn",[e,a,n])){this._drag_mode=this._drag_id=null;this.deleteEvent(e)}});var _=t.getActionData(n);var i={start_date:new Date(_.date)};if(t.matrix&&t.matrix[t._mode]){var l=t.matrix[t._mode];i[l.y_property]=_.section;var c=t._locate_cell_timeline(n);i.start_date=l._trace_x[c.x];i.end_date=t.date.add(i.start_date,l.x_step,l.x_unit)}if(t._props&&t._props[t._mode]){i[t._props[t._mode].map_to]=_.section}t.addEventNow(i);t.detachEvent(d)}a.addDragLanding(t._els["dhx_cal_data"][0],{_drag:function(t,a,e,n){r(t,a,e,n)},_dragIn:function(t,a){return t},_dragOut:function(t){return this}});if(dhtmlx.DragControl){dhtmlx.DragControl.addDrop(t._els["dhx_cal_data"][0],{onDrop:function(t,a,e,o){var d=dhtmlx.DragControl.getMaster(t);n=o;r(t,d,a,o.target||o.srcElement)},onDragIn:function(t,a,e){return a}},true)}})});