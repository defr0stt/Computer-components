function requiredName() {
    const inputField = document.querySelector('input');
    let divArray = document.getElementsByClassName('alert alert-info mt-2');
    // console.log(divArray);
    for (let i = 0; i < divArray.length; i++) {
        if(inputField.value.length != 0){
            let temp = divArray[i].getElementsByTagName('h3');
            let regExp = new RegExp('.*' + inputField.value + '.*');
            if(temp[0].innerHTML.match(regExp)){
                console.log(temp[0].innerHTML);
                divArray[i].style.display = 'block';
            } else {
                divArray[i].style.display = 'none';
            }
        } else {
            divArray[i].style.display = 'block';
        }
    }
}

// let $sliderMinYear = $('#yearMin');
// let $sliderMaxYear = $('#yearMax');

// $sliderMinYear.on('change', function() {
//     document.getElementById('yearMinSpan').innerHTML = $sliderMinYear.val();
// });
//
// $sliderMaxYear.on('change', function() {
//     document.getElementById('yearMaxSpan').innerHTML = $sliderMaxYear.val();
// });

function changeSliderValue(id,spanId){
    const slider = document.getElementById(id);
    document.getElementById(spanId).innerHTML = slider.value;
}