/***
 * let find_key = null;
        for (const [key, value] of this.students) {
            if (value.sameLastname(student)) {
                find_key = key;
                break;
            }
        }
        if (find_key) {
            this.students.delete(find_key);
        }

        this.students.set(mark, student);

    LA complejidad de este algoritmo es O(n) ya que recorre todos los elementos del mapa para encontrar si hay un estudiante con el mismo apellido.
    Si encuentra un estudiante con el mismo apellido, lo elimina y agrega el nuevo estudiante.
    Si no encuentra un estudiante con el mismo apellido, simplemente agrega el nuevo estudiante.
 */



import { Departament } from "./models/Departament";
import { Student } from "./models/Student";

let departament = new Departament();

let student1 = new Student('Carlos', 'Pac');
let student2 = new Student('Ben', 'Pac');

departament.addStudent(student1, 50);
departament.addStudent(student2, 40);
departament.printStudents();


