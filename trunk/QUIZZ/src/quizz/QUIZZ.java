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

    static public QuizzScreenQuestionCreation questionCreationScreen;
    static public QuizzScreenCreation quizzScreenCreation;
    static public QuizzScreenQuestionCorrection questionCorrectionScreen;
    static public QuizzScreenAnswer quizzScreenAnswer;
    static public QuizzScreenFinish quizzScreenFinish;
    
    static public PlayerScreenHome playerScreenHome;
    static public PlayerScreenRankQuizz playerScreenRankQuizz;
    static public PlayerScreenStat playerScreenStat; 
    
    static public AdminScreenHome adminScreenHome;
    static public AdminScreenAddAdmin adminScreenAddAdmin;
    
    static public ConnectionScreenAddUser connectionScreenAddUser;
    static public ConnectionScreen connectionScreen;

    static public Player player;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
         questionCreationScreen = new QuizzScreenQuestionCreation();
        //questionCreationScreen.setVisible(true);

        quizzScreenCreation = new QuizzScreenCreation();
        //quizzCreationScreen.setVisible(true);
        

        connectionScreen = new ConnectionScreen();
        connectionScreen.setVisible(true);
        
        quizzScreenAnswer = new QuizzScreenAnswer();
        

        playerScreenHome = new PlayerScreenHome();
        //playerScreenHome.setVisible(true);
         


        quizzScreenFinish = new QuizzScreenFinish();

        
        playerScreenHome = new PlayerScreenHome();
        //playerScreenHome.setVisible(true);
        
        playerScreenRankQuizz = new PlayerScreenRankQuizz();
        //playerRankQuizzScreen.setVisible(true);
        
        playerScreenStat = new PlayerScreenStat();
        //quizzStatPlayerScreen.setVisible(true);
        

        connectionScreenAddUser = new ConnectionScreenAddUser();
        //connectionScreenAddUser.setVisible(true);

        connectionScreenAddUser = new ConnectionScreenAddUser();
        //connectionScreenAddUser.setVisible(true);

        
        
        adminScreenAddAdmin = new AdminScreenAddAdmin();
        //adminScreenAddAdmin.setVisible(true);

    }
}
