$(document).ready(function() {
$('.head').hover(function() {
$('.xg-box,.tm-a').fadeIn();
}, function() {
$('.xg-box,.tm-a').fadeOut();
});
if ($('.box-con').css('display') == 'none') {
$('.m-list').not('.box-con').hover(function(event) {
event.stopPropagation();
//$(this).css('z-index','5');
$(this).find('.c-btn').addClass('btn-jian-on');
;
}, function() {
//$(this).css('z-index','1');
$(this).find('.c-btn').removeClass('btn-jian-on').end();
});
$('.c-btn').click(function() {
$(this).parent().find('.box-title').toggleClass('hover').parent().siblings().find('.box-title').removeClass('hover');
$(this).parent().find('.box-con').fadeToggle(100).parent().siblings().find('.box-con').hide();
$(this).toggleClass('btn-jian').parent().siblings().find('.c-btn').removeClass('btn-jian');
//$(this).parent().prev('.m-list').find('.box-title').toggleClass('last');
return false;
});
}
$('.manage .ma').hover(function() {
//$('.tips').eq($(this).index()).fadeToggle().parent().siblings().find('.tips').hide();
$(this).find('.tips').show();
}, function() {
$(this).find('.tips').hide();
});
$("input[type=text]").focus(function() {
$(this).addClass('input-green');
});
//邮箱
new $_Form({
form: "#form-sendmail", //表单选择器
check: function(formData) {
var result = true;
if (formData.sendmail_mail + '' == '') {
$formTools.showAlert('sendmail_mail', '请输入您的邮箱');
result = false;
} else if (!isEmail(formData.sendmail_mail)) {
$formTools.showAlert('sendmail_mail', '请输入正确的邮箱地址');
result = false;
} else {
$formTools.hideAlert('sendmail_mail');
}
if (formData.captcha + '' == '') {
$formTools.showAlert('captcha', '请输验证码');
result = false;
} else {
$formTools.hideAlert('captcha');
}
return result;
},
success: function(result) {//提交成功之后需要执行的动作
$('.mail-panel1').hide();
$('.mail-panel2').show();
$('.mail-step1').addClass('txt-hui');
$('.mail-step1').removeClass('txt-orange');
$('.mail-step2').addClass('txt-orange');
$('.mail-step2').removeClass('txt-hui');
if (result.mail) {
$('#mail_addr').html(result.mail);
$('#mail_addr_a').attr('href', result.mailweb);
}
if (result) {
$('#captcha').attr('src', 'http://captcha.subic888.com/image.php?app=subic888&r=' + Math.random());
$('#captcha').val('');
}
},
error: function(result) {//提交失败之后需要执行的动作,result里有errmsg,errdata可以用
$('#captcha').attr('src', 'http://captcha.subic888.com/image.php?app=subic888&r=' + Math.random());
$('#captcha').val('');
if (result.itemalert.name && result.itemalert.msg) {
$formTools.showAlert(result.itemalert.name, result.itemalert.msg);
}
},
button: $('#btn-sendmail')//提交按钮
});
//手机
new $_Form({
form: "#form-sendsms", //表单选择器
check: function(formData) {
var result = true;
if (formData.sendsms_mobile + '' == '') {
$formTools.showAlert('sendsms_mobile', '请输入您的手机号');
result = false;
} else if (!isMobile(formData.sendsms_mobile)) {
$formTools.showAlert('sendsms_mobile', '请输入正确的手机号');
result = false;
} else {
$formTools.hideAlert('sendsms_mobile');
}
return result;
},
success: function(result) {//提交成功之后需要执行的动作
$('.sms-panel1').hide();
$('.sms-panel2').show();
$('.sms-step1').addClass('txt-hui');
$('.sms-step1').removeClass('txt-orange');
$('.sms-step2').addClass('txt-orange');
$('.sms-step2').removeClass('txt-hui');
if (result.mobile) {
$('#checksms_mobile').val(result.mobile);
}
window.sendsmsHost = new sendsms();
window.sendsmsHost.check();
},
error: function(result) {//提交失败之后需要执行的动作,result里有errmsg,errdata可以用
if (result.itemalert.name && result.itemalert.msg) {
$formTools.showAlert(result.itemalert.name, result.itemalert.msg);
}
},
button: $('#btn-sendsms')//提交按钮
});
//bind手机
new $_Form({
form: "#form-bindsms", //表单选择器
check: function(formData) {
var result = true;
if (formData.bindsms_vcode + '' == '') {
$formTools.showAlert('bindsms_vcode', '请输入验证码');
result = false;
} else {
$formTools.hideAlert('bindsms_vcode');
}
return result;
},
success: function(result) {//提交成功之后需要执行的动作
myAlert('绑定成功!');
window.location.reload();
},
error: function(result) {//提交失败之后需要执行的动作,result里有errmsg,errdata可以用
if (result.itemalert.name && result.itemalert.msg) {
$formTools.showAlert(result.itemalert.name, result.itemalert.msg);
}
},
button: $('#btn-bindsms')//提交按钮
});
var provinces = ['11', '12', '13', '14', '15', '21', '22', '23', '31', '32', '33', '34',
'35', '36', '37', '41', '42', '43', '44', '45', '46', '50', '51', '52',
'53', '54', '61', '62', '63', '64', '65', '71', '81', '82', '91'];
function checkIDlength(IDcard){
var cardexp = /(^\d{15}$)|(^\d{17}(\d|X)$)/;
if(!cardexp.test(IDcard)) {
return false;
}else{
return true;
}
}
function checkProvince(pro){
var flag = false;
$.each(provinces, function(i, city){
if(city == pro){
flag = true;
}
});
return flag;
}
function checkBirthday(year, month, day){
var date = new Date();
var cyear = date.getFullYear();
if((cyear-year)<3 || (cyear-year)>120 || month<0 || month>12 || day<0 || day>31){
return false;
}else{
return true;
}
}
function checkParity(card){
var keys = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
var vals = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
var last = 0, i=0;
if(card.length == 15){
return true;
}else{
for(i =0;i<17;i++){
last+= card.substr(i,1)*keys[i];
}
var lastchar = vals[last%11];
var len = card.length-1;
if(lastchar == card.charAt(len)){
return true;
}
return false;
}
}
function _checkRealname(realname) {
var regexp2 = /^[\u4e00-\u9faf]+$/;
if (!regexp2.test($.trim(realname)) || realname.length < 2) {
return false;
} else {
return true;
}
}
//防沉迷
new $_Form({
form: "#form-fcm", //表单选择器
check: function(formData) {
var result = true;
if (formData.fcm_name + '' == '') {
$formToolsmTools.showAlert('fcm_name', '请输入姓名');
result = false;
} else {
var realname = _checkRealname(formData.fcm_name);
if(realname){
$formTools.hideAlert('fcm_name');
}else{
$formTools.showAlert('fcm_name', '姓名只允许输入中文,长度2到4位');
result = false;
}
}
if (formData.fcm_card + '' != '') {
var IDcard = $.trim(formData.fcm_card),
IDcard = IDcard.toUpperCase();
var IDlen = checkIDlength(IDcard),
IDpro = checkProvince(IDcard.substring(0, 2)),
IDbirth = checkBirthday(IDcard.substring(6, 10), IDcard.substring(10, 12), IDcard.substring(12, 14)),
IDpar = checkParity(IDcard);
if(IDlen && IDpro && IDbirth && IDpar){
$formTools.hideAlert('fcm_card');
}else{
$formTools.showAlert('fcm_card', '身份证号不正确');
result = false;
}
}else{
$formTools.showAlert('fcm_card', '请输入身份证号');
result = false;
}
if (formData.fcm_check != 1) {
$formTools.showAlert('fcm_check', '请阅读《防沉迷用户说明》');
result = false;
} else {
$formTools.hideAlert('fcm_check');
}
return result;
},
success: function(result) {//提交成功之后需要执行的动作
myAlert('设置成功!');
window.location.href='/ucindex';
},
error: function(result) {//提º¤å¤±è´¥ä¹åéè¦æ§è¡çå¨ä½,resultéæerrmsg,errdataå¯ä»¥ç¨
if (result.itemalert.name && result.itemalert.msg) {
$formTools.showAlert(result.itemalert.name, result.itemalert.msg);
}
},
button: $('#btn-fcm')//æäº¤æé®
});
//ä¿®æ¹å¯ç 
new $_Form({
form: "#form-repass", //è¡¨åéæ©å¨
check: function(formData) {
var result = true;
if (formData.repass_old + '' == '') {
$formTools.showAlert('repass_old', 'è¯·è¾å¥æ¨çå½åå¯ç ');
result = false;
} else {
$formTools.hideAlert('repass_old');
}
if (formData.repass_new.length < 6 || formData.repass_new.length > 20) {
$formTools.showAlert('repass_new', 'è¯·è¾å¥6-20å­ç¬¦');
result = false;
} else {
$formTools.hideAlert('repass_new');
}
if (formData.repass_check + '' == '') {
$formTools.showAlert('repass_check', 'è¯·åæ¬¡è¾å¥å¯ç ');
result = false;
} else if (formData.repass_check != formData.repass_new) {
$formTools.showAlert('repass_check', 'ä¸¤æ¬¡è¾å¥å¯ç ä¸ä¸è´');
result = false;
} else {
$formTools.hideAlert('repass_check');
}
return result;
},
success: function(result) {//æäº¤æåä¹åéè¦æ§è¡çå¨ä½
myAlert(" ä¿®æ¹æåï¼è¯·æ¨éæ°ç»å½");
location.href = '/ucindex.php';
},
error: function(result) {//æäº¤å¤±è´¥ä¹åéè¦æ§è¡çå¨ä½,resultéæerrmsg,errdataå¯ä»¥ç¨
if (result.itemalert.name && result.itemalert.msg) {
$formTools.showAlert(result.itemalert.name, result.itemalert.msg);
}
},
button: $('#btn-repass')//æäº¤æé®
});
window.sendsmsHost = null;
sendsms = function() {
var waitTime = 120;
var myDate = new Date();
var obj = this;
obj.time = myDate.getTime();
obj.check = function() {
var tempDate = new Date();
limitTime = waitTime - parseInt((tempDate.getTime() - obj.time) / 1000);
if (limitTime < 1) {
$('#resend').empty();
var btn = $('<span>éæ°åé</span>');
btn.click(function() {
$('.sms-panel2').hide();
$('.sms-panel1').show();
$('#btn-sendsms').click();
window.sendsmsHost = new sendsms();
window.sendsmsHost.check();
});
$('#resend').append(btn);
} else {
$('#resend').html('<a href="javascript:void(0)">' + limitTime + 'ç§åéæ°åé</a>');
setTimeout("window.sendsmsHost.check()", 1000);
}
}
}
showAnchor();
});
function openitem(target) {
$(target).parents('.m-list').children('.c-btn').click();
}
function mailStepBack() {
$('.mail-panel1').show();
$('.mail-panel2').hide();
$('.mail-step1').addClass('txt-orange');
$('.mail-step1').removeClass('txt-hui');
$('.mail-step2').addClass('txt-hui');
$('.mail-step2').removeClass('txt-orange');
$('.mail-step2').removeClass('txt-orange');
$('#captcha').attr('src', 'http://captcha.subic888.com/image.php?app=subic888&r=' + Math.random());
$('#captcha').val('');
}
//é¦é¡µéç¹å±å¼
function showAnchor(){
var anchor = window.location.hash.substr(1);
$("a.a_"+anchor).parents('.m-list').children('.c-btn').click();
} 