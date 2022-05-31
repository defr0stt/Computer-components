function currency() {
    let allComponents = document.getElementsByClassName('alert alert-info mt-2');
    for (let i = 0; i < allComponents.length; i++) {
        let price = (Number) (allComponents[i].getElementsByTagName('h3')[1].
                innerHTML.slice(0,allComponents[i].getElementsByTagName('h3')[1].innerHTML.length-1));
        let prMin = document.getElementById('priceMin');
        let prMax = document.getElementById('priceMax');
        if(document.getElementById('dollar').checked){
            price /= 30;
            price += '$';
            prMin.setAttribute('max','2000');
            prMax.setAttribute('max','2000');
            prMax.setAttribute('value','2000');
            prMax.innerHTML = '2000';
        } else {
            price *= 30;
            price += '₴';
            prMin.setAttribute('max','60000');
            prMax.setAttribute('max','60000');
            prMax.setAttribute('value','60000');
            prMax.innerHTML = '60000';
        }
        allComponents[i].getElementsByTagName('h3')[1].innerHTML = price;
    }
}

function sortByPrice(sortCondition){
    let allComponents = document.getElementsByClassName('alert alert-info mt-2');
    for (let i = 0; i < allComponents.length; i++) {
        for(let j = 0; j < allComponents.length-1; j++){
            let h3_0, h3_1, span_0, span_1, span_2, a_href;
            if(allComponents[j].style.display === 'block' && allComponents[j+1].style.display === 'block'){
                if(sortCondition === 'less_to_bigger'){
                    if((Number)(allComponents[j].getElementsByTagName('h3')[1].
                    innerHTML.slice(0,allComponents[j].getElementsByTagName('h3')[1].innerHTML.length-1))
                        > (Number)(allComponents[j+1].getElementsByTagName('h3')[1].
                        innerHTML.slice(0,allComponents[j+1].getElementsByTagName('h3')[1].innerHTML.length-1))){

                        h3_0 = allComponents[j].getElementsByTagName('h3')[0].innerHTML;
                        h3_1 = allComponents[j].getElementsByTagName('h3')[1].innerHTML;
                        span_0 = allComponents[j].getElementsByTagName('span')[0].innerHTML;
                        span_1 = allComponents[j].getElementsByTagName('span')[1].innerHTML;
                        span_2 = allComponents[j].getElementsByTagName('span')[2].innerHTML;
                        a_href = allComponents[j].getElementsByTagName('a')[0].getAttribute('href');

                            allComponents[j].getElementsByTagName('h3')[0].innerHTML =
                                allComponents[j+1].getElementsByTagName('h3')[0].innerHTML;
                            allComponents[j].getElementsByTagName('h3')[1].innerHTML =
                                allComponents[j+1].getElementsByTagName('h3')[1].innerHTML;
                            allComponents[j].getElementsByTagName('span')[0].innerHTML =
                                allComponents[j+1].getElementsByTagName('span')[0].innerHTML;
                            allComponents[j].getElementsByTagName('span')[1].innerHTML =
                                allComponents[j+1].getElementsByTagName('span')[1].innerHTML;
                            allComponents[j].getElementsByTagName('span')[2].innerHTML =
                                allComponents[j+1].getElementsByTagName('span')[2].innerHTML;
                            allComponents[j].getElementsByTagName('a')[0].setAttribute('href',
                                allComponents[j+1].getElementsByTagName('a')[0].getAttribute('href'));

                        allComponents[j+1].getElementsByTagName('h3')[0].innerHTML = h3_0;
                        allComponents[j+1].getElementsByTagName('h3')[1].innerHTML = h3_1;
                        allComponents[j+1].getElementsByTagName('span')[0].innerHTML = span_0;
                        allComponents[j+1].getElementsByTagName('span')[1].innerHTML = span_1;
                        allComponents[j+1].getElementsByTagName('span')[2].innerHTML = span_2;
                        allComponents[j+1].getElementsByTagName('a')[0].setAttribute('href', a_href);
                    }
                } else {
                    if((Number)(allComponents[j].getElementsByTagName('h3')[1].
                        innerHTML.slice(0,allComponents[j].getElementsByTagName('h3')[1].innerHTML.length-1))
                        < (Number)(allComponents[j+1].getElementsByTagName('h3')[1].
                        innerHTML.slice(0,allComponents[j+1].getElementsByTagName('h3')[1].innerHTML.length-1))){

                        h3_0 = allComponents[j].getElementsByTagName('h3')[0].innerHTML;
                        h3_1 = allComponents[j].getElementsByTagName('h3')[1].innerHTML;
                        span_0 = allComponents[j].getElementsByTagName('span')[0].innerHTML;
                        span_1 = allComponents[j].getElementsByTagName('span')[1].innerHTML;
                        span_2 = allComponents[j].getElementsByTagName('span')[2].innerHTML;
                        a_href = allComponents[j].getElementsByTagName('a')[0].getAttribute('href');

                        allComponents[j].getElementsByTagName('h3')[0].innerHTML =
                            allComponents[j+1].getElementsByTagName('h3')[0].innerHTML;
                        allComponents[j].getElementsByTagName('h3')[1].innerHTML =
                            allComponents[j+1].getElementsByTagName('h3')[1].innerHTML;
                        allComponents[j].getElementsByTagName('span')[0].innerHTML =
                            allComponents[j+1].getElementsByTagName('span')[0].innerHTML;
                        allComponents[j].getElementsByTagName('span')[1].innerHTML =
                            allComponents[j+1].getElementsByTagName('span')[1].innerHTML;
                        allComponents[j].getElementsByTagName('span')[2].innerHTML =
                            allComponents[j+1].getElementsByTagName('span')[2].innerHTML;
                        allComponents[j].getElementsByTagName('a')[0].setAttribute('href',
                            allComponents[j+1].getElementsByTagName('a')[0].getAttribute('href'));

                        allComponents[j+1].getElementsByTagName('h3')[0].innerHTML = h3_0;
                        allComponents[j+1].getElementsByTagName('h3')[1].innerHTML = h3_1;
                        allComponents[j+1].getElementsByTagName('span')[0].innerHTML = span_0;
                        allComponents[j+1].getElementsByTagName('span')[1].innerHTML = span_1;
                        allComponents[j+1].getElementsByTagName('span')[2].innerHTML = span_2;
                        allComponents[j+1].getElementsByTagName('a')[0].setAttribute('href', a_href);
                    }
                }
            }
        }
    }
}