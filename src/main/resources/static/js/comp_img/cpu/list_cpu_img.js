const title_cpu = document.querySelector('title').innerHTML;
const image_cpu = document.querySelector('img');
const condition_cpu = /.*AMD.*/;
if(!title_cpu.match(condition_cpu)){
    image_cpu.setAttribute('src','/image/components/cpu/Intel.png');
}