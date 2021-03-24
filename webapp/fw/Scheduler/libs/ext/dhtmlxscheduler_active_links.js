/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){t.config.active_link_view="day";t._active_link_click=function(e){var i=e.target||event.srcElement;var a=i.getAttribute("jump_to");var _=t.date.str_to_date(t.config.api_date);if(a){t.setCurrentView(_(a),t.config.active_link_view);if(e&&e.preventDefault)e.preventDefault();return false}};t.attachEvent("onTemplatesReady",function(){var e=function(e,i){i=i||e+"_scale_date";if(!t.templates["_active_links_old_"+i]){t.templates["_active_links_old_"+i]=t.templates[i]}var a=t.templates["_active_links_old_"+i];var _=t.date.date_to_str(t.config.api_date);t.templates[i]=function(t){return"<a jump_to='"+_(t)+"' href='#'>"+a(t)+"</a>"}};e("week");e("","month_day");if(this.matrix){for(var i in this.matrix)e(i)}this._detachDomEvent(this._obj,"click",t._active_link_click);t.event(this._obj,"click",t._active_link_click)})});