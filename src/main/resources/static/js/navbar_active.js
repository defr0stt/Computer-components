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

/*---------------Error--------------------*/

const errMatch = /.*login\?error.*/
if(document.getElementById('alert_err') != undefined){
    if(window.location.href.match(errMatch)){
        document.getElementById('alert_err').style.display = 'block';
    } else {
        document.getElementById('alert_err').style.display = 'none';
    }
}

/*---------------Profile page--------------------*/

if(window.location.href.match(/.*all_users.*/) || window.location.href.match(/.*profile.*/)){
    sessionStorage.setItem('status','logged');
    document.getElementById('log_page').setAttribute('href','/profile');
}

if(sessionStorage.getItem('status') !== undefined) {
    if (sessionStorage.getItem('status') === 'logged') {
        document.getElementById('log_page').setAttribute('href','/profile');
        } else {
        document.getElementById('log_page').setAttribute('href','/login');
        }
}

const prof = /.*profile.*/
if(window.location.href.match(prof)){
    const role = document.getElementById('basic-addon6')
    if(document.getElementById('basic-addon2') != null){
        if(document.getElementById('basic-addon2').innerHTML === 'admin'){
            role.innerHTML = 'ADMIN';
            document.getElementById('userDate').style.display = 'none';
            document.getElementById('all_users').style.display = 'block';
            document.getElementById('components_crud').style.display = 'block';
            document.getElementById('change_pass').style.display = 'none';
            document.getElementById('comp_text').style.display = 'block';
        } else {
            role.innerHTML = 'USER';
        }
    }
}