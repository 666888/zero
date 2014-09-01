window.$formTools = {
showAlert: function(name, msg) {
this.hideAlert(name);
$(':input[name=' + name + ']').parents('li.form-item').after($('<li class="txt-red form-alert" style="height:20px; min-height:20px;"><label class="dis"></label>' + msg + '</li>'));
},
hideAlert: function(name) {
$(':input[name=' + name + ']').parents('li.form-item').next('li.form-alert').remove();
}
} 