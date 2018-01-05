var CASE_SENSITIVE = true;
var CASE_INSENSITIVE = false;
var DO_TRIM=true;
var DO_NOT_TRIM=false;
var MIN_NICK_NAME_LENGTH=4;
var MAX_NICK_NAME_LENGTH=20;
var MIN_PASSWORD_LENGTH=6;
var MAX_PASSWORD_LENGTH=20;
var MIN_NAME_LENGTH=2;
var MAX_NAME_LENGTH=20;
var MIN_ADDRESS_LENGTH=2;
var MAX_ADDRESS_LENGTH=225;
/**
 * 扩展String去掉两端空格
 * 
 * @return
 */
String.prototype.trim=function() {
	var source=this.toString();
	 var len=source.length;
	 for(i=0;i<len;i++) {
		 if(source.charAt(i)!="\u3000" && source.charAt(i)!="\ue4c6")
			 	break;
	 }
	 source=source.substring(i,len);
	 source=source.replace(/(^\s*)|(^　*)|(　*$)|(^\ue4c6*)|(\ue4c6*$)|(\s*$)/g,"");
	 
	 return source;
}
/**
 * 
 * @param {}
 *            source 源字符串
 * @param {}
 *            doTrim 空格控制
 */
function requiredString(source, doTrim) {
	if (doTrim) {
		source=source.trim();
	}
	if(source.length==0) 
		return false;
	return true;
}
/**
 * 邮件验证
 * 
 * @param email
 * @return
 */
function email(email) {
	email=email.trim();
	
	if(email.length==0) {
		return true;
	}
	var pattern=/\b(^['_A-Za-z0-9-]+(\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\.[A-Za-z0-9-]+)*((\.[A-Za-z0-9]{2,})|(\.[A-Za-z0-9]{2,}\.[A-Za-z0-9]{2,}))$)\b/;
	if(regex(email,pattern,false)) {
		return true;
	}
	else {
		return false;
	}
}
/**
 * 邮编的验证
 * @param source
 * @return
 */
function postalCode(source) {
	source=source.trim();
	
	if(source.length==0) {
		return true;
	}
	var pattern=/[0-9]{1}(\d+){5}/;
	if(regex(source,pattern,false)) {
		return true;
	}
	else {
		return false;
	}
}
/**
 * 电话号码的验证
 * @param source
 * @return
 */
function phone(source) {
source=source.trim();
	
	if(source.length==0) {
		return true;
	}
	var pattern=/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
	if(regex(source,pattern,false)) {
		return true;
	}
	else {
		return false;
	}
}
/**
 * 手机号码验证
 * @param source
 * @return
 */
function mobile(source) {
	source=source.trim();
	if(source.length==0) {
		return true;
	}
	var pattern=/^((\(\d{2,3}\))|(\d{3}\-))?1\d{10}$/;
	if(regex(source,pattern,false)) {
		return true;
	}
	else {
		return false;
	}
}
/**
 * 正则验证
 * 
 * @param source
 * @param expression
 * @param isCaseSensitive
 * @return
 */
function regex(source, expression,isCaseSensitive) {
	if(source.length==0) {
		return true;
	}
	if(isCaseSensitive) {
	}
	var regExp=new RegExp(expression);
	return regExp.test(source);
}
/**
 * 判断两个字符串相等
 * 
 * @param s1
 * @param s2
 * @param isCaseSensitive
 * @param doTrim
 * @return
 */
function stringEquals(s1,s2,isCaseSensitive,doTrim) {
	if(doTrim) {
		s1.trim();
		s2.trim();
	}
	if(s1.length==0 || s2.length==0) {
		return true;
	}
	if(isCaseSensitive) {
		return (s1==s2);
	}
	else {
		return (s1.toLowerCase()==s2.toLowerCase());
	}
}
/**
 * 限定字符串长度
 * 
 * @param source
 * @param minLength
 * @param maxLength
 * @param doTrim
 * @return 符合要求返回0,否则返回字符串长度
 */
function stringLength(source, minLength, maxLength,doTrim) {
	if(doTrim) {
		source=source.trim();
	}
	if(source.length==0 || minLength==-1 || maxLength==-1) {
		return 0;
	}
	if(minLength>-1 && source.length< minLength) {
		return source.length;
	}
	else if ((maxLength > -1) && (source.length > maxLength)) {
		return source.length;
	}
	return 0;
}