/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.attachEvent("onTemplatesReady",function(){var n=document.body.getElementsByTagName("DIV");for(var t=0;t<n.length;t++){var a=n[t].className||"";a=a.split(":");if(a.length==2&&a[0]=="template"){var r='return "'+(n[t].innerHTML||"").replace(/\"/g,'\\"').replace(/[\n\r]+/g,"")+'";';r=unescape(r).replace(/\{event\.([a-z]+)\}/g,function(e,n){return'"+ev.'+n+'+"'});e.templates[a[1]]=Function("start","end","ev",r);n[t].style.display="none"}}})});