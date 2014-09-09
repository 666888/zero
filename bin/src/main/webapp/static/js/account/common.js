////ajax提交表单
//new $_Form({
// form: "#game_add",//表单选择器
// success: function(result) {//提交成功之后需要执行的动作
// alert('添加成功');
// },
// error: function(result) {//提交失败之后需要执行的动作,result里有errmsg,errdata可以用
// alert('添加成功');
// },
// button: $('#submit1')//提交按钮
//});
$_Form = function(config) {
var obj = this;
this.form = $(config.form);
this.check = function(formData) {
if (typeof config.check == 'function') {
return config.check(formData);
}
return true;
}
this.success = function(result) {
//this.form[0].reset();
if (typeof config.success == 'function') {
config.success(result);
return;
}
if (result.sucmsg) {
myAlert(result.sucmsg);
}
}
this.error = function(result) {
if (typeof config.error == 'function') {
config.error(result);
return;
}
if (result.msg) {
myAlert(result.msg);
}
}
this.submit = function() {
if (obj.form.length < 1) {
mylog('错误：没有找到表单');
return;
}
var method = obj.form.attr('method').toUpperCase();
if (method != 'POST' && method != 'GET') {
method = 'POST';
}
var formData = {}, b1;
$.each(obj.form.serializeArray(), function(k, v) {
formData[v.name] = $.trim(v.value);
});
if (!this.check(formData)) {
return;
}
if(obj.form.attr('action') == '/repass.php'){
var action = obj.form.attr('action');
$.ajax({
url:'/ajax_aeskey.php?r='+Math.random(),
success:function(data){
if(data.errno == 0){
var key = data.data;
key = CryptoJS.enc.Utf8.parse(key);
iv = CryptoJS.enc.Utf8.parse("995d1b5ebbac3761");
encrypted1 = CryptoJS.AES.encrypt(formData.repass_old, key, { iv: iv, mode:CryptoJS.mode.CBC, padding:CryptoJS.pad.ZeroPadding});
encrypted2 = CryptoJS.AES.encrypt(formData.repass_new, key, { iv: iv, mode:CryptoJS.mode.CBC, padding:CryptoJS.pad.ZeroPadding});
formData.repass_old = encrypted1.toString();
formData.repass_new = encrypted2.toString();
request(config,'GET', action,'repass_old='+encodeURIComponent(formData.repass_old)+'&repass_new='+encodeURIComponent(formData.repass_new));
}
}
})
}else{
$.ajax({
type: method,
url: obj.form.attr("action"),
data: obj.form.serialize(),
dataType: "json",
async: false,
success: function(result) {
/*
*页面没有登录，返回登录
* */
if (result.error == 'unlogin') {
window.location = '/login';
} else if (result.error == 'ok') {
obj.success(result.data);
} else {
obj.error(result.error);
}
},
error: function(XMLHttpRequest, textStatus, errorThrown) {
myAlert('亲!提交错误,请稍后再试');
}
});
}
};
if (config.button) {
$(config.button).click(function() {
obj.submit();
});
}
};
function request(config,method, url, data){
$.ajax({
type: method,
url: url,
data: data,
dataType: "json",
async: false,
success: function(result) {
/*
*页面没有登录，返回登录
* */
if (result.error == 'unlogin') {
window.location = '/login';
} else if (result.error == 'ok') {
config.success(result);
} else {
myAlert(result.error.itemalert.msg);
}
},
error: function(XMLHttpRequest, textStatus, errorThrown) {
myAlert('亲!提交错误,请稍后再试');
}
});
}
//输出调试信息
window.mylog = function(data) {
try {
if (typeof data == "function" || typeof data == "object") {
console.dir(data);
} else {
console.log(data);
}
//console.trace();
} catch (e) {
}
}
//弹窗,之后改成带样式的弹出层
window.myAlert = function(msg) {
alert(msg);
};
function isEmail(strEmail) {
return (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) ? true : false;
}
function isMobile(strMobile) {
return (strMobile.search(/^1[3|5|8]\d{9}$/) != -1) ? true : false;
} 
} 