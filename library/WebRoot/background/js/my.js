// JavaScript Document
function zhuce1(information){
	alert("xxxxxxx"+information);
}

function query(url){
	alert('���Գɹ���')
	document.form2.action=url;
	document.form2.submit();
	alert('���Գɹ�11111111111111��')
	
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
		Ҫ��ӡ��div �����ڱ��ĵ��У��ؼ����ӱ��ĵ��е� id Ϊ 'page1' ��div����
				 ��Ϊ��ҳ��ӡid Ϊ'page2'����Ϊ�ڶ�ҳ��ӡ            */
				copyrights: '�ܴ����ӵ�а�Ȩ  www.jatools.com' // ��Ȩ����,����   
			};
			document.getElementById("jatoolsPrinter").print(myDoc, false); // ֱ�Ӵ�ӡ����������ӡ�����öԻ��� 
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
				  rightMargin:100},   // �����������ҳ�߾�Ϊ10���ף�ע�⣬��λ�� 1/10����

		documents: document,
	
		fitToPage  :true,   //��Ҫʱ���Ŵ�ӡ
		copyrights: '�ܴ����ӵ�а�Ȩ  www.jatools.com' 
	};
	myDoc.done=function(){
		
		//window.close();
		 }; 
	var jatoolsPrinter = document.getElementById("jatoolsPrinter");
	
	if (how == '��ӡԤ��...') 
	     jatoolsPrinter.printPreview(myDoc); // ��ӡԤ��
	else if (how == '��ӡ...') 
	     jatoolsPrinter.print(myDoc, true); // ��ӡǰ������ӡ���öԻ���
	else 
	     jatoolsPrinter.print(myDoc, false); // �������Ի����ӡ
		 
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
				  rightMargin:100},   // �����������ҳ�߾�Ϊ10���ף�ע�⣬��λ�� 1/10����

		documents: document,
		copyrights: '�ܴ����ӵ�а�Ȩ  www.jatools.com' 
	}; 
	var jatoolsPrinter = document.getElementById("jatoolsPrinter");
	if (how == '��ӡԤ��...') 
	     jatoolsPrinter.printPreview(myDoc); // ��ӡԤ��
	else if (how == '��ӡ...') 
	     jatoolsPrinter.print(myDoc, true); // ��ӡǰ������ӡ���öԻ���
	else 
	     jatoolsPrinter.print(myDoc, false); // �������Ի����ӡ
}

//������˵�
function show(c_Str) 
{if(document.all(c_Str).style.display=='none') 
{document.all(c_Str).style.display='block';
	document.all(c_Str).style.backgroundImage='url(../images/101.png)';
} 
else{document.all(c_Str).style.display='none';
document.all(c_Str).style.backgroundImage='url(../images/101.png)';
}} 
//
//��˵�
$(function(){
		$(".nav>li").hover(function(){
			$(this).children('ul').stop(true,true).show(300);
		},function(){
			$(this).children('ul').stop(true,true).hide(300);
		})
	})
   //��˵�     
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
