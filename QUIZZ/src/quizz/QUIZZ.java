/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quizz;

import java.net.MalformedURLException;

/**
 *
 * @author Mathieu 'Triboulet' RONDOT
 */
public class QUIZZ
{

    static public QuizzScreenQuestionCreation quizzScreenQuestionCreation;
    static public QuizzScreenCreation quizzScreenCreation;
    

    static public QuizzScreenQuestionCorrection questionCorrectionScreen;
    static public QuizzScreenAnswer quizzScreenAnswer;
    static public QuizzScreenFinish quizzScreenFinish;
    static public QuizzScreenAddImage quizzScreenAddImage;
    static public QuizzScreenShowImage quizzScreenShowImage;
    static public PlayerScreenHome playerScreenHome;
    static public PlayerScreenRankQuizz playerScreenRankQuizz;
    static public PlayerScreenStat playerScreenStat; 
    
    static public AdminScreenHome adminScreenHome;
    static public AdminScreenAddAdmin adminScreenAddAdmin;
    
    static public ConnectionScreenAddUser connectionScreenAddUser;

    static public ConnectionScreen connectionScreen;
    static public Player player;
    static public Admin admin;
    static public Quiz quiz;    
    static public CustomFont customFont;

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException
    {   
        quizzScreenQuestionCreation = new QuizzScreenQuestionCreation();
       //quizzScreenQuestionCreation.setVisible(true);
        
        quizzScreenCreation = new QuizzScreenCreation();
        //quizzScreenCreation.setVisible(true);
        quizzScreenAddImage = new QuizzScreenAddImage();
        //quizzScreenAddImage.setVisible(true);
        
        quizzScreenShowImage = new QuizzScreenShowImage();
        //quizzScreenShowImage.setVisible(true);
        

        connectionScreen = new ConnectionScreen();

        connectionScreen.setVisible(true);



        //connectionScreen.setVisible(true);

        quizzScreenAnswer = new QuizzScreenAnswer();
        //quizzScreenAnswer.setVisible(true);
        
        
        playerScreenHome = new PlayerScreenHome();
        //playerScreenHome.setVisible(true);
         


        quizzScreenFinish = new QuizzScreenFinish();
        playerScreenHome = new PlayerScreenHome();
        //playerScreenHome.setVisible(true);


        
        playerScreenHome = new PlayerScreenHome();
        //playerScreenHome.setVisible(true);
        

        playerScreenRankQuizz = new PlayerScreenRankQuizz();
        //playerRankQuizzScreen.setVisible(true);
        
        playerScreenStat = new PlayerScreenStat();
        //quizzStatPlayerScreen.setVisible(true);
        

        connectionScreenAddUser = new ConnectionScreenAddUser();
        //connectionScreenAddUser.setVisible(true);        
        
        adminScreenAddAdmin = new AdminScreenAddAdmin();
        //adminScreenAddAdmin.setVisible(true);
        
        adminScreenHome = new AdminScreenHome();
        //adminScreenHome.setVisible(true);
        
        customFont = new CustomFont();

    }
}
