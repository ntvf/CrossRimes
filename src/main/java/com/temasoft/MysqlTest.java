package com.temasoft;

import com.temasoft.daos.JPAWordDAO;
import com.temasoft.daos.WordDAO;
import com.temasoft.model.Word;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: tymur
 * Date: 19.11.13
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public class MysqlTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, IOException {
//        Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///ib2", "lysaktv", "lysaktv");
//        PreparedStatement statement = conn.prepareStatement("insert into words2 (word) values (?)");

        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        WordDAO dao = context.getBean("wordService", JPAWordDAO.class);
        dao.saveAll(getWords());





//        statement.close();
//        conn.close();

    }

    public static Collection<Word> getWords() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("dictionary2.txt"));

        //WordDAO dao = testDaoSql();

        String line = null;
        StringBuilder builder = null;
        Pattern pattern = Pattern.compile("\\s");
        Set<Word> words = new HashSet<Word>();
        int currentWord = 0;
        while((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            line = matcher.replaceAll("");
            if(Character.isUpperCase(line.charAt(0))) continue;


            words.add(new Word(line));
//            statement.setString(1,line);
//            statement.execute();

//            System.out.println(builder.toString());
        }
        reader.close();
        return words;
    }


}
