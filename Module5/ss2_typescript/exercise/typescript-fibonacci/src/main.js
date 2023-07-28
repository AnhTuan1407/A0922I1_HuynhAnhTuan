function fibonacciRecursive(number) {
    if (number < 0) {
        return -1;
    }
    else if (number == 0 || number == 1) {
        return number;
    }
    else {
        return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
    }
}
var number = 10;
console.log("Số fibonacci thứ " + number + ": " + fibonacciRecursive(number));
