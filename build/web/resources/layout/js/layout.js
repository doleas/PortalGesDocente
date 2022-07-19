    var inputs = document.querySelectorAll('.input-text');
    inputs.forEach( input =>{
        input.onfocus = function(){
            input.previousElementSibling.classList.add('top');
        };   
        input.onblur = function(){
            input.value = input.value.trim();
            if(input.value.trim().length == 0){
                input.previousElementSibling.classList.remove('top');
            }
        };
    });
