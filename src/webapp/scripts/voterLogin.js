"use strict";

let voterIdInput = document.getElementById('voter-id');
let voterDOBInput = document.getElementById('voter-dob');

voterIdInput.addEventListener('change',(e)=>{
    voterIdInput.value = e.target.value
    console.log(voterIdInput.value)
})

voterDOBInput.addEventListener('change',(e)=>{
    voterDOBInput.value = e.target.value
    console.log(voterDOBInput.value)
})


let loginBTN = document.getElementById('voter-login');

loginBTN.addEventListener('click',async()=>{
    if(!voterIdInput.value||!voterDOBInput.value){
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


    const res = await fetch(`voters/is-voter`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({voterId:voterIdInput.value})
    }).then(response=>response.json())
    if(res.error){
        alert(res.error.message);
        return;
    }
    localStorage.setItem('voter-id',res.voterId)
    window.location.replace("/voterTask.html");
})
