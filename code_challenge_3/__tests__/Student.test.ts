import { Student } from "../src/models/Student";

describe("Student Class", () => {

    test("Add student 'Jhon Doe' has return 'Jhon Doe'", () => {
        let student = new Student('Jhon', 'Doe');
        expect(student.toString()).toBe('Jhon Doe');
    })

    test("Compare student 'Jhon Doe' with 'Smith Doe' has return true", () => {
        let student1 = new Student('Jhon', 'Doe');
        let student2 = new Student('Smith', 'Doe');
        expect(student1.sameLastname(student2)).toBe(true);
    })

    test("Compare student 'Jhon Doe' with 'Smith Smith' has return false", () => {
        let student1 = new Student('Jhon', 'Doe');
        let student2 = new Student('Smith', 'Smith');
        expect(student1.sameLastname(student2)).toBe(false);
    })

    test("Get lastname from student 'Jhon Doe' has return 'Doe'", () => {
        let student = new Student('Jhon', 'Doe');
        expect(student.getLastname()).toBe('Doe');
    }
    )
})