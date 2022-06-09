package Classes;

import java.io.Serializable;

public abstract class CaseQuestion extends Case implements Serializable {
    // le fichier des questions
    abstract void genererQuestion();

}
