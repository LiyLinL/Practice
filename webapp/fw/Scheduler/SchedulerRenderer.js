sap.ui.define([],function(){"use strict";var i={};i.render=function(i,e){i.write("<div");i.writeControlData(e);i.addStyle("width",e.getWidth());i.addStyle("height",e.getHeight());i.writeStyles();i.addClass("dhx_cal_container");i.writeClasses();i.write(">");i.write("<div");i.addClass("dhx_cal_navline");i.writeClasses();i.write(">");i.write("<div");i.addClass("dhx_cal_prev_button");i.writeClasses();i.write("></div>");i.write("<div");i.addClass("dhx_cal_next_button");i.writeClasses();i.write("></div>");i.write("<div");i.addClass("dhx_cal_today_button");i.writeClasses();i.write("></div>");i.write("<div");i.addClass("dhx_cal_date");i.writeClasses();i.addStyle("color","#CCE7F6");i.writeStyles();i.write("></div>");i.write('<div id="dhx_minical_icon"');i.addClass("dhx_minical_icon");i.writeClasses();i.write("></div>");i.write("</div>");i.write("<div");i.addClass("dhx_cal_header");i.writeClasses();i.write("></div>");i.write("<div");i.addClass("dhx_cal_data");i.writeClasses();i.write("></div>");i.write("</div>")};return i},true);