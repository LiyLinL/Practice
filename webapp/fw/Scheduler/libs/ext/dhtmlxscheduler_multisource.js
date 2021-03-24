/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){(function(){function o(t){var o=function(){};o.prototype=t;return o}var n=t._load;t._load=function(t,l){t=t||this._load_url;if(typeof t=="object"){var e=o(this._loaded);for(var i=0;i<t.length;i++){this._loaded=new e;n.call(this,t[i],l)}}else n.apply(this,arguments)}})()});