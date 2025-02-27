import { Departament } from "./models/Departament";
import { Student } from "./models/Student";

let departament = new Departament();

let student1 = new Student('Carlos', 'Pac');
let student2 = new Student('Ben', 'Pac');

departament.addStudent(student1, 50);
departament.addStudent(student2, 40);
departament.printStudents();


