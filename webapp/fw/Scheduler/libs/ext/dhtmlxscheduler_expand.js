/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.expand=function(){if(!e.callEvent("onBeforeExpand",[]))return;var t=e._obj;do{t._position=t.style.position||"";t.style.position="static"}while((t=t.parentNode)&&t.style);t=e._obj;t.style.position="absolute";t._width=t.style.width;t._height=t.style.height;t.style.width=t.style.height="100%";t.style.top=t.style.left="0px";var o=document.body;o.scrollTop=0;o=o.parentNode;if(o)o.scrollTop=0;document.body._overflow=document.body.style.overflow||"";document.body.style.overflow="hidden";e._maximize();e.callEvent("onExpand",[])};e.collapse=function(){if(!e.callEvent("onBeforeCollapse",[]))return;var t=e._obj;do{t.style.position=t._position}while((t=t.parentNode)&&t.style);t=e._obj;t.style.width=t._width;t.style.height=t._height;document.body.style.overflow=document.body._overflow;e._maximize();e.callEvent("onCollapse",[])};e.attachEvent("onTemplatesReady",function(){var t=document.createElement("div");t.className="dhx_expand_icon";e.toggleIcon=t;e._obj.appendChild(t);t.onclick=function(){if(!e.expanded)e.expand();else e.collapse()}});e._maximize=function(){this.expanded=!this.expanded;this.toggleIcon.style.backgroundPosition="0 "+(this.expanded?"0":"18")+"px";var t=["left","top"];for(var o=0;o<t.length;o++){var n=e.xy["margin_"+t[o]];var i=e["_prev_margin_"+t[o]];if(e.xy["margin_"+t[o]]){e["_prev_margin_"+t[o]]=e.xy["margin_"+t[o]];e.xy["margin_"+t[o]]=0}else{if(i){e.xy["margin_"+t[o]]=e["_prev_margin_"+t[o]];delete e["_prev_margin_"+t[o]]}}}e.setCurrentView()}});