/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){t.attachEvent("onLightBox",function(){if(this._cover){try{this._cover.style.height=this.expanded?"100%":(document.body.parentNode||document.body).scrollHeight+"px"}catch(t){}}});t.form_blocks.select.set_value=function(t,e,i){if(typeof e=="undefined"||e==="")e=(t.firstChild.options[0]||{}).value;t.firstChild.value=e||""}});