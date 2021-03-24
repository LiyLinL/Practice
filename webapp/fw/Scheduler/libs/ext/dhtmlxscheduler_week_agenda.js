/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e._wa={};e.xy.week_agenda_scale_height=20;e.templates.week_agenda_event_text=function(a,t,_,d){return e.templates.event_date(a)+" "+_.text};e.date.week_agenda_start=e.date.week_start;e.date.week_agenda_end=function(a){return e.date.add(a,7,"day")};e.date.add_week_agenda=function(a,t){return e.date.add(a,t*7,"day")};e.attachEvent("onSchedulerReady",function(){var a=e.templates;if(!a.week_agenda_date)a.week_agenda_date=a.week_date});(function(){var a=e.date.date_to_str("%l, %F %d");e.templates.week_agenda_scale_date=function(e){return a(e)}})();e.attachEvent("onTemplatesReady",function(){var a=e.render_data;e.render_data=function(t){if(this._mode=="week_agenda"){e.week_agenda_view(true)}else return a.apply(this,arguments)};var t=function(){e._cols=[];var a=parseInt(e._els["dhx_cal_data"][0].style.width);e._cols.push(Math.floor(a/2));e._cols.push(a-e._cols[0]-1);e._colsS={0:[],1:[]};var t=parseInt(e._els["dhx_cal_data"][0].style.height);for(var _=0;_<3;_++){e._colsS[0].push(Math.floor(t/(3-e._colsS[0].length)));t-=e._colsS[0][_]}e._colsS[1].push(e._colsS[0][0]);e._colsS[1].push(e._colsS[0][1]);t=e._colsS[0][e._colsS[0].length-1];e._colsS[1].push(Math.floor(t/2));e._colsS[1].push(t-e._colsS[1][e._colsS[1].length-1])};var _=function(){t();e._els["dhx_cal_data"][0].innerHTML="";e._rendered=[];var a="";for(var _=0;_<2;_++){var d=e._cols[_];var l="dhx_wa_column";if(_==1)l+=" dhx_wa_column_last";a+="<div class='"+l+"' style='width: "+d+"px;'>";for(var s=0;s<e._colsS[_].length;s++){var n=e.xy.week_agenda_scale_height-2;var r=e._colsS[_][s]-n-2;var i=Math.min(6,s*2+_);a+="<div class='dhx_wa_day_cont'><div style='height:"+n+"px; line-height:"+n+"px;' class='dhx_wa_scale_bar'></div><div style='height:"+r+"px;' class='dhx_wa_day_data' day='"+i+"'></div></div>"}a+="</div>"}var c=e._getNavDateElement();if(c){c.innerHTML=e.templates[e._mode+"_date"](e._min_date,e._max_date,e._mode)}e._els["dhx_cal_data"][0].innerHTML=a;var o=e._els["dhx_cal_data"][0].getElementsByTagName("div");var h=[];for(var _=0;_<o.length;_++){if(o[_].className=="dhx_wa_day_cont")h.push(o[_])}e._wa._selected_divs=[];var v=e.get_visible_events();var f=e.date.week_start(e._date);var u=e.date.add(f,1,"day");for(var _=0;_<7;_++){h[_]._date=f;e._waiAria.weekAgendaDayCell(h[_],f);var g=h[_].childNodes[0];var p=h[_].childNodes[1];g.innerHTML=e.templates.week_agenda_scale_date(f);var w=[];for(var x=0;x<v.length;x++){var m=v[x];if(m.start_date<u&&m.end_date>f)w.push(m)}w.sort(function(e,a){if(e.start_date.valueOf()==a.start_date.valueOf())return e.id>a.id?1:-1;return e.start_date>a.start_date?1:-1});for(var s=0;s<w.length;s++){var y=w[s];var k=document.createElement("div");e._rendered.push(k);var S=e.templates.event_class(y.start_date,y.end_date,y);k.className="dhx_wa_ev_body"+(S?" "+S:"");if(e.config.rtl)k.className+=" dhx_wa_ev_body_rtl";if(y._text_style)k.style.cssText=y._text_style;if(y.color)k.style.background=y.color;if(y.textColor)k.style.color=y.textColor;if(e._select_id&&y.id==e._select_id&&!(!e.config.week_agenda_select&&e.config.week_agenda_select!==undefined)){k.className+=" dhx_cal_event_selected";e._wa._selected_divs.push(k)}var b="";if(!y._timed){b="middle";if(y.start_date.valueOf()>=f.valueOf()&&y.start_date.valueOf()<=u.valueOf())b="start";if(y.end_date.valueOf()>=f.valueOf()&&y.end_date.valueOf()<=u.valueOf())b="end"}k.innerHTML=e.templates.week_agenda_event_text(y.start_date,y.end_date,y,f,b);k.setAttribute("event_id",y.id);e._waiAria.weekAgendaEvent(k,y);p.appendChild(k)}f=e.date.add(f,1,"day");u=e.date.add(u,1,"day")}};e.week_agenda_view=function(a){e._min_date=e.date.week_start(e._date);e._max_date=e.date.add(e._min_date,1,"week");e.set_sizes();if(a){e._table_view=e._allow_dnd=true;if(e._wa._prev_data_border===undefined)e._wa._prev_data_border=e._els["dhx_cal_data"][0].style.borderTopWidth;e._els["dhx_cal_data"][0].style.borderTopWidth=0;e._els["dhx_cal_data"][0].style.overflowY="hidden";e._els["dhx_cal_date"][0].innerHTML="";e._els["dhx_cal_data"][0].style.top=parseInt(e._els["dhx_cal_data"][0].style.top)-20-1+"px";e._els["dhx_cal_data"][0].style.height=parseInt(e._els["dhx_cal_data"][0].style.height)+20+1+"px";e._els["dhx_cal_header"][0].style.display="none";var t=e.$container.querySelector(".dhx_cal_scale_placeholder");if(t){t.style.display="none"}_()}else{e._table_view=e._allow_dnd=false;if(e._wa._prev_data_border!==undefined){e._els["dhx_cal_data"][0].style.borderTopWidth=e._wa._prev_data_border;delete e._wa._prev_data_border}e._els["dhx_cal_data"][0].style.overflowY="auto";e._els["dhx_cal_data"][0].style.top=parseInt(e._els["dhx_cal_data"][0].style.top)+20+"px";e._els["dhx_cal_data"][0].style.height=parseInt(e._els["dhx_cal_data"][0].style.height)-20+"px";e._els["dhx_cal_header"][0].style.display="block"}};e.mouse_week_agenda=function(a){var t=a.ev;var _=t.srcElement||t.target;var d;while(_.parentNode){if(_._date)d=_._date;_=_.parentNode}if(!d)return a;a.x=0;var l=d.valueOf()-e._min_date.valueOf();a.y=Math.ceil(l/(1e3*60)/this.config.time_step);if(this._drag_mode=="move"&&this._drag_pos&&this._is_pos_changed(this._drag_pos,a)){var s;this._drag_event._dhx_changed=true;this._select_id=this._drag_id;for(var n=0;n<e._rendered.length;n++){if(e._drag_id==this._rendered[n].getAttribute("event_id"))s=this._rendered[n]}if(!e._wa._dnd){var r=s.cloneNode(true);this._wa._dnd=r;r.className=s.className;r.id="dhx_wa_dnd";r.className+=" dhx_wa_dnd";document.body.appendChild(r)}var i=document.getElementById("dhx_wa_dnd");i.style.top=(t.pageY||t.clientY)+20+"px";i.style.left=(t.pageX||t.clientX)+20+"px"}return a};e.attachEvent("onBeforeEventChanged",function(a,t,_){if(this._mode=="week_agenda"){if(this._drag_mode=="move"){var d=document.getElementById("dhx_wa_dnd");d.parentNode.removeChild(d);e._wa._dnd=false}}return true});e.attachEvent("onEventSave",function(e,a,t){if(t&&this._mode=="week_agenda")this._select_id=e;return true});e._wa._selected_divs=[];e.attachEvent("onClick",function(a,t){if(this._mode=="week_agenda"&&!(!e.config.week_agenda_select&&e.config.week_agenda_select!==undefined)){if(e._wa._selected_divs){for(var _=0;_<this._wa._selected_divs.length;_++){var d=this._wa._selected_divs[_];d.className=d.className.replace(/ dhx_cal_event_selected/,"")}}this.for_rendered(a,function(a){a.className+=" dhx_cal_event_selected";e._wa._selected_divs.push(a)});e._select_id=a;return false}return true})})});