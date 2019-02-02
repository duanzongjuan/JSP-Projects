// JavaScript Document
function zhuce1(information){
	alert("xxxxxxx"+information);
}

function query(url){
	alert('测试成功！')
	document.form2.action=url;
	document.form2.submit();
	alert('测试成功11111111111111！')
	
}
function saveFlow(url){
		
	document.xmForm.action=url;
	document.xmForm.submit();
		
}

function submitzy(url){
	document.zyForm.action=url;
	document.zyForm.submit();
		
}
function submitzy1(url){
	document.bcForm.action=url;
	document.bcForm.submit();
		
}
function submitfy(url){
	document.fyForm.action=url;
	document.fyForm.submit();
		
}

function doPrint() {
	myDoc = {
		documents: document,
		/*
		要打印的div 对象在本文档中，控件将从本文档中的 id 为 'page1' 的div对象，
				 作为首页打印id 为'page2'的作为第二页打印            */
				copyrights: '杰创软件拥有版权  www.jatools.com' // 版权声明,必须   
			};
			document.getElementById("jatoolsPrinter").print(myDoc, false); // 直接打印，不弹出打印机设置对话框 
}

function doPrint(how) { 
var jp = document.getElementById("jatoolsPrinter");
 
	var myDoc = {
		settings:{
			paperName:'a4',
			orientation:1,
			topMargin:100,
		          leftMargin:200,
				  bottomMargin:100,
				  rightMargin:100},   // 设置上下左距页边距为10毫米，注意，单位是 1/10毫米

		documents: document,
	
		fitToPage  :true,   //必要时缩放打印
		copyrights: '杰创软件拥有版权  www.jatools.com' 
	};
	myDoc.done=function(){
		
		//window.close();
		 }; 
	var jatoolsPrinter = document.getElementById("jatoolsPrinter");
	
	if (how == '打印预览...') 
	     jatoolsPrinter.printPreview(myDoc); // 打印预览
	else if (how == '打印...') 
	     jatoolsPrinter.print(myDoc, true); // 打印前弹出打印设置对话框
	else 
	     jatoolsPrinter.print(myDoc, false); // 不弹出对话框打印
		 
}
//
function doPrint1(how) { 

	var myDoc = {
		settings:{
			paperName:'a4',
			orientation:2,
			topMargin:100,
		          leftMargin:150,
				  bottomMargin:100,
				  rightMargin:100},   // 设置上下左距页边距为10毫米，注意，单位是 1/10毫米

		documents: document,
		copyrights: '杰创软件拥有版权  www.jatools.com' 
	}; 
	var jatoolsPrinter = document.getElementById("jatoolsPrinter");
	if (how == '打印预览...') 
	     jatoolsPrinter.printPreview(myDoc); // 打印预览
	else if (how == '打印...') 
	     jatoolsPrinter.print(myDoc, true); // 打印前弹出打印设置对话框
	else 
	     jatoolsPrinter.print(myDoc, false); // 不弹出对话框打印
}

//伸缩左菜单
function show(c_Str) 
{if(document.all(c_Str).style.display=='none') 
{document.all(c_Str).style.display='block';
	document.all(c_Str).style.backgroundImage='url(../images/101.png)';
} 
else{document.all(c_Str).style.display='none';
document.all(c_Str).style.backgroundImage='url(../images/101.png)';
}} 
//
//横菜单
$(function(){
		$(".nav>li").hover(function(){
			$(this).children('ul').stop(true,true).show(300);
		},function(){
			$(this).children('ul').stop(true,true).hide(300);
		})
	})
   //左菜单     
 $(function() {
                $("#menus_area").find("dt").click(function() { 
                    if (!$(this).hasClass("on")) { 
                        $("#menus_area").find("dt").removeClass("on");
                        $(this).addClass("on");
                        $('dd').slideUp();
                        $(this).nextAll('dd').slideToggle();
                    }
                });
            })
