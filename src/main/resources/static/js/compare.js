function compareComponentsChange() {
    let cpu = document.getElementById('cpu_check').checked;
    let case_ = document.getElementById('case_check').checked;
    let hard = document.getElementById('hard_check').checked;
    let cooler = document.getElementById('cooler_check').checked;
    let gpu = document.getElementById('gpu_check').checked;
    let memory = document.getElementById('memory_check').checked;
    let board = document.getElementById('motherboard_check').checked;
    let os = document.getElementById('os_check').checked;
    let pSupply = document.getElementById('supply_check').checked;

    document.getElementById('cpu_select_div').style.display = 'none';
    document.getElementById('case_select_div').style.display = 'none';
    document.getElementById('hardware_select_div').style.display = 'none';
    document.getElementById('cooler_select_div').style.display = 'none';
    document.getElementById('gpu_select_div').style.display = 'none';
    document.getElementById('memory_select_div').style.display = 'none';
    document.getElementById('motherboard_select_div').style.display = 'none';
    document.getElementById('os_select_div').style.display = 'none';
    document.getElementById('supply_select_div').style.display = 'none';

    if(cpu) {
        document.getElementById('cpu_select_div').style.display = 'block';
    } else if(gpu) {
        document.getElementById('gpu_select_div').style.display = 'block';
    }  else if(case_){
         document.getElementById('case_select_div').style.display = 'block';
     } else if(hard) {
        document.getElementById('hardware_select_div').style.display = 'block';
    } else if(cooler){
        document.getElementById('cooler_select_div').style.display = 'block';
    } else if(memory){
        document.getElementById('memory_select_div').style.display = 'block';
    } else if(board){
        document.getElementById('motherboard_select_div').style.display = 'block';
    } else if(os){
        document.getElementById('os_select_div').style.display = 'block';
    } else if(pSupply){
        document.getElementById('supply_select_div').style.display = 'block';
    }
    changeComponent();
}

