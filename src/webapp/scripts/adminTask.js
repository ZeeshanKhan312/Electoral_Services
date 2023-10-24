"use strict";

if(!localStorage.getItem('admin-username')){
    alert("Not allowed")
    window.location.replace("/voterLogin.html");

}
