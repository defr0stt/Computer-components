function checkboxes() {
    let cpu = document.getElementById('cpu_check').checked;
    let case_ = document.getElementById('case_check').checked;
    let hard = document.getElementById('hard_check').checked;
    let cooler = document.getElementById('cooler_check').checked;
    let gpu = document.getElementById('gpu_check').checked;
    let memory = document.getElementById('memory_check').checked;
    let board = document.getElementById('motherboard_check').checked;
    let os = document.getElementById('os_check').checked;
    let pSupply = document.getElementById('supply_check').checked;

    document.getElementById('cpu_form').style.display = 'none';
    document.getElementById('case_form').style.display = 'none';
    document.getElementById('hardware_form').style.display = 'none';
    document.getElementById('cooler_form').style.display = 'none';
    document.getElementById('gpu_form').style.display = 'none';
    document.getElementById('memory_form').style.display = 'none';
    document.getElementById('motherboard_form').style.display = 'none';
    document.getElementById('os_form').style.display = 'none';
    document.getElementById('supply_form').style.display = 'none';

    if(cpu){
        document.getElementById('cpu_form').style.display = 'block';
    } else if(case_){
        document.getElementById('case_form').style.display = 'block';
    } else if(hard){
        document.getElementById('hardware_form').style.display = 'block';
    } else if(cooler){
        document.getElementById('cooler_form').style.display = 'block';
    } else if(gpu) {
        document.getElementById('gpu_form').style.display = 'block';
    } else if(memory){
        document.getElementById('memory_form').style.display = 'block';
    } else if(board){
        document.getElementById('motherboard_form').style.display = 'block';
    } else if(os){
        document.getElementById('os_form').style.display = 'block';
    } else if(pSupply){
        document.getElementById('supply_form').style.display = 'block';
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