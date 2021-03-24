/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){(function(){var n={use_id:false};function t(e){var t={};for(var i in e)if(i.indexOf("_")!==0)t[i]=e[i];if(!n.use_id)delete t.id;return t}var i;function r(){clearTimeout(i);i=setTimeout(function(){e.updateView()},1)}function o(e){e._loading=true;e._not_render=true;e.callEvent("onXLS",[])}function a(e){e._not_render=false;if(e._render_wait)e.render_view_data();e._loading=false;e.callEvent("onXLE",[])}function c(e){return n.use_id?e.id:e.cid}e.backbone=function(i,u){if(u)n=u;i.bind("change",function(n,t){var i=c(n);var o=e._events[i]=n.toJSON();o.id=i;e._init_event(o);r()});i.bind("remove",function(n,t){var i=c(n);if(e._events[i])e.deleteEvent(i)});var d=[];function v(){if(d.length){e.parse(d,"json");d=[]}}i.bind("add",function(n,t){var i=c(n);if(!e._events[i]){var r=n.toJSON();r.id=i;e._init_event(r);d.push(r);if(d.length==1)setTimeout(v,1)}});i.bind("request",function(n){if(n instanceof Backbone.Collection)o(e)});i.bind("sync",function(n){if(n instanceof Backbone.Collection)a(e)});i.bind("error",function(n){if(n instanceof Backbone.Collection)a(e)});e.attachEvent("onEventCreated",function(n){var t=new i.model(e.getEvent(n));e._events[n]=t.toJSON();e._events[n].id=n;return true});e.attachEvent("onEventAdded",function(n){if(!i.get(n)){var r=t(e.getEvent(n));var o=new i.model(r);var a=c(o);if(a!=n)this.changeEventId(n,a);i.add(o);i.trigger("scheduler:add",o)}return true});e.attachEvent("onEventChanged",function(n){var r=i.get(n);var o=t(e.getEvent(n));r.set(o);i.trigger("scheduler:change",r);return true});e.attachEvent("onEventDeleted",function(e){var n=i.get(e);if(n){i.trigger("scheduler:remove",n);i.remove(e)}return true})}})()});