/**
 * La funcion principal que hace todo el recorrido "set"
 * Tiene una complejiada lineal O(n) donde n representa aquellos elmentos de la lista que no son planos
 * Al momento de volverse a llamar de una manera recursiva tambien se tienen una complejidad lineal O(x)
 * donde x en la profundidad total del arreglo o cantidad de subarreglos dentro del mismo
 * 
 * Al mezclar ambos obtenemos un O(n+x) donde n la cantidad de elementos no arreglos del arreglo principal
 * y x la cantidad de sub arreglos contenidos quedando en una complejidad de O(n)
 * 
 */

console.log("Caso 1: ", validacion([1, 2, ["3", "4"]], [1, 2, "3", "4"]))
console.log("Caso 2: ", validacion([1, 2, [3, 4, [5, 6]]], [1, 2, 3, 4, 5, 6]))
console.log("Caso 3: ", validacion([1, 2, ["a", "b", [5, 6]]], [1, 2, "a", "b", 5, 6]))
console.log("Caso 4: ", validacion([1, 2, [3, 4, [5, 6, [7, 8, [9, 10]]]]], [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]))

function conversion(input: Array<any>): Array<any> {
    let container: Array<any> = [];
    set(input, container)
    return container;
}

function set(value: Array<any>, container: Array<any>) {
    value.forEach(element => {
        if (element instanceof Array) {
            set(element, container)
        } else {
            container.push(element)
        }
    });
}

function validacion(input: Array<any>, output: Array<any>) {
    let process = conversion(input);
    // console.log('Resultado: ', process)
    if (process === output) {
        return "Fallido"
    } else {
        return "Exitoso"
    }
}