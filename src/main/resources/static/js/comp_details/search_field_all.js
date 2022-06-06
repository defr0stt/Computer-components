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

        if(changeSliderValue('yearMax','yearMaxSpan') - changeSliderValue('yearMin','yearMinSpan')>=0){
            let temp_year = (Number)(componentInformation[2].innerHTML.substr(0,4));
            if(!((Number)(temp_year)>=(Number)(changeSliderValue('yearMin','yearMinSpan')) &&
                (Number)(temp_year)<=(Number)(changeSliderValue('yearMax','yearMaxSpan')))){
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
            if(!((Number)(temp_price)>=(Number)(changeSliderValue('priceMin','priceMinSpan')) &&
                (Number)(temp_price)<=(Number)(changeSliderValue('priceMax','priceMaxSpan')))){
                return false;
            }
        } else {
            return false;
        }
    /*------------CPU------------*/
    if(document.getElementsByTagName('title')[0].innerHTML === 'CPU'){
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
            if (checkBoxValue('checkedDesktop') && componentInformation[1].innerHTML === 'Desktop'){
                return true;
            } else if (checkBoxValue('checkedLaptop') && componentInformation[1].innerHTML === 'Laptop'){
                return true;
            }
            return false;
        }
        return true;
    }
    /*------------GPU------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'GPU'){
        if(changeSliderValue('freqMax','freqMaxSpan') - changeSliderValue('freqMin','freqMinSpan')>=0){
            let temp_freq = componentInformation[0].innerHTML.substr(0,componentInformation[0].innerHTML.length-3);
            if(!(temp_freq>=(Number)(changeSliderValue('freqMin','freqMinSpan')) &&
                temp_freq<=(Number)(changeSliderValue('freqMax','freqMaxSpan')))){
                return false;
            }
        } else {
            return false;
        }
        if(!(checkBoxValue('checkedDdr4') && checkBoxValue('checkedDdr5'))){
            if (checkBoxValue('checkedDdr4') && componentInformation[1].innerHTML === 'DDR4'){
                return true;
            } else if (checkBoxValue('checkedDdr5') && componentInformation[1].innerHTML === 'DDR5'){
                return true;
            }
            return false;
        }
        return true;
    }
    /*------------Cooler------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Cooler'){
        if(!(checkBoxValue('checkedPcCooler') && checkBoxValue('checkedComponentCooler'))){
            if (checkBoxValue('checkedPcCooler') && componentInformation[0].innerHTML === 'PC'){
                return true;
            } else if (checkBoxValue('checkedComponentCooler') && componentInformation[0].innerHTML === 'Components'){
                return true;
            }
            return false;
        }
        return true;
    }
    /*------------Hardware------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Hardware'){
        if(!(checkBoxValue('checkedInner') && checkBoxValue('checkedOuter'))){
            if (checkBoxValue('checkedInner') && componentInformation[1].innerHTML === 'Inner'){
                return true;
            } else if (checkBoxValue('checkedOuter') && componentInformation[1].innerHTML === 'Outer'){
                return true;
            }
            return false;
        }
        if(changeSliderValue('memMax','memMaxSpan') - changeSliderValue('memMin','memMinSpan')>=0){
            let temp_mem = componentInformation[0].innerHTML.substr(0,componentInformation[0].innerHTML.length-2);
            if(!(temp_mem>=changeSliderValue('memMin','memMinSpan') &&
                temp_mem<=changeSliderValue('memMax','memMaxSpan'))){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    /*------------Memory------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Memory'){
        if(!(checkBoxValue('checkedMemPC') && checkBoxValue('checkedMemLaptop'))){
            if (checkBoxValue('checkedMemPC') && componentInformation[1].innerHTML === 'PC'){
                return true;
            } else if (checkBoxValue('checkedMemLaptop') && componentInformation[1].innerHTML === 'Laptop'){
                return true;
            }
            return false;
        }
        if(changeSliderValue('memMax','memMaxSpan') - changeSliderValue('memMin','memMinSpan')>=0){
            let temp_mem = componentInformation[0].innerHTML.substr(0,componentInformation[0].innerHTML.length-3);
            if(!((Number)(temp_mem)>=(Number)(changeSliderValue('memMin','memMinSpan')) &&
                (Number)(temp_mem)<=(Number)(changeSliderValue('memMax','memMaxSpan')))){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    /*------------Motherboard------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Motherboard'){
        if(changeSliderValue('freqMax','freqMaxSpan') - changeSliderValue('freqMin','freqMinSpan')>=0){
            let temp_freq = componentInformation[0].innerHTML.substr(0,componentInformation[0].innerHTML.length-3);
            if(!((Number)(temp_freq)>=(Number)(changeSliderValue('freqMin','freqMinSpan')) &&
                (Number)(temp_freq)<=(Number)(changeSliderValue('freqMax','freqMaxSpan')))){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    /*------------Case------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Case'){
        if(!(checkBoxValue('checkedBlack') && checkBoxValue('checkedWhite'))){
            if (checkBoxValue('checkedBlack') && componentInformation[1].innerHTML === 'Black'){
                return true;
            } else if (checkBoxValue('checkedWhite') && componentInformation[1].innerHTML === 'White'){
                return true;
            }
            return false;
        }
        return true;
    }
    /*------------OS------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'OS'){
        if(!(checkBoxValue('checked64') && checkBoxValue('checked32'))){
            if (checkBoxValue('checked64') && componentInformation[1].innerHTML === '64'){
                return true;
            } else if (checkBoxValue('checked32') && componentInformation[1].innerHTML === '32'){
                return true;
            }
            return false;
        }
        return true;
    }
    /*------------Power supply------------*/
    else if(document.getElementsByTagName('title')[0].innerHTML === 'Power supply'){

        if(changeSliderValue('powerMax','powerMaxSpan') - changeSliderValue('powerMin','powerMinSpan')>=0){
            let temp_power = componentInformation[0].innerHTML.substr(0,componentInformation[0].innerHTML.length-1);
            if(!(temp_power>=(Number)(changeSliderValue('powerMin','powerMinSpan')) &&
                temp_power<=(Number)(changeSliderValue('powerMax','powerMaxSpan')))){
                return false;
            }
        } else {
            return false;
        }

        if(!(checkBoxValue('checkedSupDesktop') && checkBoxValue('checkedSupLaptop'))){
            if (checkBoxValue('checkedSupDesktop') && componentInformation[1].innerHTML === 'Desktop'){
                return true;
            } else if (checkBoxValue('checkedSupLaptop') && componentInformation[1].innerHTML === 'Laptop'){
                return true;
            }
            return false;
        }
        return true;
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