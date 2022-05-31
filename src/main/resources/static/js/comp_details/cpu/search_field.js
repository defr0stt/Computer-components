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
            let regExp1 = new RegExp('.*' + inputField.value.toUpperCase() + '.*');
            let regExp2 = new RegExp('.*' + inputField.value.toLowerCase() + '.*');
            if(temp[0].innerHTML.toLowerCase().match(regExp2) ||
                temp[0].innerHTML.toUpperCase().match(regExp1)){
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
    if (changeSliderValue('priceMax','priceMaxSpan') - changeSliderValue('priceMin','priceMinSpan') >= 0){
        let temp_price = '';
        for (let i = 0; i < componentPrice.innerHTML.length; i++) {
            if(componentPrice.innerHTML[i] === '$' || componentPrice.innerHTML[i] === '₴'){
                break;
            }
            temp_price += componentPrice.innerHTML[i];
        }
        if(!((Number)(temp_price)>=changeSliderValue('priceMin','priceMinSpan') &&
            (Number)(temp_price)<=changeSliderValue('priceMax','priceMaxSpan'))){
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
        let price = document.getElementById('price');
        let sortBy = document.getElementById('sortBy');
        // console.log(width);
        if(width <= 991){
            check.style.margin = '-80px 70% 0 14%';
            check.className = '';
            element.style.width = '50%';
            price.style.width = '50%';
            element.style.margin = '-75px 0 0 38%';
            element.className = '';
            price.style.margin='25px 0 0 38%';
            price.className='';
            sortBy.className = '';
            sortBy.style.marginTop = '-81px';
            sortBy.style.marginLeft = '230px';
            if(width<=855){
                check.style.margin = '-80px 70% 0 9%';
            }
            if(width <= 575){
                element.style.margin = '';
                element.className = 'container mt-5';
                element.style.width = '';
                price.style.margin = '';
                price.className = 'container mt-5';
                price.style.width = '';
                check.className = 'container mt-5';
                check.style.margin = '';
                sortBy.className = 'container mt-5';
                sortBy.style.marginTop = '';
                sortBy.style.marginLeft = '';
            } else if(width<=767){
                element.style.margin = '-75px 0 0 65%';
                price.style.margin = '25px 0 0 65%';
                if(width>=658){
                    check.style.margin = '-80px 70% 0 17%';
                }
            }
        } else {
            element.style.width = '40%';
            price.style.width = '37%';
            check.style.margin = '-85px 0 0 48%';
            check.className = '';
            element.style.margin = '-75px 0 0 27%';
            element.className='';
            price.style.margin='-75px 0 0 62%';
        }
    };
})();