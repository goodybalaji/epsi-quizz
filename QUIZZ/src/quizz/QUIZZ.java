/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

/**
 *
 * @author Mathieu 'Triboulet' RONDOT
 */
public class QUIZZ
{
    static public QuestionCreationScreen connectionScreen;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connectionScreen = new QuestionCreationScreen();
        connectionScreen.setVisible(true);
    }
}
