import javax.swing.*;

boolean ask(String fn)
{
    int choice = JOptionPane.showOptionDialog(null,
        "$fn already exists; \nReplace it ?",
        "Replace",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null, null, null);

        if (choice == JOptionPane.YES_OPTION)
        {
            println "yes is false"
        }
        else
        {
            println "no is true"
        }
        return choice;
} // end of ask

println "asked and got "+ask("com.jim.Fred.groovy");
