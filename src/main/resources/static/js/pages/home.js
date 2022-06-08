(function() {
    window.onresize = displayWindowSize;
    window.onload = displayWindowSize;

    function displayWindowSize() {
        let width = window.innerWidth;
        let price = document.getElementById('price');
        let sortBy = document.getElementById('sortBy');
        // console.log(width);
        if(width <= 991){
            sortBy.className = '';
            sortBy.style.marginTop = '-81px';
            sortBy.style.marginLeft = '230px';
            if(width <= 575){
                sortBy.className = 'container mt-5';
                sortBy.style.marginTop = '';
                sortBy.style.marginLeft = '';
            }
        }
    };
})();