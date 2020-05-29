DROP TABLE IF EXISTS student;
CREATE TABLE student (
                        id    BIGINT NOT NULL AUTO_INCREMENT,
                        name  VARCHAR(255) NOT NULL,
                        faculty  VARCHAR(255) NOT NULL,
                        year    VARCHAR(30) NOT NULL,
                        PRIMARY KEY(id)
);
INSERT INTO student (name, faculty, year) VALUES
            ('Jones, John', 'History', 'FIRST'),
            ('Buckley, Ed', 'Philosophy', 'SECOND'),
            ('Jankovsky, Paul', 'Programming', 'FIFTH'),
            ('Ivanov, Robert', 'Philosophy', 'THIRD'),
            ('Herz, Otto', 'Programming', 'SECOND'),
            ('Nakazumi, Hiroku', 'Programming', 'THIRD');

DROP TABLE IF EXISTS book;
CREATE TABLE book (
                         id    BIGINT NOT NULL AUTO_INCREMENT,
                         title  VARCHAR(255) NOT NULL,
                         author  VARCHAR(255) NOT NULL,
                         type    VARCHAR(30) NOT NULL,
                         student_id BIGINT,
                         PRIMARY KEY(id),
                         FOREIGN KEY (student_id)
                             REFERENCES student(id)

);
INSERT INTO book (title, author, type, student_id) VALUES
            ('Clean Code', 'Martin, Robert', 'EDUCATION', 1),
            ('A Brief History Of Time', 'Hawking, Stephen', 'NON_FICTION', 2),
            ('Moby Dick', 'Melvill, German', 'FICTION', 1),
            ('Thinking In Java', 'Eckel, Bruce', 'EDUCATION', 3),
            ('Guns, Germs, and Steel', 'Diamond, Jared', 'NON_FICTION', 4),
            ('Effective Java', 'Bloch, Joshua', 'EDUCATION', 5),
            ('Spring In Action', 'Walls, Craig', 'EDUCATION', 2),
            ('A Scanner Darkly', 'Dick, Philip', 'FICTION', null),
            ('Refactoring', 'Fowler, Martin', 'EDUCATION', 5),
            ('Salambo', 'Flaubert, Gustav', 'FICTION', null);
