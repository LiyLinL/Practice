/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.templates.calendar_month=e.date.date_to_str("%F %Y");e.templates.calendar_scale_date=e.date.date_to_str("%D");e.templates.calendar_date=e.date.date_to_str("%d");e.config.minicalendar={mark_events:true};e._synced_minicalendars=[];e.renderCalendar=function(t,a,n){var r=null;var i=t.date||e._currentDate();if(typeof i=="string")i=this.templates.api_date(i);if(!a){var d=t.container;var _=t.position;if(typeof d=="string")d=document.getElementById(d);if(typeof _=="string")_=document.getElementById(_);if(_&&(typeof _.left=="undefined"&&typeof _.right=="undefined")){var l=e.$domHelpers.getOffset(_);_={top:l.top+_.offsetHeight,left:l.left}}if(!d)d=e._get_def_cont(_);r=this._render_calendar(d,i,t);r.onclick=function(t){t=t||event;var a=t.target||t.srcElement;var n=e.$domHelpers;if(n.closest(a,".dhx_month_head")){if(!n.closest(a,".dhx_after")&&!n.closest(a,".dhx_before")){var r=n.closest(a,"[data-cell-date]");var i=r.getAttribute("data-cell-date");var d=e.templates.parse_date(i);e.unmarkCalendar(this);e.markCalendar(this,d,"dhx_calendar_click");this._last_date=d;if(this.conf.handler)this.conf.handler.call(e,d,this)}}}}else{r=this._render_calendar(a.parentNode,i,t,a);e.unmarkCalendar(r)}if(e.config.minicalendar.mark_events){var s=e.date.month_start(i);var o=e.date.add(s,1,"month");var c=this.getEvents(s,o);var u=this["filter_"+this._mode];var f={};for(var h=0;h<c.length;h++){var v=c[h];if(u&&!u(v.id,v))continue;var m=v.start_date;if(m.valueOf()<s.valueOf())m=s;m=e.date.date_part(new Date(m.valueOf()));while(m<v.end_date){if(!f[+m]){f[+m]=true;this.markCalendar(r,m,"dhx_year_event")}m=this.date.add(m,1,"day");if(m.valueOf()>=o.valueOf())break}}}this._markCalendarCurrentDate(r);r.conf=t;if(t.sync&&!n)this._synced_minicalendars.push(r);if(!r.conf._on_xle_handler){r.conf._on_xle_handler=e.attachEvent("onXLE",function t(){e.updateCalendar(r,r.conf.date)})}if(this.config.wai_aria_attributes&&this.config.wai_aria_application_role){r.setAttribute("role","application")}return r};e._get_def_cont=function(e){if(!this._def_count){this._def_count=document.createElement("div");this._def_count.className="dhx_minical_popup";this._def_count.onclick=function(e){(e||event).cancelBubble=true};document.body.appendChild(this._def_count)}if(e.left){this._def_count.style.left=e.left+"px"}if(e.right){this._def_count.style.right=e.right+"px"}if(e.top){this._def_count.style.top=e.top+"px"}if(e.bottom){this._def_count.style.bottom=e.bottom+"px"}this._def_count._created=new Date;return this._def_count};e._locateCalendar=function(t,a){if(typeof a=="string")a=e.templates.api_date(a);if(+a>+t._max_date||+a<+t._min_date)return null;var n=t.querySelector(".dhx_year_body").childNodes[0];var r=0;var i=new Date(t._min_date);while(+this.date.add(i,1,"week")<=+a){i=this.date.add(i,1,"week");r++}var d=e.config.start_on_monday;var _=(a.getDay()||(d?7:0))-(d?1:0);return n.rows[r].cells[_].firstChild};e.markCalendar=function(e,t,a){var n=this._locateCalendar(e,t);if(!n)return;n.className+=" "+a};e.unmarkCalendar=function(e,t,a){t=t||e._last_date;a=a||"dhx_calendar_click";if(!t)return;var n=this._locateCalendar(e,t);if(!n)return;n.className=(n.className||"").replace(RegExp(a,"g"))};e._week_template=function(t){var a=t||250;var n=0;var r=document.createElement("div");var i=this.date.week_start(e._currentDate());for(var d=0;d<7;d++){this._cols[d]=Math.floor(a/(7-d));this._render_x_header(d,n,i,r);i=this.date.add(i,1,"day");a-=this._cols[d];n+=this._cols[d]}r.lastChild.className+=" dhx_scale_bar_last";return r};e.updateCalendar=function(e,t){e.conf.date=t;this.renderCalendar(e.conf,e,true)};e._mini_cal_arrows=["&nbsp;","&nbsp;"];e._render_calendar=function(t,a,n,r){var i=e.templates;var d=this._cols;this._cols=[];var _=this._mode;this._mode="calendar";var l=this._colsS;this._colsS={height:0};var s=new Date(this._min_date);var o=new Date(this._max_date);var c=new Date(e._date);var u=i.month_day;var f=this._ignores_detected;this._ignores_detected=0;i.month_day=i.calendar_date;a=this.date.month_start(a);var h=this._week_template(t.offsetWidth-1-this.config.minicalendar.padding);var v;if(r){v=r}else{v=document.createElement("div");v.className="dhx_cal_container dhx_mini_calendar"}v.setAttribute("date",this._helpers.formatDate(a));v.innerHTML="<div class='dhx_year_month'></div>"+"<div class='dhx_year_grid"+(e.config.rtl?" dhx_grid_rtl'>":"'>")+"<div class='dhx_year_week'>"+(h?h.innerHTML:"")+"</div>"+"<div class='dhx_year_body'></div>"+"</div>";var m=v.querySelector(".dhx_year_month");var p=v.querySelector(".dhx_year_week");var g=v.querySelector(".dhx_year_body");m.innerHTML=this.templates.calendar_month(a);if(n.navigation){var y=function(t,a){var n=e.date.add(t._date,a,"month");e.updateCalendar(t,n);if(e._date.getMonth()==t._date.getMonth()&&e._date.getFullYear()==t._date.getFullYear()){e._markCalendarCurrentDate(t)}};var x=["dhx_cal_prev_button","dhx_cal_next_button"];var w=["left:1px;top:2px;position:absolute;","left:auto; right:1px;top:2px;position:absolute;"];var b=[-1,1];var k=function(t){return function(){if(n.sync){var a=e._synced_minicalendars;for(var r=0;r<a.length;r++){y(a[r],t)}}else{if(e.config.rtl){t=-t}y(v,t)}}};var C=[e.locale.labels.prev,e.locale.labels.next];for(var D=0;D<2;D++){var E=document.createElement("div");E.className=x[D];e._waiAria.headerButtonsAttributes(E,C[D]);E.style.cssText=w[D];E.innerHTML=this._mini_cal_arrows[D];m.appendChild(E);E.onclick=k(b[D])}}v._date=new Date(a);v.week_start=(a.getDay()-(this.config.start_on_monday?1:0)+7)%7;var H=v._min_date=this.date.week_start(a);v._max_date=this.date.add(v._min_date,6,"week");this._reset_month_scale(g,a,H,6);if(!r)t.appendChild(v);p.style.height=p.childNodes[0].offsetHeight-1+"px";var N=e.uid();e._waiAria.minicalHeader(m,N);e._waiAria.minicalGrid(v.querySelector(".dhx_year_grid"),N);e._waiAria.minicalRow(p);var O=p.querySelectorAll(".dhx_scale_bar");for(var M=0;M<O.length;M++){e._waiAria.minicalHeadCell(O[M])}var S=g.querySelectorAll("td");var T=new Date(H);for(var M=0;M<S.length;M++){e._waiAria.minicalDayCell(S[M],new Date(T));T=e.date.add(T,1,"day")}e._waiAria.minicalHeader(m,N);this._cols=d;this._mode=_;this._colsS=l;this._min_date=s;this._max_date=o;e._date=c;i.month_day=u;this._ignores_detected=f;return v};e.destroyCalendar=function(t,a){if(!t&&this._def_count&&this._def_count.firstChild){if(a||(new Date).valueOf()-this._def_count._created.valueOf()>500)t=this._def_count.firstChild}if(!t)return;t.onclick=null;t.innerHTML="";if(t.parentNode)t.parentNode.removeChild(t);if(this._def_count)this._def_count.style.top="-1000px";if(t.conf&&t.conf._on_xle_handler)e.detachEvent(t.conf._on_xle_handler)};e.isCalendarVisible=function(){if(this._def_count&&parseInt(this._def_count.style.top,10)>0)return this._def_count;return false};e._attach_minical_events=function(){e.event(document.body,"click",function(){e.destroyCalendar()});e._attach_minical_events=function(){}};e.attachEvent("onTemplatesReady",function(){e._attach_minical_events()});e.templates.calendar_time=e.date.date_to_str("%d-%m-%Y");e.form_blocks.calendar_time={render:function(t){var a="<input class='dhx_readonly' type='text' readonly='true'>";var n=e.config;var r=this.date.date_part(e._currentDate());var i=24*60,d=0;if(n.limit_time_select){d=60*n.first_hour;i=60*n.last_hour+1}r.setHours(d/60);t._time_values=[];a+=" <select class='dhx_lightbox_time_select'>";for(var _=d;_<i;_+=this.config.time_step*1){var l=this.templates.time_picker(r);a+="<option value='"+_+"'>"+l+"</option>";t._time_values.push(_);r=this.date.add(r,this.config.time_step,"minute")}a+="</select>";var s=e.config.full_day;return"<div style='height:30px;padding-top:0; font-size:inherit;' class='dhx_section_time dhx_lightbox_minical'>"+a+"<span style='font-weight:normal; font-size:10pt;'> &nbsp;&ndash;&nbsp; </span>"+a+"</div>"},set_value:function(t,a,n,r){var i=t.getElementsByTagName("input");var d=t.getElementsByTagName("select");var _,l;var s=function(t,a,n){t.onclick=function(){e.destroyCalendar(null,true);e.renderCalendar({position:t,date:new Date(this._date),navigation:true,handler:function(a){t.value=e.templates.calendar_time(a);t._date=new Date(a);e.destroyCalendar();if(e.config.event_duration&&e.config.auto_end_date&&n===0){f()}}})}};if(e.config.full_day){if(!t._full_day){var o="<label class='dhx_fullday'><input type='checkbox' name='full_day' value='true'> "+e.locale.labels.full_day+"&nbsp;</label></input>";if(!e.config.wide_form)o=t.previousSibling.innerHTML+o;t.previousSibling.innerHTML=o;t._full_day=true}var c=t.previousSibling.getElementsByTagName("input")[0];var u=e.date.time_part(n.start_date)===0&&e.date.time_part(n.end_date)===0;c.checked=u;d[0].disabled=c.checked;d[1].disabled=c.checked;c.onclick=function(){if(c.checked===true){var a={};e.form_blocks.calendar_time.get_value(t,a);_=e.date.date_part(a.start_date);l=e.date.date_part(a.end_date);if(+l==+_||+l>=+_&&(n.end_date.getHours()!==0||n.end_date.getMinutes()!==0))l=e.date.add(l,1,"day")}var r=_||n.start_date;var s=l||n.end_date;h(i[0],r);h(i[1],s);d[0].value=r.getHours()*60+r.getMinutes();d[1].value=s.getHours()*60+s.getMinutes();d[0].disabled=c.checked;d[1].disabled=c.checked}}if(e.config.event_duration&&e.config.auto_end_date){var f=function(){_=e.date.add(i[0]._date,d[0].value,"minute");l=new Date(_.getTime()+e.config.event_duration*60*1e3);i[1].value=e.templates.calendar_time(l);i[1]._date=e.date.date_part(new Date(l));d[1].value=l.getHours()*60+l.getMinutes()};d[0].onchange=f}function h(t,a,n){s(t,a,n);t.value=e.templates.calendar_time(a);t._date=e.date.date_part(new Date(a))}h(i[0],n.start_date,0);h(i[1],n.end_date,1);s=function(){};function v(e){var t=r._time_values;var a=e.getHours()*60+e.getMinutes();var n=a;var i=false;for(var d=0;d<t.length;d++){var _=t[d];if(_===a){i=true;break}if(_<a)n=_}if(!(i||n))return-1;return i?a:n}d[0].value=v(n.start_date);d[1].value=v(n.end_date)},get_value:function(t,a){var n=t.getElementsByTagName("input");var r=t.getElementsByTagName("select");a.start_date=e.date.add(n[0]._date,r[0].value,"minute");a.end_date=e.date.add(n[1]._date,r[1].value,"minute");if(a.end_date<=a.start_date)a.end_date=e.date.add(a.start_date,e.config.time_step,"minute");return{start_date:new Date(a.start_date),end_date:new Date(a.end_date)}},focus:function(e){}};e.linkCalendar=function(t,a){var n=function(){var n=e._date;var r=new Date(n.valueOf());if(a)r=a(r);r.setDate(1);e.updateCalendar(t,r);return true};e.attachEvent("onViewChange",n);e.attachEvent("onXLE",n);e.attachEvent("onEventAdded",n);e.attachEvent("onEventChanged",n);e.attachEvent("onEventDeleted",n);n()};e._markCalendarCurrentDate=function(t){var a=e.getState();var n=a.min_date;var r=a.max_date;var i=a.mode;var d=e.date.month_start(new Date(t._date));var _=e.date.add(d,1,"month");var l={month:true,year:true,agenda:true,grid:true};if(l[i]||n.valueOf()<=d.valueOf()&&r.valueOf()>=_.valueOf()){return}var s=n;while(s.valueOf()<r.valueOf()){if(d.valueOf()<=s.valueOf()&&_>s){e.markCalendar(t,s,"dhx_calendar_click")}s=e.date.add(s,1,"day")}};e.attachEvent("onEventCancel",function(){e.destroyCalendar(null,true)})});