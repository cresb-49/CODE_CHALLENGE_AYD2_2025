import { Student } from "./Student";

export class Departament {
    private students: Map<number, Student>;

    constructor() {
        this.students = new Map();
    }

    public printStudents(): void {
        console.log("|     Mark    |      Student     |");
        for (const [key, value] of this.students) {
            console.log(`| ${key}  |  ${value.toString()} |`);
        }
    }

    public addStudent(student: Student, mark: number): void {
        let find_key = null;
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
    }

    public getStudents(): Map<number, Student> {
        return this.students;
    }
}
