/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){t._get_url_nav=function(){var t={};var e=(document.location.hash||"").replace("#","").split(",");for(var n=0;n<e.length;n++){var a=e[n].split("=");if(a.length==2)t[a[0]]=a[1]}return t};t.attachEvent("onTemplatesReady",function(){var e=true;var n=t.date.str_to_date("%Y-%m-%d");var a=t.date.date_to_str("%Y-%m-%d");var r=t._get_url_nav().event||null;t.attachEvent("onAfterEventDisplay",function(t){r=null;return true});t.attachEvent("onBeforeViewChange",function(i,o,v,l){if(e){e=false;var c=t._get_url_nav();if(c.event){try{if(t.getEvent(c.event)){setTimeout(function(){u(c.event)});return false}else{var f=t.attachEvent("onXLE",function(){setTimeout(function(){u(c.event)});t.detachEvent(f)})}}catch(t){}}if(c.date||c.mode){try{this.setCurrentView(c.date?n(c.date):null,c.mode||null)}catch(t){this.setCurrentView(c.date?n(c.date):null,v)}return false}}var d=["date="+a(l||o),"mode="+(v||i)];if(r){d.push("event="+r)}var s="#"+d.join(",");document.location.hash=s;return true});function u(e){r=e;if(t.getEvent(e)){t.showEvent(e)}}})});