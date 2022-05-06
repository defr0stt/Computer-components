const title = document.querySelector('title').getAttribute('id');
const condition = /.*active.*/;
let myElem = [document.getElementById('home'),
              document.getElementById('list'),
              document.getElementById('compare'),
              document.getElementById('about')];
myElem.forEach(changeActive);

function changeActive(item) {
    /*console.log(item.textContent + '; title = ' + title);*/
    if (item.getAttribute('class').match(condition)){
        console.log('yes = ' + item.getAttribute('class'));
        item.setAttribute('class','nav-link');
    }
    if (item.textContent === title){
        if(title === 'List of components'){
            item.setAttribute('class','nav-link dropdown-toggle active');
        } else {
            item.setAttribute('class','nav-link active');
        }
    }
}
