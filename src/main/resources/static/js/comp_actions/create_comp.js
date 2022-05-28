function checkboxes() {
    let cpu = document.getElementById('cpu_check').checked;
    let case_ = document.getElementById('case_check').checked;

    document.getElementById('cpu_form').style.display = 'none';
    document.getElementById('case_form').style.display = 'none';

    if(cpu){
        document.getElementById('cpu_form').style.display = 'block';
    } else if(case_){
        document.getElementById('case_form').style.display = 'block';
    }
}

function updateComponent() {
    document.getElementById('cpu_update_form').style.display = 'none';
    document.getElementById('case_update_form').style.display = 'none';

    let condition = document.getElementById('compDetails').innerHTML;
    console.log(condition);
    if(condition.match(/.*CPU.*/)){
        document.getElementById('cpu_update_form').style.display = 'block';
    } else if(condition.match(/.*Case.*/)){
        document.getElementById('case_update_form').style.display = 'block';
    }
}