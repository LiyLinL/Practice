/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.attachEvent("onTemplatesReady",function(){e.xy.scroll_width=0;var t=e.render_view_data;e.render_view_data=function(){var i=this._els["dhx_cal_data"][0];i.firstChild._h_fix=true;t.apply(e,arguments);var h=parseInt(i.style.height);i.style.height="1px";i.style.height=i.scrollHeight+"px";this._obj.style.height=this._obj.clientHeight+i.scrollHeight-h+"px"};var i=e._reset_month_scale;e._reset_month_scale=function(t,h,l,n){var a={clientHeight:100};i.apply(e,[a,h,l,n]);t.innerHTML=a.innerHTML}})});