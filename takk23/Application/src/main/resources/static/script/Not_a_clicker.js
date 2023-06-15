var counter = 0;
var array 

function clickBtn(){
    counter += 1;
    out();
}
function out() {
    var p;
    p = document.getElementById('out');
    p.innerText = counter;
}
function pop_up(){
    elem1 = document.getElementById('attention');
    elem2 = document.getElementById('game');
    elem1.style.display='none';
    elem2.style.display='flex';
}
function img_grow(item){
    elem1 = document.getElementById(item);
    if (elem1.width<500)
    {
        elem1.width = elem1.width*2.5;
        elem1.height = elem1.height*2.5;
    }
    else
    {
        elem1.width = elem1.width/2.5;
        elem1.height = elem1.height/2.5;
    }
}
function menu_func(a, b, c){
    elem1 = document.getElementById(a);
    elem2 = document.getElementById(b);
    elem3 = document.getElementById(c);
    if (elem1.style.visibility=='hidden')
    {
        elem1.style.visibility='visible';
        elem2.style.visibility='visible';
        elem3.style.visibility='hidden';
    }
    else
    {
        elem1.style.visibility='hidden';
        elem2.style.visibility='hidden';
        elem3.style.visibility='visible';
    }
}