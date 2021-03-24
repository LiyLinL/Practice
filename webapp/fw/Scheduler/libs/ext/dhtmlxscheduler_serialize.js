/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(t){t._get_serializable_data=function(){var t={};for(var a in this._events){var e=this._events[a];if(e.id.toString().indexOf("#")==-1){t[e.id]=e}}return t};t.data_attributes=function(){var a=[];var e=t._helpers.formatDate;var r=this._get_serializable_data();for(var n in r){var i=r[n];for(var s in i)if(s.substr(0,1)!="_")a.push([s,s=="start_date"||s=="end_date"?e:null]);break}return a};t.toXML=function(t){var a=[];var e=this.data_attributes();var r=this._get_serializable_data();for(var n in r){var i=r[n];a.push("<event>");for(var s=0;s<e.length;s++)a.push("<"+e[s][0]+"><![CDATA["+(e[s][1]?e[s][1](i[e[s][0]]):i[e[s][0]])+"]]></"+e[s][0]+">");a.push("</event>")}return(t||"")+"<data>"+a.join("\n")+"</data>"};t._serialize_json_value=function(t){if(t===null||typeof t==="boolean"){t=""+t}else{if(!t&&t!==0){t=""}t='"'+t.toString().replace(/\n/g,"").replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"'}return t};t.toJSON=function(){var t=[],a="";var e=this.data_attributes();var r=this._get_serializable_data();for(var n in r){var i=r[n];var s=[];for(var _=0;_<e.length;_++){a=e[_][1]?e[_][1](i[e[_][0]]):i[e[_][0]];s.push(' "'+e[_][0]+'": '+this._serialize_json_value(a))}t.push("{"+s.join(",")+"}")}return"["+t.join(",\n")+"]"};t.toICal=function(a){var e="BEGIN:VCALENDAR\nVERSION:2.0\nPRODID:-//dhtmlXScheduler//NONSGML v2.2//EN\nDESCRIPTION:";var r="END:VCALENDAR";var n=t.date.date_to_str("%Y%m%dT%H%i%s");var i=t.date.date_to_str("%Y%m%d");var s=[];var _=this._get_serializable_data();for(var u in _){var d=_[u];s.push("BEGIN:VEVENT");if(!d._timed||!d.start_date.getHours()&&!d.start_date.getMinutes())s.push("DTSTART:"+i(d.start_date));else s.push("DTSTART:"+n(d.start_date));if(!d._timed||!d.end_date.getHours()&&!d.end_date.getMinutes())s.push("DTEND:"+i(d.end_date));else s.push("DTEND:"+n(d.end_date));s.push("SUMMARY:"+d.text);s.push("END:VEVENT")}return e+(a||"")+"\n"+s.join("\n")+"\n"+r}});