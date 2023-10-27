"use strict";

let voters;
const voterList = document.getElementById('voter-list-body')

const fetchVoters = async()=>{
    const res = await fetch(`/admin/list-voters`,{
        method: 'POST',
        headers:{
            'Content-type':'application/json',
            'Accept': 'application/json',
        },
        body:JSON.stringify({
                AdminDetails:{
                    username:localStorage.getItem('admin-username'),
                    password:localStorage.getItem('admin-pass')
                }
            })
    }).then(response=>response.json())

    voterList.innerHTML=returnHTMLCode(res)

}



fetchVoters()
const returnHTMLCode = (voters) => {
    let result ='';

    voters.forEach((voter)=>{
        result+=`<tr>
        <td>${voter.voterId}</td>
        <td>${voter.name}</td>
        <td>${voter.address}</td>
        <td>${voter.dob.split('T')[0]}</td>
        <td>${voter.mobile_no}</td>
        <td>${voter.cast}</td>
      </tr>`
    })

    return result;
}