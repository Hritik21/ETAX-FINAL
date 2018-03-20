function validateform()
{
var x = document.forms["myform"]["fname"].value;
if(x==""){
alert("first name must be filled out");
return false;
}


var y = document.forms["myform"]["lname"].value;
if(y==""){
alert("lastname name must be filled out");
return false;
}

var Z = document.forms["myform"]["pan"].value;
if(Z==""){
alert("pan number name must be filled out");
return false;
}
}