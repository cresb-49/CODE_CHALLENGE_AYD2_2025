export class Student {
    constructor(private name: string, private lastname: string) { }

    public toString(): string {
        return `${this.name} ${this.lastname}`;
    }

    public getLastname() {
        return this.lastname;
    }

    public sameLastname(student: Student) {
        return this.lastname === student.getLastname();
    }
}
