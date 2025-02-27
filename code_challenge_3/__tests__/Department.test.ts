import { Departament } from "../src/models/Departament";
import { Student } from "../src/models/Student";

describe("Departament Class", () => {
    test("Add student to map", () => {
        const departament = new Departament();
        const student1 = new Student('jose', 'perez');
        departament.addStudent(student1, 50);
        expect(departament.getStudents().get(50)).toBe(student1);
    })
    
    test("Add student whith the same lastname and replace the previous one", () => {
        const departament = new Departament();
        const student1 = new Student("John", "Doe");
        const student2 = new Student("Jane", "Doe");

        departament.addStudent(student1, 90);
        departament.addStudent(student2, 80);

        const students = departament.getStudents();
        expect(students.has(90)).toBe(false);
        expect(students.get(80)).toBe(student2);
    });

    test("Add students with different lastnames does not replace any", () => {
        const departament = new Departament();
        const student1 = new Student("John", "Doe");
        const student2 = new Student("Jane", "Smith");

        departament.addStudent(student1, 90);
        departament.addStudent(student2, 80);

        const students = departament.getStudents();
        expect(students.get(90)).toBe(student1);
        expect(students.get(80)).toBe(student2);
    });
})