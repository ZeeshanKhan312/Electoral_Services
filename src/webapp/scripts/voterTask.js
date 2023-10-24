"use strict";

if(!localStorage.getItem('voter-id')){
    alert("Not allowed")
    window.location.replace("/voterLogin.html");

}