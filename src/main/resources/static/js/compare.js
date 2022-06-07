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

    //---------------------------Motherboard---------------------------
    let motherboard_select1 = document.getElementById('motherboard_select1').value;
    let motherboard_select2 = document.getElementById('motherboard_select2').value;

    let motherboard = {
        name : getParams('name',motherboard_select1),
        typeOfComponent : getParams('typeOfComponent',motherboard_select1),
        price : getParams('price',motherboard_select1),
        year : getParams('year',motherboard_select1),
        memory : getParams('memory', motherboard_select1),
        frequency : getParams('frequency',motherboard_select1),
        socket : getParams('socket',motherboard_select1),
        outputs : getParams('outputs', motherboard_select1)
    }

    document.getElementById('motherboard_name1').innerHTML = motherboard.name + ', ' + motherboard.typeOfComponent;
    document.getElementById('motherboard_price1').innerHTML = motherboard.price + '$';
    document.getElementById('motherboard_memory1').innerHTML = motherboard.memory;
    document.getElementById('motherboard_frequency1').innerHTML = motherboard.frequency + 'MHz';
    document.getElementById('motherboard_socket1').innerHTML = motherboard.socket;
    document.getElementById('motherboard_outputs1').innerHTML = motherboard.outputs;
    document.getElementById('motherboard_year1').innerHTML = motherboard.year;

    motherboard = {
        name : getParams('name',motherboard_select2),
        typeOfComponent : getParams('typeOfComponent',motherboard_select2),
        price : getParams('price',motherboard_select2),
        year : getParams('year',motherboard_select2),
        memory : getParams('memory', motherboard_select2),
        frequency : getParams('frequency',motherboard_select2),
        socket : getParams('socket',motherboard_select2),
        outputs : getParams('outputs', motherboard_select2)
    }

    document.getElementById('motherboard_name2').innerHTML = motherboard.name + ', ' + motherboard.typeOfComponent;
    document.getElementById('motherboard_price2').innerHTML = motherboard.price + '$';
    document.getElementById('motherboard_memory2').innerHTML = motherboard.memory;
    document.getElementById('motherboard_frequency2').innerHTML = motherboard.frequency + 'MHz';
    document.getElementById('motherboard_socket2').innerHTML = motherboard.socket;
    document.getElementById('motherboard_outputs2').innerHTML = motherboard.outputs;
    document.getElementById('motherboard_year2').innerHTML = motherboard.year;

    //---------------------------Memory---------------------------
    let memory_select1 = document.getElementById('memory_select1').value;
    let memory_select2 = document.getElementById('memory_select2').value;

    let memory = {
        name : getParams('name',memory_select1),
        price : getParams('price',memory_select1),
        year : getParams('year',memory_select1),
        type : getParams('memoryType',memory_select1),
        size : getParams('memorySize',memory_select1),
        frequency : getParams('frequency',memory_select1),
        device : getParams('device',memory_select1),
    }

    document.getElementById('memory_name1').innerHTML = memory.name + ', ' + memory.device;
    document.getElementById('memory_price1').innerHTML = memory.price + '$';
    document.getElementById('memory_size1').innerHTML = memory.size + ' GB';
    document.getElementById('memory_frequency1').innerHTML = memory.frequency + 'MHz';
    document.getElementById('memory_type1').innerHTML = memory.type;
    document.getElementById('memory_year1').innerHTML = memory.year;

    memory = {
        name : getParams('name',memory_select2),
        price : getParams('price',memory_select2),
        year : getParams('year',memory_select2),
        type : getParams('memoryType',memory_select2),
        size : getParams('memorySize',memory_select2),
        frequency : getParams('frequency',memory_select2),
        device : getParams('device',memory_select2),
    }

    document.getElementById('memory_name2').innerHTML = memory.name + ', ' + memory.device;
    document.getElementById('memory_price2').innerHTML = memory.price + '$';
    document.getElementById('memory_size2').innerHTML = memory.size + ' GB';
    document.getElementById('memory_frequency2').innerHTML = memory.frequency + 'MHz';
    document.getElementById('memory_type2').innerHTML = memory.type;
    document.getElementById('memory_year2').innerHTML = memory.year;

    //---------------------------OS---------------------------
    let os_select1 = document.getElementById('os_select1').value;
    let os_select2 = document.getElementById('os_select2').value;

    let os = {
        name : getParams('name',os_select1),
        price : getParams('price',os_select1),
        year : getParams('year',os_select1),
        typeOfComponent : getParams('typeOfComponent',os_select1),
        discharge : getParams('discharge',os_select1),
        edition : getParams('edition',os_select1),
    }

    document.getElementById('os_name1').innerHTML = os.name + ', ' + os.typeOfComponent;
    document.getElementById('os_price1').innerHTML = os.price + '$';
    document.getElementById('os_name_specification1').innerHTML = os.name;
    document.getElementById('os_discharge1').innerHTML = 'x' + os.discharge;
    document.getElementById('os_edition1').innerHTML = os.edition;
    document.getElementById('os_year1').innerHTML = os.year;

    os = {
        name : getParams('name',os_select2),
        price : getParams('price',os_select2),
        year : getParams('year',os_select2),
        typeOfComponent : getParams('typeOfComponent',os_select2),
        discharge : getParams('discharge',os_select2),
        edition : getParams('edition',os_select2),
    }

    document.getElementById('os_name2').innerHTML = os.name + ', ' + os.typeOfComponent;
    document.getElementById('os_price2').innerHTML = os.price + '$';
    document.getElementById('os_name_specification2').innerHTML = os.name;
    document.getElementById('os_discharge2').innerHTML = 'x' + os.discharge;
    document.getElementById('os_edition2').innerHTML = os.edition;
    document.getElementById('os_year2').innerHTML = os.year;

    //---------------------------Supply---------------------------
    let supply_select1 = document.getElementById('supply_select1').value;
    let supply_select2 = document.getElementById('supply_select2').value;

    let supply = {
        name : getParams('name',supply_select1),
        price : getParams('price',supply_select1),
        year : getParams('year',supply_select1),
        typeOfComponent : getParams('typeOfComponent',supply_select1),
        power : getParams('power',supply_select1),
        device : getParams('device',supply_select1),
    }

    document.getElementById('supply_name1').innerHTML = supply.name + ', ' + supply.typeOfComponent;
    document.getElementById('supply_price1').innerHTML = supply.price + '$';
    document.getElementById('supply_power1').innerHTML = supply.power + 'W';
    document.getElementById('supply_device1').innerHTML = supply.device;
    document.getElementById('supply_year1').innerHTML = supply.year;

    supply = {
        name : getParams('name',supply_select2),
        price : getParams('price',supply_select2),
        year : getParams('year',supply_select2),
        typeOfComponent : getParams('typeOfComponent',supply_select2),
        power : getParams('power',supply_select2),
        device : getParams('device',supply_select2),
    }

    document.getElementById('supply_name2').innerHTML = supply.name + ', ' + supply.typeOfComponent;
    document.getElementById('supply_price2').innerHTML = supply.price + '$';
    document.getElementById('supply_power2').innerHTML = supply.power + 'W';
    document.getElementById('supply_device2').innerHTML = supply.device;
    document.getElementById('supply_year2').innerHTML = supply.year;

    //---------------------------Case---------------------------
    let case_select1 = document.getElementById('case_select1').value;
    let case_select2 = document.getElementById('case_select2').value;

    let aCase = {
        name : getParams('name',case_select1),
        price : getParams('price',case_select1),
        year : getParams('year',case_select1),
        typeOfComponent : getParams('typeOfComponent',case_select1),
        color : getParams('color',case_select1),
        type : getParams('type=',case_select1),
    }

    document.getElementById('case_name1').innerHTML = aCase.name + ', ' + aCase.typeOfComponent;
    document.getElementById('case_price1').innerHTML = aCase.price + '$';
    document.getElementById('case_color1').innerHTML = aCase.color;
    document.getElementById('case_type1').innerHTML = aCase.type;
    document.getElementById('case_year1').innerHTML = aCase.year;

    aCase = {
        name : getParams('name',case_select2),
        price : getParams('price',case_select2),
        year : getParams('year',case_select2),
        typeOfComponent : getParams('typeOfComponent',case_select2),
        color : getParams('color',case_select2),
        type : getParams('type=',case_select2),
    }

    document.getElementById('case_name2').innerHTML = aCase.name + ', ' + aCase.typeOfComponent;
    document.getElementById('case_price2').innerHTML = aCase.price + '$';
    document.getElementById('case_color2').innerHTML = aCase.color;
    document.getElementById('case_type2').innerHTML = aCase.type;
    document.getElementById('case_year2').innerHTML = aCase.year;
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