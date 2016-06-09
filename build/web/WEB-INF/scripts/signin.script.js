/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function bodyOnload(){
        setRandomBackground();
        $('#divRegForm').remove();
        var reg = document.getElementById('buttonRegister');
        reg.onclick = function(e){
                $('#divMainForm').remove();
                $('#footer').remove();
        };
}

function setRandomBackground(){
        var number = Math.floor(Math.random() * 12) + 1;
        document.body.style.backgroundImage="url('images/main.backgrounds/" + number + ".jpg')";
}