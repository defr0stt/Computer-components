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

function checkCorrection(componentInformation, componentPrice){
    if(changeSliderValue('yearMax','yearMaxSpan') - changeSliderValue('yearMin','yearMinSpan')>=0){
        let temp_freq = componentInformation[2].innerHTML.substr(0,4);
        if(temp_freq>=changeSliderValue('yearMin','yearMinSpan') &&
            temp_freq<=changeSliderValue('yearMax','yearMaxSpan')){
            return true;
        }
    }
    return false;
}