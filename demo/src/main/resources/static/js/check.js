function checkName()
{
    var reg=/^[\u4e00-\u9fa5]{2,10}$/;
    var name=document.mform.name;
    if(!reg.test(name.value))
    {
        document.getElementById("name_tip").innerHTML="<img src='/img/error.png'>请输入真实姓名,10字以内中文!";
        name.focus();
        return false;
    }
    else
    {
        document.getElementById("name_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}
function checkDepart()
{
    var reg=/^[\u4e00-\u9fa5]{2,15}$/;
    var department=document.mform.department;
    if(!reg.test(department.value))
    {
        document.getElementById("depart_tip").innerHTML="<img src='/img/error.png'>请输入院系,15字以内中文!";
        department.focus();
        return false;
    }
    else
    {
        document.getElementById("depart_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}

function checkGrage()
{

    var reg=/^\d{4}$/;
    var grade=document.mform.grade;
    if(!reg.test(grade.value))
    {
        document.getElementById("grade_tip").innerHTML="<img src='/img/error.png'>请输入年级,4位数字!";
        grade.focus();
        return false;
    }
    else
    {
        document.getElementById("grade_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}
function checkLevel()
{
    var reg=/^[\u4e00-\u9fa5]{2,5}$/;
    var level=document.mform.level;
    if(!reg.test(level.value))
    {
        document.getElementById("level_tip").innerHTML="<img src='/img/error.png'>请输入层次,5字以内中文!";
        level.focus();
        return false;
    }
    else
    {
        document.getElementById("level_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}
function checkAccount()
{
    var reg=/^\d{6}$/;
    var account=document.mform.account;
    if(!reg.test(account.value))
    {
        document.getElementById("account_tip").innerHTML="<img src='/img/error.png'>请输入账号,6位数字!";
        account.focus();
        return false;
    }
    else
    {
        document.getElementById("account_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}
function checkPass()
{
    var reg=/^\d{6}$/;
    var password=document.mform.password;
    if(!reg.test(password.value))
    {
        document.getElementById("pass_tip").innerHTML="<img src='/img/error.png'>请输入密码,6位数字!";
        password.focus();
        return false;
    }
    else
    {
        document.getElementById("pass_tip").innerHTML="<img src='/img/right.png'>";
        return true;
    }
}
function checkAll()
{
    if(!checkName() || !checkstudentid() || !checkDepart() || !checkLevel() || !checkGrage()|| !checkAccount()|| !checkPass())
        return false;
    else
        return true;
}