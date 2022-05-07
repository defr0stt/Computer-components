function changeBg(id) {
    const mouseTarget = document.getElementById(id);
    mouseTarget.addEventListener('mouseenter', e => {
        mouseTarget.style.background = '#E8E8E8';
    });
    mouseTarget.addEventListener('mouseleave', e => {
        mouseTarget.style.background = 'white';
    });
}

(function() {
    window.onresize = displayWindowSize;
    window.onload = displayWindowSize;

    function displayWindowSize() {
        let width = window.innerWidth;
        let elements = document.getElementById('all_elems').style;
        if(width <= 870){
            elements.left='15%';
            elements.right='15%';
        } else if(width > 870 && width < 1157){
            elements.left='23%';
            elements.right='23%';
        } else {
            elements.left = '32%';
            elements.right='32%';
        }
    };
})();