function changeComponent(){
    //---------------------------CPU---------------------------
        let cpu_select1 = document.getElementById('cpu_select1').value;
        let cpu_select2 = document.getElementById('cpu_select2').value;

        let cpu = {
            name : getParams('name',cpu_select1),
            type : getParams('type=',cpu_select1),
            socket : getParams('socket',cpu_select1),
            price : getParams('price',cpu_select1),
            bFreq : getParams('base',cpu_select1),
            mFreq : getParams('maxF',cpu_select1),
            core : getParams('core',cpu_select1),
            thread : getParams('thread',cpu_select1),
            year : getParams('year',cpu_select1),
            graphic : getParams('graphic',cpu_select1),
            temp : getParams('maxTem',cpu_select1)
        }

        document.getElementById('cpu_name1').innerHTML = cpu.name + ', ' + cpu.type;
        document.getElementById('cpu_price1').innerHTML = cpu.price + '$';
        document.getElementById('cpu_socket1').innerHTML = cpu.socket;
        document.getElementById('cpu_base_frequecny1').innerHTML = cpu.bFreq + 'GHz';
        document.getElementById('cpu_max_frequecny1').innerHTML = cpu.mFreq + 'GHz';
        document.getElementById('cpu_year1').innerHTML = cpu.year;
        document.getElementById('cpu_graphic1').innerHTML = cpu.graphic;
        document.getElementById('cpu_cores1').innerHTML = cpu.core;
        document.getElementById('cpu_thread1').innerHTML = cpu.thread;
        document.getElementById('cpu_max_temperature1').innerHTML = cpu.temp + ' °';

        cpu = {
            name : getParams('name',cpu_select2),
            type : getParams('type=',cpu_select2),
            socket : getParams('socket',cpu_select2),
            price : getParams('price',cpu_select2),
            bFreq : getParams('base',cpu_select2),
            mFreq : getParams('maxF',cpu_select2),
            core : getParams('core',cpu_select2),
            thread : getParams('thread',cpu_select2),
            year : getParams('year',cpu_select2),
            graphic : getParams('graphic',cpu_select2),
            temp : getParams('maxTem',cpu_select2)
        }

    document.getElementById('cpu_name2').innerHTML = cpu.name + ', ' + cpu.type;
    document.getElementById('cpu_price2').innerHTML = cpu.price + '$';
    document.getElementById('cpu_socket2').innerHTML = cpu.socket;
    document.getElementById('cpu_base_frequecny2').innerHTML = cpu.bFreq + 'GHz';
    document.getElementById('cpu_max_frequecny2').innerHTML = cpu.mFreq + 'GHz';
    document.getElementById('cpu_year2').innerHTML = cpu.year;
    document.getElementById('cpu_graphic2').innerHTML = cpu.graphic;
    document.getElementById('cpu_cores2').innerHTML = cpu.core;
    document.getElementById('cpu_thread2').innerHTML = cpu.thread;
    document.getElementById('cpu_max_temperature2').innerHTML = cpu.temp  + ' °';


    //---------------------------GPU---------------------------
        let gpu_select1 = document.getElementById('gpu_select1').value;
        let gpu_select2 = document.getElementById('gpu_select2').value;

        let gpu = {
            name : getParams('name',gpu_select1),
            price : getParams('price',gpu_select1),
            memType : getParams('memoryType',gpu_select1),
            chipName : getParams('chip',gpu_select1),
            memSize : getParams('memorySize',gpu_select1),
            coolingSys : getParams('coolingSys',gpu_select1),
            frequency : getParams('frequency',gpu_select1),
            year : getParams('year',gpu_select1),
            resolution : getParams('resolution',gpu_select1)
        }

        document.getElementById('gpu_name1').innerHTML = gpu.name + ', ' + gpu.memType;
        document.getElementById('gpu_price1').innerHTML = gpu.price + '$';
        document.getElementById('gpu_chip1').innerHTML = gpu.chipName;
        document.getElementById('gpu_mem_size1').innerHTML = gpu.memSize + " GB";
        document.getElementById('gpu_cooling_sys1').innerHTML = gpu.coolingSys;
        document.getElementById('gpu_mem_frequency1').innerHTML = gpu.frequency + 'MHz';
        document.getElementById('gpu_year1').innerHTML = gpu.year;
        document.getElementById('gpu_resolution1').innerHTML = gpu.resolution;

    gpu = {
        name : getParams('name',gpu_select1),
        price : getParams('price',gpu_select1),
        memType : getParams('memoryType',gpu_select1),
        chipName : getParams('chip',gpu_select1),
        memSize : getParams('memorySize',gpu_select1),
        coolingSys : getParams('coolingSys',gpu_select1),
        frequency : getParams('frequency',gpu_select1),
        year : getParams('year',gpu_select1),
        resolution : getParams('resolution',gpu_select1)
    }

    document.getElementById('gpu_name2').innerHTML = gpu.name + ', ' + gpu.memType;
    document.getElementById('gpu_price2').innerHTML = gpu.price + '$';
    document.getElementById('gpu_chip2').innerHTML = gpu.chipName;
    document.getElementById('gpu_mem_size2').innerHTML = gpu.memSize + " GB";
    document.getElementById('gpu_cooling_sys2').innerHTML = gpu.coolingSys;
    document.getElementById('gpu_mem_frequency2').innerHTML = gpu.frequency + 'MHz';
    document.getElementById('gpu_year2').innerHTML = gpu.year;
    document.getElementById('gpu_resolution2').innerHTML = gpu.resolution;

    //---------------------------Hardware---------------------------
    let hardware_select1 = document.getElementById('hardware_select1').value;
    let hardware_select2 = document.getElementById('hardware_select2').value;

    let hardware = {
        name : getParams('name',hardware_select1),
        price : getParams('price',hardware_select1),
        year : getParams('year',hardware_select1),
        diskType : getParams('diskType',hardware_select1),
        connection : getParams('connection',hardware_select1),
        buffSize : getParams('diskBufferSize',hardware_select1),
        size : getParams('size=',hardware_select1)
    }

    document.getElementById('hardware_name1').innerHTML = hardware.name + ', ' + hardware.diskType;
    document.getElementById('hardware_price1').innerHTML = hardware.price + '$';
    document.getElementById('hardware_size1').innerHTML = hardware.size + " GB";
    document.getElementById('hardware_connection1').innerHTML = hardware.connection;
    document.getElementById('hardware_buff_size1').innerHTML = hardware.buffSize + " MB";
    document.getElementById('hardware_year1').innerHTML = hardware.year;

    hardware = {
        name : getParams('name',hardware_select2),
        price : getParams('price',hardware_select2),
        year : getParams('year',hardware_select2),
        diskType : getParams('diskType',hardware_select2),
        connection : getParams('connection',hardware_select2),
        buffSize : getParams('diskBufferSize',hardware_select2),
        size : getParams('size=',hardware_select2)
    }

    document.getElementById('hardware_name2').innerHTML = hardware.name + ', ' + hardware.diskType;
    document.getElementById('hardware_price2').innerHTML = hardware.price + '$';
    document.getElementById('hardware_size2').innerHTML = hardware.size + " GB";
    document.getElementById('hardware_connection2').innerHTML = hardware.connection;
    document.getElementById('hardware_buff_size2').innerHTML = hardware.buffSize + " MB";
    document.getElementById('hardware_year2').innerHTML = hardware.year;

    //---------------------------Cooler---------------------------
    let cooler_select1 = document.getElementById('cooler_select1').value;
    let cooler_select2 = document.getElementById('cooler_select2').value;

    let cooler = {
        name : getParams('name',cooler_select1),
        price : getParams('price',cooler_select1),
        year : getParams('year',cooler_select1),
        type : getParams('type', cooler_select1),
        tdp : getParams('tdp',cooler_select1),
        socket : getParams('socket',cooler_select1),
        speedBase : getParams('speedBase', cooler_select1),
        speedMax : getParams('speedMax', cooler_select1),
    }

    document.getElementById('cooler_name1').innerHTML = cooler.name + ', ' + cooler.type;
    document.getElementById('cooler_price1').innerHTML = cooler.price + '$';
    document.getElementById('cooler_tdp1').innerHTML = cooler.tdp + "W";
    document.getElementById('cooler_speed_base1').innerHTML = cooler.speedBase + ' rpm';
    document.getElementById('cooler_speed_max1').innerHTML = cooler.speedMax + ' rpm';
    document.getElementById('cooler_socket1').innerHTML = cooler.socket;
    document.getElementById('cooler_year1').innerHTML = cooler.year;

    cooler = {
        name : getParams('name',cooler_select2),
        price : getParams('price',cooler_select2),
        year : getParams('year',cooler_select2),
        type : getParams('type', cooler_select2),
        tdp : getParams('tdp',cooler_select2),
        socket : getParams('socket',cooler_select2),
        speedBase : getParams('speedBase', cooler_select2),
        speedMax : getParams('speedMax', cooler_select2),
    }

    document.getElementById('cooler_name2').innerHTML = cooler.name + ', ' + cooler.type;
    document.getElementById('cooler_price2').innerHTML = cooler.price + '$';
    document.getElementById('cooler_tdp2').innerHTML = cooler.tdp + "W";
    document.getElementById('cooler_speed_base2').innerHTML = cooler.speedBase + ' rpm';
    document.getElementById('cooler_speed_max2').innerHTML = cooler.speedMax + ' rpm';
    document.getElementById('cooler_socket2').innerHTML = cooler.socket;
    document.getElementById('cooler_year2').innerHTML = cooler.year;
}

function getParams(string, option){
    let start = option.search(string);
    let result = '';
    for(let i=start;i<option.length;i++){
        if (option[i] === '='){
            for(let k=i+1;k<option.length;k++){
                if(option[k] === ',' || option[k] === '}'){
                    if(result.includes("'")){
                        result = result.slice(1,result.length-1);
                    }
                    return result;
                } else {
                    result += option[k];
                }

            }
        }
    }
}