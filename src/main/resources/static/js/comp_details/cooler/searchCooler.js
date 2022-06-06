(function() {
    window.onresize = displayWindowSize;
    window.onload = displayWindowSize;

    function displayWindowSize() {
        let width = window.innerWidth;
        let check = document.getElementById('type');
        let price = document.getElementById('price');
        let sortBy = document.getElementById('sortBy');
        // console.log(width);
        if(width <= 991){
            check.style.margin = '-80px 45% 0 14%';
            check.className = '';
            price.style.width = '50%';
            price.style.margin='25px 0 0 38%';
            price.className='';
            sortBy.className = '';
            sortBy.style.marginTop = '-81px';
            sortBy.style.marginLeft = '230px';
            if(width<=855){
                check.style.margin = '-80px 70% 0 9%';
            }
            if(width <= 575){
                price.style.margin = '';
                price.className = 'container mt-5';
                price.style.width = '';
                check.className = 'container mt-5';
                check.style.margin = '';
                sortBy.className = 'container mt-5';
                sortBy.style.marginTop = '';
                sortBy.style.marginLeft = '';
            } else if(width<=767){
                price.style.margin = '25px 0 0 65%';
                if(width>=658){
                    check.style.margin = '-80px 70% 0 17%';
                }
            }
        } else {
            price.style.width = '37%';
            check.style.margin = '-85px 0 0 30%';
            check.className = '';
            price.style.margin='-75px 0 0 48%';
        }
    };
})();