package fr.univorleans.iut45.SAEGraphe;

public class NoJoinablePageException extends RuntimeException{
    
    public NoJoinablePageException(){
        super();
    }

    public NoJoinablePageException(String message) {
        super(message);
    }
}
