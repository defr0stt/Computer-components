const title = document.querySelector('title').getAttribute('id');
const condition = /.*active.*/;
let myElem = [document.getElementById('home'),
              document.getElementById('list'),
              document.getElementById('compare'),
              document.getElementById('log_page'),
              document.getElementById('about')];
myElem.forEach(changeActive);

function changeActive(item) {
    // console.log(item.textContent + '; title = ' + title);
    if (item.getAttribute('class').match(condition)){
        // console.log('yes = ' + item.getAttribute('class'));
        item.setAttribute('class','nav-link');
    }
    let temp = item.textContent;
    if(temp.length>20){
        temp = 'Profile';
    }
    if (temp === title){
        if(title === 'List of components'){
            item.setAttribute('class','nav-link dropdown-toggle active');
        } else {
            item.setAttribute('class','nav-link active');
            if (temp === 'Profile'){
                if(document.getElementById('user_out') != null){
                    sessionStorage.setItem('status','logged');
                } else {
                    sessionStorage.setItem('status','anonymous');
                }
                console.log(sessionStorage.getItem('status'));
            }
        }
    }
}

/*---------------Profile page--------------------*/

if(sessionStorage.getItem('status') !== undefined) {
    if (sessionStorage.getItem('status') === 'logged') {
        document.getElementById('log_page').setAttribute('href','/profile');
        } else {
        document.getElementById('log_page').setAttribute('href','/login');
        }
}

const errMatch = /.*login\?error.*/
if(window.location.href.match(errMatch)){
    alert('Incorrect password or username');
}
const prof = /.*profile.*/
if(window.location.href.match(prof)){
    const role = document.getElementById('basic-addon4')
    if(document.getElementById('basic-addon2').innerHTML === 'admin'){
        role.innerHTML = 'ADMIN';
    } else {
        role.innerHTML = 'USER';
    }
}