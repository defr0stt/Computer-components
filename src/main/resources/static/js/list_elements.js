function changeBg(id) {
    const mouseTarget = document.getElementById(id);
    mouseTarget.addEventListener('mouseenter', e => {
        mouseTarget.style.background = '#E8E8E8';
    });
    mouseTarget.addEventListener('mouseleave', e => {
        mouseTarget.style.background = 'white';
    });
}

