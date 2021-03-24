/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){e.config.limit_start=null;e.config.limit_end=null;e.config.limit_view=false;e.config.check_limits=true;e.config.mark_now=true;e.config.display_marked_timespans=true;e._temp_limit_scope=function(){var t=null;var a="dhx_time_block";var r="default";var n=function(e,t,a){if(t instanceof Date&&a instanceof Date){e.start_date=t;e.end_date=a}else{e.days=t;e.zones=a}return e};var i=function(e,t,r){var i=typeof e=="object"?e:{days:e};i.type=a;i.css="";if(t){if(r)i.sections=r;i=n(i,e,t)}return i};e.blockTime=function(t,a,r){var n=i(t,a,r);return e.addMarkedTimespan(n)};e.unblockTime=function(t,a,r){a=a||"fullday";var n=i(t,a,r);return e.deleteMarkedTimespan(n)};e.attachEvent("onBeforeViewChange",function(t,a,r,n){function i(t,a){var r=e.config.limit_start,n=e.config.limit_end,i=e.date.add(t,1,a);return t.valueOf()>n.valueOf()||i<=r.valueOf()}if(e.config.limit_view){n=n||a;r=r||t;if(i(n,r)&&!(a.valueOf()==n.valueOf())){setTimeout(function(){var t=!i(a,r)?a:e.config.limit_start;e.setCurrentView(!i(t,r)?t:null,r)},1);return false}}return true});e.checkInMarkedTimespan=function(t,a,n){a=a||r;var i=true;var s=new Date(t.start_date.valueOf());var d=e.date.add(s,1,"day");var o=e._marked_timespans;for(;s<t.end_date;s=e.date.date_part(d),d=e.date.add(s,1,"day")){var f=+e.date.date_part(new Date(s));var l=s.getDay();var v=_(t,o,l,f,a);if(v){for(var u=0;u<v.length;u+=2){var c=e._get_zone_minutes(s);var m=t.end_date>d||t.end_date.getDate()!=s.getDate()?1440:e._get_zone_minutes(t.end_date);var p=v[u];var h=v[u+1];if(p<m&&h>c){if(typeof n=="function"){i=n(t,c,m,p,h)}else{i=false}if(!i)break}}}}return!i};var s=e.checkLimitViolation=function(t){if(!t)return true;if(!e.config.check_limits)return true;var r=e;var n=r.config;var i=[];if(t.rec_type){var s=e.getRecDates(t);for(var _=0;_<s.length;_++){var d=e._copy_event(t);e._lame_copy(d,s[_]);i.push(d)}}else{i=[t]}var o=true;for(var f=0;f<i.length;f++){var l=true;var d=i[f];d._timed=e.isOneDayEvent(d);l=n.limit_start&&n.limit_end?d.start_date.valueOf()>=n.limit_start.valueOf()&&d.end_date.valueOf()<=n.limit_end.valueOf():true;if(l){l=!e.checkInMarkedTimespan(d,a,function(e,t,a,n,i){var s=true;if(t<=i&&t>=n){if(i==24*60||a<i){s=false}if(e._timed&&r._drag_id&&r._drag_mode=="new-size"){e.start_date.setHours(0);e.start_date.setMinutes(i)}else{s=false}}if(a>=n&&a<i||t<n&&a>i){if(e._timed&&r._drag_id&&r._drag_mode=="new-size"){e.end_date.setHours(0);e.end_date.setMinutes(n)}else{s=false}}return s})}if(!l){l=r.checkEvent("onLimitViolation")?r.callEvent("onLimitViolation",[d.id,d]):l}o=o&&l}if(!o){r._drag_id=null;r._drag_mode=null}return o};e._get_blocked_zones=function(e,t,a,r,n){var i=[];if(e&&e[t]){var s=e[t];var _=this._get_relevant_blocked_zones(a,r,s,n);for(var d=0;d<_.length;d++){i=this._add_timespan_zones(i,_[d].zones)}}return i};e._get_relevant_blocked_zones=function(e,t,a,r){var n=a[t]&&a[t][r]?a[t][r]:a[e]&&a[e][r]?a[e][r]:[];return n};function _(t,a,r,n,i){var s=e;var _=[];var d={_props:"map_to",matrix:"y_property"};for(var o in d){var f=d[o];if(s[o]){for(var l in s[o]){var v=s[o][l];var u=v[f];if(!t[u])continue;_=s._add_timespan_zones(_,e._get_blocked_zones(a[l],t[u],r,n,i))}}}_=s._add_timespan_zones(_,e._get_blocked_zones(a,"global",r,n,i));return _}e.attachEvent("onMouseDown",function(e){return!(e==a)});e.attachEvent("onBeforeDrag",function(t){if(!t)return true;return s(e.getEvent(t))});e.attachEvent("onClick",function(t,a){return s(e.getEvent(t))});e.attachEvent("onBeforeLightbox",function(a){var r=e.getEvent(a);t=[r.start_date,r.end_date];return s(r)});e.attachEvent("onEventSave",function(t,a,r){if(!(a.start_date&&a.end_date)){var n=e.getEvent(t);a.start_date=new Date(n.start_date);a.end_date=new Date(n.end_date)}if(a.rec_type){var i=e._lame_clone(a);e._roll_back_dates(i);return s(i)}return s(a)});e.attachEvent("onEventAdded",function(t){if(!t)return true;var a=e.getEvent(t);if(!s(a)&&e.config.limit_start&&e.config.limit_end){if(a.start_date<e.config.limit_start){a.start_date=new Date(e.config.limit_start)}if(a.start_date.valueOf()>=e.config.limit_end.valueOf()){a.start_date=this.date.add(e.config.limit_end,-1,"day")}if(a.end_date<e.config.limit_start){a.end_date=new Date(e.config.limit_start)}if(a.end_date.valueOf()>=e.config.limit_end.valueOf()){a.end_date=this.date.add(e.config.limit_end,-1,"day")}if(a.start_date.valueOf()>=a.end_date.valueOf()){a.end_date=this.date.add(a.start_date,this.config.event_duration||this.config.time_step,"minute")}a._timed=this.isOneDayEvent(a)}return true});e.attachEvent("onEventChanged",function(a){if(!a)return true;var r=e.getEvent(a);if(!s(r)){if(!t)return false;r.start_date=t[0];r.end_date=t[1];r._timed=this.isOneDayEvent(r)}return true});e.attachEvent("onBeforeEventChanged",function(e,t,a){return s(e)});e.attachEvent("onBeforeEventCreated",function(t){var a=e.getActionData(t).date;var r={_timed:true,start_date:a,end_date:e.date.add(a,e.config.time_step,"minute")};return s(r)});e.attachEvent("onViewChange",function(){e._mark_now()});e.attachEvent("onAfterSchedulerResize",function(){window.setTimeout(function(){e._mark_now()},1);return true});e.attachEvent("onTemplatesReady",function(){e._mark_now_timer=window.setInterval(function(){if(!e._is_initialized())return;e._mark_now()},6e4)});e._mark_now=function(t){var a="dhx_now_time";if(!this._els[a]){this._els[a]=[]}var r=e._currentDate();var n=this.config;e._remove_mark_now();if(!t&&n.mark_now&&r<this._max_date&&r>this._min_date&&r.getHours()>=n.first_hour&&r.getHours()<n.last_hour){var i=this.locate_holder_day(r);this._els[a]=e._append_mark_now(i,r)}};e._append_mark_now=function(t,a){var r="dhx_now_time";var n=e._get_zone_minutes(a);var i={zones:[n,n+1],css:r,type:r};if(!this._table_view){if(this._props&&this._props[this._mode]){var s,_;var d=this._props[this._mode];var o=d.size||d.options.length;if(d.days>1){if(d.size&&d.options.length){t=(d.position+t)/d.options.length*d.size}s=t;_=t+o}else{s=0;_=s+o}var f=[];for(var l=s;l<_;l++){var v=l;i.days=v;var u=e._render_marked_timespan(i,null,v)[0];f.push(u)}return f}else{i.days=t;return e._render_marked_timespan(i,null,t)}}else{if(this._mode=="month"){i.days=+e.date.date_part(a);return e._render_marked_timespan(i,null,null)}}};e._remove_mark_now=function(){var e="dhx_now_time";var t=this._els[e];for(var a=0;a<t.length;a++){var r=t[a];var n=r.parentNode;if(n){n.removeChild(r)}}this._els[e]=[]};e._marked_timespans={global:{}};e._get_zone_minutes=function(e){return e.getHours()*60+e.getMinutes()};e._prepare_timespan_options=function(t){var a=[];var n=[];if(t.days=="fullweek")t.days=[0,1,2,3,4,5,6];if(t.days instanceof Array){var i=t.days.slice();for(var s=0;s<i.length;s++){var _=e._lame_clone(t);_.days=i[s];a.push.apply(a,e._prepare_timespan_options(_))}return a}if(!t||!(t.start_date&&t.end_date&&t.end_date>t.start_date||t.days!==undefined&&t.zones)&&!t.type)return a;var d=0;var o=24*60;if(t.zones=="fullday")t.zones=[d,o];if(t.zones&&t.invert_zones){t.zones=e.invertZones(t.zones)}t.id=e.uid();t.css=t.css||"";t.type=t.type||r;var f=t.sections;if(f){for(var l in f){if(f.hasOwnProperty(l)){var v=f[l];if(!(v instanceof Array))v=[v];for(var s=0;s<v.length;s++){var u=e._lame_copy({},t);u.sections={};u.sections[l]=v[s];n.push(u)}}}}else{n.push(t)}for(var c=0;c<n.length;c++){var m=n[c];var p=m.start_date;var h=m.end_date;if(p&&h){var g=e.date.date_part(new Date(p));var y=e.date.add(g,1,"day");while(g<h){var u=e._lame_copy({},m);delete u.start_date;delete u.end_date;u.days=g.valueOf();var k=p>g?e._get_zone_minutes(p):d;var w=h>y||h.getDate()!=g.getDate()?o:e._get_zone_minutes(h);u.zones=[k,w];a.push(u);g=y;y=e.date.add(y,1,"day")}}else{if(m.days instanceof Date)m.days=e.date.date_part(m.days).valueOf();m.zones=t.zones.slice();a.push(m)}}return a};e._get_dates_by_index=function(t,a,r){var n=[];a=e.date.date_part(new Date(a||e._min_date));r=new Date(r||e._max_date);var i=a.getDay();var s=t-i>=0?t-i:7-a.getDay()+t;var _=e.date.add(a,s,"day");for(;_<r;_=e.date.add(_,1,"week")){n.push(_)}return n};e._get_css_classes_by_config=function(e){var t=[];if(e.type==a){t.push(a);if(e.css)t.push(a+"_reset")}t.push("dhx_marked_timespan",e.css);return t.join(" ")};e._get_block_by_config=function(e){var t=document.createElement("div");if(e.html){if(typeof e.html=="string")t.innerHTML=e.html;else t.appendChild(e.html)}return t};e._render_marked_timespan=function(t,a,r){var n=[];var i=e.config;var s=this._min_date;var _=this._max_date;var d=false;if(!i.display_marked_timespans)return n;if(!r&&r!==0){if(t.days<7)r=t.days;else{var o=new Date(t.days);d=+o;if(!(+_>+o&&+s<=+o))return n;r=o.getDay()}var f=s.getDay();if(f>r){r=7-(f-r)}else{r=r-f}}var l=t.zones;var v=e._get_css_classes_by_config(t);if(e._table_view&&e._mode=="month"){var u=[];var c=[];if(!a){c=d?[d]:e._get_dates_by_index(r);for(var m=0;m<c.length;m++){u.push(this._scales[c[m]])}}else{u.push(a);c.push(r)}for(var m=0;m<u.length;m++){a=u[m];r=c[m];var p=Math.floor((this._correct_shift(r,1)-s.valueOf())/(60*60*1e3*24*this._cols.length)),h=this.locate_holder_day(r,false)%this._cols.length;if(this._ignores[h])continue;var g=this.config.rtl?this._colsS.col_length-1-h:h;var y=e._get_block_by_config(t),k=Math.max(a.offsetHeight-1,0),w=Math.max(a.offsetWidth-1,0),z=this._colsS[g],b=this._colsS.heights[p]+(this._colsS.height?this.xy.month_scale_height+2:2)-1;y.className=v;y.style.top=b+"px";y.style.lineHeight=y.style.height=k+"px";for(var D=0;D<l.length;D+=2){var x=l[m];var E=l[m+1];if(E<=x)return[];var M=y.cloneNode(true);M.style.left=z+Math.round(x/(24*60)*w)+"px";M.style.width=Math.round((E-x)/(24*60)*w)+"px";a.appendChild(M);n.push(M)}}}else{var O=r;if(this._ignores[this.locate_holder_day(r,false)])return n;if(this._props&&this._props[this._mode]&&t.sections&&t.sections[this._mode]){var C=this._props[this._mode];O=C.order[t.sections[this._mode]];var T=C.order[t.sections[this._mode]];if(!(C.days>1)){O=T;if(C.size&&O>C.position+C.size){O=0}}else{var N=C.size||C.options.length;O=O*N+T}}a=a?a:e.locate_holder(O);for(var m=0;m<l.length;m+=2){var x=Math.max(l[m],i.first_hour*60);var E=Math.min(l[m+1],i.last_hour*60);if(E<=x){if(m+2<l.length)continue;else return[]}var M=e._get_block_by_config(t);M.className=v;var H=this.config.hour_size_px*24+1;var S=60*60*1e3;M.style.top=Math.round((x*60*1e3-this.config.first_hour*S)*this.config.hour_size_px/S)%H+"px";M.style.lineHeight=M.style.height=Math.max(Math.round((E-x)*60*1e3*this.config.hour_size_px/S)%H,1)+"px";a.appendChild(M);n.push(M)}}return n};e._mark_timespans=function(){var t=this._els["dhx_cal_data"][0];var a=[];if(e._table_view&&e._mode=="month"){for(var r in this._scales){var n=new Date(+r);a.push.apply(a,e._on_scale_add_marker(this._scales[r],n))}}else{var n=new Date(e._min_date);for(var i=0,s=t.childNodes.length;i<s;i++){var _=t.childNodes[i];if(_.firstChild&&e._getClassName(_.firstChild).indexOf("dhx_scale_hour")>-1){continue}a.push.apply(a,e._on_scale_add_marker(_,n));n=e.date.add(n,1,"day")}}return a};e.markTimespan=function(t){var a=false;if(!this._els["dhx_cal_data"]){e.get_elements();a=true}var r=e._marked_timespans_ids,n=e._marked_timespans_types,i=e._marked_timespans;e.deleteMarkedTimespan();e.addMarkedTimespan(t);var s=e._mark_timespans();if(a)e._els=[];e._marked_timespans_ids=r;e._marked_timespans_types=n;e._marked_timespans=i;return s};e.unmarkTimespan=function(e){if(!e)return;for(var t=0;t<e.length;t++){var a=e[t];if(a.parentNode){a.parentNode.removeChild(a)}}};e._addMarkerTimespanConfig=function(t){var a="global";var r=e._marked_timespans;var n=t.id;var i=e._marked_timespans_ids;if(!i[n])i[n]=[];var s=t.days;var _=t.sections;var d=t.type;t.id=n;if(_){for(var o in _){if(_.hasOwnProperty(o)){if(!r[o])r[o]={};var f=_[o];var l=r[o];if(!l[f])l[f]={};if(!l[f][s])l[f][s]={};if(!l[f][s][d]){l[f][s][d]=[];if(!e._marked_timespans_types)e._marked_timespans_types={};if(!e._marked_timespans_types[d])e._marked_timespans_types[d]=true}var v=l[f][s][d];t._array=v;v.push(t);i[n].push(t)}}}else{if(!r[a][s])r[a][s]={};if(!r[a][s][d])r[a][s][d]=[];if(!e._marked_timespans_types)e._marked_timespans_types={};if(!e._marked_timespans_types[d])e._marked_timespans_types[d]=true;var v=r[a][s][d];t._array=v;v.push(t);i[n].push(t)}};e._marked_timespans_ids={};e.addMarkedTimespan=function(t){var a=e._prepare_timespan_options(t);if(!a.length)return;var r=a[0].id;for(var n=0;n<a.length;n++){e._addMarkerTimespanConfig(a[n])}return r};e._add_timespan_zones=function(e,t){var a=e.slice();t=t.slice();if(!a.length)return t;for(var r=0;r<a.length;r+=2){var n=a[r];var i=a[r+1];var s=r+2==a.length;for(var _=0;_<t.length;_+=2){var d=t[_];var o=t[_+1];if(o>i&&d<=i||d<n&&o>=n){a[r]=Math.min(n,d);a[r+1]=Math.max(i,o);r-=2}else{if(!s)continue;var f=n>d?0:2;a.splice(r+f,0,d,o)}t.splice(_--,2);break}}return a};e._subtract_timespan_zones=function(e,t){var a=e.slice();for(var r=0;r<a.length;r+=2){var n=a[r];var i=a[r+1];for(var s=0;s<t.length;s+=2){var _=t[s];var d=t[s+1];if(d>n&&_<i){var o=false;if(n>=_&&i<=d){a.splice(r,2)}if(n<_){a.splice(r,2,n,_);o=true}if(i>d){a.splice(o?r+2:r,o?0:2,d,i)}r-=2;break}else{continue}}}return a};e.invertZones=function(t){return e._subtract_timespan_zones([0,1440],t.slice())};e._delete_marked_timespan_by_id=function(t){var a=e._marked_timespans_ids[t];if(a){for(var r=0;r<a.length;r++){var n=a[r];var i=n._array;for(var s=0;s<i.length;s++){if(i[s]==n){i.splice(s,1);break}}}}};e._delete_marked_timespan_by_config=function(t){var a=e._marked_timespans;var n=t.sections;var i=t.days;var s=t.type||r;var _;if(n){for(var d in n){if(n.hasOwnProperty(d)&&a[d]){var o=n[d];if(a[d][o]){_=a[d][o]}}}}else{_=a.global}if(_){if(i!==undefined){if(_[i]&&_[i][s]){e._addMarkerTimespanConfig(t);e._delete_marked_timespans_list(_[i][s],t)}}else{for(var f in _){if(_[f][s]){var l=e._lame_clone(t);t.days=f;e._addMarkerTimespanConfig(l);e._delete_marked_timespans_list(_[f][s],t)}}}}};e._delete_marked_timespans_list=function(t,a){for(var r=0;r<t.length;r++){var n=t[r];var i=e._subtract_timespan_zones(n.zones,a.zones);if(i.length)n.zones=i;else{t.splice(r,1);r--;var s=e._marked_timespans_ids[n.id];for(var _=0;_<s.length;_++){if(s[_]==n){s.splice(_,1);break}}}}};e.deleteMarkedTimespan=function(t){if(!arguments.length){e._marked_timespans={global:{}};e._marked_timespans_ids={};e._marked_timespans_types={}}if(typeof t!="object"){e._delete_marked_timespan_by_id(t)}else{if(!(t.start_date&&t.end_date)){if(t.days===undefined&&!t.type)t.days="fullweek";if(!t.zones)t.zones="fullday"}var a=[];if(!t.type){for(var r in e._marked_timespans_types){a.push(r)}}else{a.push(t.type)}var n=e._prepare_timespan_options(t);for(var i=0;i<n.length;i++){var s=n[i];for(var _=0;_<a.length;_++){var d=e._lame_clone(s);d.type=a[_];e._delete_marked_timespan_by_config(d)}}}};e._get_types_to_render=function(t,a){var r=t?e._lame_copy({},t):{};for(var n in a||{}){if(a.hasOwnProperty(n)){r[n]=a[n]}}return r};e._get_configs_to_render=function(e){var t=[];for(var a in e){if(e.hasOwnProperty(a)){t.push.apply(t,e[a])}}return t};e._on_scale_add_marker=function(t,a){if(e._table_view&&e._mode!="month")return;var r=a.getDay();var n=a.valueOf();var i=this._mode;var s=e._marked_timespans;var _=[];var d=[];if(this._props&&this._props[i]){var o=this._props[i];var f=o.options;var l=e._get_unit_index(o,a);var v=f[l];if(!(o.days>1)){a=e.date.date_part(new Date(this._date))}else{var u=24*60*60*1e3;var c=Math.round((a-e._min_date)/u);var m=o.size||f.length;a=e.date.add(e._min_date,Math.floor(c/m),"day");a=e.date.date_part(a)}r=a.getDay();n=a.valueOf();if(s[i]&&s[i][v.key]){var p=s[i][v.key];var h=e._get_types_to_render(p[r],p[n]);_.push.apply(_,e._get_configs_to_render(h))}}var g=s["global"];var y=g[n]||g[r];_.push.apply(_,e._get_configs_to_render(y));for(var k=0;k<_.length;k++){d.push.apply(d,e._render_marked_timespan(_[k],t,a))}return d};e.attachEvent("onScaleAdd",function(){e._on_scale_add_marker.apply(e,arguments)});e.dblclick_dhx_marked_timespan=function(t,a){e.callEvent("onScaleDblClick",[e.getActionData(t).date,a,t]);if(e.config.dblclick_create){e.addEventNow(e.getActionData(t).date,null,t)}}};e._temp_limit_scope()});