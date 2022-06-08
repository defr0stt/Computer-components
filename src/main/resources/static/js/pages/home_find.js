function requiredName() {
    const inputField = document.querySelector('input');
    let divArray = document.getElementsByClassName('alert alert-info mt-2');
    document.getElementById('resultSet').style.display = 'none';
    // console.log(divArray);
    let counter = 0;
    for (let i = 0; i < divArray.length; i++) {
        let temp = divArray[i].getElementsByTagName('h3');
        let spanArray = divArray[i].getElementsByTagName('span');
        if(checkCorrection(spanArray,temp[1]) && inputField.value.length != 0){
            let regExp = new RegExp('.*' + inputField.value.toLowerCase() + '.*');
            if(temp[0].innerHTML.toLowerCase().match(regExp)){
                if(checkCorrection(spanArray,temp[1])){
                    divArray[i].style.display = 'block';
                    counter++;
                }
            } else {
                divArray[i].style.display = 'none';
            }
        } else if(checkCorrection(spanArray,temp[1])){
            divArray[i].style.display = 'block';
            counter++;
        } else {
            divArray[i].style.display = 'none';
        }
    }
    if (counter == 0){
        document.getElementById('resultSet').style.display='block';
    }
}

function checkCorrection(componentInformation, componentPrice){

    if (changeSliderValue('priceMax','priceMaxSpan') - changeSliderValue('priceMin','priceMinSpan') >= 0){
        let temp_price = '';
        for (let i = 0; i < componentPrice.innerHTML.length; i++) {
            if(componentPrice.innerHTML[i] === '$' || componentPrice.innerHTML[i] === '₴'){
                break;
            }
            temp_price += componentPrice.innerHTML[i];
        }
        if(!((Number)(temp_price)>=(Number)(changeSliderValue('priceMin','priceMinSpan')) &&
            (Number)(temp_price)<=(Number)(changeSliderValue('priceMax','priceMaxSpan')))){
            return false;
        }
        return true
    }
    return false;
}

/*---------------------------------Sliders-------------------------------*/
function changeSliderValue(id,spanId){
    const slider = document.getElementById(id);
    document.getElementById(spanId).innerHTML = slider.value;
    return slider.value;
}

function checkBoxValue(id) {
    const check = document.getElementById(id);
    return check.checked;
}