/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){(function(){function t(e,t,i){var n=e+"="+i+(t?"; "+t:"");document.cookie=n}function i(e){var t=e+"=";if(document.cookie.length>0){var i=document.cookie.indexOf(t);if(i!=-1){i+=t.length;var n=document.cookie.indexOf(";",i);if(n==-1)n=document.cookie.length;return document.cookie.substring(i,n)}}return""}var n=true;e.attachEvent("onBeforeViewChange",function(a,o,r,u){if(n&&e._get_url_nav){var s=e._get_url_nav();if(s.date||s.mode||s.event){n=false}}var c=(e._obj.id||"scheduler")+"_settings";if(n){n=false;var f=i(c);if(f){if(!e._min_date){e._min_date=u}f=unescape(f).split("@");f[0]=this._helpers.parseDate(f[0]);var d=this.isViewExists(f[1])?f[1]:r,l=!isNaN(+f[0])?f[0]:u;window.setTimeout(function(){e.setCurrentView(l,d)},1);return false}}var v=escape(this._helpers.formatDate(u||o)+"@"+(r||a));t(c,"expires=Sun, 31 Jan 9999 22:00:00 GMT",v);return true});var a=e._load;e._load=function(){var t=arguments;if(!e._date){var i=this;window.setTimeout(function(){a.apply(i,t)},1)}else{a.apply(this,t)}}})()});