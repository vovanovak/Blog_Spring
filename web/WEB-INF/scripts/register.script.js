/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function bodyOnload(){
        setRandomBackground();
        // var reg = document.getElementById('buttonSubmit');
        // reg.onclick = function(e){
                // $('#divMainForm').remove();
        //};
        if($('#errormsg').text() != ""){
            $('#errormsg').css("display", "none");
            alert("Check data! Email or username isn't unique!");

        }
}

function setRandomBackground(){
        var number = Math.floor(Math.random() * 12) + 1;
        document.body.style.backgroundImage="url('images/main.backgrounds/" + number + ".jpg')";
}
