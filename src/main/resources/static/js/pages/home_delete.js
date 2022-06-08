function checkDeleteButton(){
    let button = document.getElementById('delete_button');
    let u_name_model = document.getElementById('u_name').innerHTML;
    let temp = u_name_model.slice((u_name_model.search('by ') + 3),u_name_model.length);
    let username = document.getElementsByTagName('body')[0].getAttribute('id');
    console.log('temp ' + temp);
    console.log('us ' + username);
    if(username === temp){
        button.style.display = 'block';
    } else {
        button.style.display = 'none';
    }
}