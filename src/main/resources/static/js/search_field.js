function requiredName() {
    const inputField = document.querySelector('input');
    let divArray = document.getElementsByClassName('alert alert-info mt-2');
    // console.log(divArray);
    for (let i = 0; i < divArray.length; i++) {
        let temp = divArray[i].getElementsByTagName('h3');
        let spanArray = divArray[i].getElementsByTagName('span');
        if(checkCorrection(spanArray,temp[1]) && inputField.value.length != 0){
            let regExp = new RegExp('.*' + inputField.value + '.*');
            if(temp[0].innerHTML.match(regExp)){
                if(checkCorrection(spanArray)){
                    divArray[i].style.display = 'block';
                }
            } else {
                divArray[i].style.display = 'none';
            }
        } else if(checkCorrection(spanArray,temp[1])){
            divArray[i].style.display = 'block';
        } else {
            divArray[i].style.display = 'none';
        }
    }
}

function changeSliderValue(id,spanId){
    const slider = document.getElementById(id);
    document.getElementById(spanId).innerHTML = slider.value;
    return slider.value;
}

function checkBoxValue(id) {
    const check = document.getElementById(id);
    return check.checked;
}

function checkCorrection(componentInformation, componentPrice){
    if(changeSliderValue('yearMax','yearMaxSpan') - changeSliderValue('yearMin','yearMinSpan')>=0){
        let temp_year = componentInformation[2].innerHTML.substr(0,4);
        if(!(temp_year>=changeSliderValue('yearMin','yearMinSpan') &&
            temp_year<=changeSliderValue('yearMax','yearMaxSpan'))){
            return false;
        }
    } else {
        return false;
    }
    if(changeSliderValue('freqMax','freqMaxSpan') - changeSliderValue('freqMin','freqMinSpan')>=0){
        let temp_freq = componentInformation[0].innerHTML.substr(0,4);
        if(!(temp_freq>=changeSliderValue('freqMin','freqMinSpan') &&
            temp_freq<=changeSliderValue('freqMax','freqMaxSpan'))){
            return false;
        }
    } else {
        return false;
    }
    if(!(checkBoxValue('checkedDesktop') && checkBoxValue('checkedLaptop'))){
        if (checkBoxValue('checkedDesktop') && componentInformation[1].innerHTML == 'Desktop'){
            return true;
        } else if (checkBoxValue('checkedLaptop') && componentInformation[1].innerHTML == 'Laptop'){
            return true;
        }
        return false;
    }
    return true;
}

(function() {
    window.onresize = displayWindowSize;
    window.onload = displayWindowSize;

    function displayWindowSize() {
        let width = window.innerWidth;
         let element = document.getElementById('freq');
         let check = document.getElementById('type');
        if(width <= 994){
            if(width <= 575){
                check.style.margin = '';
                check.className = 'container mt-5';
            } else {
                check.style.margin = '-80px 0 0 45%';
                check.className = '';
            }
            element.style.margin = '';
            element.className = 'container mt-5';
            element.style.width = '';
        } else {
            element.style.width = '60%';
            check.style.margin = '-80px 0 0 45%';
            check.className = '';
            element.style.margin = '-75px 0 0 26%';
            element.className='';
        }
    };
})();