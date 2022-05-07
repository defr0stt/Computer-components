(function() {
    window.onresize = displayWindowSize;
    window.onload = displayWindowSize;

    function displayWindowSize() {
        let myWidth = window.innerWidth;
        let myHeight = window.innerHeight;
        // your size calculation code here
        // console.log(myWidth + "x" + myHeight);
        let temp = document.getElementById('cpu_img').style;
        let table = document.getElementById('table').style;
        if(myWidth <= 1165){
            temp.margin = "0";
            temp.textAlign = 'center';
            temp.marginLeft = 'auto';
            temp.marginRight = 'auto';
            temp.float = 'none';
            temp.display = 'block';
            table.marginLeft = '0';
            table.marginRight = '0';
            table.left = '0';
        } else {
            temp.margin = "-300px 0 0 0";
            temp.marginLeft = '0';
            temp.marginRight = '0';
            temp.textAlign = 'left';
            temp.float = 'left';
            temp.display = 'inline';
            table.marginLeft = 'auto';
            table.marginRight = 'auto';
            table.left = '25%';
        }
    };
})();