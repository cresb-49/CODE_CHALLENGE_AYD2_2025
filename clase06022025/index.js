//Ingreso de dos palabras diferentes
palabra1 = "amor";
palabra2 = "roma";

function anagrama(palabra1, palabra2) {
    if (palabra1.length !== palabra2.length) {
        return false
    }

    palabra_segmentada1 = palabra1.split("");
    palabra_segmentada2 = palabra2.split("");

    //Contamos la cantidad de letras de cada una de las palabras
    clave_valor1 = new Map();
    palabra_segmentada1.forEach(element => {
        if (!clave_valor1.get(element)) {
            clave_valor1.set(element, 1)
        } else {
            value = clave_valor1.get(element);
            clave_valor1.set(element, (value + 1));
        }
    });
    clave_valor2 = new Map();
    palabra_segmentada2.forEach(element => {
        if (!clave_valor2.get(element)) {
            clave_valor2.set(element, 1)
        } else {
            value = clave_valor2.get(element);
            clave_valor2.set(element, (value + 1));
        }
    });

    if (clave_valor1.size !== clave_valor2.size) {
        return false
    }
    // console.log(clave_valor1);
    // console.log(clave_valor2);

    for (let [key, value] of clave_valor1) {
        if (!clave_valor2.get(key)) {
            return false
        } else {
            value2 = clave_valor2.get(key)
            if (value2 !== value) {
                return false
            }
        }
    }

    return true;
}

console.log("(espada,pesada) El resultado es: ", anagrama("espada", "pesada"));
console.log("(hola,cola) El resultado es: ", anagrama("hola", "cola"));
console.log("(amor,roma) El resultado es: ", anagrama("amor", "roma"));