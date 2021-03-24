/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.config.year_x=4;e.config.year_y=3;e.xy.year_top=0;e.templates.year_date=function(t){return e.date.date_to_str(e.locale.labels.year_tab+" %Y")(t)};e.templates.year_month=e.date.date_to_str("%F");e.templates.year_scale_date=e.date.date_to_str("%D");e.templates.year_tooltip=function(e,t,a){return a.text};(function(){var t=function(){return e._mode=="year"};e.dblclick_dhx_month_head=function(a){if(t()){var r=a.target||a.srcElement;var _=e._getClassName(r.parentNode);if(_.indexOf("dhx_before")!=-1||_.indexOf("dhx_after")!=-1)return false;var i=r;while(i&&!(i.hasAttribute&&i.hasAttribute("date"))){i=i.parentNode}if(i){var o=this._helpers.parseDate(i.getAttribute("date"));o.setDate(parseInt(r.innerHTML,10));var l=this.date.add(o,1,"day");if(!this.config.readonly&&this.config.dblclick_create)this.addEventNow(o.valueOf(),l.valueOf(),a)}}};var a=e.changeEventId;e.changeEventId=function(){a.apply(this,arguments);if(t())this.year_view(true)};var r=e.render_data;var _=e.date.date_to_str("%Y/%m/%d");var i=e.date.str_to_date("%Y/%m/%d");e.render_data=function(e){if(!t())return r.apply(this,arguments);for(var a=0;a<e.length;a++)this._year_render_event(e[a])};var o=e.clear_view;e.clear_view=function(){if(!t())return o.apply(this,arguments);var a=e._year_marked_cells,r=null;for(var _ in a){if(a.hasOwnProperty(_)){r=a[_];r.className="dhx_month_head";r.removeAttribute("date")}}e._year_marked_cells={}};e._hideToolTip=function(){if(this._tooltip){this._tooltip.style.display="none";this._tooltip.date=new Date(9999,1,1)}};e._showToolTip=function(t,a,r,_){if(this._tooltip){if(this._tooltip.date.valueOf()==t.valueOf())return;this._tooltip.innerHTML=""}else{var i=this._tooltip=document.createElement("div");i.className="dhx_year_tooltip";if(this.config.rtl)i.className+=" dhx_tooltip_rtl";document.body.appendChild(i);i.onclick=e._click.dhx_cal_data}var o=this.getEvents(t,this.date.add(t,1,"day"));var l="";for(var s=0;s<o.length;s++){var n=o[s];if(!this.filter_event(n.id,n))continue;var d=n.color?"background:"+n.color+";":"";var h=n.textColor?"color:"+n.textColor+";":"";l+="<div class='dhx_tooltip_line' style='"+d+""+h+"' event_id='"+o[s].id+"'>";l+="<div class='dhx_tooltip_date' style='"+d+""+h+"'>"+(o[s]._timed?this.templates.event_date(o[s].start_date):"")+"</div>";l+="<div class='dhx_event_icon icon_details'>&nbsp;</div>";l+=this.templates.year_tooltip(o[s].start_date,o[s].end_date,o[s])+"</div>"}this._tooltip.style.display="";this._tooltip.style.top="0px";if(document.body.offsetWidth-a.left-this._tooltip.offsetWidth<0)this._tooltip.style.left=a.left-this._tooltip.offsetWidth+"px";else this._tooltip.style.left=a.left+_.offsetWidth+"px";this._tooltip.date=t;this._tooltip.innerHTML=l;if(document.body.offsetHeight-a.top-this._tooltip.offsetHeight<0)this._tooltip.style.top=a.top-this._tooltip.offsetHeight+_.offsetHeight+"px";else this._tooltip.style.top=a.top+"px"};e._year_view_tooltip_handler=function(a){if(!t())return;var a=a||event;var r=a.target||a.srcElement;if(r.tagName.toLowerCase()=="a")r=r.parentNode;if(e._getClassName(r).indexOf("dhx_year_event")!=-1)e._showToolTip(i(r.getAttribute("date")),e.$domHelpers.getOffset(r),a,r);else e._hideToolTip()};e._init_year_tooltip=function(){e._detachDomEvent(e._els["dhx_cal_data"][0],"mouseover",e._year_view_tooltip_handler);e.event(e._els["dhx_cal_data"][0],"mouseover",e._year_view_tooltip_handler)};e._get_year_cell=function(e){var t=e.getMonth()+12*(e.getFullYear()-this._min_date.getFullYear())-this.week_starts._month;var a=this._els["dhx_cal_data"][0].childNodes[t];var r=this.week_starts[t]+e.getDate()-1;var _=a.querySelectorAll(".dhx_year_body tr")[Math.floor(r/7)];var i=_.querySelectorAll("td")[r%7];return i.querySelector(".dhx_month_head")};e._year_marked_cells={};e._mark_year_date=function(t,a){var r=_(t);var i=this._get_year_cell(t);if(!i){return}var o=this.templates.event_class(a.start_date,a.end_date,a);if(!e._year_marked_cells[r]){i.className="dhx_month_head dhx_year_event";i.setAttribute("date",r);e._year_marked_cells[r]=i}i.className+=o?" "+o:""};e._unmark_year_date=function(e){var t=this._get_year_cell(e);if(!t){return}t.className="dhx_month_head"};e._year_render_event=function(e){var t=e.start_date;if(t.valueOf()<this._min_date.valueOf()){t=this._min_date}else{t=this.date.date_part(new Date(t))}while(t<e.end_date){this._mark_year_date(t,e);t=this.date.add(t,1,"day");if(t.valueOf()>=this._max_date.valueOf())return}};e.year_view=function(t){var a;if(t){a=e.xy.scale_height;e.xy.scale_height=-1}e._els["dhx_cal_header"][0].style.display=t?"none":"";e.set_sizes();if(t)e.xy.scale_height=a;e._table_view=t;if(this._load_mode&&this._load())return;if(t){e._init_year_tooltip();e._reset_year_scale();if(e._load_mode&&e._load()){e._render_wait=true;return}e.render_view_data()}else{e._hideToolTip()}};e._reset_year_scale=function(){this._cols=[];this._colsS={};var t=[];var a=this._els["dhx_cal_data"][0];var r=this.config;a.scrollTop=0;a.innerHTML="";var _=Math.floor(parseInt(a.style.width)/r.year_x);var i=Math.floor((parseInt(a.style.height)-e.xy.year_top)/r.year_y);if(i<190){i=190;_=Math.floor((parseInt(a.style.width)-e.xy.scroll_width)/r.year_x)}var o=_-11;var l=0;var s=document.createElement("div");var n=this.date.week_start(e._currentDate());this._process_ignores(n,7,"day",1);var d=7-(this._ignores_detected||0);var h=0;for(var c=0;c<7;c++){if(!(this._ignores&&this._ignores[c])){this._cols[c]=Math.floor(o/(d-h));this._render_x_header(c,l,n,s);o-=this._cols[c];l+=this._cols[c];h++}n=this.date.add(n,1,"day")}s.lastChild.className+=" dhx_scale_bar_last";for(var c=0;c<s.childNodes.length;c++){this._waiAria.yearHeadCell(s.childNodes[c])}var y=this.date[this._mode+"_start"](this.date.copy(this._date));var v=y;var f=null;for(var c=0;c<r.year_y;c++){for(var u=0;u<r.year_x;u++){f=document.createElement("div");f.className="dhx_year_box";f.style.cssText="position:absolute;";f.setAttribute("date",this._helpers.formatDate(y));f.innerHTML="<div class='dhx_year_month'></div><div class='dhx_year_grid'><div class='dhx_year_week'>"+s.innerHTML+"</div><div class='dhx_year_body'></div></div>";var m=f.querySelector(".dhx_year_month");var p=f.querySelector(".dhx_year_grid");var g=f.querySelector(".dhx_year_week");var x=f.querySelector(".dhx_year_body");var w=e.uid();this._waiAria.yearHeader(m,w);this._waiAria.yearGrid(p,w);m.innerHTML=this.templates.year_month(y);var b=this.date.week_start(y);var k=this._reset_month_scale(x,y,b,6);var N=x.querySelectorAll("td");for(var A=0;A<N.length;A++){this._waiAria.yearDayCell(N[A])}a.appendChild(f);g.style.height=g.childNodes[0].offsetHeight+"px";var T=Math.round((i-190)/2);f.style.marginTop=T+"px";this.set_xy(f,_-10,i-T-10,_*u+5,i*c+5+e.xy.year_top);t[c*r.year_x+u]=(y.getDay()-(this.config.start_on_monday?1:0)+7)%7;y=this.date.add(y,1,"month")}}var H=this._getNavDateElement();if(H){H.innerHTML=this.templates[this._mode+"_date"](v,y,this._mode)}this.week_starts=t;t._month=v.getMonth();this._min_date=v;this._max_date=y};var l=e.getActionData;e.getActionData=function(a){if(!t())return l.apply(e,arguments);var r=a?a.target:event.srcElement;var _=e._get_year_month_date(r);var i=e._get_year_month_cell(r);var o=e._get_year_day_indexes(i);if(o&&_){_=e.date.add(_,o.week,"week");_=e.date.add(_,o.day,"day")}else{_=null}return{date:_,section:null}};e._get_year_day_indexes=function(t){var a=e._get_year_el_node(t,this._locate_year_month_table);if(!a)return null;var r=0,_=0;for(var r=0,i=a.rows.length;r<i;r++){var o=a.rows[r].getElementsByTagName("td");for(var _=0,l=o.length;_<l;_++){if(o[_]==t)break}if(_<l)break}if(r<i)return{day:_,week:r};else return null};e._get_year_month_date=function(t){var t=e._get_year_el_node(t,e._locate_year_month_root);if(!t)return null;var a=t.getAttribute("date");if(!a)return null;return e.date.week_start(e.date.month_start(i(a)))};e._locate_year_month_day=function(t){return e._getClassName(t).indexOf("dhx_year_event")!=-1&&t.hasAttribute&&t.hasAttribute("date")};var s=e._locate_event;e._locate_event=function(t){var a=s.apply(e,arguments);if(!a){var r=e._get_year_el_node(t,e._locate_year_month_day);if(!r||!r.hasAttribute("date"))return null;var _=i(r.getAttribute("date"));var o=e.getEvents(_,e.date.add(_,1,"day"));if(!o.length)return null;a=o[0].id}return a};e._locate_year_month_cell=function(e){return e.nodeName.toLowerCase()=="td"};e._locate_year_month_table=function(e){return e.nodeName.toLowerCase()=="table"};e._locate_year_month_root=function(e){return e.hasAttribute&&e.hasAttribute("date")};e._get_year_month_cell=function(e){return this._get_year_el_node(e,this._locate_year_month_cell)};e._get_year_month_table=function(e){return this._get_year_el_node(e,this._locate_year_month_table)};e._get_year_month_root=function(e){return this._get_year_el_node(this._get_year_month_table(e),this._locate_year_month_root)};e._get_year_el_node=function(e,t){while(e&&!t(e)){e=e.parentNode}return e}})()});