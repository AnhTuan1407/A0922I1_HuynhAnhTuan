console.log('halo');
const fibonacci = (x) => {
    if(x < 0) {
        return -1;
    }
    if(x == 0 || x == 1) {
        return x;
    }
    else {
        return fibonacci(x-1) + fibonacci(x-2);
    }
}

let sum = 0;
for(let i = 0; i < 11; i++) {
    sum+= fibonacci(i);
}
console.log(sum);