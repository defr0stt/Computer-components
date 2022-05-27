function checkboxes() {
    let cpu = document.getElementById('cpu_check').checked;
    let case_ = document.getElementById('case_check').checked;
    console.log("case = " + case_ + '; cpu = ' + cpu);

    document.getElementById('cpu_form').style.display = 'none';
    document.getElementById('case_form').style.display = 'none';

    if(cpu){
        document.getElementById('cpu_form').style.display = 'block';
    } else if(case_){
        document.getElementById('case_form').style.display = 'block';
    }
}
