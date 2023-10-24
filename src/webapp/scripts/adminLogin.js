"use strict";

let adminIdInput = document.getElementById('admin-id');
let adminPaswInput = document.getElementById('admin-pasw');

adminIdInput.addEventListener('change',(e)=>{
    adminIdInput.value = e.target.value
    console.log(adminIdInput.value)
})

adminPaswInput.addEventListener('change',(e)=>{
    adminPaswInput.value = e.target.value
    console.log(adminPaswInput.value)
})


let loginBTN = document.getElementById('admin-login');

loginBTN.addEventListener('click',async()=>{
    if(!adminIdInput.value||!adminPaswInput.value){
        alert('Incomplete fields')
        console.log('Please enter voterid')
        cuteToast({
            type: "error", // or 'info', 'error', 'warning'
            title: "Name is required",
            message:'',
            timer: 5000
          })
          return;
    }

    const res = await fetch(`/admin/is-admin`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                AdminDetails:{
                    username:adminIdInput.value,
                    password:adminPaswInput.value
                }
            })
    }).then(response=>response.json())
    console.log(res)
    if(res.error){
        alert(res.error.message);
        return;
    }
    localStorage.setItem('admin-username',adminIdInput.value)
    localStorage.setItem('admin-pass',adminPaswInput.value)

    window.location.replace("/adminTask.html");
})
