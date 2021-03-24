/*

@license
dhtmlxScheduler v.5.3.10 Professional

This software is covered by DHTMLX Commercial License. Usage without proper license is prohibited.

(c) XB Software Ltd.

*/
Scheduler.plugin(function(e){function t(t,r){var i=e.$ajax.xpath("//data/item",t.xmlDoc);var a={};for(var l=0;l<i.length;l++){a[i[l].getAttribute(r.map_to)]=true}return a}function r(e,t){try{var r=JSON.parse(e.xmlDoc.responseText);var i={};for(var a=0;a<r.length;a++){var l=r[a];i[l.value||l.key||l.id]=true}return i}catch(e){return null}}e.form_blocks["multiselect"]={render:function(e){var t="dhx_multi_select_control dhx_multi_select_"+e.name;if(!!e.vertical){t+=" dhx_multi_select_control_vertical"}var r="<div class='"+t+"' style='overflow: auto; height: "+e.height+"px; position: relative;' >";for(var i=0;i<e.options.length;i++){r+="<label><input type='checkbox' value='"+e.options[i].key+"'/>"+e.options[i].label+"</label>";if(!!e.vertical)r+="<br/>"}r+="</div>";return r},set_value:function(i,a,l,n){var o=i.getElementsByTagName("input");for(var c=0;c<o.length;c++){o[c].checked=false}function u(e){var t=i.getElementsByTagName("input");for(var r=0;r<t.length;r++){t[r].checked=!!e[t[r].value]}}var v={};if(l[n.map_to]){var s=(l[n.map_to]+"").split(n.delimiter||e.config.section_delimiter||",");for(var c=0;c<s.length;c++){v[s[c]]=true}u(v)}else{if(e._new_event||!n.script_url)return;var f=document.createElement("div");f.className="dhx_loading";f.style.cssText="position: absolute; top: 40%; left: 40%;";i.appendChild(f);var d=[n.script_url,n.script_url.indexOf("?")==-1?"?":"&","dhx_crosslink_"+n.map_to+"="+l.id+"&uid="+e.uid()].join("");e.$ajax.get(d,function(e){var a=r(e,n);if(!a){a=t(e,n)}u(a);i.removeChild(f)})}},get_value:function(t,r,i){var a=[];var l=t.getElementsByTagName("input");for(var n=0;n<l.length;n++){if(l[n].checked)a.push(l[n].value)}return a.join(i.delimiter||e.config.section_delimiter||",")},focus:function(e){}}});